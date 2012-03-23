package Vue.Widget;

import Vue.Widget.modele.*;

public class FabriqueInstructions {

    public Widget creerWidgetWhile(){
        return new Widget(new WhileWidget());
    }
    
    public Widget creerWidgetDoWhile(){
        return new Widget(new DoWhileWidget());
    }
	
	public Widget creerWidgetIf(){
        return new Widget(new IfWidget());
    }
	
	public Widget creerWidgetIfElse(){
        return new Widget(new IfElseWidget());
    }
	
	public Widget creerWidgetTache(){
        return new Widget(new TacheWidget());
    }

	public Widget cloner(Widget comp) {
		if (comp.getModele() instanceof IfWidget) {
			return creerWidgetIf();
		} else if (comp.getModele() instanceof IfElseWidget) {
			return creerWidgetIfElse();
		} else if (comp.getModele() instanceof TacheWidget) {
			return creerWidgetTache();
		} else if (comp.getModele() instanceof WhileWidget) {
			return creerWidgetWhile();
		} else if (comp.getModele() instanceof DoWhileWidget) {
			return creerWidgetDoWhile();
		}
		return null;
	}

}
