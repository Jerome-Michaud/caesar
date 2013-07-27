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
	
	/**
	 * Donne le type de l'expression.
	 * 
	 * @return le type de l'expresssion ou null s'il est inconnu.
	 */
	public TypeElement getType();
	
	/**
	 * Permet de savoir si l'expression est booléenne.
	 * 
	 * @return <code>true</code> si c'est une expression booléenne, <code>false</code> dans le cas contraire.
	 */
	public boolean isBooleenne();
}
