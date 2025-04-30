package ufrn.br.exemplodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroClienteController {

    @GetMapping("/cadastro")
    public String cadastroClientePage() {
        return "Cadastro"; // templates/Cadastro.html
    }
}
