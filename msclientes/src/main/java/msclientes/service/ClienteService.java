package msclientes.service;

import org.springframework.stereotype.Service;

import msclientes.model.Cliente;
import msclientes.repository.ClienteJdbcRepository;
import msclientes.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
    private final ClienteJdbcRepository clienteJdbcRepository;

    public ClienteService(ClienteRepository clienteRepository, ClienteJdbcRepository clienteJdbcRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteJdbcRepository = clienteJdbcRepository;
    }

    // JPA Repository    
    public Optional<Cliente> getClienteJpa(Long id) {
        return clienteRepository.findById(id);
    }
    
    public Cliente getClienteByNomeJpa(String nome) {
        return clienteRepository.findByNome(nome);
    }    

    public List<Cliente> getAllClientesJpa() {
        return clienteRepository.findAll();
    }

    public Cliente updateClienteJpa(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public void deleteClienteJpa(Long id) {
        clienteRepository.deleteById(id);
    }

    // JDBC
    public List<Cliente> getAllClientesJdbc() {
        return clienteJdbcRepository.findAll();
    }

    public Cliente getClienteByIdJdbc(Long id) {
        return clienteJdbcRepository.findById(id);
    }
    
    public int updateClienteJdbc(Cliente cliente) {
        return clienteJdbcRepository.updateCliente(cliente);
    }
    
    public int insertClienteJdbc(Cliente cliente) {
        return clienteJdbcRepository.insertCliente(cliente);
    }          
    
    public int deleteClienteJdbc(Long id) {
        return clienteJdbcRepository.deleteCliente(id);
    }
}
