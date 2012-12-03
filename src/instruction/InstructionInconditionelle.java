package instruction;

/**
 * Concept abstrait regroupant toutes les instructions possédant un corps contenant d'autres instructions mais ne possédant pas de condition.
 */
public abstract class InstructionInconditionelle extends InstructionStructure {

	@Override
	public abstract Categorie getCategorie();
}
