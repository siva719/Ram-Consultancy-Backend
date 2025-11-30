# Use official Java 17 runtime
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy your built jar file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar.original app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 7199

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]

