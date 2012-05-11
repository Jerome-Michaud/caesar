package instruction;

import traduction.VisiteurTraduction;

/**
 * Un élément de programme est un concept abstrait regroupant instruction et expression.
 */
public interface IElementProgramme extends java.io.Serializable {

	/**
	 * Accepte un objet sachant traduire un élément de programme.
	 *
	 * @param visiteur l'objet traducteur
	 */
	void accepte(VisiteurTraduction visiteur);
}
