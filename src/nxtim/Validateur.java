package nxtim;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import nxtim.instruction.Affectation;
import nxtim.instruction.Expression;
import nxtim.instruction.ExpressionComplexe;
import nxtim.instruction.IElementProgramme;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionConfigCapteurs;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionDeclarationAffectation;
import nxtim.instruction.InstructionDeclarationCapteur;
import nxtim.instruction.InstructionDoWhile;
import nxtim.instruction.InstructionFor;
import nxtim.instruction.InstructionIf;
import nxtim.instruction.InstructionIfElse;
import nxtim.instruction.InstructionIncrementation;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionMoteurRotate;
import nxtim.instruction.InstructionRAZRotationMoteur;
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.NonLogique;
import nxtim.instruction.RotationMoteur;
import nxtim.instruction.TempsCourant;
import nxtim.instruction.ValeurCapteur;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableCapteur;
import nxtim.instruction.VisiteurElementProg;

/**
 * Cette classe permet de valider un élément NXTIM et ses fils.
 * 
 * @since 1.0
 */
public class Validateur implements VisiteurElementProg {

	private List<String> erreurs;
	
	/**
	 * Effectue une validation.
	 * 
	 * @param iElemRoot l'élément racine.
	 * 
	 * @return <code>true</code> si l'élément racine et ses fils sont valide, <code>false</code> si un élément est incorrect.
	 */
	public static boolean valider(final IElementProgramme iElemRoot) {
		final Validateur validateur = new Validateur();
		iElemRoot.accepte(validateur);
		return validateur.erreurs.isEmpty();
	}
	
	/**
	 * Crée et initialise un validateur.
	 */
	public Validateur() {
		super();
		erreurs = new LinkedList<String>();
	}
	
	/**
	 * Réinitialise le validateur.
	 */
	public void reset() {
		erreurs.clear();
	}
	
	/**
	 * Indique si les validations effectuées depuis la dernière initialisation
	 * ont réussi.
	 * 
	 * @return true s'il n'y a pas eu d'erreur de validation
	 */
	public boolean valide() {
		return erreurs.isEmpty();
	}
	
	/**
	 * Donne un itérateur sur les erreurs.
	 * 
	 * @return l'itérateur.
	 */
	public Iterator<String> getIteratorErreurs() {
		return erreurs.iterator();
	}
	
	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		if(instructionDeclaration.getMembre() == null) {
			erreurs.add("Manque la variable dans une déclaration.");
		}
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		if(instructionDeclarationAffectation.getMembre() == null) {
			erreurs.add("Manque la variable dans une déclaration.");
		}
		if(instructionDeclarationAffectation.getMembreDroit() == null) {
			erreurs.add("Manque l'expression d'initialisation dans une déclaration.");
		}
		else {
			instructionDeclarationAffectation.getMembreDroit().accepte(this);
		}
	}

	@Override
	public void visiter(InstructionIf instructionIf) {
		if(instructionIf.getCondition() == null) {
			erreurs.add("Manque la condition d'un Si.");
		}
		else {
			instructionIf.accepte(this);
		}
		for(Instruction ins : instructionIf.getEnfants()) {
			ins.accepte(this);
		}
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		inst.getMembreIf().accepte(this);
		for (Instruction is : inst.getEnfantsElse()) {
			is.accepte(this);
		}
	}

	@Override
	public void visiter(InstructionWhile inst) {
		Expression cond = inst.getCondition();
		if(cond == null) {
			erreurs.add("Manque la condition d'un Tant Que.");
		}
		else {
			cond.accepte(this);
		}
		for(Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		Expression cond = inst.getCondition();
		if(cond == null) {
			erreurs.add("Manque la condition d'un Faire-Tant Que.");
		}
		else {
			cond.accepte(this);
		}
		for(Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
	}

	@Override
	public void visiter(InstructionTache inst) {
		assert inst.getNom() != null;
		if(inst.getNom().isEmpty()) {
			erreurs.add("Une tâche n'est pas nommée.");
		}
		for(Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
	}

	@Override
	public void visiter(TempsCourant exp) {}

	@Override
	public void visiter(InstructionAttente inst) {
		if(inst.getExpression() == null) {
			erreurs.add("Manque une valeur d'attente pour une instruction d'attente.");
		}
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		if(inst.getExpression() == null) {
			erreurs.add("Manque une valeur pour une instruction de mouvement de moteur.");
		}
		else {
			inst.getExpression().accepte(this);
		}
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {}

	@Override
	public void visiter(InstructionFor instructionFor) {
		Expression exp = instructionFor.getCondition();
		if(exp == null) {
			erreurs.add("Manque la condition dans une boucle for.");
		}
		else {
			exp.accepte(this);
		}
	}

	@Override
	public void visiter(InstructionRepeat instructionRepeat) {
		Expression exp = instructionRepeat.getExpression();
		if(exp == null) {
			erreurs.add("Manque le nombre de répétition dans un Répéter.");
		}
		else {
			exp.accepte(this);
		}
	}

	@Override
	public void visiter(Variable variable) {}

	@Override
	public void visiter(Affectation affectation) {
		if(affectation.getMembreGauche() == null) {
			erreurs.add("Manque la variable dans une affectation.");
		}
		if(affectation.getMembreDroit() == null) {
			erreurs.add("Manque l'expression de la valeur dans une affectation.");
		}
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		if(expr.getMembreGauche() == null) {
			erreurs.add("Manque le membre gauche pour un opérateur binaire.");
		}
		if(expr.getMembreDroit() == null) {
			erreurs.add("Manque le membre droit pour un opérateur binaire.");
		}

	}

	@Override
	public void visiter(NonLogique nonLog) {
		if(nonLog.getCondition() == null) {
			erreurs.add("Manque la condition dans un non logique.");
		}
	}

	@Override
	public void visiter(InstructionDeclarationCapteur inst) {}

	@Override
	public void visiter(VariableCapteur variableCapteur) {}

	@Override
	public void visiter(InstructionMoteurRotate instructionMoteurRotate) {
		if(instructionMoteurRotate.getExpression() == null) {
			erreurs.add("Manque la valeur de la rotation pour une instruction de rotation de moteur.");
		}

	}

	@Override
	public void visiter(InstructionIncrementation instructionIncrementation) {
		if(instructionIncrementation.getVariable() == null) {
			erreurs.add("Manque la variable d'une incrementation.");
		}
	}

	@Override
	public void visiter(ValeurCapteur valCapteur) {}

	@Override
	public void visiter(RotationMoteur rotMoteur) {}

	@Override
	public void visiter(InstructionRAZRotationMoteur razMoteur) {}

	@Override
	public void visiter(InstructionConfigCapteurs confCapt) {}

}
