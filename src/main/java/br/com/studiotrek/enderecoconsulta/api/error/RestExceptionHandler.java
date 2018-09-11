package br.com.studiotrek.enderecoconsulta.api.error;

import br.com.studiotrek.enderecoconsulta.domain.dto.ErrorResponse;
import br.com.studiotrek.enderecoconsulta.exception.BadRequest;
import br.com.studiotrek.enderecoconsulta.exception.InternalServerError;
import br.com.studiotrek.enderecoconsulta.exception.NotFound;
import br.com.studiotrek.enderecoconsulta.util.RollbarManager;
import br.com.studiotrek.enderecoconsulta.util.StackLogger;
import com.rollbar.notifier.Rollbar;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {
    private static Rollbar rollbar = RollbarManager.getInstance();

    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBadRequest(BadRequest badRequest, WebRequest request) {
        rollbar.error(StackLogger.getMessage(badRequest));

        return ErrorResponse.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("BAD REQUEST")
                .message(badRequest.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
    }

    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalServerError(InternalServerError internalServerError, WebRequest request) {
        rollbar.error(StackLogger.getMessage(internalServerError));

        return ErrorResponse.builder()
                .timestamp(new Date())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("INTERNAL SERVER ERROR")
                .message(internalServerError.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
    }

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleNotFound(NotFound notFound, WebRequest request) {
        rollbar.error(StackLogger.getMessage(notFound));

        return ErrorResponse.builder()
                .timestamp(new Date())
                .status(HttpStatus.EXPECTATION_FAILED.value())
                .error("NOT FOUND")
                .message(notFound.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();
    }
}