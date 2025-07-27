package brito.api_municipios_censo_2022.service;

import brito.api_municipios_censo_2022.model.dto.MunicipioDTO;
import brito.api_municipios_censo_2022.model.dto.MunicipioGeometryDTO;
import brito.api_municipios_censo_2022.repository.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static brito.api_municipios_censo_2022.model.mapper.MunicipioMapper.toDTO;
import static brito.api_municipios_censo_2022.model.mapper.MunicipioMapper.toGeometryDTO;

@Service
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public List<MunicipioDTO> getDadosByMunicipio(String municipio) {
        return toDTO(municipioRepository.findByMunicipio(municipio));
    }

    public List<MunicipioDTO> getDadosByEstado(String estado) {
        return toDTO(municipioRepository.findByEstado(estado));
    }

    public List<MunicipioDTO> getDadosByPopulacao(int infLim, int supLim) {
        return toDTO(municipioRepository.findByPopulacaoBetween(infLim, supLim));
    }

    public List<MunicipioDTO> getDadosByArea(double infLim, double supLim) {
        return toDTO(municipioRepository.findByAreaBetween(infLim, supLim));
    }

    public List<MunicipioGeometryDTO> getGeomByMunicipio(String municipio) {
        return toGeometryDTO(municipioRepository.findByMunicipio(municipio));
    }

    public List<MunicipioGeometryDTO> getGeomByEstado(String estado) {
        return toGeometryDTO(municipioRepository.findByEstado(estado));
    }

    public List<MunicipioGeometryDTO> getGeomByPopulacao(int infLim, int supLim) {
        return toGeometryDTO(municipioRepository.findByPopulacaoBetween(infLim, supLim));
    }

    public List<MunicipioGeometryDTO> getGeomByArea(int infLim, int supLim) {
        return toGeometryDTO(municipioRepository.findByAreaBetween(infLim, supLim));
    }
}

