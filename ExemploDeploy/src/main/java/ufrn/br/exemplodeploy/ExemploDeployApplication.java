package ufrn.br.exemplodeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ufrn.br.exemplodeploy.repository.LogistaDAO;
import ufrn.br.exemplodeploy.service.ProdutoService;

@SpringBootApplication
public class ExemploDeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploDeployApplication.class, args);
    }

}
