package ufrn.br.exemplodeploy.repository;

import ufrn.br.exemplodeploy.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public Cliente buscarPorEmailESenha(String email, String senha) {
        Cliente cliente = null;
        try (Connection con = ConectaBanco.getConnection()) {
            String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setCpf(rs.getString("cpf"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
