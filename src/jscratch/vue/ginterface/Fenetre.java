package jscratch.vue.ginterface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import jscratch.ressources.ResourceTools;

/**
 * Fenêtre principale de l'application.
 *
 * @since 1.0
 * @version 1.0
 */
public class Fenetre extends JFrame {

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private static final Fenetre instance = new Fenetre();
	/**
	 * @see Vue.Interface.GlassPane
	 */
	private GlassPane glassPane;
	private Dimension ecran;
	private JSplitPane split;

	private Fenetre() {
		this.setTitle("JScratch");
		this.setIconImage(ResourceTools.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				split.setDividerLocation(0.75);
			}
		});

		ecran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMinimumSize(new Dimension(((int) ecran.getWidth() * 2 / 3), ((int) ecran.getHeight() * 2 / 3)));

		this.setJMenuBar(Menu.getInstance());


		this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, rootPaneCheckingEnabled, ZoneUtilisateur.getInstance(), PanelCodeConsole.getInstance());
		this.setContentPane(this.split);


		//Gestion du GlassPane
		this.glassPane = GlassPane.getInstance();
		this.setGlassPane(this.glassPane);
		this.glassPane.setVisible(true);

		this.setVisible(true);
		this.split.setDividerLocation(0.75);
		
		this.setLocationRelativeTo(null);
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de Fenetre.
	 */
	protected static Fenetre getInstance() {
		return instance;
	}
}