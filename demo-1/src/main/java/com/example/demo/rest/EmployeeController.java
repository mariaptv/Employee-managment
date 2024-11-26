package com.example.demo.rest;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * REST controller for managing employee operations.
 * Handles CRUD operations for the `Employee` entity.
 */
@RestController
@RequestMapping("/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // Service layer for business logic

    /**
     * Retrieves a list of all employees.
     *
     * @return a ResponseEntity containing the list of employees
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    /**
     * Retrieves a single employee by its ID.
     *
     * @param id the ID of the employee to retrieve
     * @return a ResponseEntity containing the employee
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    /**
     * Saves a new employee.
     *
     * @param employee the employee to be saved
     * @return a ResponseEntity containing the saved employee
     */
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        try {
            // Save the employee and generate the URI for the new resource
            Employee savedEmployee = employeeService.save(employee);
            return ResponseEntity.created(new URI("/employees/" + savedEmployee.getId())).body(savedEmployee);
        } catch (Exception e) {
            // Return a BAD_REQUEST status if an exception occurs
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Updates an existing employee by its ID.
     *
     * @param id       the ID of the employee to update
     * @param employee the updated employee data
     * @return a ResponseEntity containing the updated employee
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    /**
     * Deletes an employee by its ID.
     *
     * @param id the ID of the employee to delete
     * @return a ResponseEntity containing a boolean indicating success
     */
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id) {
        // Delete the employee
        employeeService.deleteById(id);
        // Check if the employee still exists and return the result
        return ResponseEntity.ok(!(employeeService.findById(id) != null));
    }
}
