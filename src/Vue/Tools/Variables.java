package Vue.Tools;

import java.awt.Rectangle;

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
	 * Taille en Y de la marge pour la fusion de deux widgets.
	 */
	public static final int MARGE_AIMENT = 10;
	/**
	 * Epaisseur du trait lors de la fusion.
	 */
    public static final int LINE_STROKE_VALUE = 5;

	
	/**
	 * Indice (en %) pour la conservation du widget dans le PanelCodeGraphique.
	 */
	public static final float TAUX_TRANSFERT_PANEL = (float) 0.6;
	
	/**
	 * Rectangles pour la zone d'accroche des Widgets Compose
	 */
	public static final Rectangle ZONE_ACCROCHE_PAR_DEFAULT = new Rectangle(5,25,130,16);
	
	public static final Rectangle ZONE_ACCROCHE_ELSE = new Rectangle(5,55,130,16);
	
	public static final Rectangle ZONE_ACCROCHE_DOWHILE = new Rectangle(5,15,130,16);
	
	/**
	 * Espacement WidgetCompose vide
	 * 
	 */
	
	public static final int ECART_PAR_DEFAULT = 15;
	

}
