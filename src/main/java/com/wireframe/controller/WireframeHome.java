package com.wireframe.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger; 
 
@Controller
public class WireframeHome {

  static Logger log = Logger.getLogger(WireframeHome.class.getName());
 
	@RequestMapping(value = "/")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Welcome to Wireframe 1.0</h3></div><br><br>";
                log.info("@@@@@@@@@@@@@@@@@@@@@");
		return new ModelAndView("welcome", "message", message);
	}
}
