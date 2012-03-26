package Vue.Interface;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;
import Vue.Tools.ArborescenceTools;
import Vue.Widget.Widget;
import Vue.Widget.modele.ModeleWidget;
import Vue.Widget.modele.TacheWidget;
import Vue.controller.LanceurTraduction;

public class PanelCodeConsole extends JPanel {

	private static PanelCodeConsole instance = new PanelCodeConsole();

	private PanelCodeConsole() {
		this.setMinimumSize(new Dimension(100, 600));
		this.setBorder(BorderFactory.createTitledBorder("Aperçu code console"));
		
		this.addMouseListener(LanceurTraduction.getInstance());
	}

	public static PanelCodeConsole getInstance() {
		return instance;
	}
}
