FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the JAR file from target to /app/app.jar
COPY target/yatilab-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
