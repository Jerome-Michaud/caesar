package jscratch.vue.ginterface.principales.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.parametrages.Variables;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.widgets.fabrique.FabriqueInstructions;
import jscratch.vue.widgets.Widget;
import nxtim.instruction.Categorie;

/**
 * Cette zone correspond à la zone où sont entreposés les widgets pour que l'utilisateur puisse les prendre.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelWidget extends JPanel implements Observer {

	private static PanelWidget instance = new PanelWidget();
	private FabriqueInstructions fabrique;
	private List<Widget> lesWidgets;
	private JTextPane texte;
		
	/**
	 * @since 1.0
	 */
	private PanelWidget() {
		this.lesWidgets = new LinkedList<Widget>();
		this.setBorder(BorderFactory.createTitledBorder("Widgets"));

		this.fabrique = new FabriqueInstructions();
		this.setLayout(null);

		this.texte = new JTextPane();
		this.texte.setBounds(10,20,Variables.X_MAX_INSTRUCTION - 20, 35);
		this.texte.setEditable(false);
		this.texte.setFocusable(false);
		this.texte.setOpaque(false);
		this.add(this.texte);
		
		this.setMinimumSize(new Dimension(Variables.X_MAX_INSTRUCTION, 600));
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (GUI.getPanelTypeWidget().getCurrentCategorie() == Categorie.VARIABLES && e.isPopupTrigger()) {
					GUI.getPopupVariable().show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * Permet de modifier le texte de la catégorie.
	 * 
	 * @param texte le nouveau texte
	 */
	public void setText(final String texte) {
		this.texte.setText(texte);
	}
	
	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelWidget getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @return La fabrique de widgets
	 */
	public FabriqueInstructions getFabrique() {
		return this.fabrique;
	}
	
	/**
	 * Permet de modifier la liste des widgets à afficher sur X colonnes.
	 *
	 * @since 1.0
	 *
	 * @param nbColonnes Le nombre de colonnes désiré
	 */
	public void setLesWidgets(final int nbColonnes) {
		this.removeAll();
		this.add(this.texte);
		this.lesWidgets = DicoWidgetsCategories.getInstance().getWidgets(GUI.getPanelTypeWidget().getCurrentCategorie(), true);
		placerWidgets(nbColonnes);
		
		this.validate();
		this.repaint();
	}

	/**
	 * Permet d'ajouter le widget à la fin de la liste.
	 *
	 * @since 1.0
	 *
	 * @param widget La widget à ajouter.
	 */
	public void ajouterWidget(Widget widget) {
		this.ajouterWidget(widget, this.lesWidgets.size());
	}

	/**
	 * Permet d'ajouter un widget à l'index définit.
	 *
	 * @since 1.0
	 *
	 * @param widget La widget à ajouter.
	 * @param index L'index où ajouter le widget.
	 */
	public void ajouterWidget(Widget widget, int index) {
		this.lesWidgets.add(index, widget);
	}

	/**
	 * @since 1.0
	 *
	 * @param widget Le widget.
	 * @return L'index du widget passé en paramètre.
	 */
	public int getIndex(Widget w) {
		return this.lesWidgets.indexOf(w);
	}

	/**
	 * @since 1.0
	 *
	 * @param widget Le widget à supprimer.
	 * @return true si le widget est correctement supprimé.
	 */
	public boolean supprimerWidget(Widget widget) {
		return this.lesWidgets.remove(widget);
	}

	/**
	 * Permet de placer les widgets.
	 *
	 * @since 1.0
	 */
	private void placerWidgets(final int colonnes) {
		int i = 1;
		int maxW = 0;
		int x = 15;
		int yDefaut = 55;
		int y = yDefaut;

		for (Widget w : this.lesWidgets) {
			w.setDraggable(false);
			
			if (maxW < w.getWidth()) {
				maxW = w.getWidth();
			}
			
			if (this.lesWidgets.size() > 5 && i == this.lesWidgets.size()/colonnes + 1) {
				x += maxW + 20;
				y = yDefaut;
			}
			
			w.setLocation(x, y);
			y += w.getHeight() + 20;
			
			this.add(w);
			i++;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		validate();
	}
}