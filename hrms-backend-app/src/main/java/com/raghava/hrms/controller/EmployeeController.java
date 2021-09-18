package com.raghava.hrms.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raghava.hrms.domain.Employee;
import com.raghava.hrms.service.EmployeeService;

/**
 * This is the main controller for Employee
 * 
 * @author raghava
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	private EmployeeService empService;

	public EmployeeService getEmpService() {
		return empService;
	}

	@Autowired
	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/employees")
	public Iterable<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeWithId(@PathVariable long empId) {
		return empService.getEmployeeWithId(empId);
	}

	// Edit/Update a Employee
	// PUT /employee
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployees(@RequestBody Employee emp) {

		Employee empUpdated = empService.saveEmployee(emp);

		return new ResponseEntity<Employee>(empUpdated, HttpStatus.OK);
	}

	@PostMapping("/employees")
	public ResponseEntity<Void> createEmployee(@RequestBody Employee emp) {

		Employee createdEmp = empService.saveEmployee(emp);


		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmp.getEmployeeId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Void> deleteEmployeeWithId(@PathVariable long empId){
		
		empService.deleteEmployeeWithId(empId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	

}
