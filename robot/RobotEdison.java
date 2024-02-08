package robot;

public class RobotEdison {
    
    private boolean isOn; // test si est allumé
    private int batteryLeft; // batterie restante
    private String idRobot; // nom du robot
    
    /*
    Ces éléments ne sont pas lié à l'état du robot donc pas besoin de les stocker
    
    
    public boolean turnOn; // Allumer
    public boolean turnOff; // Eteind
    public boolean chargeBattery; // Charger
    public int menu;  // Accès rapide aux fonctionnalités via le switch-case
     */
    
    // Constructeur
    public RobotEdison(boolean _isOn, int _batteryLeft, String _idRobot) // Class : Robot_Edison
    {
        // Instances de Class
        isOn = _isOn;
        batteryLeft = _batteryLeft;
        idRobot = _idRobot;
    }
    
    /**
     * Default constructeur
     *
     * Will create a simple Robot:
     *  - idRobot: Edison
     *  - batteryLeft: 80
     *  - isOn: false
     */
    public RobotEdison()
    {
        isOn = false;
        batteryLeft = 80;
        idRobot = "Edison";
    }
    // Fin de la déclaration du constructeur
    
    // Tests booleens
    public boolean testIsOn()
    {
        if(this.isOn)
        {
            System.out.println("Oui, le robot est allumé");
            return true;
        }
        else
        {
            System.out.println("Non, le robot est éteint");
            return false;
        }
    }
    public int combienBatterie()
    {
        System.out.println("La batterie restante est de : " + batteryLeft);
        return batteryLeft;
    }
    
    // Fin des tests booleens
    public int chargerBattery()
    {
        if(this.batteryLeft == 100)  // Si la batterie est à 100%
        {
            System.out.println("La batterie est déjà chargée à 100%");
        }
        else if(this.batteryLeft > 30)  // Si le niveau de batterie est superieur à 30%
        {
            System.out.println("Le niveau de batterie est actuellement de " + this.getBatteryLeft()
                    + "%, charger votre appareil maintenant pourrait réduire sa durée de vie."
                    + "\nVoulez-vous tout de même le charger ? Y/N");
            String str = Utils.sc.next();
            if(str.contains("Y") || str.contains("y"))
            {
                this.batteryLeft = 100;   // Le niveau de charge de la batterie pass à 100%
                System.out.println("\n\tLa batterie est en charge ...\n\nNiveau de charge : " + this.getBatteryLeft() + "%");
                //this.demarrer();
            }
            else
            {
                System.out.println("\n\tLe niveau de charge est inchangé : " + this.getBatteryLeft() + "%");
                //this.demarrer();
            }
        }
        return this.getBatteryLeft();
        
    }
//------------------------------------------------------------------------------------------------------------------------
    // Ajout des programmes et fonctionnalités du robot
    
    // Setter de l'objet
    public void setBatteryLeft(int _batteryLeft)
    {
        this.batteryLeft = _batteryLeft;
    }
    public void setIdRobot(String _idRobot)
    {
        this.idRobot = _idRobot;
    }
    // Fin des setters de l'objet
    // Getters du robot
    public int getBatteryLeft()
    {
        return batteryLeft;
    }
    public String getId()
    {
        return idRobot;
    }
    public boolean getIsOn()
    {
        return isOn;
    }
    // Fin des getters du robot
    // boolean tests
    boolean getTestIsOn()
    {
        return testIsOn();
    }
    
    
    /*
     * Edison fonctionality
     *
     * Surement à déplacer dans une autre classe pour mieux organiser le code, mais pas n'importe comment. On pourra en discuter
     *
     */
    public boolean allumer()
    {
        if(!this.getIsOn())
        {
            System.out.println("Démarrage du robot");
            this.isOn = true;
            Start.demarrer(this);
            return true;
        }
        else
        {
            System.out.println("Le robot était déjà allumé");
        }
        //edison.start();
        return true;
    }
    public void eteindre()
    {
        System.out.println("Extinction du robot...\nPressez A pour allumer");
        isOn = false;
        String allumage = Utils.sc.next();
        if(allumage.contains("A") || allumage.contains("a"))
        {
            isOn = true;
            //edison.start();
        }
    }
    
    public void cellularAutomata() {
        //Apelle le code Cellular Automata
        CellularAutomata.cellularAutomata(this);
    }
    
    
    
}
