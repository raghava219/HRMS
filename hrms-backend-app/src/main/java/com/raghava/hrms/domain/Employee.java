/**
 * 
 */
package com.raghava.hrms.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the Entity class Employee table.
 * 
 * @author Raghava
 *
 */

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId = 0;

	@Column(name = "employee_name")
	private String employeeName = null;

	@Column(name = "employee_gender")
	private char employeeGender = '\u0000';

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth = null;

	@Column(name = "joining_date")
	private LocalDate joiningDate = null;

	@Column(name = "email_id")
	private String emailId = null;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, char employeeGender, LocalDate dateOfBirth,
			LocalDate joiningDate, String emailId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
		this.emailId = emailId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public char getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(char employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
	
}
