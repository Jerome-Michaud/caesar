package traduction;

import instruction.Affectation;
import instruction.CapteurSlot;
import instruction.Expression;
import instruction.ExpressionComplexe;
import instruction.Instruction;
import instruction.InstructionAttente;
import instruction.InstructionDeclaration;
import instruction.InstructionDeclarationAffectation;
import instruction.InstructionDeclarationCapteur;
import instruction.InstructionDoWhile;
import instruction.InstructionFor;
import instruction.InstructionIf;
import instruction.InstructionIfElse;
import instruction.InstructionMoteurMov;
import instruction.InstructionMoteurOff;
import instruction.InstructionMoteurRotate;
import instruction.InstructionRepeat;
import instruction.InstructionTache;
import instruction.InstructionTempsCourant;
import instruction.InstructionWhile;
import instruction.Moteur;
import instruction.Variable;
import instruction.VariableCapteur;

/**
 * Traducteur d'instructions dans le langage NXC.
 * Cette classe implémente le design pattern Singleton.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public class VisiteurNXC extends VisiteurTraduction {
	
	private static VisiteurNXC instance;
	
	private VisiteurNXC() {
		super();
	}
	
	/**
	 * Donne l'instance unique de VisiteurNXC.
	 * @return l'instance de VisiteurNXC
	 */
	public synchronized static VisiteurNXC getInstance(){
		if (instance==null){
			instance = new VisiteurNXC();
		}
		return instance;
	}
	
	private void ajouterNomMoteur(Moteur m){
		if(m != null) {
			switch (m){
			case A:
				traduction += "OUT_A";
				break;
			case B:
				traduction += "OUT_B";
				break;
			case C:
				traduction += "OUT_C";
				break;
			default:
				break;
			}
		}
	}
	
	private void ajouterNomCapteur(CapteurSlot c){
		switch (c){
		case A:
			traduction += "IN_1";
			break;
		case B:
			traduction += "IN_2";
			break;
		case C:
			traduction += "IN_3";
			break;
		case D:
			traduction += "IN_4";
			break;
		}
	}
	
	
	@Override
	public void visiter(InstructionIf inst) {
		traduction+=indent();
		traduction+="if(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction+="){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}\n";
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		InstructionIf membre = inst.getMembreIf();
		if(membre != null)
			membre.accepte(this);
		// Else
		traduction+=indent();
		traduction+="else{\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfantsElse()){
			is.accepte(this);
		}
		
		nivIndent--;
		
		traduction+=indent()+"}\n";	
	}

	@Override
	public void visiter(InstructionWhile inst) {
		traduction+=indent();
		
		traduction+="while(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction+="){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);		
		}
		
		nivIndent--;
		
		traduction+=indent()+"}\n";
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		traduction+=indent();
		
		traduction+="do{\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()) {
			is.accepte(this);		
		}
		
		nivIndent--;
		
		traduction+=indent()+"} while(";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction+=");\n";
	}
	
	@Override
	public void visiter(InstructionFor inst) {		
		traduction+=indent()+"for (";
		Affectation affec = inst.getIntialization();
		if(affec != null)
			affec.accepte(this);
		traduction+="; ";
		ExpressionComplexe cond = inst.getCondition();
		if(cond != null)
			cond.accepte(this);
		traduction+="; ";
		affec = inst.getIteration();
		if(affec != null)
			affec.accepte(this);
		traduction+=" ){\n";
			
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}\n";	
	}

	@Override
	public void visiter(InstructionTache inst) {		
		traduction+=indent()+"task "+inst.getNom()+"(){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}\n";	
	}

	@Override
	public void visiter(InstructionAttente inst) {
		traduction += indent();
		traduction += "Wait(";
		Expression ex = inst.getExpression();
		if(ex != null)
			ex.accepte(this);
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		traduction += indent();
		
		if (inst.isReverse())
			traduction += "OnRev(";
		else
			traduction += "OnFwd(";
		
		ajouterNomMoteur(inst.getMoteur());
		
		traduction += ", ";
		Expression ex = inst.getExpression();
		if(ex != null)
			ex.accepte(this);
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		traduction += indent();
		traduction += "Off(";
		
		ajouterNomMoteur(inst.getMoteur());
		
		traduction += ");\n";
	}

	@Override
	public void visiter(InstructionTempsCourant inst) {
		traduction += indent();
		traduction += "CurrentTick();\n";
		//TODO CurrentTick(s)?
	}

	@Override
	public void visiter(InstructionRepeat inst) {
		traduction += indent();
		
		traduction += "repeat(";
		Expression ex = inst.getExpression();
		if(ex != null)
			ex.accepte(this);
		traduction += "){\n";
		
		nivIndent++;
		for (Instruction is:inst.getEnfants()){
			is.accepte(this);
		}
		nivIndent--;
		
		traduction+=indent()+"}\n";
	}

	@Override
	public void visiter(Affectation affectation) {
		if(affectation.isInstruction())	
			traduction += indent();
		Expression membre = affectation.getMembreGauche();
		if(membre != null)
			membre.accepte(this);
		traduction += " = ";
		membre = affectation.getMembreDroit();
		if(membre != null)
			membre.accepte(this);
		if(affectation.isInstruction())
			super.traduction += ";\n";
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		traduction += "(";
		Expression membre = expr.getMembreGauche();
		if(membre != null)
			membre.accepte(this);
		traduction += " "+expr.getOperateur()+" ";
		membre = expr.getMembreDroit();
		if(membre != null)
			membre.accepte(this);
		traduction += ")";
	}

	@Override
	public void visiter(Variable variable) {
		if (variable.isConstante()) {
			traduction += variable.getValeur();
		}
		else {
			traduction += variable.getNom();
		}
	}

	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		traduction += indent();
		Variable var = instructionDeclaration.getMembre();
		if(var != null)
		{
			traduction += var.getType()+" ";
			var.accepte(this);
		}
		traduction += ";\n";		
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		traduction += indent();
		Variable var = instructionDeclarationAffectation.getMembre();
		if(var != null)
		{
			traduction += var.getType()+" ";
			var.accepte(this);
		}
		traduction += " = ";
		Expression ex = instructionDeclarationAffectation.getMembreDroit();
		if(ex != null)
			ex.accepte(this);
		traduction += ";\n";	
	}

	@Override
	public void visiter(InstructionDeclarationCapteur instructionDeclarationCapteur) {
		traduction += indent();
		switch (instructionDeclarationCapteur.getCapteur()){
		case TOUCH : traduction+="SetSensorTouch(";
		}
		ajouterNomCapteur(instructionDeclarationCapteur.getCapteurSlot());
		traduction += ");\n";
	}

	@Override
	public void visiter(VariableCapteur variableCapteur) {
		traduction+="Sensor(";
		ajouterNomCapteur(variableCapteur.getCapteurSlot());
		traduction+=")";
		
		
	}

	@Override
	public void visiter(InstructionMoteurRotate instructionMoteurRotate) {
		// TODO Auto-generated method stub
		
	}


}
