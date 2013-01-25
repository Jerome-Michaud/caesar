package jscratch.vue.sim;

import java.awt.Graphics;

/**
 * Interface pour les éléments qui seront affichés dans le simulateur
 * @author Guillaume Delorme
 *
 */
public interface Renderer {
	/**
	 * Rendu de l'élément
	 * @param g le graphics sur lequel on effectu le rendu
	 */
	public void render(Graphics g);
}
