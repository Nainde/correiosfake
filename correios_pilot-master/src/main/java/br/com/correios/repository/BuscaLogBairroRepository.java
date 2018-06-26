package br.com.correios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.correios.dto.BuscaLogBairroDTO;
import br.com.correios.model.Logradouro;


public interface BuscaLogBairroRepository extends JpaRepository<Logradouro, Long>{
	
	@Query ("Select new br.com.correios.dto.BuscaLogBairroDTO(l.nome, l.bairro.nome, concat(l.bairro.cidade.nome, '/', l.bairro.cidade.estado.uf), l.cep ) from Logradouro l where l.bairro.cidade.estado.uf like concat('%', :UF, '%') and l.bairro.cidade.nome like concat('%', :localidade, '%') and l.bairro.nome like concat('%', :bairro, '%')")
	List <BuscaLogBairroDTO> buscaPorNomeLogBairro(@Param("UF") String UF,@Param("localidade") String localidade, @Param("bairro") String bairro);

}
