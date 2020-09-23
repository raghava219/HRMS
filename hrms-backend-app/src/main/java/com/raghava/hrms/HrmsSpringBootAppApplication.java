package com.raghava.hrms;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raghava.hrms.domain.Employee;
import com.raghava.hrms.service.EmployeeService;

@SpringBootApplication
public class HrmsSpringBootAppApplication implements CommandLineRunner {

	@Autowired
	EmployeeService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(HrmsSpringBootAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee emp1 = new Employee();
		emp1.setEmployeeName("test1");
		emp1.setJoiningDate(LocalDate.of(2020, 10,5));
		emp1.setEmployeeGender('M');
		emp1.setDateOfBirth(LocalDate.of(1985, 10,5));
		emp1.setEmailId("test123@gmail.com");
		empService.saveEmployee(emp1);
		
		
		Employee emp2 = new Employee();
		emp2.setEmployeeName("test2");
		emp2.setJoiningDate(LocalDate.of(2019, 10,5));
		emp2.setEmployeeGender('F');
		emp2.setDateOfBirth(LocalDate.of(1984, 10,5));
		emp2.setEmailId("test3@gmail.com");
		empService.saveEmployee(emp2);
		
	}

}
