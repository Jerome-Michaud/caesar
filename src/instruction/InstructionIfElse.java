package instruction;

import java.util.List;

import traduction.VisiteurTraduction;
/**
 * Instruction conditionnelle if-else.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class InstructionIfElse extends InstructionConditionelle {

	private InstructionIf membreIf;
	
	/**
	 * Crée une instruction if-else non initialisée.
	 * Ses membres ont pour valeur null.
	 */
	public InstructionIfElse() {
		this(null);
	}
	
	/**
	 * Crée une instruction if-else.
	 * @param cond la condition du if
	 */
	public InstructionIfElse(Condition cond) {
		super(null);
		membreIf = new InstructionIf(cond);
	}
	
	/**
	 * Accède à la condition du if.
	 * @return la condition.
	 */
	public Condition getCondition() {
		return getMembreIf().getCondition();
	}

	/**
	 * Modifie la condition du if.
	 * @param cond la condition
	 */
	public void setCondition(Condition cond) {
		getMembreIf().setCondition(cond);
	}

	/**
	 * Accède à la partie if du if-else.
	 * @return l'instruction if utilisée.
	 */
	public InstructionIf getMembreIf() {
		return membreIf;
	}
	
	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererIf(int position, Instruction inst){
		membreIf.inserer(position,inst);
	}
	
	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererDebutIf(Instruction inst){
		membreIf.insererDebut(inst);
	}
	
	/**
	 * Insère une instruction dans le corps de if.
	 */
	public void insererFinIf(Instruction inst){
		membreIf.insererFin(inst);
	}
	
	/**
	 * Insère une liste des instructions dans le corps de if.
	 */
	public void insererIf(int position, List<Instruction> instListe){
		membreIf.inserer(position, instListe);
	}
	
	/**
	 * Insère une liste des instructions dans le corps de if.
	 */
	public void insererDebutIf(List<Instruction> instListe){
		membreIf.insererDebut(instListe);
	}
	
	/**
	 * Insère une liste des instructions dans le corps de if.
	 */
	public void insererFinIf(List<Instruction> instListe){
		membreIf.insererFin(instListe);
	}
	
	/**
	 * Donne les instructions du corps de if.
	 * @return la list des instructions du corps de if.
	 */
	public List<Instruction> getEnfantsIf() {
		return membreIf.getEnfants();
	}
	
	/**
	 * Insère une instruction dans le else à une position donnée.
	 * @param position la position où insérer
	 * @param inst l'instruction à insérer
	 */
	public void insererElse(int position, Instruction inst){
		super.inserer(position,inst);
	}
	
	/**
	 * Insère une instruction au début du else.
	 * @param inst l'instruction à insérer
	 */
	public void insererDebutElse(Instruction inst){
		super.insererDebut(inst);
	}
	
	/**
	 * Insère une instruction à la fin du else.
	 * @param inst l'instruction à insérer
	 */
	public void insererFinElse(Instruction inst){
		super.insererFin(inst);
	}
	
	/**
	 * Insère des instructions dans le else à une position donnée.
	 * @param position la position où inserer
	 * @param instListe la liste des instruction à insérer
	 */
	public void insererElse(int position, List<Instruction> instListe){
		super.inserer(position,instListe);
	}
	
	/**
	 * Insère des instructions au début du else.
	 * @param instListe la liste des instruction à insérer
	 */
	public void insererDebutElse(List<Instruction> instListe){
		super.insererDebut(instListe);
	}
	
	/**
	 * Insère des instructions à la fin du else.
	 * @param instListe la liste des instruction à insérer
	 */
	public void insererFinElse(List<Instruction> instListe){
		super.insererFin(instListe);
	}
	
	/**
	 * Accède à la liste des instructions contenue dans le else.
	 * @return la liste des instructions.
	 */
	public List<Instruction> getEnfantsElse() {
		return getEnfants();
	}	
	
	@Override
	public String toString(){
		String res = "";
		res+= getMembreIf().toString();
		res+= "\telse\n{";
		for (Instruction is : getEnfantsElse()){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}
	
	/**
	 * TODO changer
	 * Donne la liste des instructions du corps du if à partir d'une certaine position.
	 * @param pos la position de départ
	 * @return la liste des enfants du if à partir d'un rang précis.
	 */
	public List<Instruction> getEnfantsIf(int pos) {
		return membreIf.getEnfants(pos);
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps  du membre IF.
	 * @return la liste des enfants du membre IF
	 */
	public List<Instruction> removeEnfantsIf() {
		return membreIf.removeEnfants();
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps
	 *  du membre IF à partir d'un certain rang.
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre IF à partir d'un rang precis
	 */
	public List<Instruction> removeEnfantsIf(int pos) {
		return membreIf.removeEnfants(pos);
	}
	
	/**
	 * TODO changer
	 * Donne la liste des instructions du corps du membre ELSE à partir d'une certaine position.
	 * @param pos la position de départ.
	 * @return la liste des enfants du membre ELSE a partir de rang precise
	 */
	public List<Instruction> getEnfantsElse(int pos) {
		return super.getEnfants(pos);
	}
	
	/**
	 * Supprime toutes les instructions du corps du membre ELSE.
	 * @return la liste des enfants du membre ELSE
	 */

	public List<Instruction> removeEnfantsElse() {
		return super.removeEnfants();
	}
	
	/**
	 * TODO changer
	 * Supprime toutes les instructions du corps
	 * du membre ELSE à partir d'un certain rang.
	 * @param pos le rang de départ
	 * @return la liste des enfants du membre ELSE à partir d'un rang précis.
	 */
	public List<Instruction> removeEnfantsElse(int pos) {
		return super.removeEnfants(pos);
	}
}
