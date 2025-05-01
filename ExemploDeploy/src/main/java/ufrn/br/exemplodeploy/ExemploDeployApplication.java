package ufrn.br.exemplodeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ufrn.br.exemplodeploy.service.ProdutoService;

@SpringBootApplication
public class ExemploDeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploDeployApplication.class, args);
        System.out.println("Conectando com o banco: " + System.getenv("DATABASE_NAME"));
        ProdutoService produtoService = new ProdutoService();
        System.out.println(produtoService.listarProdutos());
    }

}
