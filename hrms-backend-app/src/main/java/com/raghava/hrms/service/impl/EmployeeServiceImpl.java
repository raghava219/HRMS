package com.raghava.hrms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghava.hrms.domain.Employee;
import com.raghava.hrms.repository.EmployeeRepository;
import com.raghava.hrms.service.EmployeeService;

/**
 * This class is an implementation of EmployeeService.
 * 
 * @author raghava
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository empRepo = null;

	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeWithId(Long empId) {
		return empRepo.findById(empId);
	}

	@Override
	public Employee updateEmployeeWithId(Long empId, Employee newEmp) {

		Optional<Employee> existingEmp = empRepo.findById(empId);
		Employee emp = null;

		if (existingEmp.isPresent()) {
			emp = existingEmp.get();
			emp.setDateOfBirth(newEmp.getDateOfBirth());
			emp.setEmailId(newEmp.getEmailId());
			emp.setEmployeeGender(newEmp.getEmployeeGender());
			emp.setEmployeeName(newEmp.getEmployeeName());
		}

		return empRepo.save(emp);
	}

	@Override
	public void deleteEmployeeWithId(Long empId) {
		empRepo.deleteById(empId);
	}

}
