/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
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
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.traduction;

import nxtim.instruction.VisiteurElementProg;

public abstract class VisiteurTraduction implements VisiteurElementProg {

	/**
	 * La traduction.
	 */
	protected String traduction;
	/**
	 * Le niveau d'indentation.
	 */
	protected int nivIndent;
	/**
	 * La méthode d'indentation.
	 */
	protected boolean identationTabulation = false;
	
	public VisiteurTraduction() {
		traduction = "";
		nivIndent = 0;
	}

	/**
	 * Donne la traduction.
	 *
	 * @return la traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * Réinitialise la traduction.
	 */
	public void reset() {
		traduction = "";
		nivIndent = 0;
	}

	/**
	 * Donne l'indentation du niveau d'indentation courant.
	 *
	 * @return la chaîne correspondant à l'espace d'indentation.
	 */
	protected String indent() {
		String indentation = "";
		for (int i = 0; i < nivIndent; i++) {
			if (identationTabulation) {
				indentation += "\t";
			} else {
				indentation += "    ";
			}
		}
		return indentation;
	}

	/**
	 * Permet de savoir si le caractère tabulation est utilisé pour l'indentation.
	 *
	 * @return <code>true</code> si la tabulation est utilisée pour l'indentation, sinon <code>false</code>
	 */
	public boolean isIdentationTabulation() {
		return identationTabulation;
	}

	/**
	 * Modifie la façon d'effectuer l'indentation dans la traduction.
	 *
	 * @param identationTabulation si <code>false</code> l'indentation sera effectuée avec des espaces, sinon des tabulations
	 */
	public void setIdentationTabulation(final boolean identationTabulation) {
		this.identationTabulation = identationTabulation;
	}
}