package ufrn.br.exemplodeploy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.br.exemplodeploy.model.Carrinho;
import ufrn.br.exemplodeploy.model.Produto;

import java.io.IOException;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @RequestMapping(method = RequestMethod.GET)
    public void verCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Seu Carrinho</h1>");

        if (carrinho == null || carrinho.getProdutos().isEmpty()) {
            response.getWriter().println("<p>O carrinho está vazio.</p>");
        } else {
            response.getWriter().println("<ul>");
            for (Produto produto : carrinho.getProdutos()) {
                response.getWriter().println("<li>" + produto.getNome() + " - R$" + produto.getPreco() + "</li>");
            }
            response.getWriter().println("</ul>");
        }

        response.getWriter().println("</body></html>");
    }
}
