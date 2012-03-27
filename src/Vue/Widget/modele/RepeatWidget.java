package Vue.Widget.modele;

import Modeles.TypeWidget;
import instruction.InstructionDoWhile;
import instruction.InstructionRepeat;
import java.awt.Polygon;

public class RepeatWidget extends ModeleWidget {
		
	
	
	public RepeatWidget(){
			super();
			int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                                 /**/135,130,/**/50,45,35,30,/**/5,0};
			int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,                         /**/50,55,/**/55,60,60,55,/**/55,50};
		 	
			
			this.setTabX(tX);
			this.setTabY(tY);
			this.setTailleX();
			this.setTailleY();
			this.setType(TypeWidget.REPEAT);
			this.setMessage("Repeat");
			this.setElementProgramme(new InstructionRepeat());
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
	
	public void initListeners() {
		
	}

}
