package Vue.Widget;

import Vue.Tools.NonClonableException;
import Vue.Widget.modele.*;

public class FabriqueInstructions {

	public Widget creerWidgetInstruction(){
        return new Widget(new InstructionWidget());
    }
	
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

	public Widget cloner(Widget comp) throws NonClonableException {
		Widget w = null;
		if (comp.getModele() instanceof InstructionWidget) {
			w = creerWidgetInstruction();
		}
		else if (comp.getModele() instanceof IfWidget) {
			w = creerWidgetIf();
		}
		else if (comp.getModele() instanceof IfElseWidget) {
			w = creerWidgetIfElse();
		}
		else if (comp.getModele() instanceof TacheWidget) {
			w = creerWidgetTache();
		}
		else if (comp.getModele() instanceof WhileWidget) {
			w = creerWidgetWhile();
		}
		else if (comp.getModele() instanceof DoWhileWidget) {
			w = creerWidgetDoWhile();
		}
		if (w == null) {
			throw new NonClonableException("Ajouter le type de widget \"" + comp.getType() + "\"dans la méthode clone");
		}
		w.getModele().setCouleur(comp.getModele().getCouleur());
		return w;
	}

	private void NonClonableException(String string) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
