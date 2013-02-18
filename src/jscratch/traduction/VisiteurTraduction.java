package jscratch.traduction;

import nxtim.instruction.VisiteurElementProg;

public abstract class VisiteurTraduction implements VisiteurElementProg {

	/**
	 * La traduction.
	 */
	protected String traduction;
	/**
	 * Le niveau d'indentation.
	 */
	protected int nivIndent;
	/**
	 * La méthode d'indentation.
	 */
	protected boolean identationTabulation = false;
	
	public VisiteurTraduction() {
		traduction = "";
		nivIndent = 0;
	}

	/**
	 * Donne la traduction.
	 *
	 * @return la traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * Réinitialise la traduction.
	 */
	public void reset() {
		traduction = "";
		nivIndent = 0;
	}

	/**
	 * Donne l'indentation du niveau d'indentation courant.
	 *
	 * @return la chaîne correspondant à l'espace d'indentation.
	 */
	protected String indent() {
		String indentation = "";
		for (int i = 0; i < nivIndent; i++) {
			if (identationTabulation) {
				indentation += "\t";
			} else {
				indentation += "    ";
			}
		}
		return indentation;
	}

	/**
	 * Permet de savoir si le caractère tabulation est utilisé pour l'indentation.
	 *
	 * @return <code>true</code> si la tabulation est utilisée pour l'indentation, sinon <code>false</code>
	 */
	public boolean isIdentationTabulation() {
		return identationTabulation;
	}

	/**
	 * Modifie la façon d'effectuer l'indentation dans la traduction.
	 *
	 * @param identationTabulation si <code>false</code> l'indentation sera effectuée avec des espaces, sinon des tabulations
	 */
	public void setIdentationTabulation(final boolean identationTabulation) {
		this.identationTabulation = identationTabulation;
	}
}