Une bonne structure de projet est primordiale pour la réussite de ton projet.
Donc voici les bonnes pratiques ou une partie d'entre elle.

# Eclipse / Git

## `Oeuil pour Oeuil et Dent pour Dent`

* Faite un projet Eclipse/IntelliJ propre uniquement pour ce projet.
* Faite un projet Github uniquement pour ce projet

Si on commence à mixer les projets Eclipse entre eux ou encore les projet github, alors cela ne vas pas être possible.
Dans le cas ou on ne peux pas faire plusieurs projet Github, ce n'est pas grave, on fait un dossier dédié par projet le tout dans un repository.

Par exemple:
```text
./
 | ./projet_1/src
 | ./projet_1/....
 | ./projet_1/Readme.md
 | ./projet_2/src
 | ./projet_2/....
 | ./projet_2/Readme.md
 | ....
 | Readme.md
```

## Nom du projet
Idéalement, le nom du projet est explicite, sans abréviation et **sans espaces**.
Le dernier point peux parraitre bête, mais certain framework ou logiciel n'arrive pas s'il y a un ou plusieurs espaces dans le chemin.
Donc autant éviter des long moment de recherche.

# Le projet en lui même

Il est important de bien structurer le projet en lui même et de **rester constant** au sein d'un même projet.
On peux changer de convention entre deux projets. Mais la consistence et la cohérence au sein d'un même projet est primordiale.

Vous avez surement remarqué que dans la partie structure, je fais mention de fichier `Readme.md`
Ce fichier est important car c'est le premier fichier lu par une nouvelle personne en découvrant le projet.

## Readme.md

Le but de ce fichier est de présenter techniquement votre projet à une personne qui:
* Ne vous connais pas
* Ne connais pas le projet
* À un niveau technique proche du votre
* Ne connais pas les points trés technique de votre projet.

Idéalement un fichier `Readme.md` contiens les éléments suivant:
* Présentation
  * Présentation succinte du projet
  * Présentation des technologies mise en oeuvre et leur version
* Dévellopement
  * Comment configurer l'environnement de dévellopement 'from scratch'
  * Comment démarer le projet
* Autre information
  * Lien vers la documentation compléte du projet
  * Lien vers des ressources utiles
  * N'importe qu'elle ressource utile
  * License du projet *Souvent mise en dernier dans le Readme.md*


## Organisation des sources

Je vous invite à lire en détail ce lien: [Java Naming Convention](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)

### Choix du package principale

Le package est l'endroit ou tout votre code vas être.
Idéalement il est unique dans le monde.

La convention pose la norme d'une URL inversé.
Par exemple:
* Si `Google.com` fait du Java son package serai `com.google.nomduprojet`
  * Par exemple si c'est la branche `IA` de `Google` qui fait du Java: `com.google.ia.nomduprojet`
* Si `Wikipedia.com` fait du Java son package serai `com.wikipedia.nomduprojet`
* Si `Mr.Pharo` fait du Java son package serai `fr.pharo.nomduprojet`


Par bonne pratique, la classe contenant le `main` de notre programme est le `package principale` de notre projet.

*Pour la suite, je vais considérer que mon package principale sera `fr.pharo.robotique`*

### Les sous-packages

Les `sous-packages` permettent d'organiser son code. La notion de `sous-package` n'est pas exact.
Tout est package, mais j'emploi de terme pour éviter de confondre avec le package principale.

Il est primordiale que les packages contiennent des informations relative ensemble.

Exemple de bonne structure:
```text
./fr.pharo.robotique					-> Package principale
./fr.pharo.robotique.backend            -> Package regroupant tout le backend de l'application (partie technique)
./fr.pharo.robotique.backend.data       -> Package avec toutes les classes de données
./fr.pharo.robotique.backend.services   -> Package avec les services métier
./fr.pharo.robotique.frontend           -> Package regroupant tout le frontend/l'affichage
./fr.pharo.robotique.frontend.composant -> Package avec des composants pour le frontend
./fr.pharo.robotique.frontend.ui        -> Package avec toute l'interface graphique
./fr.pharo.robotique.utils              -> Package contenant les classes utilitaires
```

Convention de nom:
* Les packages sont en minuscule
* Éviter les noms trop longs

*Par habitude profésionnel, mes projets sont toujours séparer en `backend` et `frontend` afin de mieux segmenter le code. Un petit projet peux s'affranchir de cette séparation*


### Les Classes

Définition d'une classe:
* Une classe est présente dans un package.
* Une classe à un rôle
* Une classe à un nom en `CamelCase` commençant par une Majuscule.
  * Exemple:
    * Bon nom de classe: `CeciEstUneClasse`, `APIProvider`, `Personne`, `PersonnePhysique`, `PersonneMorale`
	* Mauvais nom de classe: `Ceci_Est_Pas_Bon`, `apiProvider`, `personne_physique`, `Personne_Morale`
* Une classe à une `JavaDoc`
  * La `JavaDoc` est comme un commentaire. Sauf qu'elle commence par `/**` et non `/*`.
  * La `JavaDoc` est affiché en HTML par les IDE lors du survole des fonctions
  * Idéalement on retrouve:
    * À quoi sert la fonction
	* Le rôle des paramétres
	* La signification de la valeur de retour si la fonction peux renvoyer quelque chose


#### Classe principale

Package: `fr.pharo.robotique`
Fichier: `App.java`

```java
package fr.pharo.robotique;  // Explication 1

/** //Explication 2
*
* Cette classe est la classe de démarrage du projet.
*
*
*/
public class App { //Explication 3

	/** //Explication 4
	*
	* Ceci est la fonction main permettant de démarrer le projet `Robotique`
	* Args:
	*  - Aucun nécéssaire
	*
	*/
	public static void main(String[] args) { //Explication 5
		....
		....
		....
	}

}
```

Explication allant autour:
1. Ceci permet de savoir dans qu'elle package la classe se trouve. C'est un élément **obligatoire** pour toutes les classes.
2. `JavaDoc` de la classe `App`. Elle décris à quoi sert la classe et idéalement quelque cas d'utilisation. On peux aussi mettre n'importe qu'elle information utile et relative à la classe dedans.
3. Déclaration de la classe
4. `JavaDoc` de la fonction `main` -> Elle décris à quoi sert la fonction et comment l'utiliser.
5. Déclaration de la fonction `main`


#### Classe générale du projet

Package: `fr.pharo.robotique.backend.data;
Fichier: `Robot.java`

```java
package fr.pharo.robotique.backend.data;	//Explication 1

/**	//Explication 2
* 
* Classe d'un Robot
* 
* Un robot est tout simple avec un niveau de batterie et un statut
* 
* Le robot perd de la batterie au rythme de Robot.BATTERIE_LOST_PER_SECOND toutes les secondes
* Si le robot n'a plus de batterie, il s'éteint.
*
* Attention: A cause de la société de consomation, il n'est pas possible de rechercher un robot!
*
*/
public class Robot {	//Explication 3
	
	/** //Explication 4
	* Perte de batterie par seconde ou le robot est allumée
	*/
	public static final double BATTERIE_LOST_PER_SECOND = 0.001d; //Explication 5
	
	
	/** //Explication 6
	* Represente l'état allumé ou éteint du robot
	*/
	private boolean allume; //Explication 7
	
	/** //Explication 8
	* Represnte le pourcentage de la batterie
	* Valeur comprise entre 0.0d et 1.0d
	*/
	private double batterie; //Explication 9

	/** //Explication 10
	* Constructeur de base d'un robot
	*/
	public Robot() {	//Explication 11
		this.allume = false;	//Robot éteint lors de sa création  //Explication 12
		this.batterie = 0.7d;	//70% de charge de la batterie		//Explication 13
	}
	
	/**	//Explication 14
	* 
	* Fonction permettant de consommé la batterie. Cette fonction est à apeller toutes les secondes.
	* Le robot est alors mis à jour en tenant de tout ses états
	*/
	public void oneSecondIsPassed() {	//Explication 15
		if(this.allume) {
			//Le Robot est allumé, il perd BATTERIE_LOST_PER_SECOND
			this.batterie -= Robot.BATTERIE_LOST_PER_SECOND;
			
			if(this.batterie <= 0.0d) {
				//Le robot n'a plus de batterie donc il s'éteint
				this.allume = false;
			}
		}
	}
	
	
	/* Getter & Setter */	//Explication 16
	
	//Explication 17
	public boolean isAllume() { return this.allume; }
	
	//Explication 18
	public void setAllume(boolean allume) {this.allume = allume;}
	
	//Explication 19
	public double getBatterie() {return this.batterie;)
	
	
	//Pas de set pour la batterie car on ne peux pas recharger. //Explication 20

}
```


Explication de la classe `Robot`:
1. Permet de savoir dans qu'elle package on ce trouve.
2. `JavaDoc` de la classe `Robot`
3. Déclaration de la classe `Robot`
4. `JavaDoc` de la constante BATTERIE_LOST_PER_SECOND
5. Déclaration de la constante:
  * `public`: L'attribut est accéssible depuis n'importe ou dans l'application
  * `static`: L'attribut est accéssible directement depuis la classe: `Robot.BATTERIE_LOST_PER_SECOND` et non `(new Robot()).BATTERIE_LOST_PER_SECOND`
  * `final`: L'attribut est une constantes. Jamais il ne sera possible de faire `Robot.BATTERIE_LOST_PER_SECOND = 0.1d` autrement que en dure dans le code.
  * `double`: Type de l'attribut
  * `BATTERIE_LOST_PER_SECOND`: Nom de l'attribut. Comme c'est une constante, sa convention est `TOUT_EN_MAJUSCULE` en remplaçcant les `espaces` par des `_`
6. `JavaDoc` de la variable `allume`
7. Déclaration de l'attribut `allume`:
  * `private`: L'attribut n'est pas visible hors de la classe. Le code: `(new Robot()).allume` n'est pas bon hors de la classe `Robot`
  * `boolean`: Type de l'attribut
  * `allume`: nom de l'attribut en `camelCase` en commençant par une minuscule
8. `JavaDoc` de la variable `batterie`
9. Déclaration de la variable `batterie`. Même explication que pour l'explication `7`
10. `JavaDoc` du constructeur sans argument de la classe `Robot`
11. Déclaration du constructeur sans argument de la classe `Robot`
12. Assignation d'un état dans la variable `allume`
13. Assignation du pourcentage par défaut de batterie du `Robot`
14. `JavaDoc` de la fonction `oneSecondIsPassed`
15. Déclaration de la fonction `oneSecondIsPassed`
  * `public`: On peux accéder à la fonction depuis n'importe qu'elle instance de la classe `Robot`. Exemple: `(new Robot()).oneSecondIsPassed()`
  * `void`: La fonction ne renvoie rien
  * `oneSecondIsPassed`: Nom de la fonction, explicite et en `camelCase` commençant par une `minuscule`
  * `()`: Argument que la fonction prend. Ici aucune
16. Les `Getters` et `Setters` sont `99%` du temps en bas de la classe. Ces fonctions réalise l'affectation simple. On considére que aucun code métier n'est présent dans ces fonctions.
17. `Getter` de l'attribut `allume`. Comme c'est un `boolean` la fonction n'est pas nommée `getAllume` mais `isAllume` pour traduire la notion d'état de la variable.
18. `Setter` de l'attribut `allume`. Affecte la valeur dans l'attribut
19. `Getter` de l'attribut `batterie`. Ici c'est un `double` donc le nom est bien `getBatterie`.
20. Commentaire rajouter pour dire que le fait qu'il y ai pas de `setter` pour l'attribut `batterie` n'est pas un oublie mais est lié au fait qu'on ne puisse pas recharger le robot.

#### Classe de Service
Il est en générale plus simple de créer des classes dédié au comportement `métier`.

Regardons alors la classe qui s'occupe des Robots.

Package: `fr.pharo.robotique.backend.services`
Fichier: `RobotService.java`

```java
package fr.pharo.robotique.backend.services;	//Explication 1

/**	//Explication 2
*
* Classe permettant de gérer n'importe qu'elle robot.
* S'occupe de les créer mais aussi de les faires vivre.
*
*/
public class RobotService { //Explication 3
	
	/** //Explication 4
	* Liste de tous les robots créer par le service
	*/
	private final List<Robot> createdRobot; //Explication 5
	
	/** //Explication 6
	* Thread utiliser pour faire vivre les robots.
	*/
	private final Thread robotLive; //Explication 7
	
	
	/** //Explication 8
	*  Constructeur du service robot
	*/
	public RobotService() { //Explication 9
		this.createdRobot = new ArrayList<>();	//Créer la liste qui contiendra tous les robots créer par le service
		this.robotLive = new Thread(this::robotAlive); //Créer le thread pour simuler la perte des batteries de tous les robots.
		this.robotLive.start();	//Démarre le Thread gardant en vie les robots.
	}
	
	/**	//Explication 10
	* Fonction permettant de créer un Robot
	*/
	public Robot creerRobot() {	//Explication 11
		Robot robot = new Robot();
		
		this.createdRobot.add(robot);
		
		return robot;
	}
	
	/**	//Explication 12
	* Fonction du service assurant l'apelle toute les secondes à tous les robots pour simuler la perte de la batterie
	*/
	private void robotAlive(){	//Explication 13
		/* code ommited */	//Explication 14
	}

}
```


Explication de la classe `RobotService`:
1. Package dans la qu'elle la classe se trouve
2. `JavaDoc` de la classe `RobotService` décrivant le but du service et ce qu'il fait
3. Déclaration de la classe `RobotService`
4. `JavaDoc` de l'attribut `createdRobot`
5. Déclaration de l'attribut `createdRobot`
  * `private`: L'attribut est privé, il n'est pas accéssible depuis l'extérieur de la classe. Le code: `(new RobotService()).createdRobot` n'est pas bon
  * `final`: L'attribut est une constantes. Cela est fait pour éviter de perdre la liste des robots créer.
  * `List<Robot>`: Type de l'attribut, c'est une liste de Java
6. `JavaDoc` de l'attribut `robotLive`
7. Déclaration de l'attribut `robotLive`
  * `private`: L'attribut n'est pas accéssible depuis l'extérieur de la classe
  * `final`: L'attribut est une constantes. Cela est fait pour ne pas perdre l'objet car il éxécute du code
  * `Thread`: Type particulier de Java permettant d'éxécuter du code en paraléle. Je ne rentre pas dans le détail.
8. `JavaDoc` du constructeur de la classe `RobotService`
9. Déclaration du constructeur sans arugment de la classe `RobotService`
  * Le contenu du constructeur est passé d'explication car les commentaires sont présent
10. `JavaDoc` de la fonction `creerRobot`
11. Déclaration de la fonction `creerRobot`
  * `public`: Fonction accéssible depuis n'importe qu'elle instance de la classe `RobotService`. Exemple: `(new RobotService()).creerRobot()` est valide.
  * `Robot`: Type de retour. Ici, la fonction renvoie un `objet` de type `Robot`
  * `creerRobot`: Nom de la fonction en `camelCase` commençant par une `minuscule`
  * `()`:  Paramétre de la fonction. Ici aucun
12. `JavaDoc` de la fonction `robotAlive`
13. Déclaration de la fonction `robotAlive`
  * `private`: La fonction n'est pas visible depuis l'extérieur de la classe.
  * `void`: Type de retour. Ici aucune.
  * `robotAlive`: Nom de la fonction en `camelCase` commençant par une `minuscule`
  * `()`: Paramétres de la fonction. Ici aucun
14. J'omais le code qui serai pas forcément grand, mais pas pertinent pour expliquer la structure du projet.


#### Classe Utilitaire

Ces classes permettent de mutualiser du code qui serai répéter à plusieurs endroit dans l'application.
Une bonne pratique est de faire une classe utilitaire par type.

Par exemple:
* `DateUtils`: Classe contenant les fonctions pratique pour toutes les `dates`
* `StringUtils`: Classe contenant les fonctions pratique pour toutes les `String`
* `RobotUtils`: Classe contenant les fonctions pratique pour la classe `Robot`.

Dans les petits projet on peux simplement faire une classe `Utils` avec tout dedans. Au quel cas, elle sera souvent placé dans le même package que la classe contenant le `Main`.

Exemple de classe `Utils`.

Package: `fr.pharo.robotique`
Fichier: `Utils.java`

```java
package fr.pharo.robotique; //Explication 1

/**	//Explication 2
* Classe contenant des fonctions static servant à travers tout le projet
*/
public class utils {	//Explication 3

	/**	//Explication 4
	* Pas de constructeur, c'est une classe d'Utils
	*/
	private Utils(){}	//Explication 5
	
	/** //Explication 6
	*
	* Éffectue le padding de la chaine sur le nombre de caractére
	* Rajoute le nom nombre de `0` devant pour avoir au moins la taille souhaité
	*
	* Exemple:
	*  - padString("123", 5)    -> 00123
	*  - padString("1234", 5)   -> 01234
	*  - padString("12345", 5)  -> 12345
	*  - padString("123456", 5) -> 123456
	*/
	public static String padString(String s, int size) {	//Explication 7
		/* code ommited */
	}

}

```

Explication de la classe `Utils`:
1. Package dans la qu'elle la classe est
2. `JavaDoc` de la classe Utils pour expliciter ce qu'elle contient
3. Déclaration de la classe `Utils`
4. `JavaDoc` du constructeur de la classe `Utils`
5. Déclaration du constructeur sans argument de la classe `Utils`
  * `private`: On ne veux pas pouvoir faire `new Utils()` donc on met le constructeur sans argument en `private`.
6. `JavaDoc` de la fonction `padString`. Vous remarquerez la présence des exemples d'utilisations et des résultats attendu
7. Déclaration de la fonction `padString`
  * `public`: La fonction est accéssible depuis n'importe ou
  * `static`: La fonction est accéssible directement depuis la classe. Le code `Utils.padString(....)` est correcte.
  * `String`: Type de retour de la fonction
  * `padString`: Nom de la fonction en `camelCase` commençant par une `minuscule`
  * `(String s, int size)`: Paramétres attendu par la fonction

#### Classe de Constantes

Par rigeur, simplicité il est conseillé de mettre ses constantes globale dans un fichier dédié.

Attention: Les constantes qui sont relative à une classe, vont avec la classe.

Par exemple: `Robot.BATTERIE_LOST_PER_SECOND` est bien car c'est la constante qui définie comment le `Robot` perd sa batterie.

Exemple de fichier de `Constant`

Package: `fr.pharo.robotique`
Fichier: `Constant.java`

```java
package fr.pharo.robotique;	//Explication 1

/** //Explication 2
* 
* Fichier contenant les constantes du projet Robotique
* 
*/
public class Constant {	//Explication 3

	/**	//Explication 4
	* Classes non instantiable
	*/
	private Constant(){}	//Explication 5
	
	/** //Explication 6
	* Date format à utiliser dans les DateFormatter
	*/
	public static final String DATE_FORMAT = "dd/MM/yyyy"; //Explication 7
	
	/**
	* Date Time format à utiliser dans les DateTimeFormatter
	*/
	public static final String DATE_TIME_FORMAT = "dd/MM/yyyy - hh:mm:ss";
	
	/**
	* Symbole de la monnaie pour l'application
	*/
	public static final String MONEY_SYMBOL = "€";

}

```

Explication de la classe `Constant`:
1. Package dans la qu'elle est la classe
2. `JavaDoc` de la classe `Constant`
3. Déclaration de la classe `Constant`
4. `JavaDoc` du constructeur sans argument de la classe `Constant`
5. Constructeur sans argument privé. Il ne fait pas de sens de faire `new Constant()`
6. `JavaDoc` de la constante `DATE_FORMAT` pour expliquer sa raison
7. Déclaration de l'attribut `DATE_FORMAT`
  * `public`: L'attribut est accéssible depuis n'importe ou dans l'application
  * `static`: L'attribut est accéssible sans instance de l'objet: Le code `Constant.DATE_FORMAT` est correct
  * `final`: L'attribut est une constante. Il n'est pas possible d'éxécuter: `Constant.DATE_FORMAT = "toto"` dans le code
  * `String`: Type de l'attribut
  * `DATE_FORMAT`: Nom de l'attribue. Comme c'est une constante, `TOUT_EN_MAJUSCULE` en remplaçant les `espaces` par des `_`

Les autres constantes ont la même explication. Donc je ne vais pas me repeter.

