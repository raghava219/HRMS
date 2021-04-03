package com.raghava.hrms.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.raghava.hrms.domain.Employee;

public class EmployeeTestData {

	public List<Employee> getAllEmployees() {

		List<Employee> empList = new ArrayList<>();

		Employee emp1 = new Employee();
		emp1.setEmployeeName("test1");
		emp1.setJoiningDate(LocalDate.of(2020, 10, 5));
		emp1.setEmployeeGender('M');
		emp1.setDateOfBirth(LocalDate.of(1985, 10, 5));
		emp1.setEmailId("test123@gmail.com");
		empList.add(emp1);

		Employee emp2 = new Employee();
		emp2.setEmployeeName("test2");
		emp2.setJoiningDate(LocalDate.of(2019, 10, 5));
		emp2.setEmployeeGender('F');
		emp2.setDateOfBirth(LocalDate.of(1984, 10, 5));
		emp2.setEmailId("test2@gmail.com");
		empList.add(emp2);

		return empList;
	}

}
