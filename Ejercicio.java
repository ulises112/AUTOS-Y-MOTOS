import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
public class Ejercicio {
    public static void main(String args[]) {
    System.out.println("\n            BIENVENIDO A NUESTRA CONCESIONARIA DE AUTOS Y MOTOS           ");
    System.out.println("\na continuacion se mostraran todos los vehiculos disponibles por el momento.\n");

    Auto peugeot206 = new Auto ("Peugeot", "206", 4, 200000.0);
    Auto peugeot208 = new Auto ("Peugeot", "208", 5, 250000.0);
    Moto titan = new Moto ("Honda", "Titan", 125, 60000.0);
    Moto ybr = new Moto ("Yamaha", "YBR", 160, 80500.5);
    Vehiculos listaVehiculos = new Vehiculos();
    listaVehiculos.vehiculos.add(peugeot206);
    listaVehiculos.vehiculos.add(peugeot208);
    listaVehiculos.vehiculos.add(titan);
    listaVehiculos.vehiculos.add(ybr);
    System.out.println(listaVehiculos.imprimirVehicul(listaVehiculos.vehiculos));

    System.out.println("Vehiculo mas caro: " + listaVehiculos.vehiculoMasCaro().getD());
    System.out.println("Vehiculo mas caro: " + listaVehiculos.vehiculoMasBarato().getD());
    System.out.println("Vehiculos que contienen la letra 'Y': " + listaVehiculos.vehiculosConString("y"));
     System.out.println("Vehiculos ordenados por precios de mayor a menor: \n" + listaVehiculos.imprimirVehiculos(listaVehiculos.ordenarPorPrecio()));
           

    }


}
class Object{
    public String getMarca() {
    return this.getMarca();
    }
    public double getPrecio(){
    return this.getPrecio();
    }
    public String getDatos(){
    return this.getDatos();
    }
    public String getD(){
    return this.getD();
    }
    public String getBusqueda(){
    return this.getBusqueda();
    }
    public boolean nombreTiene(String unaCadena) {
    return this.nombreTiene(unaCadena);
    }
}
class Auto extends Object{
    String strMarca;
    String strModelo;
    int iPuertas;
    double iPrecio;
        public Auto (String strUnaMarca, String strUnModelo, int iCantidadPuertas, double iUnPrecio){
        strMarca = strUnaMarca;
        strModelo = strUnModelo;
        iPuertas = iCantidadPuertas;
        iPrecio = iUnPrecio;
        }
        public String getMarca (){
        return strMarca;
        }
        public String getModelo (){
        return strModelo;
        }
        public int getPuertas(){
        return iPuertas;
        }
        public double getPrecio(){
        return iPrecio;
        }
        public String getDatos(){
        return "marca: "+strMarca + " // modelo " + strModelo + " // puertas " + iPuertas + " // precio: $" + iPrecio;
        }
        public String getD(){
        return strMarca+" "+strModelo;
        }
        public String getBusqueda(){
        return strMarca+" "+strModelo+" "+iPrecio;
        }
        public boolean nombreTiene(String unaCadena) {
        return strMarca.toUpperCase().contains(unaCadena.toUpperCase());
        }
}
class Moto extends Object{
    String strMarca;
    String strModelo;
    int iCilindrada;
    double iPrecio;
        public Moto (String strUnaMarca, String strUnModelo, int iUnaCilindrada, double iUnPrecio){
        strMarca = strUnaMarca;
        strModelo = strUnModelo;
        iCilindrada = iUnaCilindrada;
        iPrecio = iUnPrecio;
        }
        public String getMarca (){
        return strMarca;
        }
        public String getModelo(){
        return strModelo;
        }
        public int getCilindrada(){
        return iCilindrada;
        }
        public double getPrecio(){
        return iPrecio;
        }
        public String getDatos(){
        return "marca: "+strMarca+ " // modelo " +strModelo+ " // cilindrada " + iCilindrada + " // precio: $" + iPrecio;
        }
        public String getD(){
        return strMarca+" "+strModelo;
        }
        public String getBusqueda(){
        return strMarca+" "+strModelo+" "+iPrecio;
        }
        public boolean nombreTiene(String unaCadena) {
        return strMarca.toUpperCase().contains(unaCadena.toUpperCase());
        }
}
class Vehiculos {
List<Object> vehiculos = new ArrayList<>();
    public List<Object> getAutos() {
    return vehiculos;
    }
    public void setAutos(List<Object> listaVehiculos) {
    vehiculos = listaVehiculos;
    }
    public Object vehiculoMasCaro() {
    return Collections.max(vehiculos, Comparator.comparingDouble(Object::getPrecio));
    }

    public Object vehiculoMasBarato(){
    return Collections.min(vehiculos, Comparator.comparingDouble(Object::getPrecio));
    }
        public String imprimirVehicul(List<Object> listaVehiculos){
        String strModelos="";
        
        for(Object unVehiculo : listaVehiculos)
            strModelos = strModelos  + unVehiculo.getDatos() + "\n";
        
        return strModelos;
    }

    public String imprimirVehiculos(List<Object> listaVehiculos){
        String strModelos="";
        
        for(Object unVehiculo : listaVehiculos)
            strModelos = strModelos  + unVehiculo.getD() + "\n";
        
        return strModelos;
    }
    public List<Object> ordenarPorPrecio(){
        List<Object> vehiculosOrdenados = vehiculos.stream()
    .sorted(Comparator.comparing(Object::getPrecio).reversed()).collect(Collectors.toList());
        
        return vehiculosOrdenados;
    }

    public String vehiculosConString(String unaCadena) {
    String strModelos = "";
    List<Object> vehiculosString = vehiculos.stream()
    .filter(p -> p.nombreTiene(unaCadena)).collect(Collectors.toList());
    for(Object unVehiculo : vehiculosString)
    strModelos = strModelos + unVehiculo.getBusqueda() + "\n";
    return strModelos;
    }


}