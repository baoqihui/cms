FROM openjdk:11.0.4
ADD /target/videos-0.0.1-SNAPSHOT.jar  /videos.jar
EXPOSE 8095
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/videos.jar","--spring.profiles.active=dev","-c"]