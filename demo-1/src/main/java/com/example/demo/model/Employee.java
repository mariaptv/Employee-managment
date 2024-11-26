package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity class representing an Employee.
 * Maps to the "employees" table in the database.
 */
@Entity
@Table(name = "employees")
public class Employee {

    // Primary key for the Employee entity, with auto-generated value
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequence", allocationSize = 1)
	private Long id;


    // First name of the employee (cannot be null)
    @Column(nullable = false)
    private String firstName;

    // Middle name of the employee (optional)
    private String middleName;

    // Last name of the employee (cannot be null)
    @Column(nullable = false)
    private String lastName;

    // Location city (cannot be null)
    @Column(nullable = false)
    private String locationCity;

    // Address (cannot be null)
    @Column(nullable = false, length = 255)
    private String address;

    // Date of birth (cannot be null)
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    // Telephone (cannot be null)
    @Column(nullable = false)
    private String telephone;

    // Position title (cannot be null)
    @Column(nullable = false)
    private String positionTitle;

    // Hire date (cannot be null)
    @Column(nullable = false)
    private LocalDate hireDate;

    // Email (cannot be null and must be unique)
    @Column(nullable = false, unique = true)
    private String email;

    // Salary (cannot be null)
    @Column(nullable = false)
    private Double salary;

    // Status (cannot be null)
    @Column(nullable = false)
    private String status;

    /**
     * Default constructor.
     * Required by JPA for entity instantiation.
     */
    public Employee() {}

    /**
     * Parameterized constructor for creating a new Employee instance.
     *
     * @param firstName      the first name of the employee
     * @param middleName     the middle name of the employee
     * @param lastName       the last name of the employee
     * @param locationCity   the city where the employee is located
     * @param address        the address of the employee
     * @param dateOfBirth    the birthdate of the employee
     * @param telephone      the telephone number of the employee
     * @param positionTitle  the job title of the employee
     * @param hireDate       the hire date of the employee
     * @param email          the email of the employee
     * @param salary         the salary of the employee
     * @param status         the status of the employee
     */
    public Employee(String firstName, String middleName, String lastName, String locationCity, String address,
                    LocalDate dateOfBirth, String telephone, String positionTitle, LocalDate hireDate, 
                    String email, Double salary, String status) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.locationCity = locationCity;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.positionTitle = positionTitle;
        this.hireDate = hireDate;
        this.email = email;
        this.salary = salary;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

