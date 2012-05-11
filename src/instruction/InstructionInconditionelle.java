package instruction;

import traduction.VisiteurTraduction;

/**
 * Concept abstrait regroupant toutes les instructions possédant un corps contenant d'autres instructions mais ne possédant pas de condition.
 */
public abstract class InstructionInconditionelle extends InstructionStructure {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public abstract void accepte(VisiteurTraduction visiteur);
}
