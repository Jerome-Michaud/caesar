package nxtim.instruction;

/**
 * Instruction donnant le temps écoulé depuis le lancement du programme.
 *
 * @author Adrien DUROY
 */
public class TempsCourant implements Expression {

	/**
	 * Créé une instruction donnant le temps courant sans variable pour recevoir le temps.
	 */
	public TempsCourant() {
		super();
	}


	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}