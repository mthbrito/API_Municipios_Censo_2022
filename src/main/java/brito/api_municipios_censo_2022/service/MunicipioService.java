package brito.api_municipios_censo_2022.service;

import brito.api_municipios_censo_2022.exception.EntradaInvalidaException;
import brito.api_municipios_censo_2022.exception.MunicipiosNaoEncontradosException;
import brito.api_municipios_censo_2022.model.dto.MunicipioDTO;
import brito.api_municipios_censo_2022.model.dto.MunicipioGeometryDTO;
import brito.api_municipios_censo_2022.model.entity.Municipio;
import brito.api_municipios_censo_2022.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static brito.api_municipios_censo_2022.model.mapper.MunicipioMapper.toDTO;
import static brito.api_municipios_censo_2022.model.mapper.MunicipioMapper.toGeometryDTO;

@Service
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    @Autowired
    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public List<MunicipioDTO> getDadosMunicipio() {
        List<Municipio> municipios = municipioRepository.findAll();
        checarSeMunicipiosExistem(municipios);
        return toDTO(municipios);
    }

    public MunicipioDTO getDadosById(String id) {
        checarSeEntradaENumeroValido(id);
        return toDTO(
                municipioRepository.findById(Integer.parseInt(id))
                        .orElseThrow(MunicipiosNaoEncontradosException::new)
        );
    }

    public List<MunicipioDTO> getDadosByMunicipio(String municipio) {
        checarSeEntradaETextoValido(municipio);
        List<Municipio> municipios = municipioRepository.findByMunicipio(municipio);
        checarSeMunicipiosExistem(municipios);
        return toDTO(municipios);
    }

    public List<MunicipioDTO> getDadosByEstado(String estado) {
        checarSeEntradaETextoValido(estado);
        List<Municipio> municipios = municipioRepository.findByEstado(estado);
        checarSeMunicipiosExistem(municipios);
        return toDTO(municipios);
    }

    public List<MunicipioDTO> getDadosByPopulacao(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Municipio> municipios = municipioRepository.findByPopulacaoBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeMunicipiosExistem(municipios);
        return toDTO(municipios);
    }

    public List<MunicipioDTO> getDadosByArea(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Municipio> municipios = municipioRepository.findByAreaBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeMunicipiosExistem(municipios);
        return toDTO(municipios);
    }

    public List<MunicipioGeometryDTO> getGeomByMunicipio(String municipio) {
        checarSeEntradaETextoValido(municipio);
        List<Municipio> municipios = municipioRepository.findByMunicipio(municipio);
        checarSeMunicipiosExistem(municipios);
        return toGeometryDTO(municipios);
    }

    public List<MunicipioGeometryDTO> getGeomByEstado(String estado) {
        checarSeEntradaETextoValido(estado);
        List<Municipio> municipios = municipioRepository.findByEstado(estado);
        checarSeMunicipiosExistem(municipios);
        return toGeometryDTO(municipios);
    }

    public List<MunicipioGeometryDTO> getGeomByPopulacao(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Municipio> municipios = municipioRepository.findByPopulacaoBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeMunicipiosExistem(municipios);
        return toGeometryDTO(municipios);
    }

    public List<MunicipioGeometryDTO> getGeomByArea(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Municipio> municipios = municipioRepository.findByAreaBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeMunicipiosExistem(municipios);
        return toGeometryDTO(municipios);
    }

    private void checarSeEntradaENumeroValido(String entrada) {
        if (entrada == null || entrada.isBlank() || (!entrada.matches("^\\d+$"))) {
            throw new EntradaInvalidaException();
        }
    }

    private void checarSeEntradaENumeroValido(String entrada1, String entrada2) {
        if (entrada1 == null ||
                entrada2 == null ||
                entrada1.isBlank() ||
                entrada2.isBlank() ||
                (!entrada1.matches("^\\d+$")) ||
                (!entrada2.matches("^\\d+$"))) {
            throw new EntradaInvalidaException();
        }
    }

    private void checarSeEntradaETextoValido(String entrada) {
        if (entrada == null || (!entrada.matches("^[\\p{L}\\s-]+$"))) {
            throw new EntradaInvalidaException();
        }
    }

    private void checarSeMunicipiosExistem(List<Municipio> municipios) {
        if (municipios.isEmpty()) {
            throw new MunicipiosNaoEncontradosException();
        }
    }
}

