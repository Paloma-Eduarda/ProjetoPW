package ufrn.br.exemplodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarrinhoController {
    // teste
    @GetMapping("/carrinho")
    public String carrinhoPage() {
        return "Carrinho"; // templates/Carrinho.html
    }
}
