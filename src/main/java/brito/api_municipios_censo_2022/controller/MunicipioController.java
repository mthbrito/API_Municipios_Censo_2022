package brito.api_municipios_censo_2022.controller;

import brito.api_municipios_censo_2022.model.dto.MunicipioDTO;
import brito.api_municipios_censo_2022.model.dto.MunicipioGeometryDTO;
import brito.api_municipios_censo_2022.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/censo2022")
public class MunicipioController {

    private final MunicipioService municipioService;

    @Autowired
    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("municipios")
    public ResponseEntity<List<MunicipioDTO>> getDadosMunicipios() {
        return ResponseEntity.ok(municipioService.getDadosMunicipio());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<MunicipioDTO> getDadosById(@PathVariable("id") String id) {
        return ResponseEntity.ok(municipioService.getDadosById(id));
    }

    @GetMapping("municipio/{municipio}")
    public ResponseEntity<List<MunicipioDTO>> getDadosByMunicipio(@PathVariable String municipio) {
        return ResponseEntity.ok(municipioService.getDadosByMunicipio(municipio));
    }

    @GetMapping("estado/{estado}")
    public ResponseEntity<List<MunicipioDTO>> getDadosByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(municipioService.getDadosByEstado(estado));
    }

    @GetMapping("populacao/{infLim}/{supLim}")
    public ResponseEntity<List<MunicipioDTO>> getDadosByPopulacao(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(municipioService.getDadosByPopulacao(infLim, supLim));
    }

    @GetMapping("area/{infLim}/{supLim}")
    public ResponseEntity<List<MunicipioDTO>> getDadosByArea(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(municipioService.getDadosByArea(infLim, supLim));
    }

    @GetMapping("geom/id/{id}")
    public ResponseEntity<MunicipioGeometryDTO> getGeomById(@PathVariable String id) {
        return ResponseEntity.ok(municipioService.getGeomById(id));
    }

    @GetMapping("geom/municipio/{municipio}")
    public ResponseEntity<List<MunicipioGeometryDTO>> getGeomByMunicipio(@PathVariable String municipio) {
        return ResponseEntity.ok(municipioService.getGeomByMunicipio(municipio));
    }

    @GetMapping("geom/estado/{estado}")
    public ResponseEntity<List<MunicipioGeometryDTO>> getGeomByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(municipioService.getGeomByEstado(estado));
    }

    @GetMapping("geom/populacao/{infLim}/{supLim}")
    public ResponseEntity<List<MunicipioGeometryDTO>> getGeomByPopulacao(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(municipioService.getGeomByPopulacao(infLim, supLim));
    }

    @GetMapping("geom/area/{infLim}/{supLim}")
    public ResponseEntity<List<MunicipioGeometryDTO>> getGeomByArea(@PathVariable String infLim, @PathVariable String supLim) {
        return ResponseEntity.ok(municipioService.getGeomByArea(infLim, supLim));
    }
}
