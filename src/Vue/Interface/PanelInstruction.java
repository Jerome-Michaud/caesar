package Vue.Interface;

import Vue.Tools.Variables;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PanelInstruction extends JPanel {
	private static final PanelInstruction instance = new PanelInstruction();

	private PanelInstruction() {
		this.setLayout(new BorderLayout());

		this.setMinimumSize(new Dimension(Variables.X_MAX_INSTRUCTION, 800));
		this.setPreferredSize(new Dimension(Variables.X_MAX_INSTRUCTION, 800));

		this.add(PanelTypeWidget.getInstance(), BorderLayout.NORTH);
		this.add(PanelWidget.getInstance(), BorderLayout.CENTER);
	}

	public static PanelInstruction getInstance() {
		return instance;
	}
}
