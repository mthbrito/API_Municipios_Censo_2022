package brito.api_municipios_censo_2022.controller;

import brito.api_municipios_censo_2022.model.entity.Estado;
import brito.api_municipios_censo_2022.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/censo2022/estados")
public class EstadoController {

    private final EstadoService estadoService;

    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Estado>> getDadosEstados() {
        return ResponseEntity.ok(estadoService.getDadosEstados());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Estado> getDadosById(@PathVariable String id) {
        return ResponseEntity.ok(estadoService.getDadosById(id));
    }

    @GetMapping("estado/{estado}")
    public ResponseEntity<Estado> getDadosByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(estadoService.getDadosByEstado(estado));
    }

    @GetMapping("qtde/{infLim}/{supLim}")
    public ResponseEntity<List<Estado>> getDadosByQtde(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(estadoService.getDadosByQtde(infLim, supLim));
    }

    @GetMapping("populacao/{infLim}/{supLim}")
    public ResponseEntity<List<Estado>> getDadosByPopulacao(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(estadoService.getDadosByPopulacao(infLim, supLim));
    }

    @GetMapping("area/{infLim}/{supLim}")
    public ResponseEntity<List<Estado>> getDadosByArea(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(estadoService.getDadosByArea(infLim, supLim));
    }
}
