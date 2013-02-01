package jscratch.vue.ginterface.parametrages.panels;

import javax.swing.JPanel;

/**
 *
 * Définit un panel pour la fen^étre de paramètrage.
 * 
 * @since 1.0
 * @version 1.0
 */
public abstract class PanelParametrage extends JPanel {

	/**
	 * Met à jour le properties suivant les valeurs des champs.
	 */
	public abstract void update();
}