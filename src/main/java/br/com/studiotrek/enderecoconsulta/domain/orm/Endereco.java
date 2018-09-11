package br.com.studiotrek.enderecoconsulta.domain.orm;

import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document(collection = "endereco")
public class Endereco {
//    @Id
    private String cep;
    private String logadouro;
    private String bairro;
    private String cidade;
    private String estado;
    private CidadeInfo cidadeInfo;
    private EstadoInfo estadoInfo;
}
