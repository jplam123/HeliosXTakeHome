FROM gradle:8.9-jdk-jammy  AS build
COPY build.gradle settings.gradle /app/
COPY src /app/src/
WORKDIR /app
RUN gradle build -x test

# Use the official OpenJDK image as a base for running the application
FROM eclipse-temurin:21
VOLUME /tmp
COPY --from=build /app/build/libs/HeliosX-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080