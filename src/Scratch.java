
import Modeles.Erreur;
import Vue.Interface.Fenetre;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import javax.swing.UIManager;

public class Scratch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String[] li = {"Licensee=Alvaro Duran Tovar  ",
                "LicenseRegistrationNumber=------", "Product=Synthetica",
                "LicenseType=Non Commercial", "ExpireDate=--.--.----",
                "MaxVersion=2.999.999"};
            UIManager.put("Synthetica.license.info", li);
            UIManager.put("Synthetica.license.key",
                    "7C970FF4-E59D6AF5-8376C987-6F82C092-8377BB97");
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());

        } catch (Exception ex) {
            Erreur.afficher(ex);
        }
        Fenetre fen = Fenetre.getInstance();
    }
}
