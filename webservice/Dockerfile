FROM alpine:latest

LABEL maintainer="babishan@testmail.com"

RUN apk update
RUN apk upgrade
RUN apk add openjdk11-jre-headless

WORKDIR /app

COPY ./target/webservice-0.0.1.jar /app/webservice-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar","webservice-0.0.1.jar"]