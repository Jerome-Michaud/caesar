package jscratch;

import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jscratch.helpers.ErreurHelper;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.parametrages.ParametrageUI;

public class Scratch {

	/**
	 * Permet le lancement du programme
	 *
	 * @param args les paramètres du programme.
	 */
	public static void main(String[] args) {
		try {
			String[] li = {"Licensee=Bastien Andru", "LicenseRegistrationNumber=NCBA120326", "Product=Synthetica", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=2.999.999"};
			UIManager.put("Synthetica.license.info", li);
			UIManager.put("Synthetica.license.key", "5DE6EB11-524B1D59-CD2B3EC7-3243D187-6EA8B694");

			try {
				UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}
		
		if (args.length > 0 && "param".equals(args[0])) {
			ParametrageUI.getInstance();
		}
		else {
			GUI.getFenetre();
		}
	}
}