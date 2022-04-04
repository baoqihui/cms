FROM openjdk:11.0.4
ADD /target/cms-plus-0.0.1-SNAPSHOT.jar  /cms-plus.jar
EXPOSE 8090
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/cms-plus.jar","--spring.profiles.active=dev","-c"]