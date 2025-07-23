


# AWS Challenge - Backend Java Spring Boot

This microservice is built with Java 17 and Spring Boot 3.x, following hexagonal architecture and DDD. It exposes endpoints for person management. Authentication is handled by AWS Cognito and JWT, validated at the API Gateway layer. The API is exposed via a single route using `{proxy+}` in API Gateway.



## Main Endpoints

- `POST /api/v1/person` - Save person
- `GET /api/v1/person/{id}` - Get person by id



## Tech Stack
- Java 17
- Spring Boot 3.x
- MySQL 8.0 (RDS)
- JPA/Hibernate
- MapStruct + Lombok
- Gradle 7+
- JUnit 5 + Mockito
- Swagger/OpenAPI
- Docker
- AWS Cognito (JWT, API Gateway auth)



## Local Run

1. Set the environment variables (see below).
2. Run:
   ```sh
   ./gradlew bootRun --args='--spring.profiles.active=prod'
   ```




## Environment Variables

The application uses AWS Parameter Store and Secrets Manager for environment variable management in production. The Task Definition in ECS should reference the Parameter Store/Secrets Manager ARNs or paths for each variable. For local or Docker development, you can set the variables directly:

```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=retoaws_person_db
DB_USERNAME=root
DB_PASSWORD=toor
SERVER_PORT=8191
# Cognito
COGNITO_CLIENT_ID=xxxxxxx
COGNITO_CLIENT_SECRET=xxxxxxx
COGNITO_POOL_ID=xxxxxxx
COGNITO_REGION=us-east-1
```

> **Note:** Default production port is `8191`.



## Authentication (AWS Cognito)

- Authentication is managed by AWS Cognito. JWT tokens are validated by API Gateway.
- Endpoints are protected and require a valid JWT issued by Cognito.
- The login flow is handled outside the backend (Cognito Hosted UI or your own client).
- For testing with Postman or similar, obtain a JWT from Cognito and use it as a `Bearer` token in the `Authorization` header.

### Example: Using JWT in Postman

1. Log in to Cognito and copy the `id_token` or `access_token`.
2. In your requests, add the header:
   ```
   Authorization: Bearer <your_jwt_token>
   ```



## Docker

1. Build the image:
   ```sh
   docker build -t retoaws-backend .
   ```
2. Run the container:
   ```sh
   docker run -d --name retoaws-backend \
     -e DB_HOST=localhost \
     -e DB_PORT=3306 \
     -e DB_NAME=retoaws_person_db \
     -e DB_USERNAME=root \
     -e DB_PASSWORD=toor \
     -e SERVER_PORT=8191 \
     -e COGNITO_CLIENT_ID=xxxxxxx \
     -e COGNITO_CLIENT_SECRET=xxxxxxx \
     -e COGNITO_POOL_ID=xxxxxxx \
     -e COGNITO_REGION=us-east-1 \
     -p 8191:8191 retoaws-backend
   ```


## AWS ECS/ECR Deployment

1. Build and push the image to ECR.
2. Configure ECS to pass the environment variables (see above).
3. Ensure the security group allows port `8191`.
4. Set the active profile to `prod`.



## Swagger / OpenAPI

- Interactive docs: `http://localhost:8191/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8191/v3/api-docs`


## Testing

```sh
./gradlew test
```



## Important Notes

- The system uses AWS Parameter Store and Secrets Manager for environment variables in production (via ECS Task Definition ARNs/paths).
- Default port is `8191` (configurable).
- Authentication is via Cognito (JWT validated by API Gateway, not Spring Security).
- Check logs for startup and error details.

## Contact

For questions or support, contact the project maintainers.
