package ufrn.br.exemplodeploy.repository;

import ufrn.br.exemplodeploy.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, senha, cpf) VALUES (?, ?, ?, ?)";

        try (Connection con = ConectaBanco.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getCpf());

            stmt.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente", e);
        }
    }
}
