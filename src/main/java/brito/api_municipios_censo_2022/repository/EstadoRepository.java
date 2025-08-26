package brito.api_municipios_censo_2022.repository;

import brito.api_municipios_censo_2022.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    @Query(value = "SELECT id, estado, qtde, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM estados_censo2022 WHERE id = CAST(?1 AS integer)", nativeQuery = true)
    Estado findById(String id);

    @Query(value = "SELECT id, estado, qtde, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM estados_censo2022 WHERE estado = ?", nativeQuery = true)
    Estado findByEstado(String estado);

    @Query(value = "SELECT id, estado, qtde, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM estados_censo2022 WHERE qtde >= ? AND qtde <= ? ORDER BY qtde DESC", nativeQuery = true)
    List<Estado> findByQtdeBetween(int infLim, int supLim);

    @Query(value = "SELECT id, estado, qtde, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM estados_censo2022 WHERE populacao >= ? AND populacao <= ? ORDER BY populacao DESC", nativeQuery = true)
    List<Estado> findByPopulacaoBetween(int infLim, int supLim);

    @Query(value = "SELECT id, estado, qtde, populacao, area, ST_AsGeoJSON(geom)::json AS geom FROM estados_censo2022 WHERE area >= ? AND area <= ? ORDER BY area DESC", nativeQuery = true)
    List<Estado> findByAreaBetween(double infLim, double supLim);
}
