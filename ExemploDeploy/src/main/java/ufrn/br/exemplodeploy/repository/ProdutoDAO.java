package ufrn.br.exemplodeploy.repository;

import ufrn.br.exemplodeploy.model.Cliente;
import ufrn.br.exemplodeploy.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?)";

        try (Connection con = ConectaBanco.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());

            stmt.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Produto", e);
        }
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection con = ConectaBanco.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));

                produtos.add(produto);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }

        return produtos;
    }
}