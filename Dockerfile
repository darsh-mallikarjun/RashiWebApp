FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY target/*.jar  rashiapplication1.jar
ENTRYPOINT [ "java" , "-jar" ,"/rashiapplication1.jar"]
EXPOSE 8080