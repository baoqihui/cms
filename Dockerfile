FROM openjdk:11.0.4
ADD /target/demos-0.0.1-SNAPSHOT.jar  /demos.jar
EXPOSE 8082
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/demos.jar","--spring.profiles.active=dev","-c"]