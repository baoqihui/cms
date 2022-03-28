FROM openjdk:11.0.4
ADD /target/cms-0.0.1-SNAPSHOT.jar  /cms.jar
EXPOSE 8089
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/cms.jar","--spring.profiles.active=dev","-c"]