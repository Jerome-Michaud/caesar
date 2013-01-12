package jscratch.vue.tools;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.logging.Level;

/**
 * Classe regroupant différentes variables utilisées par le programme
 *
 * @author Andru Bastien - Aubry Bastien - Besnard Vincent - Gosselin Quentin -
 * Melnychenko Ivan
 */
public class Variables {

	/**
	 * Taille en X des boutons des catégories.
	 */
	public static final int TAILLE_CATEGORIE_X = 110;
	/**
	 * Taille en Y des boutons des catégories.
	 */
	public static final int TAILLE_CATEGORIE_Y = 25;
	/**
	 * Taille en X du PanelInstruction.
	 */
	public static final int X_MAX_INSTRUCTION = TAILLE_CATEGORIE_X * 2 + 33;
	/**
	 * Rectangles pour la zone d'accroche des Widgets Compose
	 */
	public static final Rectangle ZONE_ACCROCHE_PAR_DEFAULT = new Rectangle(5, 26, 130, 15);
	public static final Rectangle ZONE_ACCROCHE_ELSE = new Rectangle(5, 56, 130, 15);
	public static final Rectangle ZONE_ACCROCHE_DOWHILE = new Rectangle(5, 16, 130, 15);
	/**
	 * Les informations du logger seront affichés à parti de se niveau.
	 */
	public static final Level LEVEL_DES_LOGGERS = Level.WARNING;
	private static final int QUANTITE_COULEUR = 141;
	public static final Color GRIS_INACTIF = Color.LIGHT_GRAY;
	public static final Color GRIS_ACTIF = Color.DARK_GRAY;
	public static final Color GRIS_SURVOLE = new Color(QUANTITE_COULEUR, QUANTITE_COULEUR, QUANTITE_COULEUR);
	/**
	 * Taille en Y de la marge pour la fusion de deux widgets.
	 *
	 * @see properties
	 */
	public static final int MARGE_AIMENT = 10;
	/**
	 * Epaisseur du trait lors de la fusion.
	 *
	 * @see propertie
	 */
	public static final int LINE_STROKE_VALUE = 5;
	/**
	 * Indice (en %) pour la conservation du widget dans le PanelCodeGraphique.
	 *
	 * @see properties
	 */
	public static final float TAUX_TRANSFERT_PANEL = (float) 0.6;
	/**
	 * Espacement WidgetCompose vide
	 *
	 * @see properties
	 */
	public static final int ECART_PAR_DEFAULT = 15;
	/**
	 * Chemin d'accés au compilateur NXC
	 *
	 * @see properties
	 */
	public static final String CHEMIN_ACCES_NBC = "C:\\Users\\Bastien\\Desktop\\Projet\\ Robot\\Compilateur";
}
