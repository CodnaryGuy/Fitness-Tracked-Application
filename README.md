# Fitness-Tracked-Application
A fully functional Fitness Tracker REST API built using Spring Boot, implementing secure authentication, activity tracking, personalized recommendations, and production-ready best practices.
This project demonstrates real-world backend development concepts including JWT authentication, Spring Security, RBAC, JPA, Docker, and Cloud Deployment.

# Features
✅ User Registration & Login
✅ JWT Authentication & Authorization
✅ Role-Based Access Control (RBAC)
✅ Secure REST APIs
✅ Activity Tracking System
✅ AI-Powered Fitness Recommendations
✅ Input Validation with Bean Validation
✅ Password Encryption using BCrypt
✅ Swagger API Documentation
✅ Dockerized Application
✅ Cloud Deployment Ready
✅ Clean Code using Lombok
✅ MySQL Database Integration

# Technology                                       
  * Spring Boot       --> Backend Framework                 
  * Spring Security   --> Authentication & Authorization    
  * JWT               --> Secure Token-Based Authentication
  * Spring Data JPA   --> ORM & Database Interaction        
  * Hibernate         --> ORM Implementation                
  * MySQL             --> Relational Database
  * Lombok            --> Boilerplate Code Reduction
  * Swagger/OpenAPI   --> API Documentation
  * Docker            --> Containerization
  * BCrypt            --> Password Encryption               


  ## 🔐 Security Implementation ##

This application implements enterprise-level security:
🔒 Spring Security Filter Chain
🔑 JWT Token Generation & Validation
👤 Role-Based Access Control (ADMIN / USER)
🔐 BCrypt Password Encoding
🛡️ Method-Level Security
🎯 Custom JWT Filter Implementation

# 🧪 Input Validation

* Bean Validation Annotations
* Custom Error Responses
* Global Exception Handling
* Request DTO Validation

# 📄 API Documentation
Swagger UI available at:
http://localhost:8080/swagger-ui.html

# 🐳 Docker Setup

# Build Docker Image
docker build -t fitness-monolith .

# Run Container
docker run -p 8080:8080 fitness-monolith

# Run Container With DB Config 
docker run -p 8080:8080 
-e DB_URL=jdbc:mysql://host.docker.internal:3306/DB_Name 
-e DB_USER=username 
-e DB_PWD=password fitness-monolith

# ☁️ Cloud Deployment

The application is cloud-ready and can be deployed on:
* Render  -->  App Deployment
* Neon    -->  Cloud Database

# 🎓 Concepts Covered

* Spring Boot Fundamentals
* DTO Pattern
* Builder Pattern
* Spring Security Architecture
* JWT Authentication Flow
* Role-Based Authorization
* JPA Relationships
* Custom Security Filters
* Bean Validation
* Docker Containerization
* Free Cloud Deployment

