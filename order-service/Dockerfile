#
# Build image
#
FROM maven:3-jdk-11 AS build

COPY pom.xml /usr/src/app/

RUN mvn -f /usr/src/app/pom.xml dependency:go-offline

COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

#
# Image
#
FROM openjdk:11-jre-slim
COPY --from=build /usr/src/app/target/*.jar /app.jar

ENV JAVA_OPTS=""
ENV SERVER_PORT 9991

EXPOSE ${SERVER_PORT}

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
