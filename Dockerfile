<<<<<<< Updated upstream

=======
<<<<<<< HEAD
# =================================================================
# ESTÁGIO 1: Build da Aplicação com Maven
# =================================================================
=======

>>>>>>> 8aea1f99aaf4a5c38da0b264fbf3d9f1f32fa4b2
>>>>>>> Stashed changes
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
# --- MUDANÇA RECOMENDADA ---
# Em vez de clonar do Git, copiamos os arquivos locais.
# Isso é mais rápido, funciona offline e permite que você edite o código
# e reconstrua a imagem facilmente.
COPY . .

RUN mvn clean package -DskipTests

# =================================================================
# ESTÁGIO 2: Ambiente de Execução com WildFly
# =================================================================
FROM quay.io/wildfly/wildfly:36.0.1.Final-jdk21

# Copia o arquivo .war gerado no estágio anterior
COPY --from=build /app/target/BibliotecaVirtual.war /opt/jboss/wildfly/standalone/deployments/
=======
>>>>>>> Stashed changes
RUN git clone https://github.com/JuJaeger06/BibliotecaVirtual.git .

RUN mvn clean package -DskipTests

FROM quay.io/wildfly/wildfly:36.0.1.Final-jdk21

COPY --from=build /app/target/BibliotecaVirtual.war /opt/jboss/wildfly/standalone/deployments/

<<<<<<< Updated upstream
=======
>>>>>>> 8aea1f99aaf4a5c38da0b264fbf3d9f1f32fa4b2
>>>>>>> Stashed changes
