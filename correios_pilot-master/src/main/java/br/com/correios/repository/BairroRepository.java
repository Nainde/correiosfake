package br.com.correios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.correios.dto.BairroDTO;
import br.com.correios.model.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, Long>{
	@Query ("Select new br.com.correios.dto.BairroDTO(l.nome, l.cidade.nome, concat(l.cidade.nome, '/', l.cidade.estado.uf) ) from Bairro l where nome=:parametro or l.cidade.nome like concat('%', :parametro, '%')")
	List <BairroDTO> buscaPorNomeBairro(@Param("parametro") String parametro);

}
