package jscratch.modeles.sim.collision;

import java.awt.Color;

/**
 * Enumération qui contient les couleurs possibles pour les obstacles
 * @author Guillaume Delorme
 *
 */
public enum CouleurObstacle {
	BLACK (new Color(0, 0, 0)),
	BLUE (new Color(38, 173, 228)),
	CYAN (new Color(118, 188, 173)),
	DARK_GRAY (new Color(51, 51, 51)),
	GRAY (new Color(130, 130, 130)),
	GREEN (new Color(136, 196, 37)),
	LIGHT_GRAY (new Color(220, 220, 220)),
	MAGENTA (new Color(210, 77, 108)),
	ORANGE (new Color(243, 134, 48)),
	PINK (new Color(255, 158, 157)),
	RED (new Color(207, 70, 71)),
	WHITE (new Color(255, 255, 255)),
	YELLOW (new Color(249, 212, 35));
	
	private final Color couleur;
	
	CouleurObstacle(Color couleur) {
		this.couleur = couleur;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	/**
	 * Récupère la couleur depuis une chaine de caractère
	 * @param couleur la chaine de la couleur
	 * @return la couleur si elle existe, noir sinon
	 */
	public static CouleurObstacle fromString(String couleur) {
		for (CouleurObstacle c : CouleurObstacle.values()) {
			if (c.toString().equalsIgnoreCase(couleur)) {
				return c;
			}
		}
		
		return BLACK;
	}
}
