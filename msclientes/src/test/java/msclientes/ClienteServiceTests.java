package msclientes;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import msclientes.controller.ClienteController;
import msclientes.model.Cliente;
import msclientes.service.ClienteService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ClienteServiceTests {

	@Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllClientesJpa() {
        List<Cliente> clientes = Arrays.asList(
            new Cliente(1L, "João", "123456789", "joao@email.com"),
            new Cliente(2L, "Maria", "987654321", "maria@email.com")
        );

        when(clienteService.getAllClientesJpa()).thenReturn(clientes);

        List<Cliente> result = clienteController.getAllClientesJpa();

        assertEquals(2, result.size());
        verify(clienteService, times(1)).getAllClientesJpa();
    }

    @Test
    public void testGetClienteJpa() {
        Cliente cliente = new Cliente(1L, "João", "123456789", "joao@email.com");
        when(clienteService.getClienteJpa(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteController.getClienteJpa(1L);

        assertTrue(result.isPresent());
        assertEquals("João", result.get().getNome());
        verify(clienteService, times(1)).getClienteJpa(1L);
    }

    @Test
    public void testGetClienteByNomeJpa() {
        Cliente cliente = new Cliente(1L, "João", "123456789", "joao@email.com");
        when(clienteService.getClienteByNomeJpa("João")).thenReturn(cliente);

        Cliente result = clienteController.getClienteByNomeJpa("João");

        assertEquals("João", result.getNome());
        verify(clienteService, times(1)).getClienteByNomeJpa("João");
    }

    @Test
    public void testUpdateClienteJpa() {
        Cliente cliente = new Cliente(1L, "João", "123456789", "joao@email.com");
        when(clienteService.updateClienteJpa(cliente)).thenReturn(cliente);

        Cliente result = clienteController.updateClienteJpa(cliente);

        assertEquals("João", result.getNome());
        verify(clienteService, times(1)).updateClienteJpa(cliente);
    }

    @Test
    public void testDeleteClienteJpa() {
        doNothing().when(clienteService).deleteClienteJpa(1L);

        clienteController.deleteClienteJpa(1L);

        verify(clienteService, times(1)).deleteClienteJpa(1L);
    }

    @Test
    public void testGetAllClientesJdbc() {
        List<Cliente> clientes = Arrays.asList(
            new Cliente(1L, "João", "123456789", "joao@email.com"),
            new Cliente(2L, "Maria", "987654321", "maria@email.com")
        );

        when(clienteService.getAllClientesJdbc()).thenReturn(clientes);

        List<Cliente> result = clienteController.getAllClientesJdbc();

        assertEquals(2, result.size());
        verify(clienteService, times(1)).getAllClientesJdbc();
    }

    @Test
    public void testGetClienteJdbc() {
        Cliente cliente = new Cliente(1L, "João", "123456789", "joao@email.com");
        when(clienteService.getClienteByIdJdbc(1L)).thenReturn(cliente);

        Cliente result = clienteController.getClienteJdbc(1L);

        assertEquals("João", result.getNome());
        verify(clienteService, times(1)).getClienteByIdJdbc(1L);
    }

    @Test
    public void testUpdateClienteJdbc() {
        Cliente cliente = new Cliente(1L, "João", "123456789", "joao@email.com");
        when(clienteService.updateClienteJdbc(cliente)).thenReturn(1);

        String result = clienteController.updateClienteJdbc(cliente);

        assertEquals("Sucesso!", result);
        verify(clienteService, times(1)).updateClienteJdbc(cliente);
    }

    @Test
    public void testInsertClienteJdbc() {
        Cliente cliente = new Cliente(1L, "João", "123456789", "joao@email.com");
        when(clienteService.insertClienteJdbc(cliente)).thenReturn(1);

        String result = clienteController.insertClienteJdbc(cliente);

        assertEquals("Sucesso!", result);
        verify(clienteService, times(1)).insertClienteJdbc(cliente);
    }   

}
