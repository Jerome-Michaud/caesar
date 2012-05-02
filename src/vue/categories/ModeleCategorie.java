package vue.categories;

import vue.tools.Variables;
import java.awt.Color;
import java.awt.Polygon;
/**
 * Permet de définir le modèle d'un bouton de catégorie.<br />
 * <br />
 * Suivant les propriétés suivantes :<br />
 * <ul>
 *    <li>ces 2 formes :
 *            <ul>
 *                    <li>la partie colorée</li>
 *                    <li>la partie grise</li>
 *            </ul>
 *    </li>
 *    <li>la couleur de la catégorie</li>
 *    <li>le nom de la catégorie</li>
 * </ul>
 *
 * @since 1.0
 * @version 1.0
 */
public class ModeleCategorie {

	private int tabXIcone[] = {0, 5, 10, 10, 5, 0};
	private int tabYIcone[] = {5, 0, 0, Variables.TAILLE_CATEGORIE_Y, Variables.TAILLE_CATEGORIE_Y, Variables.TAILLE_CATEGORIE_Y - 5};
	private int tabX[] = {10, Variables.TAILLE_CATEGORIE_X - 5, Variables.TAILLE_CATEGORIE_X, Variables.TAILLE_CATEGORIE_X, Variables.TAILLE_CATEGORIE_X - 5, 10};
	private int tabY[] = {0, 0, 5, Variables.TAILLE_CATEGORIE_Y - 5, Variables.TAILLE_CATEGORIE_Y, Variables.TAILLE_CATEGORIE_Y};
	private Color couleur;
	private Polygon formeCouleur, formeTexte;
	private String message;

	public ModeleCategorie(String nom, Color couleur) {
		this.couleur = couleur;
		this.message = nom;
		this.formeCouleur = new Polygon(this.tabXIcone, this.tabYIcone, this.tabXIcone.length);
		this.formeTexte = new Polygon(this.tabX, this.tabY, this.tabX.length);
	}
	/**
	 * @since 1.0
	 * 
	 * @return Le polygone coloré.
	 */
	public Polygon getFormeCouleur() {
		return this.formeCouleur;
	}
	/**
	 * @since 1.0
	 * 
	 * @return Le polygone gris.
	 */
	public Polygon getFormeTexte() {
		return this.formeTexte;
	}
	/**
	 * @since 1.0
	 * 
	 * @return La couleur de la catégorie.
	 */
	public Color getCouleur() {
		return this.couleur;
	}
	/**
	 * @since 1.0
	 * 
	 * @return Le message de la catégorie.
	 */
	public String getMessage() {
		return this.message;
	}
}
