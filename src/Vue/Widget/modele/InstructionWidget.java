package Vue.Widget.modele;

import Modeles.TypeWidget;
import instruction.Instruction;
import java.awt.Polygon;
import java.io.Serializable;

public class InstructionWidget extends ModeleWidget implements Serializable{

	public InstructionWidget(String msg, Instruction i) {
		super();
				
		int[] tX = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int[] tY = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};
		
		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeWidget.INSTRUCTION);
		this.setMessage(msg);
		this.setInstruction(i);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
	}

    @Override
    public void decalageXout(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decalageXin(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decalageYout(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void decalageYin(int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
