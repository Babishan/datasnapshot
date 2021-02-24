FROM debian:latest

LABEL maintainer="babishan@testmail.com"

RUN apt update
RUN apt install default-jre-headless -y

WORKDIR /app

COPY ./target/management-0.0.1.jar /app/management-0.0.1.jar

EXPOSE 8761

ENTRYPOINT ["java"]
CMD ["-jar","-Dspring.profiles.active=prod","management-0.0.1.jar"]