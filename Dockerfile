# Use the OpenJDK 21 image as the base
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/build-restaurant-0.0.1.jar /app/build-restaurant-0.0.1.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "/app/build-restaurant-0.0.1.jar"]
