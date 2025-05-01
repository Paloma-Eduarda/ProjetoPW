package ufrn.br.exemplodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroLogistaController {

    @GetMapping("/cadastroLogista")
    public String cadastroLogistaPage() {return "CadastroLogista";}
}
