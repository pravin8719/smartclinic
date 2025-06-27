# ✅ Stage 1: Build the application
FROM gradle:8.5-jdk17 AS builder

# Copy only build files first (for better caching)
COPY build.gradle settings.gradle gradle.properties gradlew /app/
COPY gradle /app/gradle

WORKDIR /app

# Pre-download dependencies
RUN ./gradlew build -x test || return 0

# Copy the full source
COPY . /app

# Build the JAR
RUN ./gradlew clean build -x test

# ✅ Stage 2: Create a minimal runtime image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
