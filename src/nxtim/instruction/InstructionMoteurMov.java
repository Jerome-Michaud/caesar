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
 * Instruction de mouvement (rotation avant ou arrière) pour un moteur.
 */
public class InstructionMoteurMov extends InstructionMoteurCmd {

	/**
	 * Définit le sens du moteur.
	 */
	private boolean reverse;
	/**
	 * L'expression donnant la valeur de rotation.
	 */
	private Expression exp;

	/**
	 * Crée une instruction de mouvement d'un moteur non initialisée.
	 */
	public InstructionMoteurMov() {
		super();
		reverse = false;
	}

	/**
	 * Crée une instruction de mouvement d'un moteur.
	 *
	 * @param moteur le moteur concerné
	 * @param exp l'expression donnant la valeur du mouvement
	 * @param reverse booléen inversant le sens du mouvement si la valeur est <code>true</code> (mouvement arrière)
	 */
	public InstructionMoteurMov(final Moteur moteur, final Expression exp, final boolean reverse) {
		super(moteur);
		this.exp = exp;
		this.reverse = reverse;
	}

	/**
	 * Crée une instruction de mouvement d'un moteur.<br/>
	 * Le sens du mouvement n'est pas inversé.
	 *
	 * @param moteur le moteur concerné
	 * @param exp l'expression donnant la valeur du mouvement
	 */
	public InstructionMoteurMov(final Moteur moteur, final Expression exp) {
		this(moteur, exp, false);
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}

	/**
	 * Modifie le sens du mouvement.
	 *
	 * @param reverse Si <code>true</code>, le mouvement est inversé
	 */
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	/**
	 * Permet de savoir si le mouvement est inversé.
	 *
	 * @return <code>true</code> si le mouvement est inversé, sinon <code>false</code>.
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * Modifie l'expression de la valeur du mouvement.
	 *
	 * @param exp la nouvelle expression
	 */
	public void setExpression(final Expression exp) {
		this.exp = exp;
	}

	/**
	 * Accède à l'expression donnant la valeur du mouvement.
	 *
	 * @return l'expression
	 */
	public Expression getExpression() {
		return exp;
	}

	@Override
	public String toString() {
		return "moteurMov(" + getMoteur() + ")";
	}
}