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
 * Cette instruction permet de mettre en attente le programme pendant un certain temps.
 */
public class InstructionAttente implements Instruction {

	/**
	 * L'expression donnant le temps d'attente.
	 */
	private Expression expression;

	/**
	 * Créé une instruction d'attente non initialisé.<br/>
	 * L'expression donnant le temps d'attente à pour valeur
	 * <code>null</code>.
	 */
	public InstructionAttente() {
		super();
	}

	/**
	 * Créé une instruction d'attente.
	 *
	 * @param expression l'expression donnant le temps d'attente.
	 */
	public InstructionAttente(final Expression expression) {
		super();
		this.expression = expression;
	}

	/**
	 * Accède à l'expression donnant le temps d'attente.
	 *
	 * @return l'expression.
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Modifie l'expression donnant le temps d'attente.
	 *
	 * @param expr la nouvelle expression.
	 */
	public void setExpression(final Expression expr) {
		this.expression = expr;
	}

	@Override
	public Categorie getCategorie() {
		return Categorie.TEMPS;
	}

	@Override
	public void accepte(final VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}