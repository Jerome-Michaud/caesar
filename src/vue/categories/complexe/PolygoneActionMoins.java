package vue.categories.complexe;

import java.awt.Color;
import java.awt.Polygon;
import vue.ginterface.GUI;

/**
 *
 * @author Quentin
 */
public class PolygoneActionMoins extends PolygoneAction {

	private int[] tabX = { 85, 90, 95, 100, 100, 95, 90, 85 };
	private int[] tabY = { 10, 5, 5, 10, 15, 20, 20, 15 };
	
	public PolygoneActionMoins() {
		super();
		
		Polygon formeMoins = new Polygon(this.tabX, this.tabY, this.tabX.length);
				
		this.setPolygone(formeMoins);
		this.getCouleurs().put(EtatPolygon.INACTIF, Color.LIGHT_GRAY);
		this.getCouleurs().put(EtatPolygon.SURVOLE, Color.DARK_GRAY);
		this.getCouleurs().put(EtatPolygon.ACTIF, Color.RED);
	}
	
	@Override
	public void executerAction() {
		GUI.getFenetreSupressionVariable();
	}	
}
