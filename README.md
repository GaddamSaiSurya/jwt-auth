# JWT Authentication API

A production-style JWT Authentication API built using Spring Boot 3, Spring Security 6, PostgreSQL, and JWT.

## Features

- User Registration
- User Login
- BCrypt Password Encryption
- JWT Token Generation
- JWT Token Validation
- Stateless Authentication
- Spring Security Integration
- Protected Endpoints
- Global Exception Handling
- Request Validation
- Layered Architecture
- PostgreSQL Integration
- Dockerized Application

## Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Security 6
- Spring Data JPA
- PostgreSQL
- JWT (JJWT)
- Maven
- IntelliJ IDEA
- Docker
- Docker Compose

## Run Locally

mvn spring-boot:run

## Run with Docker

docker compose up --build

## Project Structure

```
src
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── repository
 ├── security
 └── service
```

## Authentication Flow

```
Client
   │
   ▼
Login Request
   │
   ▼
AuthenticationManager
   │
   ▼
CustomUserDetailsService
   │
   ▼
PostgreSQL
   │
   ▼
Password Verification
   │
   ▼
JWT Generation
   │
   ▼
JWT Returned to Client
```

For every protected request:

```
Client
   │
Bearer Token
   │
   ▼
JwtAuthenticationFilter
   │
   ▼
JWT Validation
   │
   ▼
SecurityContext
   │
   ▼
Protected Controller
```

## API Endpoints

### Register

```
POST /api/auth/register
```

Request

```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

---

### Login

```
POST /api/auth/login
```

Request

```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

### Protected Endpoint

```
GET /api/test
```

Header

```
Authorization: Bearer <JWT_TOKEN>
```

---

## Security Features

- BCrypt Password Hashing
- Stateless Authentication
- JWT Signature Verification
- Token Expiration
- Spring Security Filter Chain
- Role-based Authority Support

## What I Learned

- Spring Security Architecture
- AuthenticationManager
- UserDetails & UserDetailsService
- SecurityFilterChain
- OncePerRequestFilter
- JWT Authentication Flow
- Password Encryption with BCrypt
- Stateless Authentication
- Dependency Injection
- Layered Backend Architecture

## Future Improvements

- Refresh Tokens
- Email Verification
- Forgot Password
- Docker Deployment
- Role-based Authorization (ADMIN)
- Unit & Integration Tests
