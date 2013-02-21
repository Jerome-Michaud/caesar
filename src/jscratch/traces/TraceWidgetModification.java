package jscratch.traces;

import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.Zone;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceWidgetModification extends Trace {

	/**
	 * Les widgets.
	 */
	private Widget widget, widgetContenu;
	
	/**
	 * La zone.
	 */
	private Zone zone;
	
	/**
	 * Les valeurs en chaine de caractere.
	 */
	private String valeurAvant = "", valeurApres = "";
	
	private TypeModificationWidget typeModification;
	
	/**
	 * Constructeur privé de <code>TraceWidgetModification</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param typeMod le type de modification apportée au widget
	 */
	private TraceWidgetModification(final TypeModificationWidget typeMod, final Widget widget, final Zone zone) {
		super(TypeTrace.WIDGET_MODIFICATION);
		this.typeModification = typeMod;
		this.widget = widget;
		this.zone = zone;
	}
	
	/**
	 * Constructeur de <code>TraceWidgetModification</code>, widget vers valeur.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param zone la zone
	 * @param widgetContenu le widget avant
	 * @param valeurApres la valeur après
	 */
	public TraceWidgetModification(final Widget widget, final Zone zone, final Widget widgetContenu, final String valeurApres) {
		this(TypeModificationWidget.WIDGET_VALEUR, widget, zone);
		this.widgetContenu = widgetContenu;
		this.valeurApres = valeurApres;
	}
	
	/**
	 * Constructeur de <code>TraceWidgetModification</code>, valeur vers widget.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param zone la zone
	 * @param valeurAvant valeur avant
	 * @param widgetContenu widget apres
	 */
	public TraceWidgetModification(final Widget widget, final Zone zone, final String valeurAvant, final Widget widgetContenu) {
		this(TypeModificationWidget.VALEUR_WIDGET, widget, zone);
		this.valeurAvant = valeurAvant;
		this.widgetContenu = widgetContenu;
	}
	
	/**
	 * Constructeur de <code>TraceWidgetModification</code>, valeur vers valeur.
	 * @param widget le widget
	 * @param zone la zone
	 * @param valeurAvant la valeur avant
	 * @param valeurApres la valeur après
	 */
	public TraceWidgetModification(final Widget widget, final Zone zone, final String valeurAvant, final String valeurApres) {
		this(TypeModificationWidget.VALEUR_VALEUR, widget, zone);
		this.valeurAvant = valeurAvant;
		this.valeurApres = valeurApres;
	}
	
	/**
	 * Permet de créer une balises <code>avant</code> ou <code>apres</code>.
	 * 
	 * @param titre <code>avant</code> ou <code>apres</code>
	 * @param isWidget <code>true</code> si sous element est un widget
	 * @return l'élément
	 */
	private Element creerSousElement(final String titre, final boolean isWidget) {
		Element element = new Element(titre);
		element.setAttribute(ISWIDGET, String.valueOf(isWidget));
		if (isWidget) {
			element.setAttribute(ID, "");
			element.addContent(this.widgetContenu.toXml()); 	
		}
		else if (AVANT.equals(titre)) {
			element.setText(this.valeurAvant);
		}
		else if (APRES.equals(titre)) {
			element.setText(this.valeurApres);
		}
		
		return element;
	}

	@Override
	public Element toXml() {
		Element thisXml =  super.toXml();
		if(this.widget!=null)
			thisXml.addContent(this.widget.toXml());
		

		if (this.widget != null) {
			thisXml.addContent(this.widget.toXml());
		}
		
		if (this.zone != null) {
			thisXml.addContent(this.zone.toXml());
		}
		
		thisXml.addContent(creerSousElement(AVANT, this.typeModification.isWidgetAvant()));
		thisXml.addContent(creerSousElement(APRES, this.typeModification.isWidgetApres()));
		
		return thisXml;
	}
}