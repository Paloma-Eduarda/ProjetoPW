package ufrn.br.exemplodeploy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ufrn.br.exemplodeploy.model.Cliente;
import ufrn.br.exemplodeploy.model.Produto;
import ufrn.br.exemplodeploy.repository.ClienteDAO;
import ufrn.br.exemplodeploy.repository.ProdutoDAO;

import java.io.IOException;

@Controller
public class ListaProdutosAdminController {

    @GetMapping("/produtos/admin")
    public String listaProdutosAdminPage() {
        return "ListaProdutosAdmin"; // templates/ListaProdutosAdmin.html
    }

    @RequestMapping("/cadastrarProduto")
    public void doConfig(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        double preco = Double.valueOf(req.getParameter("preco"));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        Produto produto = new Produto(nome, descricao, preco, quantidade);
        new ProdutoDAO().cadastrarProduto(produto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write("Produto cadastro com sucesso!");
    }

}
