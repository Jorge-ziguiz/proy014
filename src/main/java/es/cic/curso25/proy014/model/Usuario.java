package es.cic.curso25.proy014.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Version
    private Long Version;

    private String name;

    private String Clave;

    @Column(nullable = false)
    private String Rol;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH })
    private Coche coche;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

 
    public static enum Roles {

        ADMIN_GARAJE("ADMIN"),
        PROPIETARIO_COCHE("USER");

        private String rol;

        Roles(String rol) {
            this.rol = rol;
        }
        
        public String getRol() {
            return rol;
        }

    }

}
