package ufrn.br.exemplodeploy.repository;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

    /*
    Default env:
        DATABASE_HOST=localhost;DATABASE_PORT=5432;DATABASE_NAME=dbaula;DATABASE_USERNAME=postgres;DATABASE_PASSWORD=postgres
     */

    /*
    Acesso ao banco no postgres do docker
    psql -h localhost -U postgres
    CREATE DATABASE mydatabase;     -> Cria o banco de dados
    \l                              -> Apresenta os bancos de dados criados
    \c mydatabase                   -> Conecta o banco de dados mydatabase
    \dt                             -> Apresenta as tabelas já criadas
    SELECT * FROM <table>;           -> Seleciona uma tabela
    */
    public static Connection getConnection() throws SQLException, URISyntaxException {
        String dbUri = System.getenv("DATABASE_HOST");
        String dbPort = System.getenv("DATABASE_PORT");
        String dbName = System.getenv("DATABASE_NAME");

        String username = System.getenv("DATABASE_USERNAME");
        String password = System.getenv("DATABASE_PASSWORD");
        String dbUrl = "jdbc:postgresql://" + dbUri + ':' + dbPort + "/" + dbName + "?serverTimezone=UTC";
        return DriverManager.getConnection(dbUrl, username, password);
    }
}