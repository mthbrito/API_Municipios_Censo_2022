package brito.api_municipios_censo_2022.repository;

import brito.api_municipios_censo_2022.model.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    List<Municipio> findByMunicipio(String municipio);

    List<Municipio> findByEstado(String estado);

    List<Municipio> findByPopulacaoBetween(int infLim, int supLim);

    List<Municipio> findByAreaBetween(double infLim, double supLim);
}
