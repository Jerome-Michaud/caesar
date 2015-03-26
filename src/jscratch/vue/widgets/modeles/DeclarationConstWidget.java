/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableConstante;
import nxtim.instruction.TypeElement;

/**
 *
 * @author daoumi
 */
public class DeclarationConstWidget extends ModeleWidget {
	private ChampTexte g;
	
	/**
	 * Constructor par défaut de <code>DeclarationVariableConst</code>.
	 */

	public DeclarationConstWidget() {
		int tX[] = {0, 5, 30, 35, 45, 50, 250, 255, 255, 250, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.DECLARERCONST);
		
		message.put(new Point(5, 17), "Const");

		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		int widthChamp = 35;
		g = new ChampTexte(widthChamp, this);
		g.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		g.setBounds(55, 3, widthChamp, 20);
		g.setValeur("");
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
			else {
				VariableConstante var = new VariableConstante(TypeElement.CONST, g.getValeur());
				((InstructionDeclaration)getElementProgramme()).setMembre((Variable)var);
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
