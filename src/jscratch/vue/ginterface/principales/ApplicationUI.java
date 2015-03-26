/*
Copyright (C) Université du Maine (2013)

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier.

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant
donné sa spécificité de logiciel libre, qui peut le rendre complexe à
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement,
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.vue.ginterface.principales;

import editeurNXC.ui.EditorUI;
import de.javasoft.plaf.synthetica.SyntheticaRootPaneUI;
import de.javasoft.swing.JYDockingPort;
import de.javasoft.swing.JYDockingView;
import de.javasoft.swing.jydocking.DockingManager;
import de.javasoft.swing.jydocking.IDockingConstants;
import de.javasoft.swing.plaf.jydocking.DefaultCloseAction;
import de.javasoft.swing.plaf.jydocking.DefaultFloatAction;
import de.javasoft.swing.plaf.jydocking.DefaultMaximizeAction;
import de.javasoft.swing.plaf.jydocking.DefaultMinimizeAction;
import java.awt.BorderLayout;
import java.awt.Desktop;
import jscratch.vue.ginterface.principales.panels.GlassPane;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.text.DefaultEditorKit;
import jdk.internal.dynalink.DefaultBootstrapper;

import jscratch.dictionnaires.DicoVariables;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.LangueHelper;
import jscratch.helpers.SessionHelper;
import jscratch.parametrages.langue.VariableLangue;
import jscratch.vue.arborescence.actions.Action;

/**
 * Fenêtre principale de l'application.
 */
public final class ApplicationUI extends JFrame {

	/**
	 * SINGLETON.
	 */
	private static ApplicationUI instance = null;
	/**
	 * Le <code>GlassPane</code>.
	 *
	 * @see GlassPane
	 */
	private GlassPane glassPane;
	/**
	 * Le <code>DockingPort</code>.
	 */
	private JYDockingPort viewport;
	/**
	 * Les différents
	 * <code>DockingView</code>.
	 */
	private JYDockingView zoneCodeGraphique, zoneCodeNXC, zoneCodeConsole, zoneSimulateur,zoneCompilateur;
	/**
	 * Le dictionnaire de variables partagée dans toute l'application.
	 */
	private DicoVariables dicoVariables;

	/**
	 * Constructeur privé de
	 * <code>ApplicationUI</code>.
	 */
	private ApplicationUI() {
		this.dicoVariables = new DicoVariables();
		this.setTitle("C.A.E.S.A.R");
		this.setIconImage(ImagesHelper.getImage("icone.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		if (this.getRootPane().getUI() instanceof SyntheticaRootPaneUI) {
			((SyntheticaRootPaneUI) this.getRootPane().getUI()).setMaximizedBounds(this);
		}

		this.setMinimumSize(new Dimension(800, 500));
		if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
			this.setExtendedState(MAXIMIZED_BOTH);
		} else {
			Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
			this.setSize((int) (tailleEcran.getWidth() * 0.7), (int) (tailleEcran.getHeight() * 0.7));
		}

		this.setJMenuBar(Menu.getInstance());

		add(creerDocking(),BorderLayout.CENTER);
		
		DockingManager.setMinimized(zoneCompilateur, true, DockingManager.RIGHT);
		DockingManager.setTabReorderByDraggingEnabled(false);
				
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DockingManager.unregisterDockable("zoneCodeGraphique-SimpleDocking");
				DockingManager.unregisterDockable("zoneCodeNXC-SimpleDocking");
				DockingManager.unregisterDockable("zoneSimulateur-SimpleDocking");
				DockingManager.unregisterDockable("zoneCodeConsole-SimpleDocking");
				DockingManager.unregisterDockable("zoneCompilateur-SimpleDocking");
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

	public JYDockingView getViewport() {
		return zoneCodeGraphique;
	}
	
	public void goToZoneOutput() {
		zoneCodeConsole.setTitle(LangueHelper.getInstance().get(VariableLangue.DOCK_OUTPUT));
		zoneCodeConsole.setIcon(ImagesHelper.getIcon("warning.png"));
		zoneCodeConsole.setDockbarIcon(ImagesHelper.getIcon("warning.png"));
	}
	
	public void goToZoneCodeConsole() {
		zoneCodeConsole.setTitle(LangueHelper.getInstance().get(VariableLangue.DOCK_CODE));
		zoneCodeConsole.setIcon(ImagesHelper.getIcon("document-code.png"));
		zoneCodeConsole.setDockbarIcon(ImagesHelper.getIcon("document-code.png"));
	}

	public DicoVariables getDicoVariables() {
		return dicoVariables;
	}

	/**
	 * Permet de créer la zone de
	 * <code>Docking</code>.
	 *
	 * @since 1.0
	 */
	private JPanel creerDocking() {
		zoneCodeGraphique = creerZoneEditionGraphique();
		zoneCodeNXC = creerZoneEditionCode();
		zoneCodeConsole = creerZoneCodeConsole();
		zoneSimulateur = creerZoneSimulation();
		zoneCompilateur = creerZoneCompilateur();
		viewport = new JYDockingPort();
		viewport.dock(zoneCodeGraphique, IDockingConstants.CENTER_REGION);

		zoneCodeGraphique.dock(zoneCodeConsole, IDockingConstants.EAST_REGION, .8f);

		zoneCodeGraphique.dock(zoneCodeNXC, IDockingConstants.CENTER_REGION, 1f);
		zoneCodeGraphique.dock(zoneSimulateur, IDockingConstants.CENTER_REGION, 1f);

		zoneCodeConsole.dock(zoneCompilateur, IDockingConstants.SOUTH_REGION, .7f);
			
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
	private JYDockingView creerZoneEditionGraphique() {
		String titre = LangueHelper.getInstance().get(VariableLangue.DOCK_ED_GRAPH);
		JYDockingView view = new JYDockingView("zoneCodeGraphique-SimpleDocking", titre, titre);
		view.addAction(new DefaultMaximizeAction(view));
		view.setIcon(ImagesHelper.getIcon("document-code-graph.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("document-code-graph.png"));
		view.setContentPane(GUI.getZoneUtilisateur());
		view.setDraggingEnabled(false);
		return view;
	}

	/**
	 * Permet de créer la zone <code>Edition code</code>.
	 *
	 * @since 1.0
	 */
	private JYDockingView creerZoneEditionCode() {
		String titre = LangueHelper.getInstance().get(VariableLangue.DOCK_ED_CODE);
		JYDockingView view = new JYDockingView("zoneCodeNXC-SimpleDocking", titre, titre);
		view.addAction(new DefaultMaximizeAction(view));
		view.setIcon(ImagesHelper.getIcon("document-code.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("document-code.png"));
		view.setContentPane(EditorUI.getInstance());
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
		String titre = LangueHelper.getInstance().get(VariableLangue.DOCK_SIM);
		JYDockingView view = new JYDockingView("zoneSimulateur-SimpleDocking", titre, titre);
		view.addAction(new DefaultMaximizeAction(view));
		view.addAction(new DefaultFloatAction(view));
		view.setIcon(ImagesHelper.getIcon("robot.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("robot.png"));
		view.setContentPane(GUI.creerZoneSimulateur());
		view.setDraggingEnabled(false);
		view.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorAdded(AncestorEvent event) {
				if ((SwingUtilities.windowForComponent(event.getComponent())) instanceof JDialog) {
					((JDialog) (SwingUtilities.windowForComponent(event.getComponent()))).addComponentListener(new ComponentAdapter() {

						@Override
						public void componentHidden(ComponentEvent e) {
							zoneCodeGraphique.dock(zoneSimulateur, IDockingConstants.CENTER_REGION, .7f);
						}

					});
				}
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
			}
		});
		return view;
	}

	/**
	 * Permet de créer la vue
	 * <code>CodeConsole</code>.
	 *
	 * @since 1.0
	 */
	private JYDockingView creerZoneCodeConsole() {
		String titre = LangueHelper.getInstance().get(VariableLangue.DOCK_CODE);
		JYDockingView view = new JYDockingView("zoneCodeConsole-SimpleDocking", titre, titre);
		view.setIcon(ImagesHelper.getIcon("document-code.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("document-code.png"));
		view.setContentPane(new JScrollPane(GUI.getPanelCodeConsole()));
		view.setDraggingEnabled(true);
		return view;
	}

	/**
	 * Permet de créer la zone simulateur
	 * <code>CodeConsole</code>.
	 *
	 * @since 1.0
	 */
	private JYDockingView creerZoneCompilateur() {
		String titre = LangueHelper.getInstance().get(VariableLangue.DOCK_COMP);
		JYDockingView view = new JYDockingView("zoneCompilateur-SimpleDocking", titre, titre);
		view.addAction(new DefaultMinimizeAction(view));
		view.setIcon(ImagesHelper.getIcon("terminal.png"));
		view.setDockbarIcon(ImagesHelper.getIcon("terminal.png"));
		view.setContentPane(GUI.getPanelCompilateur());
		view.setDraggingEnabled(true);
		return view;
	}

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de Fenetre.
	 */
	public static synchronized ApplicationUI getInstance() {
		if (instance == null) {
			instance = new ApplicationUI();
		}
		return instance;
	}
}
