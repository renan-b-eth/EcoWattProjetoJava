FROM maven:3.8.5-openjdk-17 AS build
COPY . .
COPY src ./src

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/EcoWatt-0.0.1-SNAPSHOT.jar EcoWatt.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "EcoWatt.jar"]