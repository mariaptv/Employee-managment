package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Employee;

/**
 * Repository interface for Employee entity.
 * Provides CRUD operations and query methods for Employee data.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
