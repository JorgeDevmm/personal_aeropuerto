package Proyecto;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int numMaxPasajeros;
    private int numActualPasajeros;
    private Pasajero listaPasajeros[];

    //Constructor

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajeros = 0;//iterador
        this.listaPasajeros = new Pasajero[numMaxPasajeros];//número maximo pasajeros en el vuelo
    }

    public void insertarPasajero(Pasajero pasajero) {
        listaPasajeros[numActualPasajeros] = pasajero;
        numActualPasajeros++;//incremento del iterador del arreglo de Pasajero
    }

    //métodos getters
    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }

    public int getNumActualPasajeros() {
        return numActualPasajeros;
    }

    //obtenemos el pasajero por medio del indice
    public Pasajero getPasajero(int i) {
        return listaPasajeros[i];
    }

    //obtenemos el indice del pasajero por medio del pasaporte
    public Pasajero getPasajero(String pasaporte) {
        boolean encontrado = false;
        Pasajero pas = null;
        for (int i = 0; i < listaPasajeros.length; i++) {
            if (pasaporte.equals(listaPasajeros[i].getPasaporte())) {
                encontrado = true;
                pas = listaPasajeros[i];
            }
        }
        return pas;

    }
}


