package vue.categories.complexe;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.HashMap;

/**
 *
 * @author Quentin
 */
public abstract class PolygoneAction {

	private HashMap<EtatPolygon, Color> couleurs;
	private Polygon polygone;
	private EtatPolygon etat;

	public PolygoneAction() {
		this.couleurs = new HashMap<EtatPolygon, Color>();
		this.etat = EtatPolygon.INACTIF;
	}

	protected HashMap<EtatPolygon, Color> getCouleurs() {
		return couleurs;
	}

	protected void setPolygone(Polygon polygone) {
		this.polygone = polygone;
	}

	/**
	 * Permet de connaître la forme du Polygon.
	 */
	public Polygon getPolygon() {
		return this.polygone;
	}

	/**
	 * Permet de connaître la couleur du Polygon suivant sont état.
	 */
	public Color getCouleur() {
		return this.couleurs.get(this.etat);
	}

	/**
	 * Permet de modifier l'état du Polygon.
	 *
	 * @param etat Le nouvel état du Polygon
	 */
	public void setEtat(EtatPolygon etat) {
		this.etat = etat;
	}

	/**
	 * Permet d'avoir les coordonnées du bouton par rapport au composant lui-même.
	 *
	 * @return Le coordonées du bouton par rapport à lui-même
	 */
	public Rectangle getBounds() {
		Rectangle res = new Rectangle(999, 999, 0, 0);

		for (Integer i : this.getPolygon().xpoints) {
			res.width = Math.max(res.width, i);
			res.x = Math.min(res.x, i);
		}

		for (Integer i : this.getPolygon().ypoints) {
			res.height = Math.max(res.height, i);
			res.y = Math.min(res.y, i);
		}
		res.width -= res.x;
		res.height -= res.y;


		return res;
	}

	/**
	 * Permet de déclencher l'action qui est attribuée au Polygon.
	 */
	public abstract void executerAction();
}
