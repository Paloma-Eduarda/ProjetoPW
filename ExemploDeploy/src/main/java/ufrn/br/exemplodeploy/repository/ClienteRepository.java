package ufrn.br.exemplodeploy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.exemplodeploy.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
