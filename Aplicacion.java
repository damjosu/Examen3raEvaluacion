import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Josu
 */
public class Aplicacion
{

    /**
     * @return the NUM_CASAS_MIN
     */
    public static int getNUM_CASAS_MIN() {
        return NUM_CASAS_MIN;
    }

    /**
     * @return the NUM_CASAS_MAX
     */
    public static int getNUM_CASAS_MAX() {
        return NUM_CASAS_MAX;
    }

    /**
     * @return the NUM_CASAS_SUPER_LUJO_MIN
     */
    public static int getNUM_CASAS_SUPER_LUJO_MIN() {
        return NUM_CASAS_SUPER_LUJO_MIN;
    }

    /**
     * @return the NUM_CASAS_SUPER_LUJO_MAX
     */
    public static int getNUM_CASAS_SUPER_LUJO_MAX() {
        return NUM_CASAS_SUPER_LUJO_MAX;
    }

    /**
     * @return the NUM_PISOS_MIN
     */
    public static int getNUM_PISOS_MIN() {
        return NUM_PISOS_MIN;
    }

    /**
     * @return the NUM_PISOS_MAX
     */
    public static int getNUM_PISOS_MAX() {
        return NUM_PISOS_MAX;
    }

    private ArrayList<Inmueble> inmuebles;  //  Los inmuebles.
    private static final int NUM_CASAS_MIN = 1; //  número mínimo de casas.
    private static final int NUM_CASAS_MAX = 10;    //  número máximo de casas.
    private static final int NUM_CASAS_SUPER_LUJO_MIN = 1; //  número mínimo de casas de super lujo.
    private static final int NUM_CASAS_SUPER_LUJO_MAX = 10;    //  número máximo de casas de super lujo.
    private static final int NUM_PISOS_MIN = 1; //  número mínimo de pisos.
    private static final int NUM_PISOS_MAX = 10;    //  número máximo de pisos.

    /**
     * Constructor de la Clase Aplicacion
     */
    public Aplicacion()
    {
        Random rnd = new Random();
        inmuebles = new ArrayList<>();
        //  Número de casas aleatorio.
        int casa = rnd.nextInt((NUM_CASAS_MAX + 1) - NUM_CASAS_MIN) + NUM_CASAS_MIN;
        //  Número de casas de lujo aleatorio.
        int casaSuperLujo = rnd.nextInt((NUM_CASAS_SUPER_LUJO_MAX + 1) - NUM_CASAS_SUPER_LUJO_MIN) + NUM_CASAS_SUPER_LUJO_MIN;
        //  Número de pisos aleatorio.
        int piso = rnd.nextInt((NUM_PISOS_MAX + 1) - NUM_PISOS_MIN) + NUM_PISOS_MIN;
        for (int i = 0; i < casa; i++) {    //  Se crean tantas casas como "casa".
            inmuebles.add(new Casa());  //  Se añaden al ArrayList de inmuebles.
        }

        for (int i = 0; i < casaSuperLujo; i++) {    //  Se crean tantas casas de super lujo como "casaSuperLujo".
            inmuebles.add(new CasaSuperLujo());  //  Se añaden al ArrayList de inmuebles.
        }

        for (int i = 0; i < piso; i++) {    //  Se crean tantos pisos como "piso".
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

}