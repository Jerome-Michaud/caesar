package jscratch.interpreteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import nxtim.instruction.Affectation;
import nxtim.instruction.Condition;
import nxtim.instruction.Expression;
import nxtim.instruction.IElementProgramme;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionIf;
import nxtim.instruction.InstructionIfElse;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.VariableModifiable;
import nxtim.instruction.Moteur;
import jscratch.dictionnaires.DicoVariables;
import nxtim.instruction.InstructionDeclarationAffectation;

/**
 * Constructeur de modèle NXTIM d'un programme NXC.
 * Fonctionne en postfixe uniquement.
 * 
 * @since 1.0
 */
public class MonteurNXTIM implements MonteurProgramme{

	private Pile<IElementProgramme> p;
	private DicoVariables dico;

	/**
	 * Créé un monteur de modèle NXTIM d'un programme NXC.
	 */
	public MonteurNXTIM(){
		p = new Pile<IElementProgramme>();
		dico = DicoVariables.getInstanceInterpreteur();
		/* Ajout des constantes Moteur */
		dico.ajouter(new VariableConstante(TypeVariable.INT, "OUT_A", null));
		dico.ajouter(new VariableConstante(TypeVariable.INT, "OUT_B", null));
		dico.ajouter(new VariableConstante(TypeVariable.INT, "OUT_C", null));
	}
	
	@Override
	public void declaration(String type, String var){
		TypeVariable typeVar = typeConvert(type);
		VariableModifiable vm = null;
		if(!isInteger(var,10))
			vm = new VariableModifiable(typeVar,var,null);
		DicoVariables.getInstanceInterpreteur().ajouter(vm);
		InstructionDeclaration inst = new InstructionDeclaration();
		inst.setMembre(vm);
		p.empile(inst);
	}
	
	@Override
	public void declarationInitialisation(String type, String var) {
		/* Récupération de l'expression d'initialisation */
		Expression exp = (Expression) p.depile();
		/* Création du modèle NXTIM */
		TypeVariable typeVar = typeConvert(type);
		VariableModifiable vm = new VariableModifiable(typeVar,var,null);
		DicoVariables.getInstanceInterpreteur().ajouter(vm);
		InstructionDeclarationAffectation inst = new InstructionDeclarationAffectation();
		inst.setMembre(vm);
		inst.setMembreDroit(exp);
		/* Stockage du résultat */
		p.empile(inst);
	}

	@Override
	public void affectation(){
		/* Récupération des membres de l'affectation */
		IElementProgramme ie = p.depile();
		IElementProgramme ie2 = p.depile();
		/* Si correct, stockage du résultat */
		if(ie instanceof Expression && ie2 instanceof VariableModifiable)
			p.empile(new Affectation((VariableModifiable) ie2, (Expression) ie, true));

	}

	@Override
	public void tache(String nom,int nbIns){

		ArrayList<IElementProgramme> lIE= new ArrayList<IElementProgramme>() ;
		/* Récupération des éléments du corps */
		for(int i = 1; i<= nbIns ; i++)
			lIE.add(p.depile());
		Collections.reverse(lIE);
		/* Création du modèle NXTIM correspondant */
		InstructionTache iTache = new InstructionTache(nom);
		Iterator<IElementProgramme> i = lIE.iterator();
		while(i.hasNext())
			iTache.insererFin((Instruction) i.next());
		/* Stockage du résulat */
		p.empile(iTache);
	}

	@Override
	public void condition(String nom){
		/* Récupération des deux membres de la condition */
		ArrayList<IElementProgramme> lEL = new ArrayList<IElementProgramme>();
		for(int i = 1; i<= 2; i++)
			lEL.add(p.depile());
		Collections.reverse(lEL);
		/* Création du modèle NXTIM correspondant */
		Condition cond = new Condition(convOperateur(nom), (Expression)lEL.get(0), (Expression)lEL.get(1));
		/* Stockage du résultat */
		p.empile(cond);
	}

	@Override
	public void bwhile(int nbArg){
		ArrayList<IElementProgramme> lEL = new ArrayList<IElementProgramme>();
		/* Récupération des éléments du corps */
		for(int i = 1; i<= nbArg; i++)
			lEL.add(p.depile());
		/* Récupération de la condition */
		Condition cond = (Condition) p.depile();
		/* Construction du modèle NXTIM correspondant */
		Collections.reverse(lEL);
		InstructionWhile insWhile = new InstructionWhile(cond);
		for(IElementProgramme ie : lEL)
			insWhile.insererFin((Instruction)ie);
		/* Stocker le résultat */
		p.empile(insWhile);
	}

	@Override
	public void si(int nbArg){
		/* Récupération des éléments du corps */
		ArrayList<IElementProgramme> lEL = new ArrayList<IElementProgramme>();
		for(int i = 1; i<= nbArg; i++)
			lEL.add(p.depile());
		/* Récupération de la condition */
		Condition cond = (Condition) p.depile();
		/* Construction du modèle NXTIM correspondant */
		Collections.reverse(lEL);
		InstructionIf insIf = new InstructionIf(cond);
		for(IElementProgramme ie : lEL)
			insIf.insererFin((Instruction)ie);
		/* Stockage du résultat */
		p.empile(insIf);
	}

	@Override
	public void siSinon(int nbArg1, int nbArg2) {

		ArrayList<IElementProgramme> lELIf = new ArrayList<IElementProgramme>();
		ArrayList<IElementProgramme> lELElse = new ArrayList<IElementProgramme>();
		/* Récupération des membres du else */
		for(int i = 1; i<= nbArg2; i++)
			lELIf.add(p.depile());
		Collections.reverse(lELIf);
		/* Récupération des membres du if */
		for(int i = 1; i<= nbArg1; i++)
			lELElse.add(p.depile());
		Collections.reverse(lELElse);
		/* Récupération de la condition */
		Condition cond = (Condition) p.depile();
		/* Création du modèle NXTIM correspondant */
		InstructionIfElse insIfElse = new InstructionIfElse(cond);
		for(IElementProgramme ie : lELIf)
			insIfElse.insererFinElse((Instruction)ie);
		for(IElementProgramme ie : lELElse)
			insIfElse.insererFinIf((Instruction)ie);
		/* Stokage du résultat */
		p.empile(insIfElse);

	}

	@Override
	public void variable(String var){

		VariableModifiable vm = null;
		boolean trouve = false;
		/* Recherche de la variable dans le dictionnaire de variable */
		for(Variable variable : DicoVariables.getInstanceInterpreteur().getLesVariables()){
			if(variable.getNom().equals(var)){
				/* La variable est dans le dictionnaire de variables */
				p.empile(variable);
				trouve = true;
				break;
			}
		}
		
		if(!trouve) {
			/* La variable n'est pas dans le dictionnaire de variables */
			System.err.println("WARNING : Erreur sémantique : la variable '" + var + "' n'a pas été déclarée ! ");
			/* En créé une sans la mettre dans le dico */
			vm = new VariableModifiable(null, var, null);
				p.empile(vm);
		}
	}

	@Override
	public void constante(String valeur, String type){
		TypeVariable typeVar = typeConvert(type);
		/* Création du modèle NXTIM correspondant et stockage du résultat */
		p.empile( new VariableConstante(typeVar, "", valeur));
	}

	@Override
	public void fonctionAppel(String nom, int nbArg){
		Instruction ins = null;
		Moteur moteur = null;
		ArrayList<IElementProgramme> lEL = new ArrayList<IElementProgramme>();
		/* Récupération des arguments */
		for(int i = 1; i<= nbArg; i++)
			lEL.add(p.depile());
		Collections.reverse(lEL);
		/* Construction du modèle NXTIM correspondant */
		if(nom.equals("OnFwd")){
			moteur = chercheMoteur(((Variable)lEL.get(0)).getNom());
			ins = new InstructionMoteurMov(moteur,(Expression)lEL.get(1));
		}else if(nom.equals("OnRev")){
			moteur = chercheMoteur(((Variable)lEL.get(0)).getNom());
			ins = new InstructionMoteurMov(moteur,(Expression)lEL.get(1),true);
		}else if(nom.equals("Off")){
			moteur = chercheMoteur(((Variable)lEL.get(0)).getNom());
			ins = new InstructionMoteurOff();	
			((InstructionMoteurOff) ins).setMoteur(moteur);
		}else if(nom.equals("Wait")){
			ins = new InstructionAttente();
			((InstructionAttente)ins).setExpression((Expression)lEL.get(0));
		}
		/* Stockage du résulat */
		p.empile(ins);
	}

	private Moteur chercheMoteur(String iElementProgramme){
		if(iElementProgramme.equals("OUT_A"))
			return Moteur.A;
		else if(iElementProgramme.equals("OUT_B"))
			return Moteur.B;
		else
			return Moteur.C;
	}
	
	@Override
	public void operation(String op){
		/* Récupération des 2 memnres de l'opération */
		IElementProgramme ie = p.depile();
		IElementProgramme ie2 = p.depile();
		/* Construction du modèle NXTIM correspondant */
		Operation oper = new Operation(convOperateur(op),(Variable)null,(Variable) null);
		oper.setMembreDroit((Expression)ie);
		oper.setMembreGauche((Expression) ie2);
		/* Stockage du résultat */
		p.empile(oper);
	}

	private Operateur convOperateur(String nom){

		if(nom.equals("+"))
			return Operateur.ADDITION;
		else if (nom.equals("-"))
			return Operateur.SOUSTRACTION;
		else if (nom.equals("*"))
			return Operateur.MULTIPLICATION;
		else if (nom.equals("/"))
			return Operateur.DIVISION;
		else if (nom.equals("<="))
			return Operateur.INFEGAL;
		else if (nom.equals(">="))
			return Operateur.SUPEGAL;
		else if (nom.equals(">"))
			return Operateur.SUPERIEUR;
		else if (nom.equals("<"))
			return Operateur.INFERIEUR;
		else if (nom.equals("OU"))
			return Operateur.OU;
		else if (nom.equals("ET"))
			return Operateur.ET;
		return Operateur.EGALITE;
	}

	private TypeVariable typeConvert(String type){

		if(type.equals("int"))
			return TypeVariable.INT;
		else if(type.equals("float"))
			return TypeVariable.FLOAT;
		else if(type.equals("boolean"))
			return TypeVariable.BOOL;
		else if(type.equals("short"))
			return TypeVariable.SHORT;
		else if(type.equals("long"))
			return TypeVariable.LONG;
		else if(type.equals("list"))
			return TypeVariable.LIST;
		else
			return TypeVariable.STRING;
	}

	public static boolean isInteger(String s, int radix) {

		if(s.isEmpty()) return false;
		for(int i = 0; i < s.length(); i++) {
			if(i == 0 && s.charAt(i) == '-') {
				if(s.length() == 1) return false;
				else continue;
			}
			if(Character.digit(s.charAt(i),radix) < 0) return false;
		}
		return true;
	}

	public IElementProgramme getModele(){
		return (IElementProgramme) p.sommet();
	}

	@Override
	public void reset() {
		p.nettoyer();
	}
}
