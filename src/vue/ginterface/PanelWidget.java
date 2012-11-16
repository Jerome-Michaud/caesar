package vue.ginterface;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import vue.tools.Variables;
import vue.widget.FabriqueInstructions;
import vue.widget.Widget;

/**
 * Cette zone correspond à la zone où sont entreposés les widgets pour que l'utilisateur puisse les prendre.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelWidget extends JPanel {

	private static PanelWidget instance = new PanelWidget();
	private FabriqueInstructions fabrique;
	private List<Widget> lesWidgets;
        private JButton newVariableName;
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
	 * Permet de modifier la liste des widgets à afficher.
	 * 
	 * @since 1.0
	 * 
	 * @param liste La liste des widgets à afficher (suivant la catégorie active).
	 */
	public void setLesWidgets(List<Widget> liste) {
		this.removeAll();
		this.lesWidgets = liste;
		placerWidgets();
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
        this.ajouterWidget(widget,this.lesWidgets.size());
    }
    /**
     * Permet d'ajouter un widget à l'index définit.
     * 
     * @since 1.0
     * 
     * @param widget La widget à ajouter.
     * @param index L'index où ajouter le widget.
     */
    public void ajouterWidget(Widget widget,int index) {
    	this.lesWidgets.add(index,widget);
    }
    /**
     * @since 1.0
     * 
     * @param widget Le widget.
     * @return L'index du widget passé en paramètre.
     */
    public int getIndex(Widget w){
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
	private void placerWidgets() {
		int i = 1;
		int y = 30;
		
		for (Widget w : this.lesWidgets) {
			w.setDraggable(false);

			w.setLocation(15, y);
			y += w.getHeight() + 20;

			this.add(w);
			i++;
		}
	}

}
