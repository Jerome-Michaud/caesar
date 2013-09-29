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
package jscratch.dictionnaires;

import java.awt.Color;
import java.util.HashMap;
import jscratch.parametrages.properties.VariableProperties;
import nxtim.instruction.Categorie;

/**
 * Permet de stocker les couleurs des catégories.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class DicoCouleursCategories {

	/**
	 * L'instance de <code>DicoCouleursCategories</code>.
	 */
	private static DicoCouleursCategories instance = null;
	/**
	 * Le dico.
	 */
	private HashMap<Categorie, Color> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 * 
	 * @since 1.0
	 */
	private DicoCouleursCategories() {
		this.dico = new HashMap<Categorie, Color>();
		
		this.dico.put(Categorie.STRUCTURES, VariableProperties.COULEUR_STRUCTURES);
		this.dico.put(Categorie.MOTEURS,  VariableProperties.COULEUR_MOTEURS);
		this.dico.put(Categorie.EXPRESSIONS, VariableProperties.COULEUR_EXPRESSIONS);
		this.dico.put(Categorie.CAPTEURS, VariableProperties.COULEUR_CAPTEURS);
		this.dico.put(Categorie.TEMPS, VariableProperties.COULEUR_TEMPS);
		this.dico.put(Categorie.VARIABLES, VariableProperties.COULEUR_VARIABLES);
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
	 * 
	 * @since 1.0
	 * 
	 * @return l'instance unique de <code>DicoBoutonsCategories</code>
	 */
	public static DicoCouleursCategories getInstance() {
		if (instance == null) {
			instance = new DicoCouleursCategories();
		}
		return instance;
	}
	
	/**
	 * Permet de récupérer la couleur d'une catégorie.
	 * 
	 * @since 1.0
	 * 
	 * @return  la couleur de la catégorie
	 */
	public Color getCouleur(Categorie categorie) {
		return this.dico.get(categorie);
	}
}