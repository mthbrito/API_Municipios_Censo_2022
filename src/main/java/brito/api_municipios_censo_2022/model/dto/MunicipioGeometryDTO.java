package brito.api_municipios_censo_2022.model.dto;

public record MunicipioGeometryDTO(
        int id,
        String municipio,
        String estado,
        String geom) {
}
