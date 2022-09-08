FROM openjdk:11-jdk as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew bootjar



FROM openjdk:11-jdk

COPY --from=builder build/libs/*.jar kino-project.jar
VOLUME /tmp
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/kino-project.jar"]
