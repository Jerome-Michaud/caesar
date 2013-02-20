package jscratch.vue.ginterface.principales;

import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaRootPaneUI;
import de.javasoft.swing.JYDockingPort;
import de.javasoft.swing.JYDockingView;
import de.javasoft.swing.jydocking.DockingManager;
import de.javasoft.swing.jydocking.IDockingConstants;
import de.javasoft.swing.plaf.jydocking.DefaultFloatAction;
import de.javasoft.swing.plaf.jydocking.DefaultMaximizeAction;
import java.awt.BorderLayout;
import jscratch.vue.ginterface.principales.panels.GlassPane;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jscratch.helpers.ImagesHelper;
import jscratch.helpers.SessionHelper;

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
	private static ApplicationUI instance = null;
	/**
	 * Le
	 * <code>GlassPane</code>.
	 *
	 * @see Vue.Interface.GlassPane
	 */
	private GlassPane glassPane;
	/**
	 * Le
	 * <code>DockingPort</code>.
	 */
	private JYDockingPort viewport;
	/**
	 * Les différents
	 * <code>DockingView</code>.
	 */
	private JYDockingView zoneCodeGraphique, zoneCodeConsole, zoneSimulateur;

	/**
	 * Constructeur privé de
	 * <code>ApplicationUI</code>.
	 */
	private ApplicationUI() {
		SyntheticaLookAndFeel.setWindowsDecorated(false);
		this.setTitle("C.A.E.S.A.R");
		this.setIconImage(ImagesHelper.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		if (this.getRootPane().getUI() instanceof SyntheticaRootPaneUI) {
			((SyntheticaRootPaneUI) this.getRootPane().getUI()).setMaximizedBounds(this);
		}

		this.setMinimumSize(new Dimension(800, 500));
		if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
			this.setExtendedState(MAXIMIZED_BOTH);
		}else{
			
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(tailleEcran.getWidth() * 0.7),(int)(tailleEcran.getHeight() * 0.7));
		}

		this.setJMenuBar(Menu.getInstance());

		add(creerDocking());

		DockingManager.setTabReorderByDraggingEnabled(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DockingManager.unregisterDockable("zoneCodeGraphique-SimpleDocking");
				DockingManager.unregisterDockable("zoneSimulateur-SimpleDocking");
				DockingManager.unregisterDockable("zoneCodeConsole-SimpleDocking");
				
				SessionHelper.quitter();
			}
		});

		//Gestion du GlassPane
		this.glassPane = GlassPane.getInstance();
		this.setGlassPane(this.glassPane);
		this.glassPane.setVisible(true);

		this.setVisible(true);

		this.setLocationRelativeTo(null);
	}

	public JYDockingPort getViewport() {
		return viewport;
	}

	/**
	 * Permet de créer la zone de
	 * <code>Docking</code>.
	 *
	 * @since 1.0
	 */
	private JPanel creerDocking() {
		zoneCodeGraphique = creerZoneEdition();
		zoneCodeConsole = creerZoneCodeConsole();
		zoneSimulateur = creerZoneSimulation();

		viewport = new JYDockingPort();
		viewport.dock(zoneCodeGraphique, IDockingConstants.CENTER_REGION);

		zoneCodeGraphique.dock(zoneCodeConsole, IDockingConstants.EAST_REGION, .8f);
		zoneCodeGraphique.dock(zoneSimulateur, IDockingConstants.CENTER_REGION, .7f);

		zoneCodeGraphique.getDockingPort().setTabPlacement(SwingConstants.BOTTOM);
		zoneCodeGraphique.getDockingPort().setSelectedTabIndex(0);

		JPanel p = new JPanel(new BorderLayout(0, 0));
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.add(viewport, BorderLayout.CENTER);

		return p;
	}

	/**
	 * Permet de créer la zone
	 * <code>Edition</code>.
	 *
	 * @since 1.0
	 */
	private JYDockingView creerZoneEdition() {
		JYDockingView view = new JYDockingView("zoneCodeGraphique-SimpleDocking", "Edition", "Edition");
		view.addAction(new DefaultMaximizeAction(view));
		view.setIcon(ImagesHelper.getIcon("document-code-graph.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("document-code-graph.png"));
		view.setContentPane(GUI.getZoneUtilisateur());
		view.setDraggingEnabled(false);
		return view;
	}

	/**
	 * Permet de créer la zone
	 * <code>Simulation</code>.
	 *
	 * @since 1.0
	 *
	 * @return la zone de simulation
	 */
	private JYDockingView creerZoneSimulation() {
		JYDockingView view = new JYDockingView("zoneSimulateur-SimpleDocking", "Simulation", "Simulation");
		view.addAction(new DefaultMaximizeAction(view));
		view.addAction(new DefaultFloatAction(view));
		view.setIcon(ImagesHelper.getIcon("robot.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("robot.png"));
		view.setContentPane(GUI.creerZoneSimulateur());
		view.setDraggingEnabled(false);
		return view;
	}

	/**
	 * Permet de créer la vue
	 * <code>CodeConsole</code>.
	 *
	 * @since 1.0
	 */
	private JYDockingView creerZoneCodeConsole() {
		JYDockingView view = new JYDockingView("zoneCodeConsole-SimpleDocking", "Code console", "Code console");
		view.setIcon(ImagesHelper.getIcon("document-code.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("document-code.png"));
		view.setContentPane(GUI.getPanelCodeConsole());
		view.setDraggingEnabled(false);
		return view;
	}

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de Fenetre.
	 */
	public static ApplicationUI getInstance() {
		if (instance == null) {
			instance = new ApplicationUI();
		}
		return instance;
	}
}
