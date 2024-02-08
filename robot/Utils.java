package robot;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Utils class
 */
public class Utils {
    
    /**
     * Utils class only, no instanciation allowed
     */
    private Utils(){}
    
    /**
     * Scanner
     */
    public static Scanner sc = new Scanner(System.in); // Scanner
    
    /**
     * Decimal formatter on two digits
     */
    public static DecimalFormat decimalFormat = new DecimalFormat("00"); // Formatage à deux chiffres 00
    
    /**
     * Date formatter with default format: dd-MM-yyyy
     * Exemple:
     *  12-01-2024
     *  01-12-1999
     */
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Formatage de la date jj-MM-aaaa
    
    /**
     * Time formatter with default format: HH:mm:ss
     * Exemple:
     *  12:56:32
     */
    public static SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss"); // Formatage de l'heure 24h HH:mm:ss (HH majuscule pour le format 24h -- hh minuscule pour le format 12h)
    /*  @Chris, ce n'est pas la bonne façon de faire car ce ne serai pas toujours vrai
     *  En faisant comme ça, tu as la date à la qu'elle tu as démarrer ton programme
     *  Cependant si ton code tourne pendant plusieurs jours, alors tu na plus la date du jour!
     */
    // public static Date date = new Date(); // retourne la date actuelle
    
    /**
     * Retourne la date actuel.
     * La méthode est évaluer donc la date sera toujours la date du jour
     * @return
     */
    public static Date getTodayDate() {
        return new Date();
    }
    
    
    /*
     * Même reflexion que pour la date
     */
    //public static Calendar calendar = Calendar.getInstance(); // Retourne l'heure actuelle
    
    /**
     * Retourne le calendrier.
     * @return
     */
    public static Calendar getCurrentTime() {
        return Calendar.getInstance();
    }
    
    
    
}
