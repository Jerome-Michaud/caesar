package jscratch.vue.ginterface.principales;

import jscratch.vue.ginterface.principales.panels.GlassPane;
import jscratch.vue.ginterface.principales.panels.ZoneUtilisateur;
import jscratch.vue.ginterface.principales.panels.PanelCodeConsole;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import jscratch.helpers.ImagesHelper;

/**
 * Fenêtre principale de l'application.
 *
 * @since 1.0
 * @version 1.0
 */
public final class ApplicationUI extends JFrame {

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private static final ApplicationUI instance = new ApplicationUI();
	/**
	 * @see Vue.Interface.GlassPane
	 */
	private GlassPane glassPane;
	private Dimension ecran;
	private JSplitPane split;

	private ApplicationUI() {
		this.setTitle("JScratch");
		this.setIconImage(ImagesHelper.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);


		ecran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMinimumSize(new Dimension(((int) ecran.getWidth() * 2 / 3), ((int) ecran.getHeight() * 2 / 3)));

		this.setJMenuBar(Menu.getInstance());


		this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, rootPaneCheckingEnabled, ZoneUtilisateur.getInstance(), PanelCodeConsole.getInstance());
		this.setContentPane(this.split);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				split.setDividerLocation(0.75);
			}
		});

		//Gestion du GlassPane
		this.glassPane = GlassPane.getInstance();
		this.setGlassPane(this.glassPane);
		this.glassPane.setVisible(true);

		this.setVisible(true);
		this.split.setDividerLocation(0.75);
		
		this.setLocationRelativeTo(null);
	}

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de Fenetre.
	 */
	public static ApplicationUI getInstance() {
		return instance;
	}
}