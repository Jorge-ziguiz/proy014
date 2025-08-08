package es.cic.curso25.proy014.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Version
    private Long Version;

    @Column(nullable = false,unique = true)
    private String Matricula;

    private String Marca;

    private String Modelo;

    @Column(unique = true)
    private int Plaza;

    private boolean EstaEnLaPLaza;

    @ManyToOne(fetch =FetchType.LAZY,
        cascade = {CascadeType.MERGE,CascadeType.MERGE,CascadeType.REFRESH})
    @JsonBackReference
    private Garaje garaje;

    @OneToMany(fetch = FetchType.LAZY,
        orphanRemoval = true
    ,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonManagedReference
    private List<Multa> multas = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getVersion() {
        return Version;
    }

    public void setVersion(Long version) {
        Version = version;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getPlaza() {
        return Plaza;
    }

    public void setPlaza(int plaza) {
        Plaza = plaza;
    }

    public boolean isEstaEnLaPLaza() {
        return EstaEnLaPLaza;
    }

    public void setEstaEnLaPLaza(boolean estaEnLaPLaza) {
        EstaEnLaPLaza = estaEnLaPLaza;
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }

    
}
