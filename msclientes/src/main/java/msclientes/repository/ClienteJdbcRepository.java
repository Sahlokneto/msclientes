package msclientes.repository;

import msclientes.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteJdbcRepository {
	private final JdbcTemplate jdbcTemplate;

	public ClienteJdbcRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
 
	public List<Cliente> findAll() {
		String sql = "SELECT * FROM CLIENTE";
		return jdbcTemplate.query(sql, (rs, rowNum) -> new Cliente(rs.getLong("id"), rs.getString("nome"),
				rs.getString("email"), rs.getString("telefone")));
	}

	public Cliente findById(Long id) {
		String sql = "SELECT * FROM CLIENTE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> new Cliente(rs.getLong("id"),
				rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
	}
	
	public int insertCliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (NOME, EMAIL, TELEFONE) VALUES (?, ?, ?)";
         
        return jdbcTemplate.update(sql, cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }
	
	public int updateCliente(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ? WHERE ID = ?";

        return jdbcTemplate.update(sql, 
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getTelefone(),
            cliente.getId()
        );
    }
	
	public int deleteCliente(Long id) {
        String sql = "DELETE FROM CLIENTE WHERE ID = ?";

        return jdbcTemplate.update(sql, id);
    }
}
