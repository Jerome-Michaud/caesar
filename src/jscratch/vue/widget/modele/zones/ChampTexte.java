package jscratch.vue.widget.modele.zones;

import java.awt.BorderLayout;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jscratch.vue.controller.LanceurTraduction;
import jscratch.vue.widget.modele.TypeModeleWidget;
import org.jdom2.Element;
import jscratch.vue.widget.Widget;
import nxtim.instruction.IElementProgramme;
import nxtim.instruction.VariableConstante;

/**
 * Cette classe représente un champ texte particulier intégrable dans un widget.
 */
public class ChampTexte extends JPanel implements Zone {

	private Widget widgetContenu;
	private JTextField textField;
	private List<TypeModeleWidget> typesWidgetsAcceptes;
	
	/*
	 * Etat à 0 quand on affiche uniquement le champ texte
	 * Etat à 1 quand on affiche les widgets contenus
	 */
	int etat;

	/**
	 * Constructeur faisant appel au constructeur équivalent de la classe mère.
	 */
	public ChampTexte() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.textField = new JTextField();
		this.widgetContenu = null;
		this.add(textField, BorderLayout.CENTER);
		this.etat = 0;

		this.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				composantSupp(e);
			}
		});

		this.typesWidgetsAcceptes = new LinkedList<TypeModeleWidget>();

		this.validate();
	}
	
	private void composantSupp(ContainerEvent e) {
		if (e.getChild() == widgetContenu && e.getComponent() == this) {
			setWidgetContenu(null);
		}
	}

	public boolean ajouterTypeWidgetAccepte(TypeModeleWidget type) {
		return this.typesWidgetsAcceptes.add(type);
	}

	public boolean accepteTypeWidget(TypeModeleWidget type) {
		return this.typesWidgetsAcceptes.contains(type);
	}

	/**
	 * Recupère la valeur actuelle du champ texte.
	 *
	 * Deux cas possibles:
	 * Soit le champ texte ne contient pas de widget et on retourne la valeur du champ texte
	 * Soit le champ texte contient un widget, auquel cas on retourne le nom de la variable.
	 *
	 * @return la valeur du champ texte.
	 */
	@Override
	public String getValeur() {
		if (etat == 0) {
			return this.textField.getText();
		} else if (etat == 1) {
			return "";
		} else {
			return "";
		}
	}

	/**
	 * Modifie le texte du champ texte.
	 *
	 * @param v le nouveau texte du champ.
	 */
	@Override
	public void setValeur(String v) {
		if (etat == 0) {
			this.textField.setText(v);
		}
	}

	public void setWidgetContenu(Widget w) {
		this.removeAll();
		int oldW = this.getWidth();
		if (w == null) {
			this.etat = 0;
			this.setComponent(textField);
		} else {
			this.etat = 1;
			this.textField.setSize(this.getSize());
			this.setComponent(w);
		}
		Widget parent = ((Widget) (this.getParent()));
		int decal = this.getWidth() - oldW;
		parent.getModele().decalageX(decal);
		parent.setForme(false);
		parent.getModele().decalerComposantsSuivants(this.getX(), decal);
		
		this.widgetContenu = w;
	}

	private void setComponent(JComponent comp) {
		this.setSize(comp.getSize());
		this.add(comp, BorderLayout.CENTER);
	}
	
	@Override
	public int getEtat() {
		return this.etat;
	}
	
	/**
	 * Empêche la zone de prendre du texte. La seule chose possible est de mettre un widget dedans.
	 */
	public void supprimerTexte() {
		this.textField.setEditable(false);
		this.textField.setEnabled(false);
	}

	@Override
	public Element toXml() {
		Element zone = new Element("zone");
		zone.setAttribute("isWidget", String.valueOf(this.etat == 1));

		if (this.etat == 0) {
			zone.setAttribute("valeur", this.getValeur());
		} else if (this.etat == 1) {
			zone.addContent(this.widgetContenu.toXml());
		}
		return zone;
	}

	@Override
	public int getPositionX() {
		return this.getX();
	}

	@Override
	public void setPositionX(int posX) {
		this.setLocation(posX, this.getY());
	}
}