FROM amazoncorretto:17-alpine-jdk
COPY target/miapp-0.0.1-SNAPSHOT.jar miapp.jar
ENTRYPOINT ["java","-jar","/miapp.jar"]
EXPOSE 8080 
