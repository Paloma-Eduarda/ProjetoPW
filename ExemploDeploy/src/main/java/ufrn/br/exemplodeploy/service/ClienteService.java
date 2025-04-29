package ufrn.br.exemplodeploy.service;

import org.springframework.stereotype.Service;
import ufrn.br.exemplodeploy.model.Cliente;
import ufrn.br.exemplodeploy.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
