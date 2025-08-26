package brito.api_municipios_censo_2022.controller;

import brito.api_municipios_censo_2022.model.entity.Municipio;
import brito.api_municipios_censo_2022.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/censo2022/municipios")
public class MunicipioController {

    private final MunicipioService municipioService;

    @Autowired
    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("")
    public ResponseEntity<List<Municipio>> getDadosMunicipios() {
        return ResponseEntity.ok(municipioService.getDadosMunicipios());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Municipio> getDadosById(@PathVariable String id) {
        return ResponseEntity.ok(municipioService.getDadosById(id));
    }

    @GetMapping("municipio/{municipio}")
    public ResponseEntity<List<Municipio>> getDadosByMunicipio(@PathVariable String municipio) {
        return ResponseEntity.ok(municipioService.getDadosByMunicipio(municipio));
    }

    @GetMapping("estado/{estado}")
    public ResponseEntity<List<Municipio>> getDadosByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(municipioService.getDadosByEstado(estado));
    }

    @GetMapping("populacao/{infLim}/{supLim}")
    public ResponseEntity<List<Municipio>> getDadosByPopulacao(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(municipioService.getDadosByPopulacao(infLim, supLim));
    }

    @GetMapping("area/{infLim}/{supLim}")
    public ResponseEntity<List<Municipio>> getDadosByArea(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(municipioService.getDadosByArea(infLim, supLim));
    }
}
