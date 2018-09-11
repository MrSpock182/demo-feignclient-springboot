package br.com.studiotrek.enderecoconsulta.domain.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ErrorResponse {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}