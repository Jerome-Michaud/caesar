/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko

ad.duroy@gmail.com

Ce fichier est une partie de NXTIM.

NXTIM est une bibliothèque logiciel fournissant un modèle objet du code d'un programme
pour un robot NXT. 

NXTIM est régi par la licence CeCILL-C soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL-C telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL-C, et que vous en avez accepté les
termes.
 */
package nxtim.instruction;

/**
 * Interface permettant de visiter les instructions et les expressions.
 */
public interface VisiteurElementProg {

	/**
	 * Visite une instruction Declaration.
	 *
	 * @param instructionDeclaration l'instruction à visiter
	 */
	public void visiter(InstructionDeclaration instructionDeclaration);

	/**
	 * Visite une instruction Declaration Affectation.
	 *
	 * @param instructionDeclarationAffectation l'instruction à visiter
	 */
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation);

	/**
	 * Visite une instruction if.
	 *
	 * @param instructionIf l'instruction à visiter
	 */
	public void visiter(InstructionIf instructionIf);

	/**
	 * Visite une instruction ifelse.
	 *
	 * @param inst l'instruction à visiter
	 */
	public abstract void visiter(InstructionIfElse inst);

	/**
	 * Visite une instruction while.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionWhile inst);

	/**
	 * Visite une instruction dowhile.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionDoWhile inst);

	/**
	 * Visite une tâche.
	 *
	 * @param inst l'instruction tâche.
	 */
	public void visiter(InstructionTache inst);

	/**
	 * Visite une instruction obtenant le temps courant.
	 *
	 * @param exp l'instruction à visiter
	 */
	public void visiter(TempsCourant exp);

	/**
	 * Visite une instruction d'attente.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionAttente inst);

	/**
	 * Visite une instruction de mouvement de moteur.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionMoteurMov inst);

	/**
	 * Visite une instruction d'arrêt de moteur.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionMoteurOff inst);

	/**
	 * Visite une instruction for.
	 *
	 * @param instructionFor l'instruction à visiter
	 */
	public void visiter(InstructionFor instructionFor);

	/**
	 * Visite une instruction de répétition.
	 *
	 * @param instructionRepeat l'instruction à visiter
	 */
	public void visiter(InstructionRepeat instructionRepeat);

	/**
	 * Visite une variable.
	 *
	 * @param variable la variable à visiter
	 */
	public void visiter(Variable variable);

	/**
	 * Visite une affectation.
	 *
	 * @param affectation l'affectation à visiter
	 */
	public void visiter(Affectation affectation);

	/**
	 * Visite une expression composée.
	 *
	 * @param expr l'expression à visiter
	 */
	public void visiter(ExpressionComplexe expr);
	
	/**
	 * Visite une expression logique de négation.
	 * 
	 * @param nonLog l'expression à visiter.
	 */
	public void visiter(NonLogique nonLog);

	/**
	 * Visite une declaration de capteur.
	 *
	 * @param inst l'instruction à visiter
	 */
	public void visiter(InstructionDeclarationCapteur inst);

	/**
	 * Visite une valeur de capteur.
	 *
	 * @param variableCapteur
	 */
	public void visiter(VariableCapteur variableCapteur);

	/**
	 * Visite une instruction de rotation d'un moteur.
	 *
	 * @param instructionMoteurRotate l'instruction à visiter
	 */
	public void visiter(InstructionMoteurRotate instructionMoteurRotate);
	
	/**
	 * Visite une instruction d'incrémentation.
	 * 
	 * @param instructionIncrementation l'instruction à visiter
	 */
	public void visiter(InstructionIncrementation instructionIncrementation);
	
	/**
	 * Visite une expression de récupération de la valeur d'un capteur.
	 * 
	 * @param valCapteur l'expression à visiter
	 */
	public void visiter(ValeurCapteur valCapteur);
	
	/**
	 * Visite une expression de récupération du nombre de rotations d'un moteur.
	 * 
	 * @param rotMoteur l'expression à visiter.
	 */
	public void visiter(RotationMoteur rotMoteur);
	
	/**
	 * Visite une instruction de remise à zéro d'un compteur de rotations d'un moteur.
	 * 
	 * @param razMoteur l'instruction à visiter.
	 */
	public void visiter(InstructionRAZRotationMoteur razMoteur);
	
	/**
	 * Visite une instruction de configuration des capteurs.
	 * 
	 * @param confCapt l'instruction à visiter.
	 */
	public void visiter(InstructionConfigCapteurs confCapt);
}
