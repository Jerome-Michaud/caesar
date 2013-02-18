package jscratch.dictionnaires;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	 * L'instance de <code>DicoVars</code> pour l'interpréteur.
	 */
	private static DicoVariables instanceInterp;
	/**
	 * L'instance de <code>DicoVars</code> pour l'interpréteur.
	 */
	private static DicoVariables instanceExec;
	/**
	 * Les différentes variables.
	 */
	private Map<String, Variable> dictionnaire;

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
	 * Récupère l'instance unique de <code>DicoVars</code> pour l'interpréteur de NXC.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance de <code>DicoVars</code>
	 */
	public static synchronized DicoVariables getInstanceInterpreteur() {
		if (instanceInterp == null) {
			instanceInterp = new DicoVariables();
		}
		return instanceInterp;
	}
	
	/**
	 * Récupère l'instance unique de <code>DicoVars</code> pour l'exécution.
	 *
	 * @since 1.0
	 * 
	 * @return l'instance de <code>DicoVars</code>
	 */
	public static synchronized DicoVariables getInstanceExecution() {
		if (instanceExec == null) {
			instanceExec = new DicoVariables();
		}
		return instanceExec;
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
	 * Récupère toutes les variables du dictionnaire.
	 *
	 * @since 1.0
	 * 
	 * @return les variables du dictionnaire
	 */
	public Variable[] getLesvariables() {
		return (Variable[]) dictionnaire.values().toArray(new Variable[0]);
	}
	
	/**
	 * Test l'existance d'une variable dans le dictionnaire.
	 * 
	 * @param varName le nom de la variable.
	 * @return <code>true</code> si la variable existe dans le dictionnaire, sinon <code>false</code>.
	 */
	public boolean exist(String varName) {
		return dictionnaire.containsKey(varName);
	}
	
	/**
	 * Accède à une variable du dictionnaire.
	 * 
	 * @param varName le nom de la variable.
	 * @return la variable ou <code>null</code> si aucune variable ne correspond.
	 */
	public Variable getVariable(String varName) {
		return dictionnaire.get(varName);
	}
	
	/**
	 * Vérifie si le dictionnaire est vide.
	 * 
	 * @return <code>true</code> si le dictionnaire est vide, <code>false</code> s'il possède au moins une variable.
	 */
	public boolean isEmpty() {
		return dictionnaire.isEmpty();
	}
	
	/**
	 * Supprime toutes les variables du dictionnaire.
	 */
	public void clear() {
		dictionnaire.clear();
	}
}