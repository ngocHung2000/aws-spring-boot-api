FROM openjdk:17-jdk-alpine

WORKDIR /app

MAINTAINER hungtn1

COPY target/*.jar /app/app.jar

ENV TZ=Asia/Ho_Chi_Minh
ENV SERVER_PORT=8080

ENTRYPOINT ["java","-jar","/app/app.jar"]