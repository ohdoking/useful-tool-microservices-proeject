FROM frolvlad/alpine-oraclejdk8:slim
ADD ["target/api-gateway-server-0.0.1-SNAPSHOT-exec.jar", "app.jar"]
EXPOSE 8082 8082
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar" ]
