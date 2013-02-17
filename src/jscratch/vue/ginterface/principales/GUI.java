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
import jscratch.vue.ginterface.principales.panels.ZoneSimulateur;
import jscratch.vue.ginterface.principales.popups.PopupCodeNxc;

/**
 * Facade pour la GUI.
 */
public final class GUI {

	/**
	 * Le constructeur privé de <code>GUI</code>.
	 */
	private GUI() { }

	/**
	 * Permet de récupérer la <code>Fenetre</code>.
	 * 
	 * @return la fenetre
	 */
	public static ApplicationUI getFenetre() {
		return ApplicationUI.getInstance();
	}
	
	/**
	 * Permet de récupérer la <code>GlassPane</code>.
	 * 
	 * @return le glasspane
	 */
	public static GlassPane getGlassPane() {
		return GlassPane.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelCodeConsole</code>.
	 * 
	 * @return le panel code console
	 */
	public static PanelCodeConsole getPanelCodeConsole() {
		return PanelCodeConsole.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelCodeGraphique</code>.
	 * 
	 * @return le panel code graphique
	 */
	public static PanelCodeGraphique getPanelCodeGraphique() {
		return PanelCodeGraphique.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelInstruction</code>.
	 * 
	 * @return le panel instruction
	 */
	public static PanelInstruction getPanelInstruction() {
		return PanelInstruction.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelTypeWidgert</code>.
	 * 
	 * @return le panel type widget
	 */
	public static PanelTypeWidget getPanelTypeWidget() {
		return PanelTypeWidget.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelWidget</code>.
	 * 
	 * @return le panel widget
	 */
	public static PanelWidget getPanelWidget() {
		return PanelWidget.getInstance();
	}

	/**
	 * Permet de récupérer la <code>ZoneUtilisateur</code>.
	 * 
	 * @return la zone utilisateur
	 */
	public static ZoneUtilisateur getZoneUtilisateur() {
		return ZoneUtilisateur.getInstance();
	}
	
	/**
	 * Permet de créer une nouvelle popup de variable
	 * 
	 * @return la nouvelle popup
	 */
	public static JPopupMenu creerPopupVariable() {
		return new PopupAjoutVariable();
	}
	
	/**
	 * Permet de créer une nouvelle popup de code nxc
	 * 
	 * @return la nouvelle popup
	 */
	public static JPopupMenu creerPopupCodeNxc() {
		return new PopupCodeNxc();
	}

	/**
	 * Permet de créer une nouvelle fenetre a propos.
	 * 
	 * @return la nouvelle fenetre a propos
	 */
	public static AProposUI creerAPropos() {
		return new AProposUI();
	}

	/**
	 * Permet de créer une nouvelle <code>FenetreAjoutVariable</code>.
	 * 
	 * @return la nouvelle fenetre
	 */
	public static FenetreAjoutVariable creerFenetreAjoutVariable() {
		return new FenetreAjoutVariable();
	}

	/**
	 * Permet de récupérer une nouvelle <code>FenetreSuppressionVariable</code>.
	 * 
	 * @return la nouvelle fenetre de suppresion de variable
	 */
	public static FenetreSupressionVariable creerFenetreSupressionVariable() {
		return new FenetreSupressionVariable();
	}
	
	/**
	 * Permet de créer une nouvelle zone de simulateur.
	 * 
	 * @return la nouvelle zone
	 */
	public static ZoneSimulateur creerZoneSimulateur() {
		return new ZoneSimulateur();
	}
}