package robot;

public class CellularAutomata {
    
    /**
     * Fonction static car on ne veux pas faire
     *
     * new CellularAutomata().
     * On a un comportement static, c'est à dire qui ne dépenda pas du context d'éxécution.
     *
     * @param edison
     */
    public static void cellularAutomata(RobotEdison edison) {
        // La couleur du carré est différent selon le mode utilisé (Sombre ou Clair)
        String whiteSquare = "■"; // 1
        String blackSquare = "□"; // 0
        int zero = 0; // mindu Random -- determine la couleur du carré
        int one = 1; // max du Random -- determine la couleur du carré
        boolean generation = true; // commence true et change d'état dans la boucle
        int lignes=0; // Déterminera la longueur de la boucle while et la longueur de l'affichage
    
        int[] cell = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1}; // tableau de 11 index
        System.out.println("\t\tGénération aléatoire");
        while(lignes < 20) { // boucle while délimitée par la valeur de la variable
            lignes +=1; // La variable augmente de 1 à chaque tour de boucle, determine la longueur de la boucle while
            System.out.print("\n"); // retourne à la ligne à chaque tour de boucle, permet de faire un bloc -- visuel
            for(int i=0; i<=cell.length-1; i++)
            {
                cell[i] = (int)(Math.random() * (one+1 - zero)) + zero; // Aléatoire 1 ou 0
                if(generation) {  // Si la booleenne est vraie
                    if (cell[i] == 1)
                    {
                        System.out.print(whiteSquare); // carré blanc si égal à 1
                    }
                    else if (cell[i] == 0)
                    {
                        System.out.print(blackSquare); // carré noir si égal à 0
                    }
                    generation = false; // Le booleen change d'état
                }
                if (!generation) // si la booleenne est fausse
                {
                    cell[i] = (int)(Math.random() * (one+1 - zero)) + zero; // Cellule aléatoire 1 ou 0
                    if (cell[i] == 0)
                    {
                        System.out.print(whiteSquare);
                    }
                    else if (cell[i] == 1)
                    {
                        System.out.print(blackSquare);
                    }
                    generation = true; // Le booleen change d'état
                }
            }
        }
        Start.demarrer(edison);
        System.out.println("\n");
    }
    
}
