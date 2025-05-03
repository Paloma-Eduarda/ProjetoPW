package ufrn.br.exemplodeploy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ufrn.br.exemplodeploy.model.Cliente;
import ufrn.br.exemplodeploy.repository.ClienteDAO;
import ufrn.br.exemplodeploy.service.ClienteService;

import java.io.IOException;

@Controller
public class ClienteController {

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping("/cadastro")
    public void doConfig(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String cpf = req.getParameter("cpf");

        Cliente cliente = new Cliente(email, nome, senha, cpf);
        new ClienteDAO().cadastrarCliente(cliente);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write("Cliente criado com sucesso!");
    }

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
    @RequestMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/login.html");
    }

}
