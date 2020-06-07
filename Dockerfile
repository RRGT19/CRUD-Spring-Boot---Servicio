# defines a source container image to build upon
FROM openjdk:8-jre-alpine

# add metadata to an image
LABEL maintainer="Robert Gomez <rrgt19@gmail.com>"

# adding a volume to save the logs
VOLUME /tmp

# copy a local file into the container
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar

# the app will listen on port 8080
EXPOSE 8080

# environment variable
ENV JAVA_OPTS=""

# tells Docker what it should execute when you run that container
ENTRYPOINT ["sh", "-c","java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app.jar"]
