# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/viewTRansaction-0.0.1-SNAPSHOT.jar viewTRansaction-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "viewTRansaction-0.0.1-SNAPSHOT.jar"]
