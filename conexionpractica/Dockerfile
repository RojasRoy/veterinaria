# Etapa 1: Construcción
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/conexionPractica-0.0.1-SNAPSHOT.jar app_conexionP.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_conexionP.jar"]