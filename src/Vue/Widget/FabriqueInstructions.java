package Vue.Widget;


import Vue.Tools.NonClonableException;

import Vue.Widget.modele.*;

public class FabriqueInstructions {

	//MOTEURS
	public Widget creerWidgetMoteurMovFwd(){
        return new Widget(new MoteurMovFwdWidget());
    }
    public Widget creerWidgetMoteurMovRev(){
        return new Widget(new MoteurMovRevWidget());
    }
    public Widget creerWidgetMoteurOff(){
        return new Widget(new MoteurOffWidget());
    }
	
	//BOUCLES
	public Widget creerWidgetFor(){
    	return new WidgetCompose(new ForWidget());
    }

    public Widget creerWidgetWhile(){
    	return new WidgetCompose(new WhileWidget());
    }
    
    public Widget creerWidgetDoWhile(){
        return new WidgetCompose(new DoWhileWidget());
    }
	
	public Widget creerWidgetRepeat(){
    	return new WidgetCompose(new RepeatWidget());
    }
    
    //CONDITION
	public Widget creerWidgetIf(){
        return new WidgetCompose(new IfWidget());
    }
	
	public Widget creerWidgetIfElse(){
        return new WidgetCompose(new IfElseWidget());
    }
    
    public Widget creerWidgetWait(){
        return new Widget(new WaitWidget());
    }

	public Widget creerWidgetTache(){
        return new WidgetCompose(new TacheWidget());
    }
	

	public Widget cloner(Widget comp) throws NonClonableException {
		Widget w = null;
		if (comp.getModele() instanceof InstructionWidget) {
			//w = creerWidgetMoteurFwd();
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
		else if (comp.getModele() instanceof MoteurMovFwdWidget) {
			w = creerWidgetMoteurMovFwd();
		}
		else if (comp.getModele() instanceof MoteurMovRevWidget) {
			w = creerWidgetMoteurMovRev();
		}
		else if (comp.getModele() instanceof MoteurOffWidget) {
			w = creerWidgetMoteurOff();
		}
		else if (comp.getModele() instanceof WaitWidget) {
			w = creerWidgetWait();
		}
		else if (comp.getModele() instanceof RepeatWidget) {
			w = creerWidgetRepeat();
		}
		else if (comp.getModele() instanceof ForWidget) {
			w = creerWidgetFor();
		}
		if (w == null) {
			throw new NonClonableException("Ajouter le type de widget \"" + comp.getType() + "\"dans la méthode clone");
		}
		w.getModele().setCouleur(comp.getModele().getCouleur());
		return w;
	}
}
