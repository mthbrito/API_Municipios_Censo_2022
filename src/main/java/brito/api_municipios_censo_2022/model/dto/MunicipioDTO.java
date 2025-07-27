package brito.api_municipios_censo_2022.model.dto;

public record MunicipioDTO(
        int id,
        String municipio,
        String estado,
        int populacao,
        double area) {
}
