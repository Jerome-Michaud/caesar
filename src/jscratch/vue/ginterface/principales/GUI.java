package jscratch.vue.ginterface.principales;

import jscratch.vue.ginterface.principales.popups.PopupAjoutVariable;
import jscratch.vue.ginterface.principales.panels.GlassPane;
import jscratch.vue.ginterface.principales.panels.ZoneUtilisateur;
import jscratch.vue.ginterface.principales.panels.PanelCodeConsole;
import jscratch.vue.ginterface.principales.panels.PanelTypeWidget;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import jscratch.vue.ginterface.principales.panels.PanelWidget;
import jscratch.vue.ginterface.principales.panels.PanelInstruction;
import javax.swing.JPopupMenu;
import jscratch.vue.ginterface.principales.popups.PopupCodeNxc;

/**
 * Facade pour la GUI.
 */
public final class GUI {

	/**
	 * Le constructeur privé de <code>GUI</code>.
	 */
	private GUI() { }

	public static ApplicationUI getFenetre() {
		return ApplicationUI.getInstance();
	}
	
	public static JPopupMenu getPopupVariable() {
		return new PopupAjoutVariable();
	}
	
	public static JPopupMenu getPopupCodeNxc() {
		return new PopupCodeNxc();
	}

	public static AProposUI getAPropos() {
		return new AProposUI();
	}

	public static void getFenetreAjoutVariable() {
		FenetreAjoutVariable.getInstance();
	}

	public static void getFenetreSupressionVariable() {
		FenetreSupressionVariable.getInstance();
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