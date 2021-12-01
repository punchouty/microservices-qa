FROM openjdk:11
EXPOSE 9300
ADD target/orchestration-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "app.jar" ]