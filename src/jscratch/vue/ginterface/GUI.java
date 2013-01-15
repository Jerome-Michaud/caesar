package jscratch.vue.ginterface;

/**
 * Facade pour la GUI.
 */
public class GUI {

	/**
	 * Le constructeur privé de <code>GUI</code>.
	 */
	private GUI() { }

	public static Fenetre getFenetre() {
		return Fenetre.getInstance();
	}

	public static FenetreAPropos getAPropos() {
		return new FenetreAPropos();
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