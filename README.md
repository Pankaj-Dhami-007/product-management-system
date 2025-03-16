# Product Catalog Management System

### Introduction
The **Product Catalog Management System** is a comprehensive solution for managing products and categories, designed using **Spring Boot**. It includes secure CRUD operations for products and categories, JWT-based authentication and authorization, and RESTful APIs for seamless integration. The system is built to ensure scalability, security, and maintainability, making it a robust platform for product management.

This project also provides detailed API documentation using **Swagger** and includes a **Postman collection** for testing the endpoints. By leveraging **Spring Data JPA**, it simplifies database operations and ensures efficient interaction with the underlying database.

### Key Features:
- **RESTful APIs**: 
  CRUD operations are implemented using Spring Data JPA for Product and Category entities. The relationship between these entities (e.g., One-to-Many, Many-to-One) is established and managed through the APIs.

- **Data Transfer Objects (DTOs)**: 
  DTOs are used to transfer data between layers, ensuring encapsulation and abstraction of the business logic, instead of exposing entities directly.

- **Spring Security with JWT**: 
  JWT Token-based authentication and authorization is implemented to secure the system. The project includes secure login and registration endpoints, and API access is controlled through token-based authorization.

- **User Entity**: 
  A User entity is implemented to handle user registration and login functionalities. The application secures endpoints and ensures that only authenticated users can access protected resources.

- **Global Exception Handling**: 
  Centralized global exception handling is implemented to provide meaningful error messages and ensure that the application is robust and user-friendly.

- **Swagger API Documentation**: 
  Swagger is integrated for easy API documentation and testing, enabling you to explore the APIs interactively via the Swagger UI.

- **Postman Collection**: 
  A Postman collection is included to help test all APIs and demonstrate the functionality of the endpoints.

- **Spring Boot and Spring Data JPA**: 
  This project uses Spring Boot for fast application development, and Spring Data JPA to interact with the database effortlessly.

---

### Technologies Used:
- **Spring Boot (Java)**
- **Spring Data JPA (Hibernate)**
- **Spring Security**
- **JWT (JSON Web Token) for authentication and authorization**
- **Swagger for API documentation**
- **Postman for API testing**
- **DTO pattern for data transfer**
- **Global Exception Handling**

---

### Project Structure:

#### Entities:
- **Product**: Represents the product entity with fields like `id`, `name`, `price`, `category`, etc.
- **Category**: Represents product categories, with relationships established to Product.

#### Controllers:
- **ProductController**: Handles all CRUD operations for the Product entity.
- **CategoryController**: Handles all CRUD operations for the Category entity.

#### Services:
- Service layer contains business logic for interacting with the repository layer.

#### DTOs:
- DTOs for Product and Category are used to handle data transfer between layers.

#### Security:
- **Spring Security** is implemented with **JWT** for secure login, registration, and access control of API endpoints.

#### Exception Handling:
- Global exception handling is implemented to manage and structure error responses across the application.

---
