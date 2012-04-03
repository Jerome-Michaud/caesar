package instruction;

import traduction.VisiteurTraduction;
/**
 * Concept abstrait regroupant toutes les instructions
 * possèdant un corps contenant d'autres instructions mais
 * ne possèdant pas de condition.
 * @author Adrien DUROY, Bastien AUBRY
 */
public abstract class InstructionInconditionelle extends InstructionStructure {

	@Override
	public abstract Categorie getCategorie();

	@Override
	public abstract void accepte(VisiteurTraduction visiteur);
	
}
