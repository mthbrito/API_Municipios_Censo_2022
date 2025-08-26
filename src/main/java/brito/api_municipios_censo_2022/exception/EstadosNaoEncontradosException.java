package brito.api_municipios_censo_2022.exception;

public class EstadosNaoEncontradosException extends RuntimeException {
    public EstadosNaoEncontradosException() {
        super("Nenhum estado encontrado!");
    }

    public EstadosNaoEncontradosException(String message) {
        super(message);
    }
}
