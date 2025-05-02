package ufrn.br.exemplodeploy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.br.exemplodeploy.model.Carrinho;
import ufrn.br.exemplodeploy.model.Produto;
import ufrn.br.exemplodeploy.service.ProdutoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/produtos")
@Controller

public class ListaProdutosController {

    private final ProdutoService produtoService;

    public ListaProdutosController() {
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
            response.getWriter().println(
                    "<li>" + produto.getId() + " - " + produto.getNome() + " - " + produto.getDescricao() + " - R$" + produto.getPreco() +
                            " <form method='POST' action='/produtos/adicionar' style='display:inline;'>" +
                            "<input type='hidden' name='id' value='" + produto.getId() + "'/>" +
                            "<button type='submit'>Adicionar</button>" +
                            "</form>" +
                            "</li>"
            );
        }

        response.getWriter().println("</ul>");
        response.getWriter().println("<br><a href='/carrinho'>Ver Carrinho</a>");
        response.getWriter().println("</body></html>");
    }
    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public void adicionarProdutoCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new Carrinho(new ArrayList<>());
            request.getSession().setAttribute("carrinho", carrinho);
        }

        Produto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            carrinho.addProduto(produto);
        }

        response.sendRedirect("/produtos");
    }
}
