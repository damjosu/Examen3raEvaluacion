import java.util.Random;
/**
 *
 * @author Josu
 */
public class Piso extends Inmueble {
    
    private boolean terraza;    //  Si tiene terraza o no.
    private boolean ascensor;   //  Si tiene ascensor o no.
    
    /**
     * Constructor de la clase Piso que crea un piso que puede tener o no terraza o ascensor.
     */
    public Piso() {
        Random rnd = new Random();
        terraza = false;
        ascensor = false;
        if (rnd.nextInt(1) == 0) {  //  Aleatorio entre 0 y 1, si sale 0 tiene terraza, si no no.
            terraza = true;
        }
        
        if (rnd.nextInt(1) == 0) {  //  Aleatorio entre 0 y 1, si sale 0 tiene ascensor, si no no.
            ascensor = true;
        }
    }
    
    /**
     * @return the terraza
     */
    public boolean tieneTerraza() {
        return terraza;
    }

    /**
     * @param terraza the terraza to set
     */
    public void setTerraza(boolean terraza) {
        this.terraza = terraza;
    }

    /**
     * @return the ascensor
     */
    public boolean tieneAscensor() {
        return ascensor;
    }

    /**
     * @param ascensor the ascensor to set
     */
    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }
    
    @Override
    /**
     * Devuelve los datos del Piso.
     */
    public String toString() {
        String text; 
        if (terraza) {  //  si tiene terraza.
            text = " tiene terraza ";
        } else {    // no tiene terraza.
            text = " no tiene terraza ";
        }
        
        if (ascensor) { //  si tiene ascensor.
            text += "y ascensor";
        } else {    //   no tiene ascensor.
            text += "ni ascensor";
        }
        return super.toString() + text;
    }
}