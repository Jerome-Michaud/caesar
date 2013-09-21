/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

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
		super();
		membreIf = new InstructionIf();
	}

	/**
	 * Crée une instruction if-else.
	 *
	 * @param cond la condition du if
	 */
	public InstructionIfElse(final Condition cond) {
		super();
		membreIf = new InstructionIf(cond);
	}

	@Override
	public Expression getCondition() {
		return getMembreIf().getCondition();
	}

	@Override
	public void setCondition(final Condition cond) {
		getMembreIf().setCondition(cond);
	}
	
	@Override
	public void setCondition(final NonLogique cond) {
		membreIf.setCondition(cond);
	}
	
	@Override
	public void setCondition(final Variable cond) {
		membreIf.setCondition(cond);
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