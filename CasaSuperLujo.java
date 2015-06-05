import java.util.Random;
/**
 *
 * @author Josu
 */
public class CasaSuperLujo extends Casa{

    /**
     * @return the NUM_HABITACIONES_MIN
     */
    public static int getNUM_HABITACIONES_MIN() {
        return NUM_HABITACIONES_MIN;
    }

    /**
     * @return the NUM_HABITACIONES_MAX
     */
    public static int getNUM_HABITACIONES_MAX() {
        return NUM_HABITACIONES_MAX;
    }

    /**
     * @return the NUM_PISCINAS_MIN
     */
    public static int getNUM_PISCINAS_MIN() {
        return NUM_PISCINAS_MIN;
    }

    /**
     * @return the NUM_PISCINAS_MAX
     */
    public static int getNUM_PISCINAS_MAX() {
        return NUM_PISCINAS_MAX;
    }

    /**
     * @return the DIAS_DE_NO_ALQUILER
     */
    public static int[] getDIAS_DE_NO_ALQUILER() {
        return DIAS_DE_NO_ALQUILER;
    }

    private int numPiscinas;    //  El número de piscinas que tiene.
    private int numHabitaciones;    //  El número de habitaciones que tiene.
    private static final int NUM_HABITACIONES_MIN = 5;  //  El número mínimo de habitaciones que puede tener.
    private static final int NUM_HABITACIONES_MAX = 20; //  El número máximo de habitaciones que puede tener.
    private static final int NUM_PISCINAS_MIN = 1;  //  El número mínimo de piscinas que puede tener.
    private static final int NUM_PISCINAS_MAX = 4;  //  El número máxmimo de piscinas que puede tener.
    private static final int DIAS_DE_NO_ALQUILER[] = {10, 20, 25};  //  Días que no se puede alquilar.
    
    /**
     * Constructor de la clase CasaSuperLujo que crea una casa de super lujo con un numero aleatorio
     * de habitaciones y piscinas. No se puede alquilar los DIAS_DE_NO_ALQUILER.
     */
    public CasaSuperLujo() {
        Random rnd = new Random();
        numPiscinas = rnd.nextInt((NUM_PISCINAS_MAX + 1) - NUM_PISCINAS_MIN) + NUM_PISCINAS_MIN;
        numHabitaciones = rnd.nextInt((NUM_HABITACIONES_MAX + 1) - NUM_HABITACIONES_MIN) + NUM_HABITACIONES_MIN;
    }

    /**
     * @return the numPiscinas
     */
    public int getNumPiscinas() {
        return numPiscinas;
    }

    /**
     * @param numPiscinas the numPiscinas to set
     */
    public void setNumPiscinas(int numPiscinas) {
        this.numPiscinas = numPiscinas;
    }

    /**
     * @return the numHabitaciones
     */
    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    /**
     * @param numHabitaciones the numHabitaciones to set
     */
    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }
    
    @Override
    /**
     * Devuelve los datos de la Casa de super lujo.
     */
    public String toString() {
        return super.toString() + " tiene " + numPiscinas + " piscinas y " + numHabitaciones + " habitaciones";
    }
}