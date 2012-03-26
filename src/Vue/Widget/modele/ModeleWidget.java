package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Color;
import java.awt.Polygon;

public abstract class ModeleWidget {

	public static final int OFFSET = 5;
	private int[] tabX, tabY;
	private Color couleur;
	private Polygon forme;
	private String message;
	private TypeWidget type;
	private boolean conditionHaute;
	private int tailleX;
	private int tailleY;

	public ModeleWidget() {
		this.conditionHaute = true;
		this.tailleX=this.getXMax(tabX)-this.getXMin(tabX);
		this.tailleY=this.getYMax(tabY)-this.getYMin(tabY);
		
	}
	
	public int getXMin(int[] tabX){
		int min=tabX[0];
		int i;
		
		for(i=0;i<tabX.length;i++){
			min=Math.min(min, tabX[i]);
		}
		
		return min;
	}
	
	public int getYMin(int[] tabY){
		int min=tabY[0];
		int i;
		
		for(i=0;i<tabY.length;i++){
			min=Math.min(min, tabY[i]);
		}
		
		return min;
	}
	
	public int getXMax(int[] tabX){
		int max=tabX[0];
		int i;
		
		for(i=0;i<tabX.length;i++){
			max=Math.max(max, tabX[i]);
		}
		
		return max;
	}
	
	public int getYMax(int[] tabY){
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
	
	public void setTailleX(int x){
		this.tailleX=x;
	}
	
	public int getTailleY(){
		return this.tailleY;
	}
	
	public void setTailleY(int y){
		this.tailleY=y;
	}
}