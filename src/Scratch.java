import Modeles.Erreur;
import Vue.Interface.Fenetre;
import de.javasoft.plaf.synthetica.*;
import javax.swing.UIManager;

public class Scratch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	try {
	    UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());

	} catch (Exception ex) {
	    Erreur.afficher(ex);
	}
	Fenetre fen = Fenetre.getInstance();
    }
}
