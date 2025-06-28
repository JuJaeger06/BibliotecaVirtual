
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /BibliotecVirtual

RUN git clone https://github.com/JuJaeger06/BibliotecaVirtual.git .

RUN mvn clean package -DskipTests

FROM quay.io/wildfly/wildfly:36.0.1.Final-jdk21

COPY --from=build /BibliotecVirtual/target/BibliotecVirtual.war /opt/jboss/wildfly/standalone/deployments/

