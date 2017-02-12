package com.wireframe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wireframe.exception.EmployeeNotFound;
import com.wireframe.model.Employee;
import com.wireframe.repository.EmployeeRepository;
import com.wireframe.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
    private EmployeeRepository employeeRepository;
 
    @Override
    @Transactional
    public Employee create(Employee employee) {
        Employee createdEmployee = employee;
        return employeeRepository.save(createdEmployee);
    }
     
    @Override
    @Transactional
    public Employee findById(long id) {
        return employeeRepository.findOne(id);
    }
 
    @Override
    @Transactional(rollbackFor=EmployeeNotFound.class)
    public Employee delete(long id) throws EmployeeNotFound {
        Employee deletedEmployee = employeeRepository.findOne(id);
         
        if (deletedEmployee == null)
            throw new EmployeeNotFound();
         
        employeeRepository.delete(deletedEmployee);
        return deletedEmployee;
    }
 
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
 
    @Override
    @Transactional(rollbackFor=EmployeeNotFound.class)
    public Employee update(Employee employee) throws EmployeeNotFound {
        Employee updatedEmployee = employeeRepository.findOne(employee.getId());
         
        if (updatedEmployee == null)
            throw new EmployeeNotFound();
         
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setStatus(employee.getStatus());
        //TODO No birthdate yet....
        return updatedEmployee;
    }
}
