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

/**
 * Boucle d'une situation de départ jusqu'à
 * une condition avec un traitement à chaque tour de boucle.
 *
 * @author Adrien DUROY, Bastien AUBRY
 */
public class InstructionFor extends InstructionConditionelle {

	/**
	 * La valeur d'initialisation.
	 */
	private Affectation initialisation;
	/**
	 * Expression à chaque itération.
	 */
	private Expression iteration;

	/**
	 * Crée une boucle For non initialisée.<br/>
	 * Ses membres ont pour valeur
	 * <code>null</code>.
	 */
	public InstructionFor() {
		super();
	}

	/**
	 * Crée une boucle For.
	 *
	 * @param initialisation l'initialisation
	 * @param condition la condition d'arrêt
	 * @param iteration le traitement de fin de tour de boucle
	 */
	public InstructionFor(final Affectation initialisation, final Condition condition, final InstructionIncrementation iteration) {
		super(condition);
		this.initialisation = initialisation;
		iteration.setIsInstruction(false);
		this.iteration = iteration;
		this.initialisation.setIsInstruction(false);
	}
	
	/**
	 * Crée une boucle For.
	 *
	 * @param initialisation l'initialisation
	 * @param condition la condition d'arrêt
	 * @param iteration le traitement de fin de tour de boucle
	 */
	public InstructionFor(final Affectation initialisation, final Condition condition, final Affectation iteration) {
		super(condition);
		this.initialisation = initialisation;
		iteration.setIsInstruction(false);
		this.iteration = iteration;
		if(initialisation != null) {
			this.initialisation.setIsInstruction(false);
		}
		if(iteration != null) {
			iteration.setIsInstruction(false);
		}
	}

	/**
	 * Accède à la partie initialisation de la boucle.
	 *
	 * @return l'affectation d'initialisation
	 */
	public Affectation getInitialisation() {
		return initialisation;
	}

	/**
	 * Modifie l'initialisation de la boucle.
	 *
	 * @param intialisation la nouvelle affectation d'initialisation
	 */
	public void setInitialisation(final Affectation intialisation) {
		this.initialisation = intialisation;
		if(initialisation != null)
			this.initialisation.setIsInstruction(false);
	}

	/**
	 * Accède à l'itération de la boucle.
	 *
	 * @return l'expression effectué à chaque itération
	 */
	public Expression getIteration() {
		return iteration;
	}

	/**
	 * Modifie l'itération de la boucle.
	 *
	 * @param iteration la nouvelle expression d'itération
	 */
	public void setIteration(final InstructionIncrementation iteration) {
		if(iteration != null) {
			iteration.setIsInstruction(false);
		}
		this.iteration = iteration;
	}
	
	/**
	 * Modifie l'itération de la boucle.
	 *
	 * @param iteration la nouvelle expression d'itération
	 */
	public void setIteration(final Affectation iteration) {
		iteration.setIsInstruction(false);
		this.iteration = iteration;
		if(iteration != null)
			iteration.setIsInstruction(false);
	}

	@Override
	public void accepte(VisiteurElementProg visiteur) {
		visiteur.visiter(this);
	}
}