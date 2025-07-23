# --- Stage 1: Build the Spring Boot application with Gradle ---
# Use a JDK image for building. Eclipse Temurin is a popular choice.
FROM amazoncorretto:21-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle wrapper files and build.gradle/settings.gradle
# This ensures that Gradle is self-contained and builds are consistent.
COPY gradlew .
COPY gradlew.bat .
COPY gradle ./gradle
COPY build.gradle .
COPY settings.gradle .

# Copy your application source code
COPY src ./src

# Make gradlew executable
RUN chmod +x gradlew

# Build the Spring Boot application using the Gradle wrapper.
# Use --no-daemon for Docker builds to prevent background processes.
# Use -x test to skip tests for faster build in Docker, or remove if you want tests to run.
RUN ./gradlew bootJar -x test --no-daemon

# --- Stage 2: Create the final, lightweight runtime image ---
# Use a JRE (Java Runtime Environment) image. These are much smaller than JDK images.
FROM amazoncorretto:21-alpine AS runner

# Set the working directory
WORKDIR /app

# Define an argument for the JAR file name.
# Gradle's bootJar typically produces the JAR in build/libs.
ARG JAR_FILE=build/libs/*.jar

# Copy the built JAR file from the 'builder' stage into the 'runner' stage
COPY --from=builder /app/${JAR_FILE} app.jar

# Define the PORT environment variable.
# Spring Boot will automatically pick this up to set server.port.
# Provide a default value (e.g., 8080) if not explicitly set when running the container.
ENV PORT=8080

# Set the entrypoint to run the Spring Boot application.
# Use java -jar and pass the PORT environment variable to Spring Boot's server.port property.
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]