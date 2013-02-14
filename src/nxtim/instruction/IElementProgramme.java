package nxtim.instruction;

/**
 * Un élément de programme est un concept abstrait regroupant instruction et expression.
 */
public interface IElementProgramme extends java.io.Serializable {

	/**
	 * Accepte un objet sachant parcourir un élément de programme.
	 *
	 * @param visiteur l'objet souhaitant parcourir l'élément.
	 */
	void accepte(VisiteurElementProg visiteur);
}
