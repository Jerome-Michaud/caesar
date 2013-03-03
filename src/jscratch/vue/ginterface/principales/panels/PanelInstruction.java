package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import jscratch.parametrages.properties.VariableProperties;

/**
 * Cette zone correspond à la zone où l'utilisateur peut choisir ses widgets.<br />
 * 
 * @since 1.0
 * @version 1.0
 */
public final class PanelInstruction extends JPanel {

	/**
	 * @since 1.0
	 */
	private static final PanelInstruction instance = new PanelInstruction();

	private PanelInstruction() {
		this.setLayout(new BorderLayout());

		this.setMinimumSize(new Dimension(VariableProperties.X_MAX_INSTRUCTION, 800));
		this.setPreferredSize(new Dimension(VariableProperties.X_MAX_INSTRUCTION, 800));

		this.add(PanelTypeWidget.getInstance(), BorderLayout.NORTH);
		this.add(PanelWidget.getInstance(), BorderLayout.CENTER);
	}

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelInstruction.
	 */
	public static PanelInstruction getInstance() {
		return instance;
	}
}
