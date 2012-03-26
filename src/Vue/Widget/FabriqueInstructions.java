package Vue.Widget;


import Vue.Tools.NonClonableException;

import Vue.Widget.modele.*;

public class FabriqueInstructions {

	//MOTEURS
	public Widget creerWidgetMoteurMovFwd(){
        return new WidgetTexte(new MoteurMovFwdWidget(), 10, 10);
    }
    public Widget creerWidgetMoteurMovRev(){
        return new WidgetTexte(new MoteurMovRevWidget(), 10, 10);
    }
    public Widget creerWidgetMoteurOff(){
        return new Widget(new MoteurOffWidget());
    }
	
	//BOUCLES
	public Widget creerWidgetFor(){
    	return new WidgetTexte(new ForWidget(), 10, 10);
    }

    public Widget creerWidgetWhile(){
    	return new WidgetCompose(new WhileWidget());
    }
    
    public Widget creerWidgetDoWhile(){
        return new WidgetCompose(new DoWhileWidget());
    }
	
	public Widget creerWidgetRepeat(){
    	return new WidgetTexte(new RepeatWidget(), 10, 10);
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
        return new WidgetComposeTextField(new TacheWidget(),10,10);
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
