FROM ubuntu:16.04

LABEL maintainer="babishan@testmail.com"

RUN apt update
RUN apt install git -y
RUN apt install default-jdk -y

WORKDIR /app

COPY ./target/webservice-0.0.1.jar /app/webservice-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar","-Dspring.profiles.active=prod","webservice-0.0.1.jar"]