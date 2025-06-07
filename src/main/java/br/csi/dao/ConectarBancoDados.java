package br.csi.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBancoDados {

    public static Connection conectarBancoPostgres()
            throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded!");

        String url = "jdbc:postgresql://localhost:5432/bibliotecaVirtual";
        String user = "postgres";
        String password = "TEznl41B*";

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
