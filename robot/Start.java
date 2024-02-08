package robot;

/**
 * Class used to handle the user input for the gven Robot
 */
public class Start {
    
    /**
     * The Demarrer function work with only one Robot
     * @param edison
     */
    public static void demarrer(RobotEdison edison)  // Affiche la notice, regroupe toutes les fonctionnalitées
    {
        System.out.print("-------------------------------------------------------------\n\t\tLe robot " + edison.getId() + " est un robot programmable et modulable.\n"
                + "Notice :\n1. Eteindre\n2. Allumer\n3. Charger la batterie\n4. Afficher la date et l'heure"
                + "\n5. Cellular Automata\n6. Calculs\n7. Tableaux\n8. Boucles for\n9. Jours de la semaine\n\n0. Quitter\n\nChoisis en donnant le numéro du programme : "
                + "\n");
        int choixMenu = Utils.sc.nextInt();
        if(choixMenu == 1)
        {
            edison.eteindre();
        }
        else if(choixMenu == 2)
        {
            edison.allumer();
        }
        else if(choixMenu == 3)
        {
            //edison.getBatteryLeft();
            edison.combienBatterie();//A beaucoup plus de sens car cela affiche des résultats
        }
        else if(choixMenu == 4)
        {
            //edison.afficherDateHeure();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else if(choixMenu == 5)
        {
            edison.cellularAutomata();
        }
        else if(choixMenu == 6)
        {
            //edison.getMenuCalcul();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else if(choixMenu == 7)
        {
            //edison.getMenuTableaux();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else if(choixMenu == 8)
        {
            //edison.menuBoucleFor();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else if(choixMenu == 9)
        {
            //edison.getJourSemaine();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else if(choixMenu == 123)
        {
            //edison.notaBene();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else if(choixMenu == 0)
        {
            System.out.println("\n\n\tMenu principal\nLe niveau de batterie est de " + edison.getBatteryLeft() + "%"
                    + "\nNous somme le " + Utils.dateFormat.format(Utils.getTodayDate())
                    + "\nIl est " + Utils.hourFormat.format(Utils.getCurrentTime().getTime()));
            //edison.getEteindre();
            System.out.println("Code a faire pour le choix menu: " + choixMenu);
        }
        else
        {
            System.out.println("\tSaisie invalide : caractères interdits.");
            Start.demarrer(edison);
        }
        
    }
    
}
