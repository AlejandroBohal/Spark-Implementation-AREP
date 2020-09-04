package edu.escuelaing.arep.persistence;

/**
 * The type Cliente.
 */
public class Cliente {
    private String nombre;
    private String empresa;
    private int edad;

    /**
     * Instantiates a new Cliente.
     *
     * @param nombre  nombre de la persona
     * @param edad    edad de la persona
     * @param empresa empresa de la persona
     */
    public Cliente(String nombre,int edad, String empresa){
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
    }

    /**
     * Gets nombre.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets empresa.
     *
     * @return empresa de la persona
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Sets empresa.
     *
     * @param empresa empresa de la persona
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Gets edad.
     *
     * @return edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets edad.
     *
     * @param edad edad de la persona
     */
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
