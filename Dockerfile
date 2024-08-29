FROM openjdk:8

COPY target/drugstore-0.0.1-SNAPSHOT.jar /tmp/app.jar
WORKDIR /tmp

ENTRYPOINT ["java", "-jar","app.jar"]