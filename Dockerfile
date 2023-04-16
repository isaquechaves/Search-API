FROM openjdk:11-slim-buster
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]