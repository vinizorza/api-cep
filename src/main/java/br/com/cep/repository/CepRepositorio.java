package br.com.cep.repository;

import br.com.cep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CepRepositorio extends JpaRepository<Cep, String> {
    @Query(value = "SELECT cep FROM Cep cep WHERE cep.cidade.ibge = ?1 and cep.cidade.uf = ?2")
    List<Cep> listByCidade(String ibge, String uf);
}
