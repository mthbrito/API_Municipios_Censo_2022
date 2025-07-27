package brito.api_municipios_censo_2022.exception;

public class EntradaInvalidaException extends RuntimeException {

    public EntradaInvalidaException() {
        super("Entrada inválida!");
    }

    public EntradaInvalidaException(String message) {
        super(message);
    }
}
