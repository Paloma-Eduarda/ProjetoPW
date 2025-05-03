package ufrn.br.exemplodeploy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ufrn.br.exemplodeploy.model.Cliente;

import java.io.IOException;

@Controller
public class LoginLogistaController {
    @RequestMapping("/login")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Cliente cliente = clienteDAO.buscarPorEmailESenha(email, senha);

        if (cliente != null) {
            req.getSession().setAttribute("clienteLogado", cliente);
            resp.sendRedirect("/produtos");
        } else {
            resp.getWriter().write("Login inválido");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

