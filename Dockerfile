FROM openjdk:11.0.4
ADD /target/train-0.0.1-SNAPSHOT.jar  /train.jar
EXPOSE 8093
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/train.jar","--spring.profiles.active=dev","-c"]