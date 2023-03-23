#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/ascii-0.0.1.jar ascii.jar
# PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ascii.jar"]