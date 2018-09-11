package br.com.studiotrek.enderecoconsulta.api.v1.endereco;

import br.com.studiotrek.enderecoconsulta.domain.orm.Endereco;
//import br.com.studiotrek.enderecoconsulta.domain.repository.EnderecoRepository;
import br.com.studiotrek.enderecoconsulta.domain.repository.EnderecoRepository;
import br.com.studiotrek.enderecoconsulta.exception.BadRequest;
import br.com.studiotrek.enderecoconsulta.exception.NotFound;
import br.com.studiotrek.enderecoconsulta.service.EnderecoService;
import br.com.studiotrek.enderecoconsulta.util.Validation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/endereco")
public class EnderecoRest {
    private final EnderecoService enderecoService;
    private final EnderecoRepository enderecoRepository;

    @ApiOperation(value = "Endereço",
            response = Endereco.class,
            notes = "Consulta de endereço")
    @ApiResponses(value= {
            @ApiResponse(
                    code = 400,
                    message ="Bad Request",
                    response = BadRequest.class
            ),
            @ApiResponse(
                    code = 404,
                    message ="Not Found",
                    response = NotFound.class
            ),
            @ApiResponse(
                    code = 500,
                    message ="Internal Error",
                    response = InternalError.class
            )
    })

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cep}")
    public Endereco getEndereco(@PathVariable String cep) {
        if(Validation.isCEP(cep)) {
            throw new BadRequest("CEP Invalido");
        }
//        return enderecoRepository.save(enderecoService.getCep(cep));
        return enderecoService.getCep(cep);
    }
}