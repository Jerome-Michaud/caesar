package Vue.Widget.modele;

import Modeles.TypeWidget;
import java.awt.Polygon;

public class MoteurMovFwdWidget extends ModeleWidget {

		
	
	public MoteurMovFwdWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.MOTEURMOVFWD);
		this.setMessage("Moteurmovfwd");
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

	}

	@Override
	public void decalageXout(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decalageXin(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decalageYout(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decalageYin(int x) {
		// TODO Auto-generated method stub
		
	}
}