package Proyecto;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class AeropuertoPublico extends Aeropuerto {

    private double subvencion;

    //constructores
    public AeropuertoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPublico(String nombre, String ciudad, String pais, Compania[] compania, double subvencion) {
        super(nombre, ciudad, pais, compania);
        this.subvencion = subvencion;
    }

    public AeropuertoPublico(String nombre, String ciudad, String pais, double subvencion) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }

    public double getSubvencion() {
        return subvencion;
    }
}
