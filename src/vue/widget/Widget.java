package vue.widget;

import vue.tools.DragAndDropTools;
import vue.widget.modele.ModeleWidget;
import vue.widget.modele.zones.Zone;
import instruction.IElementProgramme;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

import modeles.TypeWidget;
import org.jdom2.Attribute;
import org.jdom2.Element;

/**
 * Classe représentant graphiquement un widget.
 */
public class Widget extends JComponent {
	/**
	 * Ratio à partir duquel, si on dépose un widget à cheval entre le <code>PanelInstruction</code> et le <code>PanelCodeGraphique</code>,
	 * on peut choisir soit de déplacer un widget pour qu'il soit entièrement sur le PanelCodeGraphique, ou bien le supprimer.
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
	 * Le parent du Widget.<br/>
	 * Il peut être soit un composant complexe, soit le PanelCodeGraphique, soit <code>null</code> quand le Widget est en cours de draggage.
	 */
	private IWidget parent;

	
	@Override
	public void paintComponent(final Graphics g) {
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
	 * Constructeur du Widget initialisant toutes les propriétés du Widget.
	 *
	 * @param modele le modèle de structure à appliquer au Widget
	 */
	public Widget(final ModeleWidget modele) {
		this.font = new Font("TimesRoman ", Font.PLAIN, 12);
		this.modele = modele;
		this.setFont(this.font);
		this.setFocusable(true);
		this.setOpaque(true);
		this.setForme(true);
		
                
		initListeners();

		for (Zone z : this.modele.getLesZonesSaisies()) {
			this.add((JComponent) z);
		}
        
        this.parent = null;
    }

	
    /**
     * Méthode permettant de définir la forme du widget et de calculer ses
     * nouvelles dimensions et localisations.
     *
     * @param setLocation Permet de choisir si il faut également redéfinir la localisation du widget
     */
    public void setForme(final boolean setLocation) {
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
	 * Méthode d'initialisation des listeners du widget (click, drag et drop).
	 */
	public void initListeners() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(final MouseEvent e) {
				DragAndDropTools.getInstance().clickWidget((Widget) e.getComponent(), e.getPoint());
			}

			@Override
			public void mouseReleased(final MouseEvent e) {
				DragAndDropTools.getInstance().dropWidget();
			}
		});

		this.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(final MouseEvent e) {
				DragAndDropTools.getInstance().dragWidget((Widget) e.getComponent());
			}
		});
	}

	/**
	 * Permet de récupérer le modèle du widget.
	 *
	 * @return le modèle du Widget
	 */
	public ModeleWidget getModele() {
		return this.modele;
	}

	/**
	 * Permet de savoir si le widget est draggable.
	 *
	 * @return <code>true</code> si le composant est draggable, sinon <code>false</code>
	 */
	public boolean isDraggable() {
		return this.draggable;
	}

	/**
	 * Définie si un composant est draggable.
	 *
	 * @param draggable la valeur définissant si le composant sera draggable ou non
	 */
	public void setDraggable(final boolean draggable) {
		this.draggable = draggable;
	}

	/**
	 * Méthode permettant de définir le point où a eu lieu le click au sein du widget.
	 *
	 * @param ptClick le point de click sur le widget
	 */
	public void setPtClick(final Point ptClick) {
		this.ptClick = ptClick;
	}

	/**
	 * Méthode permettant de récupérer le point où a eu lieu le click sur le widget.
	 *
	 * @return le point où a eu lieu le click au sein du widget
	 */
	public Point getPtClick() {
		return this.ptClick;
	}

	/**
	 * Méthode permettant de savoir si un composant est complexe ou non.
	 *
	 * @return <code>true</code> si le composant est complexe, <code>false</code> dans le cas contraire
	 */
	public boolean isComplexe() {
		return false;
	}

	/**
	 * Méthode permettant de récupérer le parent du composant au sein de l'arborescence.
	 *
	 * @return le parent du Widget au sein de l'arborescence
	 */
	public IWidget parent() {
		return parent;
	}

	/**
	 * Méthode permettant de définir le parent du Widget.<br/>
	 * Ce parent peut être soit :
	 * <ul>
	 * <li>le PanelCodeGraphique</li>
	 * <li>un composant Complexe</li>
	 * <li><code>null</code> si le composant est un cours de draggage</li>
	 * </ul>
	 *
	 * @param parent le nouveau parent du Widget
	 */
	public void defParent(final IWidget parent) {
		this.parent = parent;
	}

	/**
	 * Méthode permettant de récupérer le type du Widget au sein de son modèle.
	 *
	 * @return le type du modèle du Widget
	 */
	public TypeWidget getType() {
		return this.modele.getType();
	}

	/**
	 * Méthode permettant de récupérer l'élément de programme du widget au sein de son modèle.
	 *
	 * @return l'élément de programme du modèle du widget
	 */
	public IElementProgramme getElementProgramme() {
		return this.modele.getElementProgramme();
	}

	/**
	 * Met à jour l'arborescence des instructions.
	 */
	public void applyChangeModele() { }
	
	/**
	 * Permet d'avoir comment le widget doit se sérialiser.
	 */
	public Element toXml() {
		Element widget = new Element("widget");
		widget.setAttribute(new Attribute("class", this.modele.getClass().getSimpleName()));
		
		Element coordonnees = new Element("coordonnees");
		coordonnees.setAttribute(new Attribute("x", String.valueOf(this.getLocation().x)));
		coordonnees.setAttribute(new Attribute("y", String.valueOf(this.getLocation().y)));
		widget.addContent(coordonnees);
		
		// Gestion des zones du widget (valeurs, variables, ...)
		if (this.modele.getLesZonesSaisies().size() > 0) {
			Element attribut = new Element("attributs");
			
			int i = 0;
			for (Zone z : this.modele.getLesZonesSaisies()) {
				Element zone = new Element("zone");
				zone.setAttribute(new Attribute("id", String.valueOf(i)));
				i++;
				zone.setAttribute(new Attribute("value", String.valueOf(z.getValeur())));
				attribut.addContent(zone);
			}
			widget.addContent(attribut);
		}
		return widget;
	}
}
