package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;

public abstract class ModeleWidget {

	public static final int OFFSET = 5;
	protected int[] tabX, tabY;
	protected Color couleur;
	protected Polygon forme;
	protected String message;
	protected TypeWidget type;

	public ModeleWidget() {
	}

	public Polygon getForme() {
		return this.forme;
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public String getMessage() {
		return this.message;
	}
	
	public TypeWidget getType() {
		return this.type;
	}
}