/**
 * 
 */
package com.raghava.hrms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.raghava.hrms.domain.Employee;

/**
 * Employee Repository for performing CRUD operations on Employee entity.
 * @author Raghava
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
