FROM adoptopenjdk/openjdk8:latest
ADD target/loompalandia-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "sh", "-c", "java  -Dspring.profiles.active=docker -jar /app.jar" ]