package jscratch.vue.ginterface.parametrages;

import de.javasoft.swing.JYTabbedPane;
import jscratch.vue.ginterface.parametrages.panels.PanelCategories;
import jscratch.vue.ginterface.parametrages.panels.PanelTraces;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import jscratch.vue.ginterface.parametrages.panels.PanelAutres;
import jscratch.vue.ginterface.parametrages.panels.PanelInterfaces;
import jscratch.vue.ginterface.parametrages.panels.PanelOngletsWidgets;

/**
 * L'interface de paramétrage.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class ParametrageUI extends JFrame {

	/**
	 * Unique instance of <code>TestParametrage</code>.
	 */
	private static ParametrageUI instance = null;

	/**
	 * Les onglets
	 */
	private JYTabbedPane tab = null;
	
	/**
	 * Bouton sauvegarder.
	 */
	private JButton sauvegarder = null;

	/**
	 * Private constructor of <code>TestParametrage</code>.
	 */
    private ParametrageUI() {
		this.setTitle("Configuration de JScratch");
		this.setIconImage(ImagesHelper.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		tab = new JYTabbedPane();
		tab.insertTab("Interface", null, PanelInterfaces.getInstance(), null, 0);
		tab.insertTab("Catégories", null, PanelCategories.getInstance(), null, 1);
		tab.insertTab("Widgets", null, PanelOngletsWidgets.getInstance(), null, 2);
		tab.insertTab("Autres", null, PanelAutres.getInstance(), null, 3);
		tab.insertTab("Traces", null, PanelTraces.getInstance(), null, 4);
		
		tab.setTabReorderByDraggingEnabled(false);
		
		this.sauvegarder = new JButton("Sauvegarder");
		this.sauvegarder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelInterfaces.getInstance().update();
				PanelCategories.getInstance().update();
				PanelOngletsWidgets.getInstance().update();
				PanelAutres.getInstance().update();
				PanelTraces.getInstance().update();
				
				PropertiesHelper.getInstance().sauvegarder();
			}
		});
		
		this.add(this.tab, BorderLayout.CENTER);
		this.add(this.sauvegarder, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Accessor for <code>TestParametrage</code>.
	 *
	 * @return unique instance of <code>TestParametrage</code>
	 */
    public static ParametrageUI getInstance() {
        if (instance == null) {
			instance = new ParametrageUI();
		}
		return instance;
    }
 }