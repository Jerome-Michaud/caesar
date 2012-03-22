package Vue.Widget;

public class FabriqueInstructions {

    public Widget creerWidgetInstruction(){
        return new WidgetInstruction(new ModeleWidget());
    }
    
    public Widget creerWidgetIf(){
        return new WidgetTexte(new ModeleWidget(), 10, 10);
    }

}
