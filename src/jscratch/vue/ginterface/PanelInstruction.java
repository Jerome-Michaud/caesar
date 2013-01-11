package jscratch.vue.ginterface;

import vue.tools.Variables;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Cette zone correspond à la zone où l'utilisateur peut choisir ses widgets.<br />
 * Permet de regrouper les 2 panels :
 * <ul>
 * <li>PanelTypeWidget</li>
 * <li>PanelWidget</li>
 * </ul>
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelInstruction extends JPanel {

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private static final PanelInstruction instance = new PanelInstruction();

	private PanelInstruction() {
		this.setLayout(new BorderLayout());

		this.setMinimumSize(new Dimension(Variables.X_MAX_INSTRUCTION, 800));
		this.setPreferredSize(new Dimension(Variables.X_MAX_INSTRUCTION, 800));

		this.add(PanelTypeWidget.getInstance(), BorderLayout.NORTH);
		this.add(PanelWidget.getInstance(), BorderLayout.CENTER);
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelInstruction.
	 */
	protected static PanelInstruction getInstance() {
		return instance;
	}
}
