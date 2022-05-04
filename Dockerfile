FROM openjdk:11.0.4
ADD /target/hospital-0.0.1-SNAPSHOT.jar  /hospital.jar
EXPOSE 8091
ENTRYPOINT ["java","-Xms1024m","-Xmx1024m","-jar","/hospital.jar","--spring.profiles.active=dev","-c"]