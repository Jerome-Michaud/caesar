package jscratch.interpreteur;

/**
 * Interface pour les objets permettant de construire un programme
 *
 * @author Adrien DUROY
 */
public interface MonteurProgramme {
	
	/**
	 * Ajoute une affectation au programme.
	 */
	public void affectation();
	
	/**
	 * Ajoute une boucle while au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps du while.
	 */
	public void bwhile(int nbInst);
	
	/**
	 * Ajoute une boucle do-while au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps de la boucle.
	 */
	public void bdoWhile(int nbInst);
	
	/**
	 * Ajoute une condition au programme.
	 * 
	 * @param op l'opérateur conditionnel.
	 */
	public void condition(String op);
	
	/**
	 * Ajoute une constante au programme.
	 * 
	 * @param valeur la valeur de la constante.
	 * @param type le type de la constante.
	 */
	public void constante(String valeur, String type);
	
	/**
	 * Ajoute une déclaration d'une variable.
	 * 
	 * @param type le type de la variable.
	 * @param var le nom de la variable.
	 */
	public void declaration(String type, String var);
	
	/**
	 * Ajoute une déclaration avec initialisation au programme.
	 * 
	 * @param type le type de la variable.
	 * @param var le nom de la variable.
	 */
	public void declarationInitialisation(String type, String var);
	
	/**
	 * Ajout un appel à une fonction dans le programme.
	 * 
	 * @param nom le nom de la fonction.
	 * @param nbArgs le nombre d'arguments de la fonction.
	 */
	public void fonctionAppel(String nom, int nbArgs);
	
	/**
	 * Ajoute une opération au programme.
	 * 
	 * @param op l'opérateur arithmétique.
	 */
	public void operation(String op);
	
	/**
	 * Ajoute une instruction if au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps du if. 
	 */
	public void si(int nbInst);
	
	/**
	 * Ajoute une instruction if-else dans le programme.
	 * 
	 * @param nbInstIf le nombre d'instruction dans le corps du if.
	 * @param nbInstElse le nombre d'instruction dans le corps du else.
	 */
	public void siSinon(int nbInstIf, int nbInstElse);
	
    /**
     * Ajoute une tâche au programme.
     * 
     * @param nom le nom de la tâche
     */
    public void tache(String nom, int nbInst);

	/**
	 * Ajoute un appel à une variable au programme.
	 * 
	 * @param nom le nom de la variable.
	 */
	public void variable(String nom);
	
    /**
     * Remet à zéro le monteur. Le monteur repart d'un programme vierge.
     */
    public void reset();
}
