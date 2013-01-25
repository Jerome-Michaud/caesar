package jscratch.vue.ginterface;

import java.awt.Component;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import jscratch.modeles.DicoWidgetsCategories;
import jscratch.vue.tools.Variables;
import jscratch.vue.widget.fabrique.FabriqueInstructions;
import jscratch.vue.widget.Widget;

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

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private PanelWidget() {
		this.lesWidgets = new LinkedList<Widget>();
		this.setBorder(BorderFactory.createTitledBorder("Instructions"));

		this.fabrique = new FabriqueInstructions();
		this.setLayout(null);

		this.setMinimumSize(new Dimension(Variables.X_MAX_INSTRUCTION, 600));
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	protected static PanelWidget getInstance() {
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
		this.lesWidgets = DicoWidgetsCategories.getInstance().getWidgets(GUI.getPanelTypeWidget().getCurrentCategorie());
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
		int y = 30;

		for (Widget w : this.lesWidgets) {
			w.setDraggable(false);
			
			if (maxW < w.getWidth()) {
				maxW = w.getWidth();
			}
			
			if (this.lesWidgets.size() > 5 && i == this.lesWidgets.size()/colonnes + 1) {
				x += maxW + 20;
				y = 30;
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