package instruction;

import java.util.List;

/**
 * Instruction conditionnelle if-else.
 */
public class InstructionIfElse extends InstructionConditionelle {

	/**
	 * L'instruction if utilisée.
	 */
	private InstructionIf membreIf;

	/**
	 * Crée une instruction if-else non initialisée.<br/>
	 * Ses membres ont pour valeur
	 * <code>null</code>.
	 */
	public InstructionIfElse() {
		this(null);
	}

	/**
	 * Crée une instruction if-else.
	 *
	 * @param cond la condition du if
	 */
	public InstructionIfElse(final Condition cond) {
		super(null);
		membreIf = new InstructionIf(cond);
	}

	@Override
	public Condition getCondition() {
		return getMembreIf().getCondition();
	}

	@Override
	public void setCondition(final Condition cond) {
		getMembreIf().setCondition(cond);
	}

	/**
	 * Accède à la partie if du if-else.
	 *
	 * @return l'instruction if utilisée.
	 */
	public InstructionIf getMembreIf() {
		return membreIf;
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Insère une instruction dans le corps de if.
	 *
	 * @param position la position où insérer
	 * @param inst l'instruction à insérer
	 */
	public void insererIf(final int position, final Instruction inst) {
		membreIf.inserer(position, inst);
	}

	/**
	 * Insère une instruction dans le corps de if.
	 *
	 * @param inst l'instruction à insérer
	 */
	public void insererDebutIf(final Instruction inst) {
		membreIf.insererDebut(inst);
	}

	/**
	 * Insère une instruction dans le corps de if.
	 *
	 * @param inst l'instruction à insérer à la fin du IF
	 */
	public void insererFinIf(final Instruction inst) {
		membreIf.insererFin(inst);
	}

	/**
	 * Insère une liste des instructions dans le corps de if.
	 *
	 * @param position la position où insérer les instructions
	 * @param instListe la liste des instructions à insérer
	 */
	public void insererIf(final int position, final List<Instruction> instListe) {
		membreIf.inserer(position, instListe);
	}

	/**
	 * Insère une liste des instructions dans le corps de if.
	 *
	 * @param instListe la liste des instructions à insérer à au début du IF
	 */
	public void insererDebutIf(final List<Instruction> instListe) {
		membreIf.insererDebut(instListe);
	}

	/**
	 * Insère une liste des instructions dans le corps de if.
	 *
	 * @param instListe la liste des instructions à insérer à la fin du IF
	 */
	public void insererFinIf(final List<Instruction> instListe) {
		membreIf.insererFin(instListe);
	}

	/**
	 * Donne les instructions du corps de if.
	 *
	 * @return la liste des instructions du corps de if.
	 */
	public List<Instruction> getEnfantsIf() {
		return membreIf.getEnfants();
	}

	/**
	 * Insère une instruction dans le else à une position donnée.
	 *
	 * @param position la position où insérer
	 * @param inst l'instruction à insérer
	 */
	public void insererElse(final int position, final Instruction inst) {
		super.inserer(position, inst);
	}

	/**
	 * Insère une instruction au début du else.
	 *
	 * @param inst l'instruction à insérer
	 */
	public void insererDebutElse(final Instruction inst) {
		super.insererDebut(inst);
	}

	/**
	 * Insère une instruction à la fin du else.
	 *
	 * @param inst l'instruction à insérer à la fin du ELSE
	 */
	public void insererFinElse(final Instruction inst) {
		super.insererFin(inst);
	}

	/**
	 * Insère des instructions dans le else à une position donnée.
	 *
	 * @param position la position où insérer
	 * @param instListe la liste des instruction à insérer dans le ELSE
	 */
	public void insererElse(final int position, final List<Instruction> instListe) {
		super.inserer(position, instListe);
	}

	/**
	 * Insère des instructions au début du else.
	 *
	 * @param instListe la liste des instruction à insérer au début du ELSE
	 */
	public void insererDebutElse(final List<Instruction> instListe) {
		super.insererDebut(instListe);
	}

	/**
	 * Insère des instructions à la fin du else.
	 *
	 * @param instListe la liste des instruction à insérer à la fin du ELSE
	 */
	public void insererFinElse(final List<Instruction> instListe) {
		super.insererFin(instListe);
	}

	/**
	 * Accède à la liste des instructions contenue dans le else.
	 *
	 * @return la liste des instructions du ELSE
	 */
	public List<Instruction> getEnfantsElse() {
		return getEnfants();
	}

	@Override
	public String toString() {
		String res = "";
		res += getMembreIf().toString();
		res += "\telse\n{";
		for (Instruction is : getEnfantsElse()) {
			res += "\t" + is + ";\n";
		}
		res += "\t}\n";
		return res;
	}

	/**
	 * TODO changer
	 * Donne la liste des instructions du corps du if à partir d'une certaine position.
	 *
	 * @param pos la position de départ
	 * @return la liste des enfants du if à partir d'un rang précis.
	 */
	public List<Instruction> getEnfantsIf(final int pos) {
		return membreIf.getEnfants(pos);
	}

	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps du membre IF.
	 *
	 * @return la liste des enfants du membre IF
	 */
	public List<Instruction> removeEnfantsIf() {
		return membreIf.removeEnfants();
	}

	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps
	 * du membre IF à partir d'un certain rang.
	 *
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre IF à partir d'un rang precis
	 */
	public List<Instruction> removeEnfantsIf(final int pos) {
		return membreIf.removeEnfants(pos);
	}

	/**
	 * TODO changer
	 * Donne la liste des instructions du corps du membre ELSE à partir d'une certaine position.
	 *
	 * @param pos la position de départ.
	 * @return la liste des enfants du membre ELSE a partir de rang précise
	 */
	public List<Instruction> getEnfantsElse(final int pos) {
		return super.getEnfants(pos);
	}

	/**
	 * Supprime toutes les instructions du corps du membre ELSE.
	 *
	 * @return la liste des enfants du membre ELSE
	 */
	public List<Instruction> removeEnfantsElse() {
		return super.removeEnfants();
	}

	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps du membre ELSE à partir d'un certain rang.
	 *
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre ELSE à partir d'un rang précis.
	 */
	public List<Instruction> removeEnfantsElse(final int pos) {
		return super.removeEnfants(pos);
	}
}