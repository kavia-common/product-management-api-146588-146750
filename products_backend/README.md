# Products Backend

Spring Boot REST API for managing products.

Endpoints:
- GET /api/products
- GET /api/products/{id}
- POST /api/products
- PUT /api/products/{id}
- DELETE /api/products/{id}

Docs:
- Swagger UI: /swagger-ui.html
- OpenAPI JSON: /api-docs

Database:
- Default: In-memory H2 (dev).
- For production, set environment variables for PostgreSQL (DB_URL, DB_USERNAME, DB_PASSWORD) and configure JPA dialect accordingly in application.properties.
```env
DB_URL=jdbc:postgresql://host:port/db
DB_USERNAME=postgres
DB_PASSWORD=secret
```
