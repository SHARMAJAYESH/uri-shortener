# Use OpenJDK 17 base image
FROM azul/zulu-openjdk:17.0.16-17.60

# Set working directory
WORKDIR /app

# Copy target jar (you must build it first!)
COPY target/uri-shortener-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
