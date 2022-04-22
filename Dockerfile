FROM openjdk:11.0.4
ADD /target/user-0.0.1-SNAPSHOT.jar  /user.jar
EXPOSE 8090
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/user.jar","--spring.profiles.active=dev","-c"]