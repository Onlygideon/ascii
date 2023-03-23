#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /src
COPY pom.xml pom.xml
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /target/ascii-0.0.1.jar ascii.jar
# PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ascii.jar"]