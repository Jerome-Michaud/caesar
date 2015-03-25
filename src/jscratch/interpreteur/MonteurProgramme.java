/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

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
package jscratch.interpreteur;

/**
 * Interface pour les objets permettant de construire un programme
 *
 * @author Adrien DUROY
 */
public interface MonteurProgramme {
	
	/**
	 * Ajoute une affectation au programme.
	 */
	public void affectation();
	
	/**
	 * Ajoute une boucle while au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps du while.
	 */
	public void bwhile(int nbInst);
	
	/**
	 * Ajoute une boucle do-while au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps de la boucle.
	 */
	public void bdoWhile(int nbInst);
	
	/**
	 * Ajoute une boucle repeat au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps de la boucle.
	 */
	public void brepeat(int nbInst);
	
	/**
	 * Ajoute une boucle for au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps de la boucle.
	 */
	public void bfor(int nbInst);
	
	/**
	 * Ajoute une condition au programme.
	 * 
	 * @param op l'opérateur conditionnel.
	 */
	public void condition(String op);
	
	/**
	 * Ajoute une constante au programme.
	 * 
	 * @param valeur la valeur de la constante.
	 * @param type le type de la constante.
	 */
	public void constante(String valeur, String type);
	
	/**
	 * Ajoute une déclaration d'une variable.
	 * 
	 * @param type le type de la variable.
	 * @param var le nom de la variable.
	 */
	public void declaration(String type, String var);
	
	/**
	 * Ajoute une déclaration avec initialisation au programme.
	 * 
	 * @param type le type de la variable.
	 * @param var le nom de la variable.
	 */
	public void declarationInitialisation(String type, String var);
	
	/**
	 * Ajout un appel à une fonction dans le programme.
	 * 
	 * @param nom le nom de la fonction.
	 * @param nbArgs le nombre d'arguments de la fonction.
	 */
	public void fonctionAppel(String nom, int nbArgs);
	
	/**
	 * Ajoute une opération au programme.
	 * 
	 * @param op l'opérateur arithmétique.
	 */
	public void operation(String op);
	
	/**
	 * Ajoute une instruction if au programme.
	 * 
	 * @param nbInst le nombre d'instruction dans le corps du if. 
	 */
	public void si(int nbInst);
	
	/**
	 * Ajoute une instruction if-else dans le programme.
	 * 
	 * @param nbInstIf le nombre d'instruction dans le corps du if.
	 * @param nbInstElse le nombre d'instruction dans le corps du else.
	 */
	public void siSinon(int nbInstIf, int nbInstElse);
	
    /**
     * Ajoute une tâche au programme.
     * 
     * @param nom le nom de la tâche
     */
    public void tache(String nom, int nbInst);

	/**
	 * Ajoute un appel à une variable au programme.
	 * 
	 * @param nom le nom de la variable.
	 */
	public void variable(String nom);
	
    /**
     * Remet à zéro le monteur. Le monteur repart d'un programme vierge.
     */
    public void reset();
}
