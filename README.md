# coffee-catalog-api

### Architecture

1. Entity layer (Database mapping)
2. Repository Layer (Data access)
3. Response / Request / Mapper Layer (DTO - Data Transfer Objects)
4. Service Layer (Business logic)
5. Controller Layer (REST API)
6. Exception Handling
7. Testing

## Docker

### Start PostgreSQL

`docker-compose up -d`

### Check if running

`docker-compose ps`

### View logs

`docker-compose logs -f postgres`

## Spring Boot

`./mvnw spring-boot:run`

## Swagger UI

`http://localhost:8080/swagger-ui.html`

## OpenAPI api-docs (Postman Collection)

`http://localhost:8080/api-docs`

### Postman Collection

Import the collection and environment:

- Collection: `src/main/resources/postman/collection.json`
- Environment: `src/main/resources/postman/local_environment.json`

## Auth and Refresh Token

- Login: `POST /api/auth/login` returns access token and refresh token
- After 15 mins (example): `GET /api/coffees` returns 401 (Unauthorized) expired token
- Refresh Token: `POST /api/auth/refresh-token` with refresh token returns new access token
- Logout: `POST /api/auth/logout` revokes the refresh token returns 403 (Forbidden)
- Or after 7 days refresh token expires and user needs to login again

### On FE, store access token In-Memory Storage (Redux) + HttpOnly Cookie for Refresh Token

- axios create instance interceptor with token and withCredentials: true (crucial to allow
  sending cookies to the API)
- On 401 error, call refresh token without intervention from user
- On 403 error, redirect to login page
