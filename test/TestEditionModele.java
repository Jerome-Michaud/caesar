import java.util.List;

import instruction.Affectation;
import instruction.Condition;
import instruction.Instruction;
import instruction.InstructionAttente;
import instruction.InstructionDeclaration;
import instruction.InstructionIfElse;
import instruction.InstructionMoteurMov;
import instruction.InstructionMoteurOff;
import instruction.InstructionStructure;
import instruction.InstructionTache;
import instruction.InstructionWhile;
import instruction.Moteur;
import instruction.Operateur;
import instruction.TypeVariable;
import instruction.VariableConstante;
import instruction.VariableModifiable;
import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;

public class TestEditionModele {
	
	static InstructionStructure i1;
	static InstructionDeclaration i2;
	static Affectation i3;
	static InstructionMoteurMov i4;
	static InstructionAttente i5;
	static InstructionMoteurMov i6;
	static InstructionAttente i7;
	static InstructionMoteurOff i8;
	static InstructionWhile i9;
	static InstructionAttente i10;
	static InstructionIfElse i11;
	static InstructionMoteurMov i12;
	static Affectation i13;
	static InstructionMoteurMov i14;
	static Affectation i15;
	
	private static void init() throws Exception{

		//task main()
		i1 = new InstructionTache();
		
		// int i ;
		i2 = new InstructionDeclaration () ;
		i1.insererFin(i2);
		
		VariableModifiable i = new VariableModifiable(TypeVariable.INT,"i","");
		i2.setMembre(i);
		
		// i = 1 ;
		i3 = new Affectation(true);
		i1.insererFin(i3);
		i3.setMembreGauche(i);
		i3.setMembreDroit(new VariableConstante(TypeVariable.INT,"","1"));
		
		// OnFwd(OUT_A, 75);
		
		i4 = new InstructionMoteurMov();
		i1.insererFin(i4);
		i4.setMoteur(Moteur.A);
		i4.setExpression(new VariableConstante(TypeVariable.INT,"","75"));
		
		
		// Wait(800);
		i5 = new InstructionAttente();
		i1.insererFin(i5);
		i5.setExpression(new VariableConstante(TypeVariable.INT,"","800"));
		
		// OnRev(OUT_A, 75);
		
		i6 = new InstructionMoteurMov();
		i1.insererFin(i6);
		i6.setMoteur(Moteur.A);
		i6.setExpression(new VariableConstante(TypeVariable.INT,"","75"));
		i6.setReverse(true);
		
		// Wait(360);
		
		i7 = new InstructionAttente();
		i1.insererFin(i7);
		i7.setExpression(new VariableConstante(TypeVariable.INT,"","360"));
		
		// Off(OUT_A);
		
		i8 = new InstructionMoteurOff();
		i1.insererFin(i8);
		i8.setMoteur(Moteur.A);
		
		
		
		// while(i < 3)
		
		
		
		i9 = new InstructionWhile();
		i1.insererFin(i9);
		Condition condsup ;
		i9.setCondition(condsup = new Condition(Operateur.INFERIEUR));
		condsup.setMembreGauche(i);
		condsup.setMembreDroit(new VariableConstante(TypeVariable.INT,"","3"));
		
		
		
		
		//{
			
			//Wait(100);
			i10 = new InstructionAttente();
			i9.insererFin(i10);
			i10.setExpression(new VariableConstante(TypeVariable.INT,"","100"));
			
			//if ( i == 1 )
			i11 = new InstructionIfElse();
			i9.insererFin(i11);
			Condition condegal ;
			i11.setCondition(condegal = new Condition(Operateur.EGALITE));
			condegal.setMembreGauche(i);
			condegal.setMembreDroit(new VariableConstante(TypeVariable.INT,"","1"));
			
			
			//{
				//OnFwd(OUT_A, 75);
				i12 = new InstructionMoteurMov();
				i11.insererFinIf(i12);
				i12.setMoteur(Moteur.A);
				i12.setExpression(new VariableConstante(TypeVariable.INT,"","75"));
			
				
				//i = 2 ;
				i13 = new Affectation(true);
				
				i11.insererFinIf(i13);
				i13.setMembreGauche(i);
				i13.setMembreDroit(new VariableConstante(TypeVariable.INT,"","2"));
				
			//}
			//else
			//{
				
				//OnRev(OUT_A, 75);
				i14 = new InstructionMoteurMov();
				i11.insererFinElse(i14);
				i14.setMoteur(Moteur.A);
				i14.setExpression(new VariableConstante(TypeVariable.INT,"","75"));
				i14.setReverse(true);
				
				
				
				//i = 1 ;
				i15 = new Affectation(true);
				i11.insererFinElse(i15);
				i15.setMembreGauche(i);
				i15.setMembreDroit(new VariableConstante(TypeVariable.INT,"","1"));
			//}	


		//}
	}
	
	public static void genererCode(){
		VisiteurTraduction trad;
		trad = VisiteurNXC.getInstance();
		trad.setIdentationTabulation(false);
		trad.reset();
		trad.visiter((InstructionTache) i1);
		System.out.println(trad.getTraduction());
	}
	
	public static void main (String[] args) throws Exception{

		//////////////////////////////////////////////////////////		
		//Application des changements differentes a la programme//
		//////////////////////////////////////////////////////////		
			
		System.out.println("Programme complete:");
		init();
		genererCode();
		System.out.println();
		
		//////////////////////////////////////////////////////////
		System.out.println("Ajout/suppression debut/milieu:");
		init();
		i9.removeEnfants();
		i9.removeEnfants();
		List<Instruction> l = i1.removeEnfants(7);

		i1.insererFin(l);
		i1.insererDebut(l);
		
		l = i1.removeEnfants(7);
		i1.inserer(InstructionStructure.POSITION_DEBUT_CODE,l);
		l = i1.removeEnfants(7);
		i1.inserer(InstructionStructure.POSITION_FIN_CODE,l);
		
		l = i1.removeEnfants(7);
		i1.inserer(1,l);

		genererCode();
		System.out.println();
		
		
		//////////////////////////////////////////////////////////
		System.out.println("Ajout/suppression dans if:");
		init();
		
		l = i11.removeEnfantsIf(1);
		i11.insererDebutIf(l);
		
		l = i11.removeEnfantsIf(1);
		i11.insererIf(InstructionStructure.POSITION_DEBUT_CODE,l);
		l = i11.removeEnfantsIf(1);
		i11.insererIf(InstructionStructure.POSITION_FIN_CODE,l);
		
		l = i11.removeEnfantsIf(1);
		i11.insererIf(1,l);

		i11.insererIf(InstructionStructure.POSITION_DEBUT_CODE, i2);
		i11.insererIf(InstructionStructure.POSITION_FIN_CODE, i2);
		genererCode();
		System.out.println();
		
		
		//////////////////////////////////////////////////////////
		
		System.out.println("Ajout/suppression dans else:");
		init();
		l = i11.removeEnfantsElse();
		i11.insererFinElse(l);
		l = i11.removeEnfantsElse();
		i11.insererDebutElse(l);
		
		l = i11.removeEnfantsElse(0);
		i11.insererElse(InstructionStructure.POSITION_DEBUT_CODE,l);
		l = i11.removeEnfantsElse(1);
		i11.insererElse(InstructionStructure.POSITION_FIN_CODE,l);
		
		l = i11.removeEnfantsElse();
		
		genererCode();
		System.out.println();
		
		
		//////////////////////////////////////////////////////////
	}	
}


/*
 * 
 * task main()
{
	
int i ;
i = 1 ;
	
	
OnFwd(OUT_A, 75);
Wait(800);
OnRev(OUT_A, 75);
Wait(360);
Off(OUT_A);

 while(i > 3)
{
	
	Wait(100);
	
	if ( i == 1 )
	{
		OnFwd(OUT_A, 75);
		i = 2 ;
	}
	else
	{
		OnRev(OUT_A, 75);
		i = 1 ;
	}	





}

 */