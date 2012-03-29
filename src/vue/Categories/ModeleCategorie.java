package vue.Categories;

import vue.Tools.Variables;
import java.awt.Color;
import java.awt.Polygon;

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

	public Polygon getFormeCouleur() {
		return this.formeCouleur;
	}

	public Polygon getFormeTexte() {
		return this.formeTexte;
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public String getMessage() {
		return this.message;
	}
}
