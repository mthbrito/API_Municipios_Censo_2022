package brito.api_municipios_censo_2022.exception;

public class MunicipiosNaoEncontradosException extends RuntimeException {

    public MunicipiosNaoEncontradosException() {
        super("Nenhum município encontrado!");
    }

    public MunicipiosNaoEncontradosException(String message) {
        super(message);
    }
}
