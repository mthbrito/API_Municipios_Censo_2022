package brito.api_municipios_censo_2022.repository;

import brito.api_municipios_censo_2022.model.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    @Query(value = "SELECT id, municipio, estado, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM municipios_censo2022 WHERE id = CAST(?1 AS integer)", nativeQuery = true)
    Municipio findById(String id);

    @Query(value = "SELECT id, municipio, estado, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM municipios_censo2022 WHERE municipio = ?", nativeQuery = true)
    List<Municipio> findByMunicipio(String municipio);

    @Query(value = "SELECT id, municipio, estado, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM municipios_censo2022 WHERE estado = ?", nativeQuery = true)
    List<Municipio> findByEstado(String estado);

    @Query(value = "SELECT id, municipio, estado, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM municipios_censo2022 WHERE populacao >= ? AND populacao <= ?", nativeQuery = true)
    List<Municipio> findByPopulacaoBetween(int infLim, int supLim);

    @Query(value = "SELECT id, municipio, estado, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM municipios_censo2022 WHERE area >= ? AND area <= ?", nativeQuery = true)
    List<Municipio> findByAreaBetween(double infLim, double supLim);


}
