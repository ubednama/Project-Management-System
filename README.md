# Project Management System - Backend

## Overview

The Project Management System is a comprehensive solution designed to manage projects efficiently. This backend is built using Spring Boot and provides robust APIs for the frontend to interact with. It includes features such as user authentication, project creation and management, task tracking, and integration with external services.

## Technologies Used

### Backend

- **Spring Boot**: A powerful framework for building Java-based applications.
- **Spring Data JPA**: Simplifies database access and provides a high-level abstraction for ORM.
- **Spring Security**: Comprehensive security framework for Java applications.
- **MySQL**: Relational database management system.
- **JJWT**: Java library for JSON Web Tokens.
- **Lombok**: Java library that helps to reduce boilerplate code.
- **Spring Mail**: For sending emails.
- **Razorpay**: Payment gateway integration.

### Dependencies

- **Spring Boot Starter Data JPA**
- **Spring Boot Starter JDBC**
- **Spring Boot Starter Security**
- **Spring Boot Starter Web**
- **Spring Boot DevTools**
- **Spring Cloud GCP Starter SQL MySQL**
- **Lombok**
- **Spring Boot Starter Test**
- **Spring Security Test**
- **JJWT (API, Implementation, Jackson)**
- **Spring Boot Starter Mail**
- **JSON**
- **Razorpay Java**

## Features

- User authentication and authorization
- Project creation and management
- Task tracking and assignment
- Real-time updates and notifications
- Integration with external services (e.g., payment gateways)
- Email notifications

## Getting Started

### Prerequisites

- Java 17
- MySQL database
- Maven

### Installation

```sh
#Clone the repository:
git clone https://github.com/ubednama/Project-Management-System.git
cd Project-Management-System

#Build the project:
mvn clean install

#Run the application:
mvn spring-boot:run
```

### Configuration

- **Backend Configuration**:
    Update the `.env` file environment variables.

## Deployment

The backend is deployed on Google Cloud Platform.

## Contributing

Contributions are welcome.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
