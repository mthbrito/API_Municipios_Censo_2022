package brito.api_municipios_censo_2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntradaInvalidaException.class)
    private ResponseEntity<String> entradaInvalidaHandler(EntradaInvalidaException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(MunicipiosNaoEncontradosException.class)
    private ResponseEntity<String> municipiosNaoEncontrados(MunicipiosNaoEncontradosException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(EstadosNaoEncontradosException.class)
    private ResponseEntity<String> estadosNaoEncontrados(EstadosNaoEncontradosException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
