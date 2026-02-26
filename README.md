# YatiLab Backend

YatiLab Backend is a **Spring Boot–based REST API** that powers the YatiLab research platform.  
It provides authentication, data persistence, and API services for the frontend application.

The project is built using **Java, Spring Boot, Maven, PostgreSQL, and Docker**.

---

# Project Structure

```text
yatilab
│
├── .github
├── .idea
├── .mvn
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.research.yatilab
│   │   │       ├── controller
│   │   │       ├── handler
│   │   │       ├── model
│   │   │       ├── repo
│   │   │       ├── security
│   │   │       └── YatilabApplication.java
│   │   │
│   │   └── resources
│   │
│   └── test
│
├── target
├── docker-compose.yml
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# Technology Stack

## Backend
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA

## Database
- PostgreSQL

## Build Tool
- Maven

## Containerization
- Docker
- Docker Compose

## Frontend
- React

---

# Maven Build

Build the project using Maven:

```bash
mvn clean install
```

This command will:

- Download dependencies
- Compile the code
- Run tests
- Generate a JAR file

Generated artifact location:

```
target/yatilab-0.0.1-SNAPSHOT.jar
```

---

# Run the Spring Boot Application

### Run using Maven

```bash
mvn spring-boot:run
```

### Run using JAR

```bash
java -jar target/yatilab-0.0.1-SNAPSHOT.jar
```

Application will start at:

```
http://localhost:8080
```

---

# Docker Support

The project includes Docker configuration for running the full stack.

Services included:

- PostgreSQL
- Spring Boot Backend
- React Frontend

---

# Build Docker Image for Backend

```bash
docker build -t yatilab-backend .
```

Verify image:

```bash
docker images
```

---

# PostgreSQL Docker Image

The application uses the official PostgreSQL image.

```
postgres:15
```

Configuration:

```
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=postgres
```

Port:

```
5432
```

---

# Docker Compose

The repository includes a docker-compose setup to run the entire system.

```
docker-compose.yml
```

---

# Docker Compose Build

Build all services defined in docker-compose:

```bash
docker compose build
```

This will:

- Build Spring Boot backend image
- Build React frontend image
- Pull PostgreSQL image

---

# Start All Containers

```bash
docker compose up
```

Run in background:

```bash
docker compose up -d
```

---

# Access Applications

### Backend API

```
http://localhost:8080
```

### Frontend

```
http://localhost:3000
```

### PostgreSQL

```
localhost:5432
```

---

# View Logs

```bash
docker compose logs
```

Specific service logs:

```bash
docker compose logs springboot-app
docker compose logs postgres
docker compose logs react-app
```

---

# Stop Containers

```bash
docker compose down
```

Remove volumes as well:

```bash
docker compose down -v
```

---

# Frontend Repository

Frontend code is available at:

https://github.com/uaerty/YatiLab

---

# Author

Dr. Yatish Bathla  
YatiLab – Research in Information and Communication Technologies
