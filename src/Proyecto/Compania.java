package Proyecto;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class Compania {
    private String nombre;
    private Vuelo listaVuelos[] = new Vuelo[10];
    private int numVuelo = 0;

    //constructor
    public Compania(String nombre) {
        this.nombre = nombre;
    }

    //pasar la lista de vuelo para guardarlo en mi arreglo de vuelo
    public Compania(String nombre, Vuelo v[]) {
        this.nombre = nombre;
        listaVuelos = v;
        numVuelo = v.length;
    }

    //getters
    public void insertarVuelo(Vuelo vuelo) {
        listaVuelos[numVuelo] = vuelo;
        numVuelo++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    //introducimos la el numero de vuelo
    public Vuelo getVuelo(int i) {
        return listaVuelos[i];
    }

    //introducimos por identificador
    public Vuelo getVuelo(String id) {
        boolean encontrado = false;
        Vuelo v = null;
        for (int i = 0; i < listaVuelos.length; i++) {
            if (id.equals(listaVuelos[i].getIdentificador())) {
                encontrado = true;
                v = listaVuelos[i];
            }
        }
        return v;
    }
}
