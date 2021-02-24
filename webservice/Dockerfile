FROM debian:latest

LABEL maintainer="babishan@testmail.com"

RUN apt update
RUN apt install default-jre-headless -y

WORKDIR /app

COPY ./target/webservice-0.0.1.jar /app/webservice-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar","webservice-0.0.1.jar"]