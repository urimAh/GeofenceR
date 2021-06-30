FROM openjdk:8-jre-alpine
ENV TZ=Europe/Rome
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]