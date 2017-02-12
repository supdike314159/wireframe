package com.wireframe.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wireframe.exception.EmployeeNotFound;
import com.wireframe.model.Employee;
import com.wireframe.service.EmployeeService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {

	static Logger log = Logger.getLogger(EmployeeController.class.getName());
	
	@Autowired
    private EmployeeService employeeService;
 
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView newEmployeePage() {
        ModelAndView mav = new ModelAndView("employee-new", "employee", new Employee());
        return mav;
    }
     
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewEmployee(@ModelAttribute Employee employee, 
            final RedirectAttributes redirectAttributes) {
         
        ModelAndView mav = new ModelAndView();
        String message = "New employee "+employee.getFirstName()+" "+employee.getLastName()+" was successfully created.";
         
        employeeService.create(employee);
        mav.setViewName("redirect:/index.html");
                 
        redirectAttributes.addFlashAttribute("message", message);   
        return mav;     
    }
     
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView employeeListPage() {
        ModelAndView mav = new ModelAndView("employee-list");
        List<Employee> employeeList = employeeService.findAll();
        mav.addObject("employeeList", employeeList);
        return mav;
    }
     
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editEmployeePage(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("employee-edit");
        Employee employee = employeeService.findById(id);
        mav.addObject("employee", employee);
        return mav;
    }
     
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editShop(@ModelAttribute Employee employee,
            @PathVariable Integer id,
            final RedirectAttributes redirectAttributes) throws EmployeeNotFound {
         
        ModelAndView mav = new ModelAndView("redirect:/index.html");
        String message = "Employee was successfully updated.";
 
        employeeService.update(employee);
         
        redirectAttributes.addFlashAttribute("message", message);   
        return mav;
    }
     
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable Integer id,
            final RedirectAttributes redirectAttributes) throws EmployeeNotFound {
         
        ModelAndView mav = new ModelAndView("redirect:/index.html");        
         
        Employee employee = employeeService.delete(id);
        String message = "The employee "+employee.getFirstName()+" "+employee.getFirstName()+" was successfully deleted.";
         
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
    
}
