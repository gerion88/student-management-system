# student-management-system
This is a backend REST API for managing students, built with Java 21, Spring Boot 3, PostgreSQL, and Docker. It provides full CRUD functionality, Swagger documentation, and a health monitoring endpoint via Spring Boot Actuator.
A backend REST API for managing students, built with **Java 21**, **Spring Boot 3**, **PostgreSQL**, and **Docker**.

---

## Features

- Create, update, delete, and retrieve students
- RESTful API with Swagger UI documentation
- Database migrations with Flyway
- PostgreSQL integration
- Health check endpoint with Spring Actuator

---

## Tech Stack

| Technology | Description |
|-------------|-------------|
| Java 21 | Core language |
| Spring Boot 3 | Main backend framework |
| Spring Data JPA | ORM layer |
| PostgreSQL | Database |
| Flyway | Database versioning |
| Swagger / OpenAPI | API documentation |
| Docker | Containerization (for database) |

---

## Run Locally

### 1️⃣ Clone the project
```bash
git clone https:/
/github.com/gerion88/student-management-system.git



2️⃣ Configure database

Make sure Docker is running, then start PostgreSQL:

docker compose up -d

3️⃣ Run the app
./mvnw spring-boot:run


The app will start at:
 http://localhost:8080

Swagger UI:
 http://localhost:8080/swagger-ui.html

Health check (Actuator):
 http://localhost:8080/actuator/health

Example Request (via Swagger)

POST /api/students

{
  "firstName": "Joe",
  "lastName": "Mason",
  "birthDate": "2025-11-11",
  "email": "joe@example.com",
  "phone": "555-1234"
}


Response:

{
  "id": 1,
  "firstName": "Joe",
  "lastName": "Mason",
  "email": "joe@example.com"
}

🩺 Health Check Example
curl http://localhost:8080/actuator/health


Response:

{"status":"UP"}

🧑‍💻 Author
Georgiy Ryazanov
Full-Stack Developer | Java Backend | REST APIs
🌐 Upwork Profile
 (https://www.upwork.com/freelancers/~012e6a572fed53e5c2?mp_source=share)
