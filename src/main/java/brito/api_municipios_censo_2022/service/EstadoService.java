package brito.api_municipios_censo_2022.service;

import brito.api_municipios_censo_2022.exception.EntradaInvalidaException;
import brito.api_municipios_censo_2022.exception.EstadosNaoEncontradosException;
import brito.api_municipios_censo_2022.model.entity.Estado;
import brito.api_municipios_censo_2022.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> getDadosEstados() {
        List<Estado> estados = estadoRepository.findAll();
        checarSeEstadosExistem(estados);
        return estados;
    }

    public Estado getDadosById(String id) {
        checarSeEntradaENumeroValido(id);
        Estado estado = estadoRepository.findById(id);
        checarSeEstadoExiste(estado);
        return estado;
    }

    public Estado getDadosByEstado(String estado) {
        checarSeEntradaETextoValido(estado);
        Estado estado_ = estadoRepository.findByEstado(estado);
        checarSeEstadoExiste(estado_);
        return estado_;
    }

    public List<Estado> getDadosByQtde(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Estado> estados = estadoRepository.findByQtdeBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeEstadosExistem(estados);
        return estados;
    }

    public List<Estado> getDadosByPopulacao(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Estado> estados = estadoRepository.findByPopulacaoBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeEstadosExistem(estados);
        return estados;
    }

    public List<Estado> getDadosByArea(String infLim, String supLim) {
        checarSeEntradaENumeroValido(infLim, supLim);
        List<Estado> estados = estadoRepository.findByAreaBetween(Integer.parseInt(infLim), Integer.parseInt(supLim));
        checarSeEstadosExistem(estados);
        return estados;
    }

    private void checarSeEstadoExiste(Estado estado) {
        if (estado == null) {
            throw new EstadosNaoEncontradosException();
        }
    }

    private void checarSeEstadosExistem(List<Estado> estados) {
        if (estados.isEmpty()) {
            throw new EstadosNaoEncontradosException();
        }
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

}
