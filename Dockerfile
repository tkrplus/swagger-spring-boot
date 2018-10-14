FROM gradle:jdk8-alpine as builder
MAINTAINER Takeru Niwa tkrplus@gihub.com

COPY --chown=gradle:gradle . .

RUN ./gradlew build

FROM openjdk:8-jre-alpine as runner

VOLUME /tmp

COPY --from=builder /home/gradle/build/libs/*.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
