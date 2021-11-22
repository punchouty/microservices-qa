FROM openjdk:11
EXPOSE 9100
ADD target/cud-api-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "app.jar" ]