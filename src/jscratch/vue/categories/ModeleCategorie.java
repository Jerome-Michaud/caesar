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
package jscratch.vue.categories;

import java.awt.Color;
import java.awt.Polygon;

import jscratch.dictionnaires.DicoCouleursCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.lang.CategorieLangueTraducteur;
import jscratch.parametrages.properties.VariableProperties;
import nxtim.instruction.Categorie;

/**
 * Permet de définir le modèle d'un bouton de catégorie.<br />
 * <br />
 * Suivant les propriétés suivantes :<br />
 * <ul>
 * <li>ces 2 formes :
 * <ul>
 * <li>la partie colorée</li>
 * <li>la partie grise</li>
 * </ul>
 * </li>
 * <li>la couleur de la catégorie</li>
 * <li>le nom de la catégorie</li>
 * </ul>
 */
public class ModeleCategorie {

	/**
	 * Coordonnées X du polygone coloré.
	 */
	private int tabXIcone[] = {0, 5, 10, 10, 5, 0};
	/**
	 * Coordonnées Y du polygone coloré.
	 */
	private int tabYIcone[] = {5, 0, 0, VariableProperties.TAILLE_CATEGORIE_Y, VariableProperties.TAILLE_CATEGORIE_Y,
		VariableProperties.TAILLE_CATEGORIE_Y - 5};
	/**
	 * Coordonnées X du polygone gris.
	 */
	private int tabX[] = {10, VariableProperties.TAILLE_CATEGORIE_X - 5, VariableProperties.TAILLE_CATEGORIE_X,
		VariableProperties.TAILLE_CATEGORIE_X, VariableProperties.TAILLE_CATEGORIE_X - 5, 10};
	/**
	 * Coordonnées Y du polygone gris.
	 */
	private int tabY[] = {0, 0, 5, VariableProperties.TAILLE_CATEGORIE_Y - 5, VariableProperties.TAILLE_CATEGORIE_Y,
		VariableProperties.TAILLE_CATEGORIE_Y};
	/**
	 * La couleur de la catégorie.
	 */
	private Color couleur;
	/**
	 * Les polygones donnant le polygone global.
	 */
	private Polygon formeCouleur, formeTexte;
	
	/**
	 * La catégorie correspondant au bouton.
	 */
	private Categorie categorie;
	
	/**
	 * Définit un nouveau modèle de catégorie.
	 *
	 * @param categorie la catégorie.
	 */
	public ModeleCategorie(final Categorie categorie) {
		this.couleur = DicoCouleursCategories.getInstance().getCouleur(categorie);
		this.categorie = categorie;
		this.formeCouleur = new Polygon(this.tabXIcone, this.tabYIcone, this.tabXIcone.length);
		this.formeTexte = new Polygon(this.tabX, this.tabY, this.tabX.length);
	}

	/**
	 * Retourne le polygone coloré.
	 *
	 * @return Le polygone coloré
	 */
	public Polygon getFormeCouleur() {
		return this.formeCouleur;
	}

	/**
	 * Retourne le polygone gris.
	 *
	 * @return le polygone gris
	 */
	public Polygon getFormeTexte() {
		return this.formeTexte;
	}

	/**
	 * Retourne la couleur de la catégorie.
	 *
	 * @return La couleur de la catégorie
	 */
	public Color getCouleur() {
		return this.couleur;
	}

	/**
	 * Retourne le nom de la catégorie.
	 *
	 * @param nombreWidget <code>true</code>, si on veut afficher le nombre de widget dans la catégorie
	 * @return le message de la catégorie
	 */
	public String getMessage(final boolean nombreWidget) {
		if (nombreWidget) {
			return CategorieLangueTraducteur.traduire(this.categorie) + " (" + DicoWidgetsCategories.getInstance().getWidgets(this.categorie, true).size() + ")" ;
		}
		return this.categorie.toString();
	}
	
	/**
	 * Retourne la catégorie du bouton.
	 * 
	 * @return la categorie
	 */
	public Categorie getCategorie() {
		return this.categorie;
	}
}