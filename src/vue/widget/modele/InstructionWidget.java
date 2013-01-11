package vue.widget.modele;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;

import modeles.TypeWidget;
import nxtim.instruction.Instruction;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type Instruction.
 *
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class InstructionWidget extends ModeleWidget implements Serializable {

	/**
	 * Constructeur du modele définissant les différents paramètres de
	 * l'Instruction.
	 */
	public InstructionWidget(String msg, Instruction i) {
		super();

		int[] tX = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int[] tY = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeWidget.INSTRUCTION);

		message.put(new Point(5, 17), msg);

		this.setElementProgramme(i);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
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

	@Override
	public void initListeners() {
	}
}
