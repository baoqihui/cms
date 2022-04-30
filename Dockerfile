FROM openjdk:11.0.4
ADD /target/office-0.0.1-SNAPSHOT.jar  /office.jar
EXPOSE 8092
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/office.jar","--spring.profiles.active=dev","-c"]