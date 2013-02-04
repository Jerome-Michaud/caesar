package jscratch.parametrages;

import java.awt.Color;
import java.awt.Rectangle;
import jscratch.helpers.PropertiesHelper;

/**
 * Classe regroupant différentes variables utilisées par le programme
 *
 * @since 1.0
 * @version 1.0
 */
public class Variables {

	/**
	 * Taille en X des boutons des catégories.
	 * 
	 * @see properties
	 */
	public static final int TAILLE_CATEGORIE_X = Integer.parseInt(PropertiesHelper.getInstance().get("taille.categorie.x"));
	
	/**
	 * Taille en Y des boutons des catégories.
	 * 
	 * @see properties
	 */
	public static final int TAILLE_CATEGORIE_Y = Integer.parseInt(PropertiesHelper.getInstance().get("taille.categorie.y"));

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
	
	// Gestion des couleurs des catégories
	private static final int QUANTITE_COULEUR = 141;
	public static final Color GRIS_INACTIF = Color.LIGHT_GRAY;
	public static final Color GRIS_ACTIF = Color.DARK_GRAY;
	public static final Color GRIS_SURVOLE = new Color(QUANTITE_COULEUR, QUANTITE_COULEUR, QUANTITE_COULEUR);
	
	/**
	 * Taille en Y de la marge pour la fusion de deux widgets.
	 *
	 * @see properties
	 */
	public static final int MARGE_AIMENT = Integer.parseInt(PropertiesHelper.getInstance().get("marge.aiment"));
	
	/**
	 * Epaisseur du trait lors de la fusion.
	 *
	 * @see propertie
	 */
	public static final int LINE_STROKE_VALUE = Integer.parseInt(PropertiesHelper.getInstance().get("linestroke.value"));
	
	/**
	 * Indice (en %) pour la conservation du widget dans le PanelCodeGraphique.
	 *
	 * @see properties
	 */
	public static final float TAUX_TRANSFERT_PANEL = Float.parseFloat(PropertiesHelper.getInstance().get("taux.transfert"));
	
	/**
	 * Espacement WidgetCompose vide
	 *
	 * @see properties
	 */
	public static final int ECART_PAR_DEFAULT = Integer.parseInt(PropertiesHelper.getInstance().get("ecart.defaut"));
	
	/**
	 * Chemin d'accès au compilateur NXC
	 *
	 * @see properties
	 */
	public static final String CHEMIN_ACCES_NBC = PropertiesHelper.getInstance().get("user.chemin.compilateur");
	
	/**
	 * Affichage du nombre de widget dans les boutons catégorie.
	 * 
	 * @see properties
	 */
	public static final boolean AFFICHAGE_NOMBRE_WIDGET = Boolean.valueOf(PropertiesHelper.getInstance().get("user.categorie.afficher.nombrewidget"));
}