package nxtim.instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Concept abstrait regroupant toutes les instructions composées d'un corps contenant d'autres instruction.<br/>
 * Utilisation du design pattern Composite.
 */
public abstract class InstructionStructure implements Instruction {

	/**
	 * La constante pour définir le début du code.
	 */
	public static final int POSITION_DEBUT_CODE = 0;
	/**
	 * La constante pour définir la fin du code.
	 */
	public static final int POSITION_FIN_CODE = Integer.MAX_VALUE;
	/**
	 * La liste des enfants de la structure.
	 */
	private List<Instruction> enfants;

	/**
	 * Crée une instruction "structure" vide.
	 */
	public InstructionStructure() {
		enfants = new ArrayList<Instruction>();
	}

	/**
	 * Crée une instruction "structure" avec des instruction dans le corps.
	 *
	 * @param enfants la liste des instructions du corps
	 */
	public InstructionStructure(final List<Instruction> enfants) {
		this.enfants = enfants;
	}

	/**
	 * Ajoute une instruction dans le corps.
	 *
	 * @param position la position où insérer l'instruction
	 * @param inst l'instruction à insérer
	 */
	public void inserer(final int position, final Instruction inst) {
		if (position == POSITION_FIN_CODE) {
			insererFin(inst);
		} else {
			enfants.add(position, inst);
		}
	}

	/**
	 * Ajoute une instruction au début du corps.
	 *
	 * @param inst l'instruction à insérer au début du corps
	 */
	public void insererDebut(final Instruction inst) {
		enfants.add(POSITION_DEBUT_CODE, inst);
	}

	/**
	 * Ajoute une instruction à la fin du corps.
	 *
	 * @param inst l'instruction à insérer à la fin du corps
	 */
	public void insererFin(final Instruction inst) {
		enfants.add(inst);
	}

	/**
	 * Ajoute plusieurs instructions dans le corps.
	 *
	 * @param position la position où insérer les instructions
	 * @param instListe la liste des instructions à insérer
	 */
	public void inserer(final int position, final List<Instruction> instListe) {
		if (position == POSITION_FIN_CODE) {
			enfants.addAll(instListe);
		} else {
			enfants.addAll(position, instListe);
		}
	}

	/**
	 * Ajoute plusieurs instructions au début du corps.
	 *
	 * @param instListe les instructions à insérer au début du corps
	 */
	public void insererDebut(final List<Instruction> instListe) {
		enfants.addAll(POSITION_DEBUT_CODE, instListe);
	}

	/**
	 * Ajoute plusieurs instructions à la fin du corps.
	 *
	 * @param instListe les instructions à insérer à la fin du corps
	 */
	public void insererFin(final List<Instruction> instListe) {
		enfants.addAll(instListe);
	}

	/**
	 * Donne la liste des instructions du corps de l'instruction.
	 *
	 * @return la liste des instructions de l'instruction
	 */
	public List<Instruction> getEnfants() {
		return enfants;
	}

	/**
	 * Donne la liste des instructions du corps de l'instruction à partir d'une certaine position.
	 *
	 * @param pos la position de départ
	 * @return la liste des instructions concernées
	 */
	public List<Instruction> getEnfants(final int pos) {
		return new ArrayList<Instruction>(enfants.subList(pos, enfants.size()));
	}

	/**
	 * Supprime toutes les instructions du corps de l'instruction.
	 *
	 * @return la liste des enfants supprimés
	 */
	public List<Instruction> removeEnfants() {
		return removeEnfants(0);
	}

	/**
	 * Supprime toutes les instructions du corps de l'instruction à partir d'un certain rang.
	 *
	 * @param pos le rang de départ
	 * @return la liste des enfants supprimés
	 */
	public List<Instruction> removeEnfants(final int pos) {
		List<Instruction> res = getEnfants(pos);
		enfants.removeAll(res);
		return res;
	}
}