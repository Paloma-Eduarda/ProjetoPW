package ufrn.br.exemplodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListaProdutosController {

    @GetMapping("/produtos")
    public String listaProdutosPage() {
        return "ListaProdutos"; // templates/ListaProdutos.html
    }
}
