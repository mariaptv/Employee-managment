# Employee Management System

## Overview
This project is a simple **Employee Management System** built using **Spring Boot** and an in-memory H2 database. It supports operations like:
- Adding new employees
- Viewing all employees
- Viewing employee details by ID
- Updating employee information
- Deleting employees

It also includes **unit tests** for the service and controller layers to ensure the application behaves as expected.

---

## Features
- RESTful API for managing employees.
- Auto-generated database schema and initial data population.
- Comprehensive unit tests for critical components.
- In-memory H2 database for development and testing.

---

## Requirements
- **Java Development Kit (JDK)**: Version 17 or higher.
- **Spring Tool Suite (STS)** or any IDE with Spring Boot support.
- **Maven**: Version 3.6+ or **Gradle**: Version 7.0+.
- **H2 Database Console**: Embedded for development.

---

## Setup Instructions

### Clone the Repository
```bash
git clone <repository_url>
cd <project_directory>
```

## Database Configuration
This project uses an in-memory H2 database. No external setup is required. You can access the H2 console for debugging:

- **URL**: [http://localhost:8080/h2-ui](http://localhost:8080/h2-ui)
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave blank)

---

## Running the Application

### Using Spring Tool Suite (STS)

#### Import the Project:
1. Open STS.
2. Click **File > Import > Maven > Existing Maven Projects**.
3. Select the project directory and click **Finish**.

#### Build the Project:
1. Right-click on the project in the **Package Explorer**.
2. Select **Run As > Maven Install** (if using Maven) or **Gradle > Refresh Gradle Project** (if using Gradle).

#### Run the Application:
1. Right-click on the main application class (`Demo1Application`).
2. Select **Run As > Spring Boot App**.

#### Access the Application:
- **API Base URL**: [http://localhost:8080/employees](http://localhost:8080/employees).
- **H2 Console**: [http://localhost:8080/h2-ui](http://localhost:8080/h2-ui).

---

## Running Tests

### Overview of Tests
The project includes **unit tests** for:
1. **Controller Layer**:
   - Validates API endpoints in `EmployeeController`.
   - Mocks the service layer to ensure isolated testing.
2. **Service Layer**:
   - Tests business logic in `EmployeeService`.
   - Mocks the repository layer.

### Test Files
- **`EmployeeServiceTest`**: Tests service-layer logic.
- **`EmployeeControllerTest`**: Tests REST API endpoints.

### How to Run Tests in STS

#### Run All Tests:
1. Right-click on the project in the **Package Explorer**.
2. Select **Run As > JUnit Test**.
3. This runs all the test cases in the project.

#### Run Specific Test Class:
1. Navigate to the test class (e.g., `EmployeeServiceTest`).
2. Right-click on the file and select **Run As > JUnit Test**.

#### View Test Results:
- Open the **JUnit** view in STS to see the results.
- If a test fails, click on the test name to view the error details.

### Example Test Output:
```plaintext
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.827 sec
```
## Testing with cURL or Postman
You can also manually test the API using tools like **Postman** or **cURL**. Refer to the API endpoints in the **API Endpoints** section below.

---

## API Endpoints

### Base URL
http://localhost:8080/employees

---

### Endpoints

#### 1. Get All Employees
**Request**:  
`GET /employees`

**Response**:
```json
[
  {
    "id": 1,
    "firstName": "John",
    "middleName": "A",
    "lastName": "Doe",
    "locationCity": "New York",
    "address": "123 Street",
    "dateOfBirth": "1990-01-01",
    "telephone": "1234567890",
    "positionTitle": "Developer",
    "hireDate": "2020-01-01",
    "email": "john.doe@example.com",
    "salary": 60000.0,
    "status": "Active"
  }
]
```
### 2. Get Employee by ID

**Request**:  
`GET /employees/{id}`

**Response**:
```json
{
  "id": 1,
  "firstName": "John",
  "middleName": "A",
  "lastName": "Doe",
  "locationCity": "New York",
  "address": "123 Street",
  "dateOfBirth": "1990-01-01",
  "telephone": "1234567890",
  "positionTitle": "Developer",
  "hireDate": "2020-01-01",
  "email": "john.doe@example.com",
  "salary": 60000.0,
  "status": "Active"
}
```
### 3. Create a New Employee

**Request**:  
`POST /employees`

**Request Body**:
```json
{
  "firstName": "Emily",
  "middleName": "C",
  "lastName": "Brown",
  "locationCity": "Los Angeles",
  "address": "456 Avenue",
  "dateOfBirth": "1992-03-15",
  "telephone": "9876543210",
  "positionTitle": "Designer",
  "hireDate": "2022-06-01",
  "email": "emily.brown@example.com",
  "salary": 70000.0,
  "status": "Active"
}
```

**Response**:
```json
{
  "id": 1,
  "firstName": "John",
  "middleName": "Updated",
  "lastName": "Doe",
  "locationCity": "New York",
  "address": "123 Street",
  "dateOfBirth": "1990-01-01",
  "telephone": "1234567890",
  "positionTitle": "Senior Developer",
  "hireDate": "2020-01-01",
  "email": "john.doe@example.com",
  "salary": 80000.0,
  "status": "Active"
}
```


