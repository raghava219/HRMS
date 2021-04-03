package com.raghava.hrms.controller;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.raghava.hrms.data.EmployeeTestData;
import com.raghava.hrms.domain.Employee;
import com.raghava.hrms.service.EmployeeService;


public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeServiceMock = EasyMock.createMock(EmployeeService.class);
	
	private EmployeeController employeeController = new EmployeeController();
	
	private EmployeeTestData empTestData = null;

	Iterable<Employee> expectedEmpList = null;
	
	public EmployeeControllerTest() {
		
	}
	
	@Before
	public void before() {
		empTestData = new EmployeeTestData();
		expectedEmpList = empTestData.getAllEmployees();
		employeeController.setEmpService(employeeServiceMock);

	}

	@Test
	public void testGetAllEmployeeDetails() {

		Iterable<Employee> actualEmpList = null;

		EasyMock.expect(employeeServiceMock.getAllEmployees()).andReturn(expectedEmpList);
		EasyMock.replay(employeeServiceMock);

		try {
			actualEmpList = (List<Employee>) employeeController.getAllEmployees();
		} catch (Exception e) {
			assertFalse(true);
		}

		assertEquals(expectedEmpList, actualEmpList);

	}
	
	@Test
	public void testGetEmployeeWithId() {

		Employee expectedEmp = empTestData.getAllEmployees().get(0);
		Employee actualEmp = null;
		
		EasyMock.expect(employeeServiceMock.getEmployeeWithId(Long.valueOf(expectedEmp.getEmployeeId()))).andReturn(expectedEmp);
		EasyMock.replay(employeeServiceMock);
		
		try {
			actualEmp = employeeController.getEmployeeWithId(Long.valueOf(expectedEmp.getEmployeeId()));
		} catch (Exception e) {
			assertFalse(true);
		}
		
		assertEquals(expectedEmp, actualEmp);
	}
	
	@After
	public void after() {
		
	}
	
	
	
}











