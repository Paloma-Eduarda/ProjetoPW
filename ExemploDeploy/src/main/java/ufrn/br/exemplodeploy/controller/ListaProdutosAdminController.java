package ufrn.br.exemplodeploy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.br.exemplodeploy.model.Cliente;
import ufrn.br.exemplodeploy.model.Produto;
import ufrn.br.exemplodeploy.repository.ClienteDAO;
import ufrn.br.exemplodeploy.repository.ProdutoDAO;
import ufrn.br.exemplodeploy.service.ProdutoService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/produto")
public class ListaProdutosAdminController {

    private final ProdutoService produtoService;

    public ListaProdutosAdminController() {
        this.produtoService = new ProdutoService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Produto> produtos = produtoService.listarProdutos();

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Lista de Produtos</h1>");;
        response.getWriter().println("<ul>");

        for (Produto produto : produtos) {
            response.getWriter().println("<li>" + produto.getId() + " - " + produto.getNome() + " - " + produto.getDescricao() + " - R$" + produto.getPreco() + "</li>");
        }

        response.getWriter().println("</ul>");
        response.getWriter().println("</body></html>");
    }

    @RequestMapping(value = {"cadastrarProduto"}, method = RequestMethod.POST)
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
