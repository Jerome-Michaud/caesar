package jscratch.vue.categories;

import java.awt.Color;
import java.awt.Polygon;
import jscratch.dictionnaires.DicoCouleursCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.parametrages.Variables;
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
 *
 * @since 1.0
 * @version 1.0
 */
public class ModeleCategorie {

	/**
	 * Coordonnées X du polygone coloré.
	 */
	private int tabXIcone[] = {0, 5, 10, 10, 5, 0};
	/**
	 * Coordonnées Y du polygone coloré.
	 */
	private int tabYIcone[] = {5, 0, 0, Variables.TAILLE_CATEGORIE_Y, Variables.TAILLE_CATEGORIE_Y,
		Variables.TAILLE_CATEGORIE_Y - 5};
	/**
	 * Coordonnées X du polygone gris.
	 */
	private int tabX[] = {10, Variables.TAILLE_CATEGORIE_X - 5, Variables.TAILLE_CATEGORIE_X,
		Variables.TAILLE_CATEGORIE_X, Variables.TAILLE_CATEGORIE_X - 5, 10};
	/**
	 * Coordonnées Y du polygone gris.
	 */
	private int tabY[] = {0, 0, 5, Variables.TAILLE_CATEGORIE_Y - 5, Variables.TAILLE_CATEGORIE_Y,
		Variables.TAILLE_CATEGORIE_Y};
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
	 * @param nom le nom de la catégorie
	 * @param couleur la couleur de la catégorie
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
			return this.categorie.toString() + " (" + DicoWidgetsCategories.getInstance().getWidgets(this.categorie, true).size() + ")" ;
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