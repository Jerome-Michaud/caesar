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

import jscratch.helpers.LangueHelper;
import jscratch.parametrages.langue.VariableLangue;

/**
 * Cette énumération regroupe les différentes catégories d'instructions et d'expressions possibles.
 */
public enum Categorie {

	/**
	 * Instruction structure (fonctions, tâches).
	 */
	STRUCTURES,
	/**
	 * Instruction de moteur.
	 */
	MOTEURS,
	/**
	 * Variable ou instruction associée aux variables.
	 */
	VARIABLES,
	/**
	 * Instruction associée aux capteurs
	 */
	CAPTEURS,
	/**
	 * Instruction de gestion du temps.
	 */
	TEMPS,
	/**
	 * Expression diverse.
	 */
	EXPRESSIONS;

	/**
	 * Permet de récupérer le nom de la clé pour la catégorie afin de l'utiliser dans un fichier properties.
	 * 
	 * @since 1.0
	 * 
	 * @return le nom
	 */
	public String toProperties() {
		switch (this) {
			case STRUCTURES:
				return "Structures";
			case MOTEURS:
				return "Moteurs";
			case VARIABLES:
				return "Variables";
			case CAPTEURS:
				return "Capteurs";
			case TEMPS:
				return "Temps";
			case EXPRESSIONS:
				return "Expressions";
			default:
				return null;
		}
	}
	
	@Override
	public String toString() {
		switch (this) {
			case STRUCTURES:
				return LangueHelper.getInstance().get(VariableLangue.CAT_STRUCTURES);
			case MOTEURS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_MOTEURS);
			case VARIABLES:
				return LangueHelper.getInstance().get(VariableLangue.CAT_VARIABLES);
			case CAPTEURS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_CAPTEURS);
			case TEMPS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_TEMPS);
			case EXPRESSIONS:
				return LangueHelper.getInstance().get(VariableLangue.CAT_EXPRESSIONS);
			default:
				return null;
		}
	}
}
