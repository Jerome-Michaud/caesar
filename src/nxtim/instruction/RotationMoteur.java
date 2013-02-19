package nxtim.instruction;

/**
 * Expression donnant le nombre de rotation d'un moteur.
 * 
 * @author Adrien DUROY
 */
public class RotationMoteur implements Expression {
	private Moteur moteur;
	
	/**
	 * Créé une expression donnat le nombre de rotations du moteur A.
	 */
	public RotationMoteur() {
		this(Moteur.A);
	}
	
	/**
	 * Créé une expression donnant le nombre de rotations d'un moteur.
	 * 
	 * @param m le moteur dont on souhaite connaître le nombre de rotation.
	 */
	public RotationMoteur(Moteur m) {
		moteur = m;
	}
	
	/**
	 * Donne le moteur associée à l'expression.
	 * 
	 * @return le moteur. 
	 */
	public Moteur getMoteur() {
		return moteur;
	}
	
	/**
	 * Modifie le moteur sur lequel récupéré le nombre de rotation.
	 * 
	 * @param m le nouveau moteur.
	 */
	public void setMoteur(Moteur m) {
		moteur = m;
	}
	
	@Override
	public Categorie getCategorie() {
		return Categorie.MOTEURS;
	}

	@Override
	public void accepte(VisiteurElementProg v) {
		v.visiter(this);
	}
	
}
