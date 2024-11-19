FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN mvn clean package -DskipTests
RUN apt-get install maven -y
RUN mvn clean install
RUN mvn clean 
RUN mvn help:effective-pom



FROM openjdk:17.0.1-jdk-slim
EXPOSE 8080

COPY --from=build /target/EcoWatt-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]