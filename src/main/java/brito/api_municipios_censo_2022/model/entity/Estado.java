package brito.api_municipios_censo_2022.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados_censo2022")
public class Estado {
    @Id
    private int id;
    private String estado;
    private int qtde;
    private int populacao;
    private double area;
    private String geom;

    public Estado() {
    }

    public Estado(int id, String estado, int qtde, int populacao, double area, String geom) {
        this.id = id;
        this.estado = estado;
        this.qtde = qtde;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
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
