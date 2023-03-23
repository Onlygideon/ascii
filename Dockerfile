#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY target/com.api.ascii-1.0.0.jar ascii.jar
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /target/ascii-0.0.1-SNAPSHOT.jar ascii.jar
# PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ascii.jar"]