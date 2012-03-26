package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;
import java.io.Serializable;
import java.awt.Rectangle;
import java.util.List;
import java.util.LinkedList;

public abstract class ModeleWidget implements Serializable{

	public static final int OFFSET = 5;
	protected int[] tabX, tabY;
	private Color couleur;
	private Polygon forme;
	private String message;
	private TypeWidget type;
	private boolean conditionHaute;
	private int tailleX;
	private int tailleY;
	protected List<Rectangle> zonesAccroches;

	public ModeleWidget() {
		this.conditionHaute = true;
		this.zonesAccroches = new LinkedList<Rectangle>();

	}
	
	public List<Rectangle> getZonesAccroches() {
		return zonesAccroches;
	}

	public void setZonesAccroches(List<Rectangle> zonesAccroches) {
		this.zonesAccroches = zonesAccroches;
	}

	public int getXMin(){
		int min=tabX[0];
		int i;
		
		for(i=0;i<tabX.length;i++){
			min=Math.min(min, tabX[i]);
		}
		
		return min;
	}
	
	public int getYMin(){
		int min=tabY[0];
		int i;
		
		for(i=0;i<tabY.length;i++){
			min=Math.min(min, tabY[i]);
		}
		
		return min;
	}
	
	public int getXMax(){
		int max=tabX[0];
		int i;
		
		for(i=0;i<tabX.length;i++){
			max=Math.max(max, tabX[i]);
		}
		
		return max;
	}
	
	public int getYMax(){
		int max=tabY[0];
		int i;
		
		for(i=0;i<tabY.length;i++){
			max=Math.max(max, tabY[i]);
		}
		
		return max;
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
	
	public int getTailleX(){
		return this.tailleX;
	}
	
	public void setTailleX(){
		this.tailleX=this.getXMax()-this.getXMin();
	}
	
	public int getTailleY(){
		return this.tailleY;
	}
	
	public void setTailleY(){
		this.tailleY=this.getYMax()-this.getYMin();
	}
	
	public abstract void decalageXout(int x);
    
    public abstract void decalageXin(int x);
    
    public abstract void decalageYout(int x);
    
    public abstract void decalageYin(int x);
}