package com.wireframe.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.apache.log4j.Logger; 
 
@Controller
@RequestMapping(value = "/welcome")
public class WireframeHome {

  static Logger log = Logger.getLogger(WireframeHome.class.getName());
 
  @RequestMapping(method = RequestMethod.GET)
  public String helloWorld(ModelMap model) {
 
    model.addAttribute("message","Hello Wireframe");
    return "welcome";
  }
}
