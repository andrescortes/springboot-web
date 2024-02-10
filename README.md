# Spring Boot MVC with Thymeleaf

This project is a simple example of using Spring Boot with MVC and Thymeleaf for building web applications.

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven or Gradle for dependency management (if using Maven, you can use the Maven Wrapper included in the project)

## Getting Started

To run the application locally, you can use the following command:

```bash
./mvnw spring-boot:run
```

## Project Structure
The project structure follows the standard layout for a Spring Boot application:
```
project
├── src
│   ├── main
│   │   ├── java             # Java source files
│   │   │   └── com.example  # Package for application code
│   │   │       ├── controller    # MVC controllers
│   │   │       ├── model         # Data model classes
│   │   │       ├── service       # Business logic services
│   │   │       └── Application.java  # Main application class
│   │   └── resources        # Static resources, templates, and application properties
│   │       ├── static       # Static assets (CSS, JavaScript, etc.)
│   │       └── templates    # Thymeleaf templates
│   └── test                # Test source files
└── pom.xml                 # Project object model for Maven
```
## Features
1. MVC architecture for building web applications
2. Thymeleaf for server-side HTML templates
3. Dependency management with Maven or Gradle
4. Auto-configuration and convention over configuration with Spring Boot

## Resources
Spring Boot Documentation
Thymeleaf Documentation
