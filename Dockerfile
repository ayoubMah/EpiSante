FROM openjdk:21-jdk

WORKDIR /usr/src/app

COPY target/*jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Episante-back-1.0-SNAPSHOT"]
