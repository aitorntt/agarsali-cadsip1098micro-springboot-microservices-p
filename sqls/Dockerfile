ARG CR_URL
FROM $CR_URL/openjdk:8-jdk-alpine as base


ENV DISCOVERY_HOST ${DISCOVERY_HOST:-NOT_DEFINED}
ENV DISCOVERY_PORT ${DISCOVERY_PORT:-8761}
ENV CONFIG_SERVER_URL ${CONFIG_SERVER_URL:-NOT_DEFINED}
ENV CONFIG_SERVER_PORT ${CONFIG_SERVER_PORT:-8888}
ENV GATEWAY_HOST ${GATEWAY_HOST:-NOT_DEFINED}
ENV GATEWAY_PORT ${GATEWAY_PORT:-8080}

ENV DATABASE_SERVER ${DATABASE_SERVER:-NOT_DEFINED}
ENV DATABASE_USER ${DATABASE_USER:-NOT_DEFINED}
ENV DATABASE_PASS ${DATABASE_PASS:-NOT_DEFINED}
ENV DATABASE_DB ${DATABASE_DB:-NOT_DEFINED}


FROM $CR_URL/maven:3.6.2-jdk-8 as build

ARG NEXUS_USR_READ
ARG NEXUS_PSW_READ
ARG NEXUS_URL_MVN

# Create app directory
WORKDIR /app
COPY ./.m2 ./.m2

COPY ./pom.xml ./pom.xml
RUN cp pom.xml pom2.xml && cat pom2.xml | grep -vP "<module>(?!micro-commons|sqls)" > pom.xml && rm pom2.xml

COPY ./micro-commons/pom.xml ./micro-commons/pom.xml
COPY ./sqls/pom.xml ./sqls/pom.xml

RUN mvn -B -ntp -s .m2/settings.xml prepare-package

COPY ./micro-commons/ ./micro-commons/
COPY ./sqls/ ./sqls/

RUN mvn -B -ntp -s .m2/settings.xml package -DskipTests

FROM base as final
EXPOSE 8888 
COPY --from=build /app/sqls/target/*.jar /app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]

# Run image with additional arguments
# docker build -t <imagename>:latest .
# custom port
# docker run -d -p 8085:<tomcat port>  <imagename>  --server.port=<tomcat port>
#
# if you don't want to change tomcat port then:
# docker run -d -p 8085:8090 <imagename> 
