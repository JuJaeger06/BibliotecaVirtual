package br.csi.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBancoDados {

    public static Connection conectarBancoPostgres()
            throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded!");

        // --- ALTERAÇÕES COMEÇAM AQUI ---

        // Obtenha os valores das variáveis de ambiente definidas no docker-compose.yml
        // Se uma variável não for encontrada, ela usa um valor padrão (útil para desenvolvimento local fora do Docker)
        String dbHost = System.getenv("HOST") != null ? System.getenv("HOST") : "localhost";
        String dbPort = "5432"; // Porta padrão do PostgreSQL
        String dbName = System.getenv("NAME") != null ? System.getenv("NAME") : "bibliotecaVirtual";
        String dbUser = System.getenv("USER") != null ? System.getenv("USER") : "postgres";
        // IMPORTANTE: Certifique-se de que você está lendo "PASSWORD" aqui, conforme definido em docker-compose.yml
        String dbPass = System.getenv("PASSWORD") != null ? System.getenv("PASSWORD") : "TEznl41B*";

        // Constrói a URL dinamicamente usando as variáveis de ambiente
        String url = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        System.out.println("Tentando conectar a: " + url); // Log para ajudar a depurar a URL final

        // Usa as variáveis para estabelecer a conexão
        return DriverManager.getConnection(url, dbUser, dbPass);

        // --- ALTERAÇÕES TERMINAM AQUI ---
    }
}