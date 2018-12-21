FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} demoapplication.jar
RUN sh -c 'touch /demoapplication.jar'