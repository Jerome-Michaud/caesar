package jscratch;

import jscratch.traces.DicoTraces;
import jscratch.traces.TypeTrace;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class TestTraces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DicoTraces.getInstance().ajouterTrace(TypeTrace.WIDGET_AJOUT);
		DicoTraces.getInstance().ajouterTrace(TypeTrace.WIDGET_DEPLACEMENT);
		DicoTraces.getInstance().ajouterTrace(TypeTrace.WIDGET_MODIFICATION);
		DicoTraces.getInstance().ajouterTrace(TypeTrace.WIDGET_SUPPRESSION);
		DicoTraces.getInstance().ajouterTrace(TypeTrace.CATEGORIE_CHANGEMENT);
		DicoTraces.getInstance().ajouterTrace(TypeTrace.SIMULATEUR_BOUTONS);
		
		System.out.println(DicoTraces.getInstance().getLesTraces());
    }

}