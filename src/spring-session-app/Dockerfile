FROM mcr.microsoft.com/java/jdk:11u8-zulu-alpine as builder
WORKDIR /app
RUN apk update && \
    apk add --no-cache git
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build --info

FROM mcr.microsoft.com/java/jre-headless:11u8-zulu-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/spring-session-app-*.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128M", "-XX:+FlightRecorder", "-XX:+PrintFlagsFinal", "-jar", "app.jar"]