package jscratch.modeles;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;

/**
 * Définit le dictionnaire de variables.
 */
public final class DicoVariables {

	/**
	 * L'instance de
	 * <code>DicoVars</code>.
	 */
	private static DicoVariables instance;
	/**
	 * Les différentes variables.
	 */
	private HashMap<String, Variable> dictionnaire;

	/**
	 *
	 */
	private DicoVariables() {
		dictionnaire = new HashMap<String, Variable>();
	}

	/**
	 * Récupère l'instance unique de
	 * <code>DicoVars</code>.
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
	 * @param v
	 */
	public void ajouter(final Variable v) {
		if (!v.getNom().isEmpty() && !dictionnaire.containsKey(v.getNom())) {
			dictionnaire.put(v.getNom(), v);
		}
	}

	/**
	 * Supprimer la variable portant le nom.
	 *
	 * @param nom le nom de la variable
	 */
	public void supprimer(final String nom) {
		dictionnaire.remove(nom);
	}

	/**
	 * Récupère toutes les variables du type voulu.
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
	 * @return le dictionnaire contenant toutes les variables avec leur nom
	 */
	public HashMap<String, Variable> getDictionnaire() {
		return this.dictionnaire;
	}

	/**
	 * Récupère toutes les variables du dictionnaire.
	 *
	 * @return les variables du dictionnaire
	 */
	public Variable[] getLesvariables() {
		return (Variable[]) dictionnaire.values().toArray(new Variable[0]);
	}
}
