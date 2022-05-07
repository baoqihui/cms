FROM openjdk:11.0.4
ADD /target/medical-0.0.1-SNAPSHOT.jar  /medical.jar
EXPOSE 8082
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/medical.jar","--spring.profiles.active=dev","-c"]