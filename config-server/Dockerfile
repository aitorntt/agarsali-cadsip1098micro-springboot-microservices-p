ARG CR_URL
FROM $CR_URL/openjdk:8-jdk-alpine as base

FROM $CR_URL/maven:3.6.2-jdk-8 as build

ARG NEXUS_USR_READ
ARG NEXUS_PSW_READ
ARG NEXUS_URL_MVN

# Create app directory
WORKDIR /app
COPY config-server/pom.xml .
COPY .m2/ ./m2
COPY config-server/src/ ./src

RUN mvn -B -ntp -ntp -s ./m2/settings.xml package -DskipTests

FROM base as final
EXPOSE 8888 
COPY --from=build /app/target/config*.jar /app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]

# Run image with additional arguments
# docker build -t <imagename>:latest .
# custom port
# docker run -d -p 8085:<tomcat port>  <imagename>  --server.port=<tomcat port>
#
# if you don't want to change tomcat port then:
# docker run -d -p 8085:8090 <imagename> 
