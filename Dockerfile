FROM amazoncorretto:17-alpine-jdk
COPY target/emi-0.0.1-SNAPSHOT.jar emi-app.jar
ENTRYPOINT ["java","-jar","/emi-app.jar"]
EXPOSE 8080 
