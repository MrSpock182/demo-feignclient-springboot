package br.com.studiotrek.enderecoconsulta.service;

import br.com.studiotrek.enderecoconsulta.domain.orm.Endereco;
import br.com.studiotrek.enderecoconsulta.domain.repository.EnderecoRepository;
import br.com.studiotrek.enderecoconsulta.exception.BadRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class EnderecoServiceFallback implements EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Override
    public Endereco getCep(String cep) {
        Optional<Endereco> endereco = enderecoRepository.findById(cep);
        if(!endereco.isPresent()) {
            throw new BadRequest("Endereço não encontrado");
        }

        return endereco.get();
    }
}
