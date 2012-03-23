package Vue.Widget;

import Vue.Widget.modele.*;

public class FabriqueInstructions {

    public Widget creerWidgetWhile(){
    	return new WidgetTexte(new WhileWidget(), 10, 10);
    }
    
    public Widget creerWidgetIf(){
        return new WidgetTexte(new IfWidget(), 10, 10);
    }
    public Widget creerWidgetFor(){
    	return new WidgetTexte(new ForWidget(), 10, 10);
    }
    
    public Widget creerWidgetIfElse(){
    	return new WidgetTexte(new ForWidget(), 10, 10);
    }
    public Widget creerWidgetDoWhile(){
    	return new WidgetTexte(new DoWhileWidget(), 10, 10);
    }
    public Widget creerWidgetRepeat(){
    	return new WidgetTexte(new RepeatWidget(), 10, 10);
    }
    
    public Widget creerWidgetMoteurMovFwd(){
        return new WidgetTexte(new MoteurMovFwdWidget(), 10, 10);
    }
    public Widget creerWidgetMoteurMovRev(){
        return new WidgetTexte(new MoteurMovRevWidget(), 10, 10);
    }
    public Widget creerWidgetMoteurOff(){
        return new Widget(new MoteurOffWidget());
    }
    public Widget creerWidgetTache(){
        return new Widget(new TacheWidget());
    }
    
    public Widget creerWidgetWait(){
        return new Widget(new WaitWidget());
    }


}
