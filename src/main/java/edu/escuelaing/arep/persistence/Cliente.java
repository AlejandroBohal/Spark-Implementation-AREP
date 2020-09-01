package edu.escuelaing.arep.persistence;

public class Cliente {
    private String nombre;
    private String empresa;
    public Cliente(String nombre, String empresa){
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
