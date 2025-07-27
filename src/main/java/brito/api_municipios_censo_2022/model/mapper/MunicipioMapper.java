package brito.api_municipios_censo_2022.model.mapper;

import brito.api_municipios_censo_2022.model.dto.MunicipioDTO;
import brito.api_municipios_censo_2022.model.dto.MunicipioGeometryDTO;
import brito.api_municipios_censo_2022.model.entity.Municipio;

import java.util.List;

public class MunicipioMapper {

    public static MunicipioDTO toDTO(Municipio municipio) {
        return new MunicipioDTO(
                municipio.getId(),
                municipio.getMunicipio(),
                municipio.getEstado(),
                municipio.getPopulacao(),
                municipio.getArea()
        );
    }

    public static List<MunicipioDTO> toDTO(List<Municipio> municipios) {
        return municipios
                .stream()
                .map(MunicipioMapper::toDTO)
                .toList();
    }

    public static MunicipioGeometryDTO toGeometryDTO(Municipio municipio) {
        return new MunicipioGeometryDTO(municipio.getGeom());
    }

    public static List<MunicipioGeometryDTO> toGeometryDTO(List<Municipio> municipios) {
        return municipios
                .stream()
                .map(MunicipioMapper::toGeometryDTO)
                .toList();
    }
}
