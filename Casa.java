import java.util.Random;
/**
 *
 * @author ASIR2
 */
public class Casa extends Inmueble {
    
    private boolean jardin; //  Si tiene jardin o no.
    private boolean zonaTranquila;  //  Si está en una zona tranquila o no.
    
    /**
     * Constructor de la clase Casa que crea una casa que puede tener o no jardin o zona tranquila.
     */
    public Casa() {
        Random rnd = new Random();
        jardin = false;
        zonaTranquila = false;
        if (rnd.nextInt(1) == 0) {  //  Aleatorio entre 0 y 1, si sale 0 tiene jardin, si no no.
            jardin = true;
        }
        
        if (rnd.nextInt(1) == 0) {  //  Aleatorio entre 0 y 1, si sale 0 tiene zonaTranquila, si no no.
            zonaTranquila = true;
        }
    }
    
    /**
     * @return the jardin
     */
    public boolean tieneJardin() {
        return jardin;
    }

    /**
     * @param jardin the jardin to set
     */
    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    /**
     * @return the zonaTranquila
     */
    public boolean tieneZonaTranquila() {
        return zonaTranquila;
    }

    /**
     * @param zonaTranquila the zonaTranquila to set
     */
    public void setZonaTranquila(boolean zonaTranquila) {
        this.zonaTranquila = zonaTranquila;
    }
    
    @Override
    /**
     * Devuelve los datos de la Casa.
     */
    public String toString() {
        String text; 
        if (jardin) {   //  Si tiene jardin.
            text = " tiene jardín ";
        } else {    //  No tiene jardín.
            text = " no tiene jardín ";
        }
        
        if (zonaTranquila) {    //  Si está en una zona tranquila.
            text += "y está en una zona tranquila";
        } else {    //  No está en una zona tranquila.
            text += "y no está en una zona tranquila";
        }
        return super.toString() + text;
    }
}