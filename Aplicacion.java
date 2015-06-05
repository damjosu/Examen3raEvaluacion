import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Josu
 */
public class Aplicacion
{

    /**
     * @return the NUM_CASAS
     */
    public static int getNUM_CASAS() {
        return NUM_CASAS;
    }

    /**
     * @return the NUM_CASAS_SUPER_LUJO
     */
    public static int getNUM_CASAS_SUPER_LUJO() {
        return NUM_CASAS_SUPER_LUJO;
    }

    /**
     * @return the NUM_PISOS
     */
    public static int getNUM_PISOS() {
        return NUM_PISOS;
    }

    private ArrayList<Inmueble> inmuebles;  //  Los inmuebles.
    private LinkedHashMap<Integer, Integer> reservas;    //  Reservas. La idReservaActual y el DNI del cliente.
    private static int idReservaActual = 1;   //  Número de reserva actual.
    private static final int NUM_CASAS = 5; //  número mínimo de casas.
    private static final int NUM_CASAS_SUPER_LUJO = 5; //  número mínimo de casas de super lujo.
    private static final int NUM_PISOS = 5; //  número mínimo de pisos.

    /**
     * Constructor de la Clase Aplicacion
     */
    public Aplicacion()
    {
        Random rnd = new Random();
        inmuebles = new ArrayList<>();
        reservas = new LinkedHashMap<>();

        for (int i = 0; i < NUM_CASAS; i++) {    //  Se crean tantas casas como "casa".
            inmuebles.add(new Casa());  //  Se añaden al ArrayList de inmuebles.
        }

        for (int i = 0; i < NUM_CASAS_SUPER_LUJO; i++) {    //  Se crean tantas casas de super lujo como "casaSuperLujo".
            inmuebles.add(new CasaSuperLujo());  //  Se añaden al ArrayList de inmuebles.
        }

        for (int i = 0; i < NUM_PISOS; i++) {    //  Se crean tantos pisos como "piso".
            inmuebles.add(new Piso());  //  Se añaden al ArrayList de inmuebles.
        }

    }

    /**
     * Muestra todos los inmuebles.
     */
    public void mostrarInmuebles() {
        String casa = "";
        String casaSuperLujo = "";
        String piso = "";
        for (Inmueble inmueble : inmuebles) {
            if (inmueble instanceof Casa) { //  Si inmueble es de tipo casa.
                casa += inmueble.toString() + "\n";
            }

            if (inmueble instanceof CasaSuperLujo) {    //  Si inmueble es de tipo CasaSuperLujo.
                casaSuperLujo += inmueble.toString() + "\n";
            }

            if (inmueble instanceof Piso) { //  Si inmueble es de tipo Piso
                piso += inmueble.toString() + "\n";
            }
        }

        System.out.println("CASAS");
        System.out.println(casa);
        System.out.println("CASAS SUPER LUJO");
        System.out.println(casaSuperLujo);
        System.out.println("PISOS");
        System.out.println(piso);
    }

    /**
     * Comprueba si para esos dias y para ese numero de personas hay algo disponible y los muesta por pantalla.
     */
    public void mostrarDisponibles(int diaLlegada, int diaSalida, int numPersonas) {
        if (diaSalida - diaLlegada <= 7) {   //  Reservan para menos de 8 dias.
            for (int i = 0; i < inmuebles.size(); i++) {   //  Se recorren todos los inmuebles.
                if (inmuebles.get(i).estaDisponible(diaLlegada, diaSalida, numPersonas)) {  //  Está disponible.
                    System.out.println(inmuebles.get(i).toString());    //  Muestra los datos del inmueble disponible.
                }
            }
        } else {    //  Reservan para 8 días o mas.
            for (int i = 0; i < inmuebles.size(); i++) { //  Se recorren todos los inmuebles.
                if (!(inmuebles.get(i) instanceof Piso)) {  //  No son pisos.  
                    if (inmuebles.get(i).estaDisponible(diaLlegada, diaSalida, numPersonas)) {  //  Está disponible.
                        System.out.println(inmuebles.get(i).toString());   //  Muestra los datos del inmueble disponible.
                    } //  Descartamos los pisos ya que no pueden reservarse por más de 7 días.
                }
            }
        }
    }

    /**
     * Reserva el inmueble si esta disponible. Guarda la reserva.
     */
    public void reservar(int diaLlegada, int diaSalida, int numPersonas, int id, int dni) {
        boolean encontrado = false; //  No se ha encontrado el inmueble.
        boolean idIncorrecta = false;
        int i = 0;
        while (!idIncorrecta && !encontrado && i < inmuebles.size()) { //  Mientras no encuentre el inmueble y no se haya recorrido todos los inmuebles sigue iterando.
            if(inmuebles.get(i).getId() == id) {    //  La id pasada por el usuario existe.
                if (inmuebles.get(i).estaDisponible(diaLlegada, diaSalida, numPersonas)) {  //  Esta libre.
                    for (int a = diaLlegada; a <= diaSalida; a++) { //  Recorre cada dia de la reserva.
                        inmuebles.get(i).setReserva(i); //  Reserva ese día.
                        reservas.put(idReservaActual, dni); //  Se guarda la reserva con una id especifica y el DNI del cliente.
                        inmuebles.get(i).setNumeroReservas(inmuebles.get(i).getNumReservas() + 1);  //  Se aumenta en 1 el número de reservas del inmueble.
                        idReservaActual++;                        
                    } 
                } else {
                    System.out.println("No está libre.");
                }
                encontrado = true;  //   Se ha encontrado el inmueble.
            } else {
                System.out.println("ID introducida incorrecta.");
                idIncorrecta = true;
            }            
            i++;
        }
    }

    /**
     * Muestra los datos de los inmuebles por orden de reservas de mayor a menor.
     */
    public void mostrarInmueblesPorReservas() {
        Collections.sort(inmuebles, new Comparator<Inmueble>() { //  Ordena el ArrayList de mayor a menor numero de reservas
                @Override
                public int compare(Inmueble i1, Inmueble i2) {
                    return new Integer(i2.getNumReservas()).compareTo(new Integer(i1.getNumReservas()));
                }
            });
        for (int i = 0; i < inmuebles.size(); i++) {
            System.out.println("Reservas " + inmuebles.get(i).getNumReservas() + " " + inmuebles.get(i).toString());
        } 
    }
    
    /**
     * Muestra los datos de los inmuebles ordenados de mayor a menor por precio.
     */
    public void mostrarInmueblesPorPrecio() {
        Collections.sort(inmuebles, new Comparator<Inmueble>() { //  Ordena el ArrayList de mayor a menor por precio
                @Override
                public int compare(Inmueble i1, Inmueble i2) {
                    return new Float(i2.calcularPrecio() * i2.getNumReservas()).compareTo(new Float(i1.calcularPrecio() * i1.getNumReservas()));
                }
            });
        for (int i = 0; i < inmuebles.size(); i++) {
            System.out.println("Precio " + inmuebles.get(i).calcularPrecio() + "€ Reservas " + inmuebles.get(i).getNumReservas() + " " + inmuebles.get(i).toString());
        } 
    }

}