package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.rest.EmployeeController;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmployeeController controller;

    public EmployeeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee employee = createMockEmployee();

        when(service.findAll()).thenReturn(List.of(employee));

        ResponseEntity<List<Employee>> response = controller.getAllEmployees();

        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetEmployeeById_Success() {
        Employee employee = createMockEmployee();

        when(service.getEmployeeById(1L)).thenReturn(employee);

        ResponseEntity<Employee> response = controller.getEmployeeById(1L);

        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertEquals("John", response.getBody().getFirstName());
    }

    @Test
    void testGetEmployeeById_NotFound() {
        when(service.getEmployeeById(1L)).thenThrow(new RuntimeException("Employee not found"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> controller.getEmployeeById(1L));

        assertEquals("Employee not found", exception.getMessage());
    }

    @Test
    void testSaveEmployee_Success() {
        Employee employee = createMockEmployee();

        when(service.save(employee)).thenReturn(employee);

        ResponseEntity<Employee> response = controller.saveEmployee(employee);

        assertNotNull(response);
        assertEquals(CREATED, response.getStatusCode());
        assertEquals("John", response.getBody().getFirstName());
    }

    @Test
    void testUpdateEmployee_Success() {
        // Create an existing employee
        Employee existingEmployee = createMockEmployee();

        // Create an updated employee object with the new details
        Employee updatedEmployee = createMockEmployee();
        updatedEmployee.setFirstName("Updated Name");

        // Mock the behavior of the service layer
        when(service.getEmployeeById(1L)).thenReturn(existingEmployee);
        when(service.updateEmployee(1L, updatedEmployee)).thenReturn(updatedEmployee);

        // Call the controller method
        ResponseEntity<Employee> response = controller.updateEmployee(1L, updatedEmployee);

        // Assertions
        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Name", response.getBody().getFirstName());
    }


    @Test
    void testUpdateEmployee_NotFound() {
        Employee updatedEmployee = createMockEmployee();

        when(service.updateEmployee(1L, updatedEmployee)).thenThrow(new RuntimeException("Employee not found"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> controller.updateEmployee(1L, updatedEmployee));

        assertEquals("Employee not found", exception.getMessage());
    }

    @Test
    void testDeleteEmployee_Success() {
        // Mock the service to do nothing for deleteById
        doNothing().when(service).deleteById(1L);

        // Mock the service to return an empty Optional when findById is called
        when(service.findById(1L)).thenReturn(Optional.empty());

        // Call the controller's deleteEmployee method
        ResponseEntity<Boolean> response = controller.deleteEmployee(1L);

        // Validate the response
        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertTrue(response.getBody());
    }


    private Employee createMockEmployee() {
        return new Employee("John", "M", "Doe", "New York", "123 Street",
                LocalDate.of(1990, 1, 1), "1234567890", "Developer",
                LocalDate.of(2020, 1, 1), "john.doe@example.com", 60000.0, "Active");
    }
}
