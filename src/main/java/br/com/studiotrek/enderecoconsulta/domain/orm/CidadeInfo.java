package br.com.studiotrek.enderecoconsulta.domain.orm;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CidadeInfo {
    private String areakm2;
    private String codigoIbge;
}
