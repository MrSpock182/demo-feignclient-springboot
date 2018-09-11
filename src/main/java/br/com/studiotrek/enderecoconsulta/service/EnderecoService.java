package br.com.studiotrek.enderecoconsulta.service;

import br.com.studiotrek.enderecoconsulta.domain.orm.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cepService", url = "http://api.postmon.com.br")
public interface EnderecoService {
    @RequestMapping("/v1/cep/{cep}")
    Endereco getCep(@PathVariable("cep") String cep);
}