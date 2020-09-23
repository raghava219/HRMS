package com.raghava.hrms.service;

import java.util.Optional;

import com.raghava.hrms.domain.Employee;

/**
 * This EmployeeService interface is used for performing CRUD operation on Employee
 * 
 * @author raghava
 *
 */
public interface EmployeeService {
	
	Employee saveEmployee(Employee emp); 
	
	Iterable<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeWithId(Long empId);

	Employee updateEmployeeWithId(Long empId, Employee newEmp);
	
	void deleteEmployeeWithId(Long empId);
	
}
