package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void testFindAll() {
        Employee employee = createMockEmployee();

        when(repository.findAll()).thenReturn(List.of(employee));

        List<Employee> employees = service.findAll();

        assertNotNull(employees);
        assertEquals(1, employees.size());
        assertEquals("John", employees.get(0).getFirstName());
    }

    @Test
    void testGetEmployeeById_Success() {
        Employee employee = createMockEmployee();

        when(repository.findById(1L)).thenReturn(Optional.of(employee));

        Employee result = service.getEmployeeById(1L);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
    }

    @Test
    void testGetEmployeeById_NotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.getEmployeeById(1L));

        assertEquals("Employee not found", exception.getMessage());
    }

    @Test
    void testSaveEmployee() {
        Employee employee = createMockEmployee();

        when(repository.save(employee)).thenReturn(employee);

        Employee savedEmployee = service.save(employee);

        assertNotNull(savedEmployee);
        assertEquals("John", savedEmployee.getFirstName());
    }

    @Test
    void testUpdateEmployee_Success() {
        Employee existingEmployee = createMockEmployee();
        Employee updatedEmployee = createMockEmployee();
        updatedEmployee.setFirstName("Updated Name");

        when(repository.findById(1L)).thenReturn(Optional.of(existingEmployee));
        when(repository.save(existingEmployee)).thenReturn(existingEmployee);

        Employee result = service.updateEmployee(1L, updatedEmployee);

        assertNotNull(result);
        assertEquals("Updated Name", result.getFirstName());
    }

    @Test
    void testUpdateEmployee_NotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Employee updatedEmployee = createMockEmployee();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.updateEmployee(1L, updatedEmployee));

        assertEquals("Employee not found", exception.getMessage());
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(repository).deleteById(1L);

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    private Employee createMockEmployee() {
        return new Employee("John", "M", "Doe", "New York", "123 Street",
                LocalDate.of(1990, 1, 1), "1234567890", "Developer",
                LocalDate.of(2020, 1, 1), "john.doe@example.com", 60000.0, "Active");
    }
}
