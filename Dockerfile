FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/p_apoio-0.0.1-SNAPSHOT.jar api-pda.jar
EXPOSE 8080
#ENTRYPOINT exec java $JAVA_OPTS -jar api-pda.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar api-pda.jar


#usando docker compose
#ou
#criar network
#docker network create pda_network
#start mongo
#docker run --rm --name mongocontainer --network=pda_network -d mongo
#start api
#docker run --name pdacontainer --network pdanetwork --rm -d -p 8080:8080 api-pda:latest
