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

import java.util.Scanner;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4;//número de aeropuertos
    static Aeropuerto aeropuerto[] = new Aeropuerto[num];


    public static void main(String[] args) {

        //insertar datos de los aeropuertos
        insertarDatosAeropuerto(aeropuerto);
    }

    //método para insertar datos de los aeropuerto
    public static void insertarDatosAeropuerto(Aeropuerto aero[]) {
        //crear aeropuerto publico
        aero[0] = new AeropuertoPublico("Jorge Chavez", "Lima", "Perú", 8000000);
        aero[0].insertarCompania(new Compania("AeroPeru"));//como no tenemos creado una compania, lo creamos en al momento
        aero[0].insertarCompania(new Compania("LATAM"));
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB20", "lima", "Mexico", 150.90, 150));
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB21", "lima", "Buenos Aires", 180.90, 120));
        aero[0].getCompania("LATAM").insertarVuelo(new Vuelo("FC12", "lima", "lodres", 500.90, 180));
        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("jorge", "x4510", "peruana"));
        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Andrea", "x4512", "ucraniana"));
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
        aero[2] = new AeropuertoPublico("Aeropuerto Bogota", "bogota", "Colombia", 2000000);

        aero[3] = new AeropuertoPublico("Aeropuerto Mexico", "Ciudad de Mexico", "Mexico", 4000000);
        aero[3].insertarCompania(new Compania("AeroMexico"));//como no tenemos creado una compania, lo creamos en al momento
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Ciudad de Mexico", "lima", 270.90, 130));
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("IB2040", "Ciudad de Mexico", "Bogota", 450.90, 110));
        aero[3].getCompania("AeroMexico").getVuelo("AE030").insertarPasajero(new Pasajero("Marina", "r2412", "Mexicana"));

    }

    public static void menu() {
        int opcion;
        do {
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados(Publicos o Privados)");
            System.out.println("2. Ver Empresas(Privado) o Subvencion(Publico)");
            System.out.println("3. Listar compañias de un Aeropuerto");
            System.out.println("4. Listar Vuelos por Compañia");
            System.out.println("5. Listar Posibles Vuelos de Origen a Destino");
            System.out.println("6. Salir");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1://"1. Ver Aeropuertos gestionados(Publicos o Privados)"
                    break;
                case 2://"2. Ver Empresas(Privado) o Subvencion(Publico)"
                    break;
                case 3://"3. Listar compañias de un Aeropuerto"
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
}
