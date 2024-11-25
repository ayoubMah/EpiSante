FROM openjdk:21-jdk

WORKDIR /usr/src/app

COPY target/*jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Episante-back-0.0.1-SNAPSHOT.jar"]
