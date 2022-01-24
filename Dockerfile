FROM openjdk:8-jdk-alpine
MAINTAINER linkedin.com/in/raul-paes
COPY target/admin-service-0.0.1-SNAPSHOT.jar admin-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/admin-server-1.0.0.jar"]