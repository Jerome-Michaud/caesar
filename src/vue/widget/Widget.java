package vue.widget;

import vue.ginterface.GlassPane;
import vue.ginterface.PanelCodeGraphique;
import vue.ginterface.PanelWidget;
import vue.tools.DragAndDropTools;
import vue.widget.modele.ModeleWidget;
import vue.widget.modele.zones.Zone;
import instruction.IElementProgramme;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

import modeles.TypeWidget;
/**
 * Classe représentant graphiquement un widget.
 *
 * @author Bastien Andru - Vincent Besnard - Quentin Gosselin
 */
public class Widget extends JComponent {
	/**
	 * Ratio à partir duquel, si on dépose un widget à
	 * cheval entre le panelInstruction et le PanelCodeGraphique, on peut
	 * choisir soit de déplacer un widget pour qu'il soit entièrement sur le
	 * PanelCodeGraphique, ou bien le supprimer.
	 */
    public static final float TAUX_TRANSFERT_PANEL = (float) 0.6;
    /**
     * Point au sein du widget en cours de draggage où a eu lieu le click d'origine.
     */
    private Point ptClick;
    /**
     * Valeur booléenne permettant de savoir si un widget peut être dragué ou non.
     */
    private boolean draggable = false;
    /**
     * Modèle du widget.
     */
    private ModeleWidget modele;
    /**
     * Police de caractères utilisée par le widget.
     */
    private Font font;
    /**
     * Le parent du Widget. Il peut être soit un composant complexe,
     * soit le PanelCodeGraphique, soit null quand le Widget est en cours de draggage.
     */
    private IWidget parent;
    /**
     * Redéfinition dela méthode PaintCompnent afin de permettre de dessiner la
     * forme customisée du Widget.
     *
     * @param g L'objet Graphics d'appel
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(this.modele.getCouleur());
        g2d.fillPolygon(this.modele.getForme());
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(this.modele.getForme());
        g2d.setColor(Color.WHITE);
        for (Point p : this.modele.getMessage().keySet()) {
			if (this.modele.isConditionHaute()) {
				g2d.drawString(this.modele.getMessage().get(p), p.x, p.y);
			}
			else {
				g2d.drawString(this.modele.getMessage().get(p), p.x, this.getHeight() - p.y);
			}
		}
        super.paintComponent(g);
    }
    /**
     * Constructeur du Widget initialisant toutes les propriétés du Widget
     *
     * @param modele Le modèle de structure à appliquer au Widget
     */
    public Widget(ModeleWidget modele) {
        this.font = new Font("TimesRoman ", Font.PLAIN, 12);
        this.modele = modele;
        this.setFont(this.font);
        this.setFocusable(true);
        this.setOpaque(true);
        this.setForme(true);

        initListeners();

		for(Zone z : this.modele.getLesZonesSaisies()) {
			this.add((JComponent) z);
		}
        
        this.parent = null;
    }
    /**
     * Méthode permettant de repeindre le widget, mais aussi le
     * PanelCodeGraphique et le GlassPane
     */
    private void repaintAll(MouseEvent e) {
        PanelWidget.getInstance().repaint();
        PanelCodeGraphique.getInstance().repaint();
        GlassPane.getInstance().repaint();
    }
    /**
     * Méthode permettant de définir la forme du widget et de calculer ses
     * nouvelles dimensions et localisations.
     *
     * @param setLocation Permet de choisir si il faut également redéfinir la localisation du widget
     */
    public void setForme(boolean setLocation) {
        int maxX = 0;
        for (Integer i : this.modele.getForme().xpoints) {
            maxX = Math.max(maxX, i);
        }

        int maxY = 0;
        for (Integer i : this.modele.getForme().ypoints) {
            maxY = Math.max(maxY, i);
        }

		if (setLocation) {
			this.setBounds(0, 0, maxX + 1, maxY + 1);
		}
		else {
			this.setSize(maxX + 1, maxY + 1);
		}
        this.setPreferredSize(new Dimension(maxX, maxY));
    }
    /**
	 * Méthode d'initialisation des listeners du widget (click, drag et drop)
	 */
    public void initListeners() {
        this.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                DragAndDropTools.getInstance().clickWidget((Widget) e.getComponent(), e.getPoint());
                repaintAll(e);
            }

            public void mouseReleased(MouseEvent e) {
                DragAndDropTools.getInstance().dropWidget();
            }
        });
		
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                DragAndDropTools.getInstance().dragWidget((Widget) e.getComponent());
            }
        });
    }
    /**
     * Permet de récupérer le modèle du widget.
     *
     * @return Le modèle du Widget
     */
    public ModeleWidget getModele() {
        return this.modele;
    }
    /**
     * Permet de savoir si le widget est draggable.
     *
     * @return true si le composant est draggable, false sinon.
     */
    public boolean isDraggable() {
        return this.draggable;
    }
    /**
     * Définie si un composant est draggable.
     *
     * @param draggable La valeur définissant si le composant sera draggable ou non
     */
    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }
    /**
     * Méthode permettant de définir le point où a eu lieu le click au sein du widget.
     * @param ptClick Le point de click sur le widget
     */
    public void setPtClick(Point ptClick) {
        this.ptClick = ptClick;
    }
    /**
     * Méthode permettant de récupérer le point où a eu lieu le click sur le widget.
     *
     * @return Le point où a eu lieu le click au sein du widget
     */
    public Point getPtClick() {
        return this.ptClick;
    }
    /**
     * Méthode permettant de savoir si un composant est complexe ou non.
     * @return true si le composant est complexe, false dans le cas contraire.
     */
    public boolean isComplexe() {
        return false;
    }
    /**
     * Méthode permettant de récupérer le parent du composant au sein de l'arborescence.
     * @return Le parent du Widget au sein de l'arborescence.
     */
    public IWidget parent() {
        return parent;
    }
    /**
     * Méthode permettant de définir le parent du Widget. Ce parent peut être
     * soit le PanelCodeGraphique, soit un composant Complexe, soit null si le
     * composant est un cours de draggage.
     *
     * @param parent Le nouveau parent du Widget
     */
    public void defParent(IWidget parent) {
        this.parent = parent;
    }
    /**
     * Méthode permettant de recupérer le type du Widget au sein de son modèle.
     * @return Le type du modèle du Widget
     */
    public TypeWidget getType() {
        return this.modele.getType();
    }
    /**
     * Méthode permettant de récupérer l'element de programme du widget au sein de son modèle
     * @return L'élement de programme du modèle du widget
     */
	public IElementProgramme getElementProgramme() {
		return this.modele.getElementProgramme();
	}
	
	public void applyChangeModele() {}
}