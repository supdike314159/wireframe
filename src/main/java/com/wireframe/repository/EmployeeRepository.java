package com.wireframe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wireframe.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
