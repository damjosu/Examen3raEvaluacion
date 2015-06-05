import java.util.Random;
import java.util.LinkedHashMap;
/**
 *
 * @author Josu
 */
public abstract class Inmueble {

    /**
     * @return the idActual
     */
    public static int getIdActual() {
        return idActual;
    }

    /**
     * @param aIdActual the idActual to set
     */
    public static void setIdActual(int aIdActual) {
        idActual = aIdActual;
    }

    /**
     * @return the numMaxPersonas
     */
    public static int getNumMaxPersonas() {
        return numMaxPersonas;
    }

    /**
     * @param aNumMaxPersonas the numMaxPersonas to set
     */
    public static void setNumMaxPersonas(int aNumMaxPersonas) {
        numMaxPersonas = aNumMaxPersonas;
    }

    /**
     * @return the NUM_PERSONAS_MIN
     */
    public static int getNUM_PERSONAS_MIN() {
        return NUM_PERSONAS_MIN;
    }

    /**
     * @return the NUM_PERSONAS_MAX
     */
    public static int getNUM_PERSONAS_MAX() {
        return NUM_PERSONAS_MAX;
    }

    /**
     * @return the DISTANCIA_MIN
     */
    public static int getDISTANCIA_MIN() {
        return DISTANCIA_MIN;
    }

    /**
     * @return the DISTANCIA_MAX
     */
    public static int getDISTANCIA_MAX() {
        return DISTANCIA_MAX;
    }

    private int id; //  id del inmueble.
    private int distancia;  //  Distancia en km al centro Eivissa.
    private LinkedHashMap<Integer, Boolean> reservas;   //  Día y true si esta ocupado , o false en caso contrario
    private static int idActual = 1;    //  número de id actual.
    private static int numMaxPersonas; //  número máximo de personas que puede albergar ESTE INMUEBLE.
    private static final int NUM_PERSONAS_MIN = 1;  //  número de personas mínimo que puede albergar.
    private static final int NUM_PERSONAS_MAX = 10;  //  número de personas máximo que puede albergar CUALQUIER INMUEBLE.
    private static final int DISTANCIA_MIN = 10;    //  distancia mínima al centro Eivissa.
    private static final int DISTANCIA_MAX = 50;   //  distancia máxima al centro Eivissa.

    /**
     * Constructor de la clase Inmueble que crea un Inmueble con una distancia y número
     * de personas aleatoria, y una id en base al último creado.
     */
    public Inmueble() {
        Random rnd = new Random();
        distancia = rnd.nextInt((DISTANCIA_MAX + 1) - DISTANCIA_MIN) + DISTANCIA_MIN;   //  distancia aleatoria entre unos limites.
        numMaxPersonas = rnd.nextInt((NUM_PERSONAS_MAX + 1) - NUM_PERSONAS_MIN) + NUM_PERSONAS_MIN; //  numeroMaximo de personas que puede albergar entre unos límites.
        reservas = new LinkedHashMap<>();
        for (int i = 1; i <= 31; i++) {
            reservas.put(i, false);
        }
        id = idActual;
        idActual++;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * Reserva para un dia en específico.
     */    
    public void setReserva(int dia) {
        reservas.put(dia, true);
    }

    /**
     * @return true si esta disponible, false en caso contrario.
     */
    public boolean estaDisponible(int diaLlegada, int diaSalida, int numPersonas) {
        boolean disponible = true;  //  Está disponible.
        int i = diaLlegada;
        if (numPersonas <= this.numMaxPersonas) {   //  Si caben suficientes personas.
            while (disponible && i <= diaSalida) {
                if (reservas.get(i)) {  //  Si esta ocupado.
                    disponible = false; //  No está disponible.
                }
                i++;
            }
        } else {    //  No caben suficientes personas.
            disponible = false;
        }        
        return disponible;
    }    

    @Override
    /**
     * Devuelve los datos del Inmueble.
     */
    public String toString() {
        return "ID: " + id + " distancia a Eivissa: " + distancia + "km " + "puede alojar " + numMaxPersonas + " personas";
    }
}