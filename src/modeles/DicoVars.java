package modeles;

import instruction.TypeVariable;
import instruction.Variable;
import instruction.VariableModifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Définit le dictionnaire de variables.
 */
public final class DicoVars {

	/**
	 * L'instance de
	 * <code>DicoVars</code>.
	 */
	private static DicoVars instance;
	/**
	 * Les différentes variables.
	 */
	private HashMap<String, Variable> dictionnaire;

	/**
	 *
	 */
	private DicoVars() {
		dictionnaire = new HashMap<String, Variable>();
		//this.dictionnaire.put("icerkjnfenefn", new VariableModifiable(TypeVariable.INT, "icerkjnfenefn", "0"));
	}

	/**
	 * Récupère l'instance unique de <code>DicoVars</code>.
	 * 
	 * @return l'instance de <code>DicoVars</code>
	 */
	public static synchronized DicoVars getInstance() {
		if (instance == null) {
			instance = new DicoVars();
		}
		return instance;
	}

	/**
	 * Ajouter la variable dans le dictionnaire.
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
