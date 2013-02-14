package nxtim.instruction;

/**
 * Tâche pour un programme d'un robot NXT.
 */
public class InstructionTache extends InstructionInconditionelle {

	/**
	 * Le nom de la variable.
	 */
	private String nom;

	/**
	 * Crée une tâche qui aura pour nom : "main".
	 */
	public InstructionTache() {
		this.nom = "main";
	}

	/**
	 * Crée une tâche.
	 *
	 * @param nom le nom de la tâche
	 */
	public InstructionTache(final String nom) {
		this.nom = nom;
	}

	/**
	 * Accède au nom de la tâche.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom de la tâche.
	 *
	 * @param nom le nouveau nom
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.STRUCTURES;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	@Override
	public String toString() {
		String res = "";
		res += nom + "(){\n";
		for (Instruction is : getEnfants()) {
			res += "\t" + is + ";\n";
		}
		res += "}";
		return res;
	}
}