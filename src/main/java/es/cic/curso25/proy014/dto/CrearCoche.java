package es.cic.curso25.proy014.dto;

public class CrearCoche {

    private String Matricula;

    private String Marca;

    private String Modelo;

    public CrearCoche() {
    }

    public CrearCoche(String matricula, String marca, String modelo) {
        Matricula = matricula;
        Marca = marca;
        Modelo = modelo;
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

}
