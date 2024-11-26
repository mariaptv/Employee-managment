package com.example.demo.initializer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Qualifier;
import com.example.demo.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.EmployeeRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final EmployeeRepository repository;

    public DatabaseInitializer(@Qualifier("employeeRepository") EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Employee("John", "A", "Doe", "New York", "123 Street",
                LocalDate.of(1990, 1, 1), "1234567890", "Developer",
                LocalDate.of(2020, 1, 1), "john.doe@example.com", 60000.0, "Active"));
        repository.save(new Employee("Jane", "B", "Smith", "Chicago", "456 Avenue",
                LocalDate.of(1985, 2, 2), "0987654321", "Manager",
                LocalDate.of(2015, 2, 2), "jane.smith@example.com", 75000.0, "Active"));
        
    }
}
