package Vue.Widget;

import java.awt.*;
import java.awt.Color;

public class ModeleWidget {

    public static final int OFFSET = 5;
    private int tabX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
    private int tabY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};
    private Color couleur;
    private Polygon forme;
    private String message;
    private TypeWidget type;

    public ModeleWidget(TypeWidget type) {
	this.couleur = Color.BLUE;
	this.type = type;
	this.message = "répéter";
	this.forme = new Polygon(this.tabX, this.tabY, this.tabX.length);
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