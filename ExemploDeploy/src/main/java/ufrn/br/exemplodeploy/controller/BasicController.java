package ufrn.br.exemplodeploy.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ufrn.br.exemplodeploy.repository.ConectaBanco;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class BasicController {

    @RequestMapping("/config")
    public void doConfig(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConectaBanco.getConnection();
            stmt = con.
                    prepareStatement(
                            "CREATE TABLE IF NOT EXISTS " +
                                    "produto (id SERIAL PRIMARY KEY, " +
                                    "nome VARCHAR(55), " +
                                    "descricao VARCHAR(55), " +
                                    "preco FLOAT)");
            stmt.execute();
            stmt = con
                    .prepareStatement(
                            "INSERT INTO produto (nome, descricao, preco) VALUES \n"
                                    + "('Mesa', 'Qualquer', '23.0'),\n"
                                    + "('Caneta', 'Qualquer', '52.0'),\n"
                                    + "('Cadeira', 'Qualquer', '10.0'),\n"
                                    + "('TV', 'Dachshund', '75.0'),\n"
                                    + "('Monitor', 'Qualquer', '110.0'),\n"
                                    + "('Computador', 'Qualquer', '20.0')");
            stmt.execute();
            con.close();

            response.getWriter().println("ok");

        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().println(ex);
        }
    }

}
