👨‍💼 Employee Management System

<div align="center">

🚀 A RESTful Employee Management System built with Spring Boot, JPA & PostgreSQL

Manage employee records through a clean layered backend architecture with CRUD operations, PostgreSQL persistence, and REST APIs.

<br/>








</div>

📌 About the Project

Employee Management System is a backend application developed using Java, Spring Boot, Spring Data JPA, and PostgreSQL.

The project demonstrates how to build a layered REST API for managing employee information. It includes employee creation, employee retrieval by ID, complete employee updates, email updates, and employee deletion.

The application follows a simple and maintainable architecture:

Client
  │
  ▼
REST Controller
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
PostgreSQL Database

✨ Features

✅ Create a new employee

🔍 Find an employee by ID

✏️ Update complete employee details

📧 Update employee email separately

🗑️ Delete an employee

🛡️ Custom EmployeeNotFoundException

🗄️ PostgreSQL database integration

🔗 Spring Data JPA repository

🧩 Layered architecture

♻️ Lombok for reducing boilerplate code

🆔 Automatic employee ID generation starting from 100

📦 Maven-based project

🧪 Spring Boot test setup

🛠️ Tech Stack

Technology

Usage

☕ Java 21

Application development

🌱 Spring Boot 4.1.0

Backend framework

🌐 Spring Web MVC

REST API development

🗃️ Spring Data JPA

Database access

🐘 PostgreSQL

Relational database

📦 Maven

Dependency & build management

♻️ Lombok

Boilerplate reduction

🎨 Vaadin 25.2.1

UI/application frontend support

🧪 JUnit / Spring Boot Test

Testing

🏗️ Project Structure

EmployeeManagementSystem/
│
├── src/
│   ├── main/
│   │   ├── java/com/ems/EmployeeManagementSystem/
│   │   │   │
│   │   │   ├── Controller/
│   │   │   │   └── EmployeeController.java
│   │   │   │
│   │   │   ├── Entity/
│   │   │   │   └── Employee.java
│   │   │   │
│   │   │   ├── Exception/
│   │   │   │   └── EmployeeNotFoundException.java
│   │   │   │
│   │   │   ├── Repository/
│   │   │   │   └── EmployeeRepository.java
│   │   │   │
│   │   │   ├── Service/
│   │   │   │   └── EmployeeService.java
│   │   │   │
│   │   │   └── EmployeeManagementSystemApplication.java
│   │   │
│   │   ├── resources/
│   │   │   └── application.properties
│   │   │
│   │   └── frontend/
│   │       └── index.html
│   │
│   └── test/
│       └── java/
│           └── EmployeeManagementSystemApplicationTests.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md

🧩 Architecture

1️⃣ Controller Layer

EmployeeController exposes REST endpoints under:

/api/v1/employee

It receives HTTP requests and delegates business operations to the service layer.

2️⃣ Service Layer

EmployeeService contains the application/business logic and communicates with the repository.

3️⃣ Repository Layer

EmployeeRepository extends:

JpaRepository<Employee, Long>

This provides built-in database operations such as:

save()

findById()

deleteById()

findAll()

and more

4️⃣ Entity Layer

The Employee class is mapped to a PostgreSQL table using JPA annotations.

Employee fields:

id
name
age
email
password

🔌 REST API Endpoints

Base URL:

http://localhost:8080/api/v1/employee

➕ Create Employee

POST

/api/v1/employee/signup

Request Body

{
  "name": "Prajval",
  "age": 22,
  "email": "prajval@example.com",
  "password": "123456"
}

Example cURL

curl -X POST http://localhost:8080/api/v1/employee/signup \
-H "Content-Type: application/json" \
-d "{\"name\":\"Prajval\",\"age\":22,\"email\":\"prajval@example.com\",\"password\":\"123456\"}"

🔍 Find Employee by ID

GET

/api/v1/employee/{id}

Example:

GET http://localhost:8080/api/v1/employee/100

Example Response

{
  "id": 100,
  "name": "Prajval",
  "age": 22,
  "email": "prajval@example.com",
  "password": "123456"
}

⚠️ For a production application, passwords should never be returned in API responses. Password hashing and DTO-based responses should be added.

✏️ Update Employee

PUT

/api/v1/employee

Request Body

{
  "id": 100,
  "name": "Prajval VK",
  "age": 23,
  "email": "prajvalvk@example.com",
  "password": "newPassword"
}

📧 Update Employee Email

PATCH

/api/v1/employee/{id}/{email}

Example:

PATCH http://localhost:8080/api/v1/employee/100/newmail@example.com

This updates only the employee's email address.

🗑️ Delete Employee

DELETE

/api/v1/employee/{id}

Example:

DELETE http://localhost:8080/api/v1/employee/100

📋 Get All Employees

The project currently contains the endpoint:

GET /api/v1/employee

but FetchAll() is not implemented yet and currently returns null.

Suggested implementation

@GetMapping
public List<Employee> fetchAll() {
    return employeeService.fetchAll();
}

And in the service:

public List<Employee> fetchAll() {
    return employeeRepository.findAll();
}

🗄️ Database Configuration

The application uses PostgreSQL.

Current configuration:

spring.datasource.url=jdbc:postgresql://localhost:5432/EmployeeManagementSystem
spring.datasource.username=postgres
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

Create the database

Open PostgreSQL / pgAdmin and execute:

CREATE DATABASE EmployeeManagementSystem;

🔐 Important: Do not push real database passwords to GitHub. Use environment variables or an external configuration file for production.

🚀 Getting Started

Prerequisites

Make sure the following are installed:

☕ Java 21

📦 Maven

🐘 PostgreSQL

💻 IntelliJ IDEA / Eclipse / VS Code

🔧 Git

🌐 Postman or another REST API client

1️⃣ Clone the Repository

git clone https://github.com/Prajvalvk/Employee_Management_System.git

cd Employee_Management_System

2️⃣ Configure PostgreSQL

Create the database:

CREATE DATABASE EmployeeManagementSystem;

Then update:

src/main/resources/application.properties

with your local PostgreSQL username and password.

3️⃣ Build the Project

Using Maven:

mvn clean install

Or on Windows with the Maven wrapper:

mvnw.cmd clean install

4️⃣ Run the Application

mvn spring-boot:run

Or:

mvnw.cmd spring-boot:run

The application will be available at:

http://localhost:8080

🧪 Testing the APIs

You can test the REST APIs using:

Postman

Insomnia

cURL

IntelliJ HTTP Client

Recommended testing flow:

1. Create Employee
       ↓
2. Find Employee by ID
       ↓
3. Update Employee
       ↓
4. Update Email
       ↓
5. Delete Employee

🔐 Current Security Notes

This project is intended as a learning/backend project.

Before using it in a production environment, consider adding:

🔒 Spring Security

🔑 Password hashing using BCrypt

🪪 JWT authentication

📦 DTOs instead of exposing entities directly

🚫 Never return passwords in API responses

✅ Bean Validation

🌐 Global exception handling with @ControllerAdvice

🔐 Environment variables for database credentials

📝 API documentation with Swagger/OpenAPI

📊 Logging instead of System.out.println()

🔮 Future Enhancements

Some useful improvements planned for the project:

Implement GET /api/v1/employee for all employees

Add DTO layer

Add request validation

Add global exception handling

Add Spring Security

Add JWT authentication

Hash employee passwords

Add pagination and sorting

Add employee search/filter

Add Swagger/OpenAPI documentation

Add comprehensive unit and integration tests

Add a polished frontend dashboard

Dockerize the application

Deploy backend and database

📚 What This Project Demonstrates

This project is useful for demonstrating practical knowledge of:

Java
  ↓
Spring Boot
  ↓
REST API
  ↓
Spring Data JPA
  ↓
Hibernate
  ↓
PostgreSQL

It also demonstrates:

Dependency Injection

REST controllers

Service-repository architecture

JPA entity mapping

Repository abstraction

Exception handling

CRUD operations

Maven project management

PostgreSQL integration

👨‍💻 Author

Prajval V K

🎓 Computer Science & Engineering
💻 Java | Spring Boot | SQL | PostgreSQL
🚀 Backend & Full Stack Development





⭐ Support

If you found this project useful, consider giving the repository a ⭐ on GitHub.

<div align="center">

Built with ☕ Java + 🌱 Spring Boot + 🐘 PostgreSQL

Employee Management System

</div>
