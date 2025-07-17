FROM gradle:8.14.3-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test --no-daemon

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/build/libs/retoaws-0.0.1-SNAPSHOT.jar app.jar

ENV DB_HOST=localhost \
    DB_PORT=3306 \
    DB_NAME=awsreto_person_db \
    DB_USERNAME=root \
    DB_PASSWORD=toor \
    SERVER_PORT=8092

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "app.jar"]
