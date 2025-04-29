package ufrn.br.exemplodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListaProdutosAdminController {

    @GetMapping("/produtos/admin")
    public String listaProdutosAdminPage() {
        return "ListaProdutosAdmin"; // templates/ListaProdutosAdmin.html
    }
}
