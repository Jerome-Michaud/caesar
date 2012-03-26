package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;
import java.io.Serializable;

public abstract class ModeleWidget implements Serializable {

    public static final int OFFSET = 5;
    private int[] tabX, tabY;
    private Color couleur;
    private Polygon forme;
    private String message;
    private TypeWidget type;
    private boolean conditionHaute;
    protected boolean attachableHaut, attachableBas;

    public ModeleWidget() {
        this.conditionHaute = true;
        this.attachableBas = true;
        this.attachableHaut = true;
    }

    public boolean isConditionHaute() {
        return conditionHaute;
    }

    public void setConditionHaute(boolean conditionHaute) {
        this.conditionHaute = conditionHaute;
    }

    public int[] getTabX() {
        return tabX;
    }

    public void setTabX(int[] tabX) {
        this.tabX = tabX;
    }

    public int[] getTabY() {
        return tabY;
    }

    public void setTabY(int[] tabY) {
        this.tabY = tabY;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Polygon getForme() {
        return forme;
    }

    public void setForme(Polygon forme) {
        this.forme = forme;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TypeWidget getType() {
        return type;
    }

    public void setType(TypeWidget type) {
        this.type = type;
    }

    public boolean isAttachableBas() {
        return attachableBas;
    }

    public boolean isAttachableHaut() {
        return attachableHaut;
    }
}