package br.com.studiotrek.enderecoconsulta.domain.orm;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EstadoInfo {
    private String nome;
    private String codigoIbge;
    private String areaKm2;
}
