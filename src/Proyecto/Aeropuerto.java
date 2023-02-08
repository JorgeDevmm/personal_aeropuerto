package Proyecto;

import com.sun.security.jgss.GSSUtil;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compania listaCompania[] = new Compania[10];
    private int numCompania;

    //constructores
    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompania = 0;
    }

    public Aeropuerto(String nombre, String ciudad, String pais, Compania compania[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        listaCompania = compania;
        numCompania = compania.length;
    }


    public void insertarCompania(Compania compania) {
        listaCompania[numCompania] = compania;
        numCompania++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compania[] getListaCompania() {
        return listaCompania;
    }

    public int getNumCompania() {
        return numCompania;
    }

    //obtener compania por medio del iterador introducido
    public Compania getCompania(int i) {
        return listaCompania[i];
    }

    //obtener compania por medio de la compania ingresada
    public Compania getCompania(String nombre) {
        boolean encontrado = false;
        int i = 0;
        Compania c = null;

        while ((!encontrado) && (i < listaCompania.length)) {
            if (nombre.equals(listaCompania[i].getNombre())) {
                encontrado = true;
                c = listaCompania[i];//asignamos el objeto de mi lista de companias en el objeto c
            }
            i++;
        }
        return c;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + "\n" +
                "ciudad: " + ciudad + "\n" +
                "pais: " + pais + "\n";
    }
}
