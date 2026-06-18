FROM eclipse-temurin:17-jdk
MAINTAINER "Manoj M"
COPY target/SpringBootForDocker-0.0.1-SNAPSHOT.jar  /usr/app/
WORKDIR /usr/app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","SpringBootForDocker-0.0.1-SNAPSHOT.jar"]
