# 🚀 Auth Service

This project is an authentication API built with Spring Boot, created to practice backend concepts and simulate a real-world authentication flow.

The goal is not just to make it work, but to follow good practices like clean architecture, separation of responsibilities, and secure password handling.

---

## 📌 Features

* User registration
* Password encryption using BCrypt
* Data validation with Bean Validation
* Clean separation between layers (Controller, Service, Repository)

---

## 🧠 What I'm practicing here

This project is part of my learning journey as a backend developer.
Some of the main concepts I'm focusing on:

* Structuring a REST API properly
* Using DTOs to control input and output
* Keeping business logic inside the service layer
* Securing sensitive data (like passwords)
* Writing cleaner and more maintainable code

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Lombok
* Jakarta Validation

---

## 📂 Project Structure

src/main/java/com/yourproject

├── controller
├── service
├── dto
├── entity
├── repository
├── validation
└── config

---

## 🔐 Security

Passwords are encrypted using BCrypt before being stored in the database.
This ensures that sensitive data is never saved in plain text.

---

## 📮 Endpoint

### Register User

POST /auth/register

Request:

{
"name": "Patrick",
"age": 25,
"phone": "11999999999",
"email": "[patrick@email.com](mailto:patrick@email.com)",
"password": "123456"
}

Response:

{
"id": 1,
"name": "Patrick",
"age": 25,
"phone": "11999999999",
"email": "[patrick@email.com](mailto:patrick@email.com)"
}

---

## ⚙️ Running the project

1. Clone the repository

git clone https://github.com/PatrickRebecchi/auth-service.git

2. Configure your database (PostgreSQL)

spring.datasource.url=jdbc:postgresql://localhost:5432/authdb
spring.datasource.username=your_user
spring.datasource.password=your_password

3. Run the application

./mvnw spring-boot:run

---
## 🐳 Running with Docker

This project uses Docker to run a PostgreSQL database in an isolated environment.

### Requirements
- Docker installed

### How to run

docker-compose up -d

---

## 🚧 Next steps

* Implement login
* Add JWT authentication
* Email confirmation with token
* Global exception handling
* Improve project structure

---
## 🤖 AI-assisted learning

During the development of this project, I used AI tools as a support resource for learning and problem-solving.
The focus was on understanding the concepts and building solutions independently, rather than copying code.

---

## 👨‍💻 About me

I'm currently studying Software Engineering and focusing on backend development with Java.

