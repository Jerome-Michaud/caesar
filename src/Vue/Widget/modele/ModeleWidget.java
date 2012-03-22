package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;

public class ModeleWidget {

	public static final int OFFSET = 5;
	protected int tabX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
	protected int tabY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};
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
}