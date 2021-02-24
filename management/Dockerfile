FROM alpine:latest

LABEL maintainer="babishan@testmail.com"

RUN apk update
RUN apk upgrade
RUN apk add openjdk11-jre-headless

WORKDIR /app

COPY ./target/management-0.0.1.jar /app/management-0.0.1.jar

EXPOSE 8761

ENTRYPOINT ["java"]
CMD ["-jar","-Dspring.profiles.active=prod","management-0.0.1.jar"]