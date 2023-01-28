package Proyecto;

/**
 * @author Jorge Monzón
 * @project personal_aeropuerto
 */
public class AeropuertoPrivado  extends Aeropuerto{
    private String listaEmpresas[] = new String[10];
    private int numEmpresa;

    //constructor
    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compania[] compania, String[] empresas) {
        super(nombre, ciudad, pais, compania);
        this.listaEmpresas = empresas;
        numEmpresa = empresas.length;
    }
    //método ingresar empresas en conjunto
    public void insertarEmpresas(String e[]){
        this.listaEmpresas = e;//copiar de arreglo a arreglo
        this.numEmpresa = e.length;//indicar cuantos elementos tiene el arreglo
    }
    //método para ingresa empresa por unidad
    public void insertarEmpresa(String e){
        listaEmpresas[numEmpresa] = e;
        numEmpresa++;
    }
    //muestra todas la empresas
    public String[] getListaEmpresas() {
        return listaEmpresas;
    }

    //muestra una empresa en particular
    public int getNumEmpresa() {
        return numEmpresa;
    }
}
