# ------------ Stage 1: Build the app ------------
FROM maven:3.9.6-eclipse-temurin-21 as builder

# Set working directory inside build image
WORKDIR /build

# Copy the module’s pom.xml and src
COPY inventory-service/pom.xml inventory-service/
COPY inventory-service/src/ inventory-service/src/

# Build the project using Maven
RUN mvn -f inventory-service/pom.xml clean package -DskipTests

# ------------ Stage 2: Package the app ------------
FROM eclipse-temurin:21-jdk as runner
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=builder /build/inventory-service/target/*.jar app.jar

EXPOSE 8086

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
