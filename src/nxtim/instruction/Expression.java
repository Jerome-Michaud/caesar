package nxtim.instruction;

/**
 * Une expression est un morceau de code d'un programme qui donne une valeur et qui n'est pas nécessairement une instruction.
 * <ul>
 * <li>opération</li>
 * <li>condition</li>
 * <li>variable</li>
 * </ul>
 */
public interface Expression extends IElementProgramme {

	/**
	 * Donne la catégorie de l'expression.
	 *
	 * @return la catégorie
	 */
	@Override
	public Categorie getCategorie();
}
