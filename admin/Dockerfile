ARG CR_URL
FROM $CR_URL/openjdk:8-jdk-alpine as base


ENV DISCOVERY_HOST ${DISCOVERY_HOST:-NOT_DEFINED}
ENV DISCOVERY_PORT ${DISCOVERY_PORT:-8761}
ENV CONFIG_SERVER_URL ${CONFIG_SERVER_URL:-c0nf1g}
ENV CONFIG_SERVER_PORT ${CONFIG_SERVER_PORT:-8888}

FROM $CR_URL/maven:3.6.2-jdk-8 as build

ARG NEXUS_USR_READ
ARG NEXUS_PSW_READ
ARG NEXUS_URL_MVN

# Create app directory
WORKDIR /app
COPY admin/pom.xml .
COPY .m2/ ./m2
COPY admin/src/ ./src

RUN mvn -B -ntp -s ./m2/settings.xml package -DskipTests

FROM base as final
EXPOSE 8788
COPY --from=build /app/target/admin*.jar /app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]

# Run image with additional arguments
# docker build -t <imagename>:latest .
# custom port
# docker run -d -p 8085:<tomcat port>  <imagename>  --server.port=<tomcat port>
#
# if you don't want to change tomcat port then:
# docker run -d -p 8085:8090 <imagename> 
