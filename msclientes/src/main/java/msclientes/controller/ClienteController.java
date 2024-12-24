package msclientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msclientes.model.Cliente;
import msclientes.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
    private ClienteService clienteService;

	// JPA
	@GetMapping("/jpa")
    public List<Cliente> getAllClientesJpa() {
        return clienteService.getAllClientesJpa();
    }
    
    @GetMapping("/jpa/{id}")
    public Optional<Cliente> getClienteJpa(@PathVariable Long id) {
        return clienteService.getClienteJpa(id);
    }
    
    @GetMapping("/jpa/nome/{nome}")
    public Cliente getClienteByNomeJpa(@PathVariable String nome) {
        return clienteService.getClienteByNomeJpa(nome);
    }    
	
    @PostMapping("/jpa")
    public Cliente updateClienteJpa(@RequestBody Cliente cliente) {
        return clienteService.updateClienteJpa(cliente);
    }       

    @DeleteMapping("/jpa/{id}")
    public void deleteClienteJpa(@PathVariable Long id) {
        clienteService.deleteClienteJpa(id);
    }
    
    // JDBC
    @GetMapping("/jdbc")
    public List<Cliente> getAllClientesJdbc() {
        return clienteService.getAllClientesJdbc();
    }
    
    @GetMapping("/jdbc/{id}")
    public Cliente getClienteJdbc(@PathVariable Long id) {
        return clienteService.getClienteByIdJdbc(id);
    }           
	
    @PostMapping("/jdbc/update")
    public String updateClienteJdbc(@RequestBody Cliente cliente) {
        int val = clienteService.updateClienteJdbc(cliente);
        
        if(val > 0) {
        	return "Sucesso!";
        }else {
        	return "Erro!";
        }
    }   
    
    @PostMapping("/jdbc/insert")
    public String insertClienteJdbc(@RequestBody Cliente cliente) {
        int val = clienteService.insertClienteJdbc(cliente);
        
        if(val > 0) {
        	return "Sucesso!";
        }else {
        	return "Erro!";
        }
    } 

    @DeleteMapping("/jdbc/{id}")
    public void deleteClienteJdbc(@PathVariable Long id) {
        clienteService.deleteClienteJdbc(id);
    }
	
}
