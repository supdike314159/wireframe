package com.wireframe.service;

import java.util.List;

import com.wireframe.exception.EmployeeNotFound;
import com.wireframe.model.Employee;

public interface EmployeeService {
	public Employee create(Employee employee);
	public Employee delete(long id) throws EmployeeNotFound;
	public List<Employee> findAll();
	public Employee update(Employee employee) throws EmployeeNotFound;
	public Employee findById(long id);
}
