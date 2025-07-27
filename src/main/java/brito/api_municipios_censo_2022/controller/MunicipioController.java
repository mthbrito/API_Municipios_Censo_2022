package brito.api_municipios_censo_2022.controller;

import brito.api_municipios_censo_2022.model.dto.MunicipioDTO;
import brito.api_municipios_censo_2022.model.dto.MunicipioGeometryDTO;
import brito.api_municipios_censo_2022.service.MunicipioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/censo2022")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("municipio/{municipio}")
    public List<MunicipioDTO> getDadosByMunicipio(@PathVariable("municipio") String municipio) {
        return municipioService.getDadosByMunicipio(municipio);
    }

    @GetMapping("estado/{estado}")
    public List<MunicipioDTO> getDadosByEstado(@PathVariable("estado") String estado) {
        return municipioService.getDadosByEstado(estado);
    }

    @GetMapping("populacao/{infLim}/{supLim}")
    public List<MunicipioDTO> getDadosByPopulacao(@PathVariable("infLim") int infLim, @PathVariable("supLim") int supLim) {
        return municipioService.getDadosByPopulacao(infLim, supLim);
    }

    @GetMapping("area/{infLim}/{supLim}")
    public List<MunicipioDTO> getDadosByArea(@PathVariable("infLim") double infLim, @PathVariable("supLim") double supLim) {
        return municipioService.getDadosByArea(infLim, supLim);
    }

    @GetMapping("geom/municipio/{municipio}")
    public List<MunicipioGeometryDTO> getGeomByMunicipio(@PathVariable("municipio") String municipio) {
        return municipioService.getGeomByMunicipio(municipio);
    }

    @GetMapping("geom/estado/{estado}")
    public List<MunicipioGeometryDTO> getGeomByEstado(@PathVariable("estado") String estado) {
        return municipioService.getGeomByEstado(estado);
    }

    @GetMapping("geom/populacao/{infLim}/{supLim}")
    public List<MunicipioGeometryDTO> getGeomByPopulacao(@PathVariable("infLim") int infLim, @PathVariable("supLim") int supLim) {
        return municipioService.getGeomByPopulacao(infLim, supLim);
    }

    @GetMapping("geom/area/{infLim}/{supLim}")
    public List<MunicipioGeometryDTO> getGeomByArea(@PathVariable("infLim") int infLim, @PathVariable("supLim") int supLim) {
        return municipioService.getGeomByArea(infLim, supLim);
    }

}
