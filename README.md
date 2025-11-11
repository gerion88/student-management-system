# Student Management System (Backend)

## Run locally

1) Start Postgres via Docker:
```bash
docker compose up -d
```

2) Build & run the app:
```bash
./mvnw spring-boot:run
# or: mvn spring-boot:run
```

3) Open Swagger UI:
- http://localhost:8080/swagger-ui/index.html

## Endpoints (students)
- `GET /api/students?page=0&size=20&q=`
- `GET /api/students/{id}`
- `POST /api/students`
- `PUT /api/students/{id}`
- `DELETE /api/students/{id}`
