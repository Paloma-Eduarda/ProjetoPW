package ufrn.br.exemplodeploy.repository;

import ufrn.br.exemplodeploy.model.Logista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogistaDAO {
    public Logista buscarPorEmailESenha(String email, String senha) {
        Logista logista = null;
        try (Connection con = ConectaBanco.getConnection()) {
            String sql = "SELECT * FROM logista WHERE email = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                logista = new Logista();
                logista.setId(rs.getLong("id"));
                logista.setNome(rs.getString("nome"));
                logista.setEmail(rs.getString("email"));
                logista.setSenha(rs.getString("senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logista;
    }
}
