package jscratch.dictionnaires;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;

/**
 * Définit le dictionnaire de variables.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class DicoVariables {

	/**
	 * L'instance de <code>DicoVars</code>.
	 */
	private static DicoVariables instance;
	/**
	 * Les différentes variables.
	 */
	private HashMap<String, Variable> dictionnaire;

	/**
	 * Constructeur privé de <code>DicoVariables</code>.
	 * 
	 * @since 1.0
	 */
	private DicoVariables() {
		dictionnaire = new HashMap<String, Variable>();
	}

	/**
	 * Récupère l'instance unique de <code>DicoVars</code>.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance de <code>DicoVars</code>
	 */
	public static synchronized DicoVariables getInstance() {
		if (instance == null) {
			instance = new DicoVariables();
		}
		return instance;
	}

	/**
	 * Ajouter la variable dans le dictionnaire.
	 *
	 * @since 1.0
	 * 
	 * @param v la variable à ajouter
	 */
	public void ajouter(final Variable v) {
		if (!v.getNom().isEmpty() && !dictionnaire.containsKey(v.getNom())) {
			dictionnaire.put(v.getNom(), v);
		}
	}

	/**
	 * Supprimer la variable portant le nom.
	 *
	 * @since 1.0
	 * 
	 * @param nom le nom de la variable
	 */
	public void supprimer(final String nom) {
		dictionnaire.remove(nom);
	}

	/**
	 * Récupère toutes les variables du type voulu.
	 *
	 * @since 1.0
	 * 
	 * @param type le type de variable désiré
	 * @return les variables du type désiré
	 */
	public List<Variable> getVariablesDeType(final TypeVariable type) {
		ArrayList<Variable> res = new ArrayList<Variable>();
		for (Variable v : dictionnaire.values()) {
			if (v.getType() == type) {
				res.add(v);
			}
		}
		return res;
	}

	/**
	 * Récupère le dictionnaire.
	 *
	 * @since 1.0
	 * 
	 * @return le dictionnaire contenant toutes les variables avec leur nom
	 */
	public HashMap<String, Variable> getDictionnaire() {
		return this.dictionnaire;
	}

	/**
	 * Récupère toutes les variables du dictionnaire.
	 *
	 * @since 1.0
	 * 
	 * @return les variables du dictionnaire
	 */
	public Variable[] getLesvariables() {
		return (Variable[]) dictionnaire.values().toArray(new Variable[0]);
	}
}