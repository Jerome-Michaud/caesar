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

import java.util.ArrayList;
import java.util.List;

/**
 * Concept abstrait regroupant toutes les instructions composées d'un corps contenant d'autres instruction.<br/>
 * Utilisation du design pattern Composite.
 */
public abstract class InstructionStructure implements Instruction {

	/**
	 * La constante pour définir le début du code.
	 */
	public static final int POSITION_DEBUT_CODE = 0;
	/**
	 * La constante pour définir la fin du code.
	 */
	public static final int POSITION_FIN_CODE = Integer.MAX_VALUE;
	/**
	 * La liste des enfants de la structure.
	 */
	private List<Instruction> enfants;

	/**
	 * Crée une instruction "structure" vide.
	 */
	public InstructionStructure() {
		enfants = new ArrayList<Instruction>();
	}

	/**
	 * Crée une instruction "structure" avec des instruction dans le corps.
	 *
	 * @param enfants la liste des instructions du corps
	 */
	public InstructionStructure(final List<Instruction> enfants) {
		this.enfants = enfants;
	}

	/**
	 * Ajoute une instruction dans le corps.
	 *
	 * @param position la position où insérer l'instruction
	 * @param inst l'instruction à insérer
	 */
	public void inserer(final int position, final Instruction inst) {
		if (position == POSITION_FIN_CODE) {
			insererFin(inst);
		} else {
			enfants.add(position, inst);
		}
	}

	/**
	 * Ajoute une instruction au début du corps.
	 *
	 * @param inst l'instruction à insérer au début du corps
	 */
	public void insererDebut(final Instruction inst) {
		enfants.add(POSITION_DEBUT_CODE, inst);
	}

	/**
	 * Ajoute une instruction à la fin du corps.
	 *
	 * @param inst l'instruction à insérer à la fin du corps
	 */
	public void insererFin(final Instruction inst) {
		enfants.add(inst);
	}

	/**
	 * Ajoute plusieurs instructions dans le corps.
	 *
	 * @param position la position où insérer les instructions
	 * @param instListe la liste des instructions à insérer
	 */
	public void inserer(final int position, final List<Instruction> instListe) {
		if (position == POSITION_FIN_CODE) {
			enfants.addAll(instListe);
		} else {
			enfants.addAll(position, instListe);
		}
	}

	/**
	 * Ajoute plusieurs instructions au début du corps.
	 *
	 * @param instListe les instructions à insérer au début du corps
	 */
	public void insererDebut(final List<Instruction> instListe) {
		enfants.addAll(POSITION_DEBUT_CODE, instListe);
	}

	/**
	 * Ajoute plusieurs instructions à la fin du corps.
	 *
	 * @param instListe les instructions à insérer à la fin du corps
	 */
	public void insererFin(final List<Instruction> instListe) {
		enfants.addAll(instListe);
	}

	/**
	 * Donne la liste des instructions du corps de l'instruction.
	 *
	 * @return la liste des instructions de l'instruction
	 */
	public List<Instruction> getEnfants() {
		return enfants;
	}

	/**
	 * Donne la liste des instructions du corps de l'instruction à partir d'une certaine position.
	 *
	 * @param pos la position de départ
	 * @return la liste des instructions concernées
	 */
	public List<Instruction> getEnfants(final int pos) {
		return new ArrayList<Instruction>(enfants.subList(pos, enfants.size()));
	}

	/**
	 * Supprime toutes les instructions du corps de l'instruction.
	 *
	 * @return la liste des enfants supprimés
	 */
	public List<Instruction> removeEnfants() {
		return removeEnfants(0);
	}

	/**
	 * Supprime toutes les instructions du corps de l'instruction à partir d'un certain rang.
	 *
	 * @param pos le rang de départ
	 * @return la liste des enfants supprimés
	 */
	public List<Instruction> removeEnfants(final int pos) {
		List<Instruction> res = getEnfants(pos);
		enfants.removeAll(res);
		return res;
	}
}