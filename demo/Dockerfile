
FROM eclipse-temurin:21-jdk


WORKDIR /app


COPY target/CitaSaludPermissions1.jar app.jar


EXPOSE 8080

# Comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]
