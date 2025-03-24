# simpleauth-springboot

Project Report: Spring Boot Authentication Service

**1. Introduction:**

This project is a robust, RESTful authentication and authorization service built using Spring Boot. It provides secure user registration, login, role-based access control, and user management functionalities. It aims to simplify and standardize authentication across various applications and services within the organization, particularly those interacting with USB framework components.

**2. Why Needed:**

Centralized Authentication: Existing authentication mechanisms may be scattered or inconsistent. This service provides a centralized and standardized approach, improving security and maintainability.
Role-Based Access Control (RBAC): Many USB framework applications require fine-grained access control based on user roles. This service enables efficient management of roles and permissions.
Security: Addresses vulnerabilities associated with ad-hoc authentication implementations.
Scalability: Spring Boot's architecture allows for easy scaling as the number of users and applications grows.
Integration: Simplifies integration with other systems and services.

**3. What It Does:**

User Registration: Allows new users to create accounts.
User Login: Authenticates users and provides secure access.
Role Management: Enables admin users to assign and update user roles.
Role-Based Access Control: Protects endpoints based on user roles (e.g., admin dashboard).
User Retrieval: allows a user to be retrieved by username.

**4. Tech Stack:**

Spring Boot: Framework for building RESTful APIs.
Spring Security: Handles authentication and authorization.
Java: Programming language.
MySQL: Database for storing user and role information.
JPA/Hibernate: Object-relational mapping.
Postman: API testing tool.
Git/GitHub: Version control and collaboration.
BCryptPasswordEncoder: Secure password hashing.

**5. Results:**

Successfully implemented secure user registration and login.
Established role-based access control for protected endpoints.
Created a scalable and maintainable authentication service.
Improved security of the system.
Simplified user management.

**6. Tools:**

Eclipse (IDE).
MySQL Workbench or command-line client.
Postman.
Git.

**7. Technologies:**

RESTful API design.
JSON data format.
HTTP protocol.
Spring Security.
JPA/Hibernate.

**8. Challenges:**

Designing a robust and secure role-based access control system.
Handling database interactions and ensuring data integrity.
Integrating Spring Security with Spring Boot.
Ensuring proper authentication and authorization.
Debugging security related issues.

**9. Future Scope:**

Implement OAuth 2.0 for third-party authentication.
Add JWT (JSON Web Token) support for stateless authentication.
Integrate with LDAP or Active Directory for enterprise environments.
Implement password reset functionality.
Add more detailed logging.
Add endpoint for user deletion.
Add endpoint for changing user password.

**10. What's New From Present:**

Centralized and standardized authentication.
Fine-grained role-based access control.
Improved security and maintainability.
Scalability for future growth.
Simplified integration with other services.

**11. Input and Output:**

Input:
User registration requests (username, password).
Login requests (username, password).
User role update requests (username, roles).
Username for user retrieval.
Output:
Authentication tokens (or session IDs).
User details (JSON).
Success/error messages (JSON).

**12. Use Cases:**

Securing USB device management applications.
Controlling access to diagnostic tools and logs.
Managing user permissions for firmware updates.
Authenticating users for data analysis and reporting tools.
13. Daily Life Use (Samsung USB Framework Team):

**13. Current uses**

Simplifies authentication for new USB framework applications.
Provides a secure and consistent way to manage user permissions.
Reduces the time and effort required to implement authentication.
Allows you to easily test security related features of the USB framework applications.

**14. For Users:**

Provides a secure and reliable login experience.
Ensures that users only have access to authorized features.
Protects sensitive data and operations.

**15. System Architecture Diagram:**

    A[Client (Postman, UI, etc.)] -->|HTTP Requests| B(Spring Boot Authentication Service);
    B -->|Database Queries| C[MySQL Database];
    B -->|Authentication/Authorization| D[Spring Security];
    B -->|Data Transfer| E[JSON];
    D --> C;
Explanation:

Client: Represents any application or user interface that interacts with the authentication service (e.g., Postman for testing, a web UI, or another application).
Spring Boot Authentication Service: The core application that handles authentication, authorization, and user management.
MySQL Database: Stores user data, roles, and user-role relationships.
Spring Security: Manages authentication and authorization logic.
JSON: The data format used for communication between the client and the service.

**16 . Project Structure:**

simpleauth/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── simpleauth/
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── UserController.java
│   │   │   │   │   │   │   ├── AdminController.java
│   │   │   │   │   │   ├── dto/
│   │   │   │   │   │   │   ├── RegistrationRequest.java
│   │   │   │   │   │   │   ├── UpdateUserRolesRequest.java
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── User.java
│   │   │   │   │   │   │   ├── Role.java
│   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   ├── UserRepository.java
│   │   │   │   │   │   ├── security/
│   │   │   │   │   │   │   ├── WebSecurityConfig.java
│   │   │   │   │   │   ├── service/
│   │   │   │   │   │   │   ├── UserService.java
│   │   │   │   │   │   ├── SimpleauthApplication.java
│   │   │   │   │   │   ├── SimpleauthApplicationTests.java
│   │   │   │   │   ├── resources/
│   │   │   │   │   │   ├── application.properties
│   │   │   │   │   │   ├── application.yml
│   │   │   │   │   ├── test/
│   │   │   ├── pom.xml (Maven) or build.gradle (Gradle)

**17. Explanation of Key Directories and Files:**

controller/: Contains REST controllers (UserController.java, AdminController.java) that handle HTTP requests.
dto/: Contains Data Transfer Objects (RegistrationRequest.java, UpdateUserRolesRequest.java) for request and response payloads.
model/: Contains entity classes (User.java, Role.java) that represent database tables.
repository/: Contains JPA repositories (UserRepository.java) for database interactions.
security/: Contains Spring Security configuration (WebSecurityConfig.java).
service/: Contains service classes (UserService.java) for business logic.
application.properties or application.yml: Configuration files for Spring Boot.
pom.xml (Maven) or build.gradle (Gradle): Build configuration files.

**18. Data Flow Diagram (Example: User Registration):**

sequenceDiagram
    participant Client
    participant UserController
    participant UserService
    participant UserRepository
    participant MySQL Database

    Client->>UserController: POST /register (RegistrationRequest)
    UserController->>UserService: registerUser(RegistrationRequest)
    UserService->>UserRepository: save(User)
    UserRepository->>MySQL Database: INSERT INTO users
    MySQL Database-->>UserRepository: Success
    UserRepository-->>UserService: User Object
    UserService-->>UserController: User Object
    UserController-->>Client: 200 OK (User Registered)
Explanation:

The client sends a POST request to the /register endpoint with user registration details.
The UserController delegates the registration logic to the UserService.
The UserService uses the UserRepository to save the user data to the database.
The database confirms the successful insertion.
The user object is returned, and then a 200 ok response is sent to the client.


*******************************************************************************************************************************************************************

**Testing**

**1. Results:**

Successful Implementation of Core Features:
The service successfully implements user registration, login, user retrieval, and role-based access control.
Admin users can effectively manage user roles.
Improved Security:
Password hashing using BCryptPasswordEncoder ensures secure storage of user credentials.
Role-based access control restricts access to protected endpoints, minimizing security risks.
Robust and Scalable Architecture:
Spring Boot's architecture enables easy scaling and maintenance.
The service is designed to handle a growing number of users and applications.
Simplified Integration:
The RESTful API design allows for easy integration with various client applications.
The service is able to return JSON responses that are easy to use.
Positive Testing Outcomes:
All test cases passed, validating the service's functionality and reliability.

**2. Testing Postman:**

Unit Testing (If Applicable):
While this project primarily focuses on API testing, unit tests can be written for service classes and other components.
For example, testing the UserService methods to ensure they correctly interact with the UserRepository.

**API Testing (Postman):**

**Login Endpoint (/login):**
Tested with valid and invalid credentials.
Verified successful login and 401 Unauthorized responses.
**Admin Dashboard Endpoint (/admin/dashboard):**
Tested with admin user credentials, regular user credentials, and no credentials.
Verified 200 OK for admin users and 403 Forbidden/401 Unauthorized for others.
**User Registration Endpoint (/register):**
Tested with valid registration data and duplicate usernames.
Verified successful registration and 400 Bad Request responses.
**Get User by Username Endpoint (/users/{username}):**
Tested with valid, and invalid usernames.
Verified 200 ok for valid usernames, and 404 not found for invalid usernames.
**Update User Roles Endpoint (/users/{username}/roles):**
Tested with valid admin credentials, valid usernames, and valid role updates.
Tested with invalid admin credentials, and invalid usernames.
Verified 200 ok for valid requests, and 403 forbidden or 404 not found for invalid requests.
**Database Verification:**
Verified that user and role data is correctly stored in the MySQL database.
Checked the users, roles, and user_roles tables for data integrity.
**Security Testing:**
Ensured that protected endpoints are only accessible to authorized users.
Verified that password hashing is correctly implemented.
Tested that the authorization headers are correctly used.
**Error Handling:**
Tested error scenarios (e.g., invalid usernames, duplicate registrations) and verified that the service returns appropriate error responses.
**Logging:**
Verified that the logs contain proper information, and that they can be used to debug any issues.
**Example Test Case (Postman):**

Test Case: Successful User Login

Endpoint: POST /login

**Request Body:**

JSON

{
    "username": "regularuser",
    "password": "userpassword"
}
**Expected Response:**

Status: 200 OK
Body: Login successful
Actual Response:

Status: 200 OK
Body: Login successful
Result: Pass
