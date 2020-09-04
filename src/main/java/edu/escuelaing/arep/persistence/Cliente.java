package edu.escuelaing.arep.persistence;

public class Cliente {
    private String nombre;
    private String empresa;
    private int edad;
    public Cliente(String nombre,int edad, String empresa){
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                ", edad=" + edad +
                '}';
    }
}
