FROM openjdk:14.0.1
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]