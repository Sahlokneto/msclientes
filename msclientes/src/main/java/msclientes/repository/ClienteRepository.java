package msclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import msclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query(value = "SELECT * FROM CLIENTE WHERE NOME = ?1", nativeQuery = true)
    Cliente findByNome(String nome);
}