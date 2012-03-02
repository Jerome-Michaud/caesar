package instruction;

import traduction.VisiteurTraduction;

public abstract class InstructionMoteurCmd extends InstructionTerminale{

	protected Moteur moteur;

	public abstract Categorie getCategorie() ;
	
	
	public abstract void accepte(VisiteurTraduction visiteur) ;
	
	public void setMoteur(Moteur moteur){

			this.moteur = moteur;
	}
	
	

}
