FROM openjdk:11
EXPOSE 9200
ADD target/graphql-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "app.jar" ]