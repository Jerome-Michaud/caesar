package Vue.Widget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Vue.Tools.ComposantIntrouvableException;
import Vue.Widget.modele.ModeleWidget;

public class WidgetCompose extends Widget implements IWidget {

	private HashMap<Rectangle,List<Widget>> mapZone;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("on est dans le paint du widget compose");
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.GREEN);
		for(Rectangle r : this.mapZone.keySet()){
			System.out.println("on draw un rect "+r);
			g2d.drawRect(r.x, r.y, r.width, r.height);
			
		}
		
	}

	public WidgetCompose(ModeleWidget comp) {
		super(comp);
		this.mapZone = new HashMap<Rectangle,List<Widget>>();
		for(Rectangle r : comp.getZonesAccroches()){
			this.mapZone.put(r, new LinkedList<Widget>());
		}
	}

	public boolean ajouterWidget(Rectangle cle, Widget widget) {
		return this.mapZone.get(cle).add(widget);
	}

	public boolean supprimerWidget(Rectangle cle, Widget widget) {
		return this.mapZone.get(cle).remove(widget);
	}

	public HashMap<Rectangle,List<Widget>> getLesFils() {
		return this.mapZone;
	}

	/*public HashMap<Rectangle,List<Widget>> getComposition() {
		return this.mapZone.;
	}*/

	public List<Widget> getWidgetsAssocies(Widget comp) throws ComposantIntrouvableException{
		List<Widget> l = null;
		boolean trouve = false;
		for(List<Widget> lst : this.mapZone.values()){
			for(Widget w : lst){
				if(lst.contains(comp)){
					trouve = true;
					l = lst;
					break;
				}
			}
			if(trouve)
				break;
		}
		if(!trouve)
			throw new ComposantIntrouvableException();
			return l;
	}
	
	@Override
	public boolean isComplexe(){
		return true;
	}
	
	@Override
    public boolean isRacine() {
        return false;
    }
}
