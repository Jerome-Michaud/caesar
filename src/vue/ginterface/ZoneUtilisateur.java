package vue.ginterface;

import java.awt.BorderLayout;
import javax.swing.JPanel;
/**
 * Cette zone correspond à la zone où l'utilisateur peut intéragir.<br />
 * Permet de regrouper les 2 panels :
 * <ul>
 *    <li>PanelInstruction</li>
 *    <li>PanelCodeGraphique</li>
 * </ul>
 *
 * @since 1.0
 * @version 1.0
 */
public class ZoneUtilisateur extends JPanel {
	private static ZoneUtilisateur instance = new ZoneUtilisateur();
	/**
	 * SINGLETON.
	 * 
	 * @since 1.0
	 */
	private ZoneUtilisateur() {
		this.setLayout(new BorderLayout());
		
		this.add(PanelInstruction.getInstance(), BorderLayout.WEST);
		this.add(PanelCodeGraphique.getInstance(), BorderLayout.CENTER);
	}
	/**
	 * SINGLETON.
	 * 
	 * @since 1.0
	 * 
	 * @return L'unique instance de ZoneUtilisateur.
	 */
	protected static ZoneUtilisateur getInstance() {
		return instance;
	}
}