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

import nxtim.exception.NXTIMBadTypeElementException;

/**
 * Expression composée de deux autres expressions avec lesquelles effectuer une opération.<br/>
 * Utilise le design pattern Composite.
 */
public abstract class ExpressionComplexe implements Expression {

	private Expression membreDroit;
	private Expression membreGauche;
	private Operateur operateur;

	/**
	 * Crée une expression vide, le contenu devra être fourni plus tard.
	 */
	public ExpressionComplexe() {
		super();
	}

	/**
	 * Crée une expression complexe.
	 *
	 * @param operation l'opérateur de l'expression
	 * @param membreGauche l'expression à gauche de l'opérateur
	 * @param membreDroit l'expression à droite de l'opérateur
	 */
	public ExpressionComplexe(final Operateur operation, final Expression membreGauche, final Expression membreDroit) {
		this.operateur = operation;
		this.membreGauche = membreGauche;
		this.membreDroit = membreDroit;
		valideOperandes();
	}

	/**
	 * Crée une expression complexe dont seul l'opérateur est défini, les membres devront être fournis plus tard.
	 *
	 * @param operation l'opérateur de l'expression
	 */
	public ExpressionComplexe(final Operateur operation) {
		this.operateur = operation;
	}

	/**
	 * Modifie le membre droit.
	 *
	 * @param expression l'expression à mettre en membre droit
	 */
	public void setMembreDroit(final Expression expression) {
		membreDroit = expression;
		valideOperandes();
	}

	/**
	 * Modifie le membre gauche.
	 *
	 * @param expression l'expression à mettre en membre gauche
	 */
	public void setMembreGauche(final Expression expression) {
		membreGauche = expression;
		valideOperandes();
	}

	/**
	 * Accède au membre gauche.
	 *
	 * @return le membre gauche.
	 */
	public Expression getMembreGauche() {
		return this.membreGauche;
	}

	/**
	 * Accède au membre droit.
	 *
	 * @return le membre droit.
	 */
	public Expression getMembreDroit() {
		return this.membreDroit;
	}

	/**
	 * Accède à l'opérateur.
	 *
	 * @return l'opérateur.
	 */
	public Operateur getOperateur() {
		return this.operateur;
	}

	@Override
	public String toString() {
		return "(" + membreGauche + operateur + membreDroit + ")";
	}
	
	/*
	 * Valide les opérandes par rapport à l'opérateur.
	 */
	protected void valideOperandes() throws NXTIMBadTypeElementException {
		if(Operateur.isLogiqueBooleenne(getOperateur())) {
			//opérandes doivent être booléens
			if(getMembreDroit() != null && !getMembreDroit().isBooleenne()){
				throw new NXTIMBadTypeElementException(getMembreDroit().getType(), "Opérateur de condition (" + getOperateur() + ") invalide avec ce type.");
			}
			else if(getMembreGauche() != null && !getMembreGauche().isBooleenne()) {
				throw new NXTIMBadTypeElementException(getMembreGauche().getType(), "Opérateur de condition (" + getOperateur() + ") invalide avec ce type.");
			}
		}
		else {//opérateur logique n'étant pas de logique booléenne et opérateur arithmétique
			Operateur o = getOperateur();
			switch(o) {
				case EGALITE:
					break;
				default:
					//opérateur ne doivent pas être booléens
					if(getMembreDroit() != null && getMembreDroit().isBooleenne()) {
						throw new NXTIMBadTypeElementException(getMembreDroit().getType(), "Opérateur de condition (" + getOperateur() + ") invalide avec ce type.");
					}
					if(getMembreGauche() != null && getMembreGauche().isBooleenne()) {
						throw new NXTIMBadTypeElementException(getMembreGauche().getType(), "Opérateur de condition (" + getOperateur() + ") invalide avec ce type.");
					}
					break;
			}
		}
	}
}
