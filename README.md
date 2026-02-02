# FieldOps

FieldOps is a Kotlin + Ktor backend service built to practice and demonstrate
production-ready backend patterns.

The project is intentionally developed step-by-step to mirror how real backend
services evolve in professional environments.

## Tech Stack
- Kotlin
- Ktor (Netty)
- kotlinx.serialization
- Gradle
- Logback

## Current Features
- Health check endpoint (`GET /health`)
- Example API endpoint (`GET /hello`)
- JSON request/response handling
- Centralized error handling
- Request logging
- In-memory persistence (repository pattern)
- Basic API tests

## Project Structure
- `plugins/` – Ktor plugins (logging, serialization, error handling)
- `routes/` – HTTP endpoints
- `models/` – API data models
- `repository/` – Persistence abstractions
- `Application.kt` – Server bootstrap

## Running the Service

```bash
./gradlew run
