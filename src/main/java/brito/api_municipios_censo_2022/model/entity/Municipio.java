package brito.api_municipios_censo_2022.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "municipios_censo2022")
public class Municipio {

    @Id
    private int id;
    private String municipio;
    private String estado;
    private int populacao;
    private double area;
    private String geom;

    public Municipio() {
    }

    public Municipio(int id, String municipio, String estado, int populacao, double area, String geom) {
        this.id = id;
        this.municipio = municipio;
        this.estado = estado;
        this.populacao = populacao;
        this.area = area;
        this.geom = geom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
