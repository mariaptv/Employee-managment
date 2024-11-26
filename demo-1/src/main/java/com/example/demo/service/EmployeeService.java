package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Service class for managing employees.
 * Implements the `EmployeeRepository` interface and provides business logic for the `Employee` entity.
 */
@Service
public class EmployeeService implements EmployeeRepository {

    @Autowired
    private EmployeeRepository repository; // Repository for interacting with the database

    /**
     * Retrieves all employees from the repository.
     *
     * @return a list of all employees
     */
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee to retrieve
     * @return the employee with the specified ID
     * @throws RuntimeException if the employee is not found
     */
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    /**
     * Saves an employee to the repository.
     *
     * @param entity the employee to save
     * @return the saved employee
     */
    @Override
    public <S extends Employee> S save(S entity) {
        return repository.save(entity);
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee to create
     * @return the created employee
     */
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    /**
     * Updates an existing employee.
     *
     * @param id            the ID of the employee to update
     * @param updatedEmployee the updated employee data
     * @return the updated employee
     */
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setMiddleName(updatedEmployee.getMiddleName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setLocationCity(updatedEmployee.getLocationCity());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        existingEmployee.setTelephone(updatedEmployee.getTelephone());
        return repository.save(existingEmployee);
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    /**
     * Deletes an employee entity.
     *
     * @param entity the employee entity to delete
     */
    @Override
    public void delete(Employee entity) {
        repository.delete(entity);
    }

    // Boilerplate methods from EmployeeRepository (TODO placeholders)

    @Override
    public List<Employee> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

   
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Employee> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Employee> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Employee, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
}
