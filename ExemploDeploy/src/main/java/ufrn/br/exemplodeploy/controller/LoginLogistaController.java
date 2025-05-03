package ufrn.br.exemplodeploy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ufrn.br.exemplodeploy.model.Cliente;
import ufrn.br.exemplodeploy.model.Logista;
import ufrn.br.exemplodeploy.repository.ClienteDAO;
import ufrn.br.exemplodeploy.repository.LogistaDAO;

import java.io.IOException;

@Controller
public class LoginLogistaController {

    private final LogistaDAO logistaDAO = new LogistaDAO();

    @RequestMapping("/login-lojista")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email_corporativo");
        String senha = req.getParameter("senha");

        Logista logista = logistaDAO.buscarPorEmailESenha(email, senha);

        if (logista != null) {
            req.getSession().setAttribute("logistaLogado", logista);
            resp.sendRedirect("/produto");
        } else {
            resp.getWriter().write("Login inválido");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

