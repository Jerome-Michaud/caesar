/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.ginterface;

/**
 *
 * @author Quentin
 */
public class GUI {

	private GUI() {
	}

	public static Fenetre getFenetre() {
		return Fenetre.getInstance();
	}

	public static FenetreAPropos getAPropos() {
		return new FenetreAPropos();
	}

	public static FenetreAjoutVariable getFenetreAjoutVariable() {
		return new FenetreAjoutVariable();
	}

	public static FenetreSupressionVariable getFenetreSupressionVariable() {
		return new FenetreSupressionVariable();
	}

	public static GlassPane getGlassPane() {
		return GlassPane.getInstance();
	}

	public static PanelCodeConsole getPanelCodeConsole() {
		return PanelCodeConsole.getInstance();
	}

	public static PanelCodeGraphique getPanelCodeGraphique() {
		return PanelCodeGraphique.getInstance();
	}

	public static PanelInstruction getPanelInstruction() {
		return PanelInstruction.getInstance();
	}

	public static PanelTypeWidget getPanelTypeWidget() {
		return PanelTypeWidget.getInstance();
	}

	public static PanelWidget getPanelWidget() {
		return PanelWidget.getInstance();
	}

	public static ZoneUtilisateur getZoneUtilisateur() {
		return ZoneUtilisateur.getInstance();
	}
}
