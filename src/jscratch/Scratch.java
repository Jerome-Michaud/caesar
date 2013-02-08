package jscratch;

import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.ErreurHelper;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.parametrages.ParametrageUI;
import jscratch.vue.sim.Fenetre;

public class Scratch {

	/**
	 * Permet le lancement du programme
	 *
	 * @param args les paramètres du programme.
	 */
	public static void main(String[] args) {
		try {
			//Cle du lookandfeel
			String[] li = {"Licensee=Bastien Andru", "LicenseRegistrationNumber=NCBA120326", "Product=Synthetica", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=2.999.999"};
			UIManager.put("Synthetica.license.info", li);
			UIManager.put("Synthetica.license.key", "5DE6EB11-524B1D59-CD2B3EC7-3243D187-6EA8B694");

			// Cle des addons
			String[] li2 = {"Licensee=Bastien Andru", "LicenseRegistrationNumber=NCBA130131", "Product=SyntheticaAddons", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=1.999.999"};
			UIManager.put("SyntheticaAddons.license.info", li2);
			UIManager.put("SyntheticaAddons.license.key", "664973DE-55A50F80-8176ABB3-2BAFF4B7-5F2EEDB2");
			
			try {
				UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
			} catch (UnsupportedLookAndFeelException ex) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				ErreurHelper.afficher(ex);
			}
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}
		
		if (args.length > 0 && "param".equals(args[0])) {
			ParametrageUI.getInstance();
		}
		else {
			DicoBoutonsCategories.getInstance();
			DicoWidgetsCategories.getInstance().nettoyer();
		
			GUI.getFenetre();
			//new Fenetre();
		}
	}
}