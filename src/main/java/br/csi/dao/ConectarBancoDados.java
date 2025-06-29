package br.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBancoDados {

    // CÓDIGO CORRIGIDO PARA SER FLEXÍVEL COM DOCKER
    public static Connection conectarBancoPostgres() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver carregado!");

<<<<<<< Updated upstream
        // --- ALTERAÇÕES COMEÇAM AQUI ---

=======
<<<<<<< HEAD
        // 1. Busca as variáveis de ambiente definidas no docker-compose.yml.
        // Se não existirem, usa valores padrão para rodar localmente sem Docker.
        String dbHost = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
        String dbName = System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "bibliotecaVirtual";
        String dbUser = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "postgres";
        String dbPass = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "1234"; // Senha padrão local

        // 2. Monta a URL de conexão dinamicamente
        String url = "jdbc:postgresql://" + dbHost + ":5432/" + dbName;

        System.out.println("Conectando a: " + url); // Log para ajudar na depuração

        // 3. Usa as variáveis para criar a conexão
        return DriverManager.getConnection(url, dbUser, dbPass);
=======
        // --- ALTERAÇÕES COMEÇAM AQUI ---

>>>>>>> Stashed changes
        // Obtenha os valores das variáveis de ambiente definidas no docker-compose.yml
        // Se uma variável não for encontrada, ela usa um valor padrão (útil para desenvolvimento local fora do Docker)
        String dbHost = System.getenv("HOST") != null ? System.getenv("HOST") : "localhost";
        String dbPort = "5432"; // Porta padrão do PostgreSQL
        String dbName = System.getenv("NAME") != null ? System.getenv("NAME") : "bibliotecaVirtual";
        String dbUser = System.getenv("USER") != null ? System.getenv("USER") : "postgres";
        // IMPORTANTE: Certifique-se de que você está lendo "PASSWORD" aqui, conforme definido em docker-compose.yml
        String dbPass = System.getenv("PASSWORD") != null ? System.getenv("PASSWORD") : "1234*";

        // Constrói a URL dinamicamente usando as variáveis de ambiente
        String url = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        System.out.println("Tentando conectar a: " + url); // Log para ajudar a depurar a URL final

        // Usa as variáveis para estabelecer a conexão
        return DriverManager.getConnection(url, dbUser, dbPass);

        // --- ALTERAÇÕES TERMINAM AQUI ---
<<<<<<< Updated upstream
=======
>>>>>>> 8aea1f99aaf4a5c38da0b264fbf3d9f1f32fa4b2
>>>>>>> Stashed changes
    }
}