package jscratch.vue.categories.complexe;

import java.awt.Color;
import java.awt.Polygon;
import jscratch.vue.ginterface.GUI;

/**
 *
 * @author Quentin
 */
public class PolygoneActionPlus extends PolygoneAction {

	private int[] tabX = {65, 70, 75, 80, 80, 75, 70, 65};
	private int[] tabY = {10, 5, 5, 10, 15, 20, 20, 15};

	public PolygoneActionPlus() {
		super();

		Polygon formePlus = new Polygon(this.tabX, this.tabY, this.tabX.length);

		this.setPolygone(formePlus);
		this.getCouleurs().put(EtatPolygon.INACTIF, Color.LIGHT_GRAY);
		this.getCouleurs().put(EtatPolygon.SURVOLE, Color.DARK_GRAY);
		this.getCouleurs().put(EtatPolygon.ACTIF, Color.GREEN);
	}

	@Override
	public void executerAction() {
		GUI.getFenetreAjoutVariable();
	}
}
