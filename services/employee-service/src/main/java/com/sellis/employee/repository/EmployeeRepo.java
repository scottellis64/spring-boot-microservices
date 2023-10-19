package com.sellis.employee.repository;

import com.sellis.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description
 *
 * @author sellis
 */
public interface EmployeeRepo  extends JpaRepository<Employee, Integer>
{
}
