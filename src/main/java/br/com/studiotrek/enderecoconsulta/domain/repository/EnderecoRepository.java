package br.com.studiotrek.enderecoconsulta.domain.repository;

import br.com.studiotrek.enderecoconsulta.domain.orm.Endereco;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, String> {
}