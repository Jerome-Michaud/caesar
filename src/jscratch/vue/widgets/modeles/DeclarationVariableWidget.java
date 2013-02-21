package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.Variable;

/**
 * @since 1.0
 */
public class DeclarationVariableWidget extends ModeleWidget {

	private ChampTexte g;
	
	/**
	 * Constructor par défaut de <code>DeclarationVariableWidget</code>.
	 */
	public DeclarationVariableWidget() {
		int tX[] = {0, 5, 30, 35, 45, 50, 90, 95, 95, 90, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.DECLARERVARIABLE);

		message.put(new Point(5, 17), "Déclarer");

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		int widthChamp = 35;
		g = new ChampTexte(widthChamp, this);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		g.setBounds(55, 3, widthChamp, 20);
		g.supprimerTexte();
		this.getLesZonesSaisies().add(g);
		
		setElementProgramme(new InstructionDeclaration());
	}
	
	@Override
	public void applyChangeModele() {
		if (g != null) {
			Widget contentWidget = g.getContentWidget();

			if (contentWidget != null) {
				((InstructionDeclaration)getElementProgramme()).setMembre((Variable)contentWidget.getElementProgramme());
			}
		}
	}
	
	@Override
	public void decalageY(int b, Rectangle r) {
		int i;
		for (i = 8; i < 16; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}
}