package jscratch.vue.ginterface.principales;

import de.javasoft.swing.JYDockingPort;
import de.javasoft.swing.JYDockingView;
import de.javasoft.swing.jydocking.DockingManager;
import de.javasoft.swing.plaf.jydocking.DefaultMinimizeAction;
import java.awt.BorderLayout;
import jscratch.vue.ginterface.principales.panels.GlassPane;

import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
	
	private JYDockingPort viewport;
	private JYDockingView zoneCodeGraphique, zoneCodeConsole, zoneSimulateur;

	/**
	 * Constructeur privé de <code>ApplictionUI</code>.
	 */
	private ApplicationUI() {
		this.setTitle("C.A.E.S.A.R");
		this.setIconImage(ImagesHelper.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setMinimumSize(new Dimension(800, 500));
		this.setExtendedState(MAXIMIZED_BOTH);

		this.setJMenuBar(Menu.getInstance());

		add(creerDocking());

		DockingManager.setMinimized(zoneCodeConsole, true);
		DockingManager.setTabReorderByDraggingEnabled(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent evt) {
				DockingManager.unregisterDockable("zoneCodeGraphique-SimpleDocking");
				DockingManager.unregisterDockable("zoneSimulateur-SimpleDocking");
				DockingManager.unregisterDockable("zoneCodeConsole-SimpleDocking");
			}
		});

		//Gestion du GlassPane
		this.glassPane = GlassPane.getInstance();
		this.setGlassPane(this.glassPane);
		this.glassPane.setVisible(true);

		this.setVisible(true);

		this.setLocationRelativeTo(null);
	}

	/**
	 * Permet de créer la zone de <code>Docking</code>.
	 * 
	 * @since 1.0
	 */
	private JPanel creerDocking() {
		zoneCodeGraphique = creerZoneEdition();
		zoneCodeConsole = creerZoneCodeConsole();
		zoneSimulateur = creerZoneSimulation();
		
		viewport = new JYDockingPort();
		viewport.dock(zoneCodeGraphique);
		
		zoneCodeGraphique.dock(zoneCodeConsole, DockingManager.EAST_REGION, .10f);
		zoneCodeGraphique.dock(zoneSimulateur, DockingManager.CENTER_REGION, 1f);

		zoneCodeGraphique.getDockingPort().setTabPlacement(SwingConstants.BOTTOM);
		zoneCodeGraphique.getDockingPort().setSelectedTabIndex(0);
		
		JPanel p = new JPanel(new BorderLayout(0, 0));
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.add(viewport, BorderLayout.CENTER);

		return p;
	}

	/**
	 * Permet de créer la zone <code>Edition</code>.
	 * 
	 * @since 1.0
	 */
	private JYDockingView creerZoneEdition() {
		JYDockingView view = new JYDockingView("zoneCodeGraphique-SimpleDocking", "Edition", "Edition");
		view.setIcon(ImagesHelper.getIcon("code_18.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("code_18.png"));
		//view.setTerritoryBlocked(DockingManager.CENTER_REGION, true);
		view.setContentPane(GUI.getZoneUtilisateur());

		return view;
	}

	/**
	 * Permet de créer la zone <code>Simulation</code>.
	 * 
	 * @since 1.0
	 * 
	 * @return la zone de simulation
	 */
	private JYDockingView creerZoneSimulation() {
		JYDockingView view = new JYDockingView("zoneSimulateur-SimpleDocking", "Simulation", "Simulation");
		view.addAction(new DefaultMinimizeAction(view, DockingManager.LEFT));
		view.setIcon(ImagesHelper.getIcon("robot_18.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("robot_18.png"));
		//view.setTerritoryBlocked(DockingManager.CENTER_REGION, true);
		view.setContentPane(GUI.creerZoneSimulateur());

		return view;
	}
	
	/**
	 * Permet de créer la vue <code>CodeConsole</code>.
	 * 
	 * @since 1.0
	 */
	private JYDockingView creerZoneCodeConsole() {
		JYDockingView view = new JYDockingView("zoneCodeConsole-SimpleDocking", "Code console", "Code console");
		view.addAction(new DefaultMinimizeAction(view, DockingManager.RIGHT));
		view.setIcon(ImagesHelper.getIcon("cmd_18.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("cmd_18.png"));
		//view.setTerritoryBlocked(DockingManager.EAST_REGION, true);
		view.setContentPane(GUI.getPanelCodeConsole());

		return view;
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
