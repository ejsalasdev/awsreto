
# Person API

This microservice is built with Java 17 and Spring Boot 3.x, following hexagonal architecture and Domain-Driven Design (DDD) principles. The API provides endpoints to create and retrieve person records, with robust validation and test coverage focused on domain logic.

## Endpoints

### 1. Create Person
- **POST** `/api/v1/person/save`
- **Request Body:**
  - Contains identification number, name, and email fields.
- **Response:**
  - Returns the created person object with its attributes.
- **Errors:**
  - Returns a conflict error if the person already exists.

### 2. Get Person
- **GET** `/api/v1/person/{identificationNumber}`
- **Response:**
  - Returns the person object if found.
- **Errors:**
  - Returns a not found error if the person does not exist.

## Architecture
- Hexagonal (Ports & Adapters)
- DDD: Domain models, use cases, and validations
- Persistence: H2 for local development, ready for MySQL/RDS
- MapStruct: Entity-model mapping
- Swagger/OpenAPI: Automatic documentation
- Testing: JUnit 5 + Mockito, Jacoco coverage for use cases

## Usage
- Development: `./gradlew bootRun`
- Testing: `./gradlew test`
- Coverage: `./gradlew jacocoTestReport`
- Swagger UI: `/swagger-ui.html`

## Environment Variables
```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=retoaws_person_db
DB_USERNAME=root
DB_PASSWORD=toor
JWT_SECRET=your-secret-key
JWT_EXPIRATION=86400000
SERVER_PORT=8092
```

## Considerations
- Centralized validation and error handling
- Minimum 80% coverage on domain logic
- Code and documentation in English
- Conventional commits and branching

---
> For technical questions, refer to the Swagger documentation and the tests in `src/test/java/com/talentpool/retoaws/domain/usecases/PersonUseCaseTest.java`.
