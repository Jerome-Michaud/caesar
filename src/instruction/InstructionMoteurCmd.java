package instruction;

import traduction.VisiteurTraduction;

public abstract class InstructionMoteurCmd implements Instruction {

	protected Moteur moteur;

	public InstructionMoteurCmd(Moteur moteur){
		this.moteur = moteur;
	}
	
	public abstract Categorie getCategorie() ;
	
	
	public abstract void accepte(VisiteurTraduction visiteur) ;
	
	public void setMoteur(Moteur moteur){

			this.moteur = moteur;
	}
	public Moteur getMoteur(){
		return moteur;
	}
	
	

}
