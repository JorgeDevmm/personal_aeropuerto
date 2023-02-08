/*Diseñar y codificar una aplicación informática para una compañia de gestión aeroportuaria satisfaciendo
los siguientes requisitos:
-Para cada aeropuerto es necesario saber:
a) Todas las compañias de vuelos que operan en él.
b) Nombre del aeropuerto, la ciudad donde se ubica y el país al que pertenece
- Cada compañia se caracteriza por el nombre y la lista de vuelos que ofrece.
- los vuelos están definidos por su identificador, la ciudad de origen, la ciudad de destino,
el precio del viaje, la lista de pasajeros, el número máximo de pasajeros permitidos en el vuelo
y el número real de pasajeros que ha reservado asiento en el avión.
- Los aeropuertos pueden ser privados o publicos.
a) Los aeropuertos privados tienen una serie de empresas que los patrocinan y es necesario saber el nombre
de cada una de esas empresas.
b) Para los aeropuertos públicos se requiere saber la cantidad de dinero correspondiente a la subvención
gubernamental.
- Se necesita gestionar también la información de los pasajeros.
a) Para cada pasajero se necesita saber nombre, número de pasaporte y nacionalidad

La aplicación tendrá un menú con las siguientes opciones:
1) Consultar los aeropuertos gestionados, indicando separadamente los aeropuertos públicos y los privados.
Para cada uno de ellos debera mostrar su nombre, la ciudad de ubicación, y el pais al que pertenece.
2) Visualizar las empresas que patrocinan un determinado aeropuerto en caso que sea privado, o la cuantía
 de la subvención en caso de que se trate de un aeropuerto público.
3) Para un determinado aeropuerto, se debe poder mostrar la lista de compañias que vuela desde ese
aeropuerto.
4) Para una determinada compañia que opera en un aeropuerto concreto, listar todos los posibles vuelos
que dicha compañia ofrece, mostrando su indentificador, la ciudad origen y destino y el precio del vuelo.
5)Mostrar todos los posibles vuelos (identificador) que parten de una ciudad origen a otra ciudad destino
(indicadas por el usuario) y mostrar su precio
*
* */
package Proyecto;

import java.nio.file.attribute.AclFileAttributeView;
import java.util.Scanner;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4;//número de aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];


    public static void main(String[] args) {

        try {
            //insertar datos de los aeropuertos
            insertarDatosAeropuerto(aeropuertos);
            menu();
        } catch (NullPointerException exception) {
            String mensaje = exception.getMessage();
            exception.printStackTrace();
        }


    }

    //método para insertar datos de los aeropuerto
    public static void insertarDatosAeropuerto(Aeropuerto aero[]) {
        //crear aeropuerto publico
        aero[0] = new AeropuertoPublico("Jorge Chavez", "Lima", "Perú", 8000000);
        aero[0].insertarCompania(new Compania("AeroPeru"));//como no tenemos creado una compania, lo creamos en al momento
        aero[0].insertarCompania(new Compania("LATAM"));
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB20", "lima", "Mexico", 150.90, 150));
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB21", "lima", "Buenos Aires", 180.90, 120));
        aero[0].getCompania("LATAM").insertarVuelo(new Vuelo("FC12", "lima", "londres", 500.90, 180));
        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("jorge", "x4510", "peruana"));
        aero[0].getCompania("AeroPeru").getVuelo("IB21").insertarPasajero(new Pasajero("Andrea", "x4512", "ucraniana"));
        aero[0].getCompania("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("luis", "E6710", "Colombiano"));

        aero[1] = new AeropuertoPrivado("Central Ciudad Real", "Central Real", "España");
        aero[1].insertarCompania(new Compania("AirEuropa"));
        String empresas[] = {"Cobresol", "Anguila34"};
        //aplicando downcasting
        ((AeropuertoPrivado) aero[1]).insertarEmpresas(empresas);
        aero[1].getCompania("AirEuropa").insertarVuelo(new Vuelo("AE025", "madrid", "Buenos Aires", 240, 150));
        aero[1].getCompania("AirEuropa").getVuelo("AE025").insertarPasajero(new Pasajero("Juan", "A3546", "Peruana"));

        aero[2] = new AeropuertoPublico("Aeropuerto Bogota", "bogota", "Colombia", 2000000);
        aero[2].insertarCompania(new Compania("AirAmerica"));//como no tenemos creado una compania, lo creamos en al momento
        aero[2].insertarCompania(new Compania("VuelaBogota"));
        aero[2].getCompania("AirAmerica").insertarVuelo(new Vuelo("AE030", "Bogota", "Lima", 170.90, 140));
        aero[2].getCompania("AirAmerica").insertarVuelo(new Vuelo("AE031", "Bogota", "Lima", 150.90, 120));
        aero[2].getCompania("AirAmerica").getVuelo("AE030").insertarPasajero(new Pasajero("Julian", "x4510", "peruana"));
        aero[2].getCompania("AirAmerica").getVuelo("AE031").insertarPasajero(new Pasajero("Max", "x4512", "Colombiana"));

        aero[3] = new AeropuertoPublico("Aeropuerto Mexico", "Ciudad de Mexico", "Mexico", 4000000);
        aero[3].insertarCompania(new Compania("AeroMexico"));//como no tenemos creado una compania, lo creamos en al momento
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Ciudad de Mexico", "lima", 270.90, 130));
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Ciudad de Mexico", "Bogota", 450.90, 110));
        aero[3].getCompania("AeroMexico").getVuelo("IB2040").insertarPasajero(new Pasajero("Marina", "r2412", "Mexicana"));

    }

    public static void menu() {
        String nombreAeropuerto;
        int opcion;
        Aeropuerto aeropuertoEncontrado;
        do {
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados(Publicos o Privados)");
            System.out.println("2. Ver Empresas(Privado) o Subvencion(Publico)");
            System.out.println("3. Listar compañias de un Aeropuerto");
            System.out.println("4. Listar Vuelos por Compañia");
            System.out.println("5. Listar Posibles Vuelos de Origen a Destino");
            System.out.println("6. Salir");

            System.out.println("");
            System.out.print("Ingresar opcion:");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1://"1. Ver Aeropuertos gestionados(Publicos o Privados)"
                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2://"2. Ver Empresas(Privado) o Subvencion(Publico)"
                    System.out.println("");
                    mostrarPatrocinioEmpresas(aeropuertos);
                    break;
                case 3://"3. Listar compañias de un Aeropuerto"
                    System.out.println("");
                    System.out.println("Ingresar el nombre del Aeropuerto");
                    entrada.nextLine();//limpiar buffer
                    nombreAeropuerto = entrada.nextLine();
                    aeropuertoEncontrado = buscarAeropuerto(nombreAeropuerto, aeropuertos);//almacenamos el objeto de tipo Aeropuerto que retorna del método en la variable aeropuertoEncontrado
                    if (aeropuertoEncontrado == null) {
                        System.out.println("Aeropuerto no existe");
                    } else {//si existe el aeropuerto invocara al otro método
                        mostrarCompanias(aeropuertoEncontrado);
                    }
                    break;
                case 4://"4. Listar Vuelos por Compañia"
                    break;
                case 5://"5. Listar Posibles Vuelos de Origen a Destino"
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error, Se equivoco de opción de menú");
                    break;
            }
            System.out.println("");
        } while (opcion != 6);
    }

    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]) {
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {//válida con instancef mi objeto esta instanciado con el tipo de un objeto
                System.out.println("AeropuertoPrivado");
                System.out.println(aeropuertos[i].toString());
            } else {
                System.out.println("AeropuertoPublico");
                System.out.println(aeropuertos[i].toString());
            }
            System.out.println("");
        }
    }

    public static void mostrarPatrocinioEmpresas(Aeropuerto aeropuerto[]) {
        System.out.println("listar Datos de empresas o Subvenciones");
        System.out.println("========================================");
        String empresas[];//arreglo de tipo empresa para almacenar las empresas encontradas
        for (int i = 0; i < aeropuerto.length; i++) {
            if (aeropuerto[i] instanceof AeropuertoPrivado) {
                System.out.println("* Aeropuerto Privado: " + aeropuerto[i].getNombre());
                empresas = ((AeropuertoPrivado) aeropuerto[i]).getListaEmpresas();

                for (int j = 0; j < empresas.length; j++) {
                    System.out.println("empresa[" + j + "]: " + empresas[j]);
                }
            } else {
                System.out.println("* Aeropuerto Publico: " + aeropuerto[i].getNombre());
                System.out.println("Subvención: " + ((AeropuertoPublico) aeropuerto[i]).getSubvencion());

            }
            System.out.println("");
        }
    }

    public static Aeropuerto buscarAeropuerto(String nombreAeropuerto, Aeropuerto aeropuertos[]) {
        Aeropuerto aeropuertoEncontrado = null;
        for (int i = 0; i < aeropuertos.length; i++) {
            if (nombreAeropuerto.equals(aeropuertos[i].getNombre())) {
                aeropuertoEncontrado = aeropuertos[i];
            }
        }
        return aeropuertoEncontrado;
    }

    public static void mostrarCompanias(Aeropuerto aeropuertoEncontrado) {
        System.out.println("\nLas Companias del Aeropuerto: " + aeropuertoEncontrado.getNombre());
        //recorrerar la cantidad de compánia que exista en getNumCompania
        for (int i = 0; i < aeropuertoEncontrado.getNumCompania(); i++) {
            System.out.println(aeropuertoEncontrado.getCompania(i).getNombre());//accediendo al interador de compania y por el el método getNombre
        }
    }
}
