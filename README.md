# User Management REST Api

A Production-ready Backend Service Built With Spring Boot to handle robust User Profile Management, Dynamic Data Mapping, and input Validation Workflows.

# Tech Stack & Ecosystem
* **Core Framework:** Java 26 & Spring Boot 4.1.0 (Web, Data JPA)
* **Database Layer:** MySQL JDBC Connector
* **Data Mapping:** ModelMapper
* **Documentation:** Springdoc OpenAPI (Swagger UI Interface)
* **Boilerplate Reduction:** Project Lombok with Annotation Processing
* **Validation:** Jakarta Bean Validation API

* # Key Features
* **Complete CRUD:** RESTful endpoints utilizing standard HTTP verbs (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`).
* **Optimized Object Merging:** Implements explicit ModelMapper destination object binding during entity updates, preventing state loss or structural row duplication.
* **Credential Isolation:** Keeps local database connection strings completely safe from version control tracking by utilizing IDE environment variable injections.
* **Interactive Testing Dashboard:** Features a live API explorer via integrated Swagger interface wrappers built for the Spring Boot 4 ecosystem.

* # REST API Specifications
* # User Endpoints
* | HTTP Method | Endpoint Path | Context Description |
| :--- | :--- | :--- |
| `GET` | `/user/all` | Retrieve all registered records |
| `GET` | `/user/id/{id}` | Lookup a user profile by primary key |
| `GET` | `/user/username/{username}` | Lookup a user profile by unique username |
| `POST` | `/user` | Register a new user |
| `PUT` | `/user/{username}` | Rewrite of an existing user profile record |
| `PATCH` | `/user/{username}` | Partial dynamic update of target user fields |
| `DELETE` | `/user/id/{id}` | Delete user profile record using primary key |
| `DELETE` | `/user/username/{username}` | Delete user profile record using username |
---

## Interactive Swagger API Documentation
## Swagger UI Dashboard (Visual Interface)
Use this web page to view all endpoints in a clean UI, look at response models, and execute live API requests:
**[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

## OpenAPI Specifications (Raw JSON Data)
Use this endpoint to view or export the underlying raw OpenAPI 3 specification data:
**[http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)**
