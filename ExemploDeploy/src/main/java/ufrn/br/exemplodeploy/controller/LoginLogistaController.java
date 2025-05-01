package ufrn.br.exemplodeploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogistaController {
    @GetMapping({"/loginLogista"})
    public String loginLogista() {return "LoginLogista";}
}

