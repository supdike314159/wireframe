package com.wireframe.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wireframe.model.Employee;

public class EmployeeValidator implements Validator {

	//private final static String EMPLOYEES_NUMBER = "emplNumber";

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		
		//Integer emplNumber = employee.getFirstName();
		
		//ValidationUtils.rejectIfEmpty(errors, "name", "employee.name.empty");
		//ValidationUtils.rejectIfEmpty(errors, EMPLOYEES_NUMBER, "shop.emplNumber.empty");
		
		//if (emplNumber != null && emplNumber < 1)
		//	errors.rejectValue(EMPLOYEES_NUMBER, "shop.emplNumber.lessThenOne");

	}
}
