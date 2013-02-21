package jscratch.traces;

import jscratch.vue.widgets.Widget;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceWidgetDeplacement extends Trace {

	/**
	 * Les widgets importants.
	 */
	private Widget widget, parentAvant, parentApres;
	private int positionParRapportParentAvant, positionParRapportParentApres;
	
	/**
	 * Constructeur par défaut de <code>TraceDeplacementWidget</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget deplacé
	 * @param parentAvant le parent avant déplacement
	 * @param parentApres le parent après déplacement
	 * @param isAjout <code>true</code> si le widget est ajouté depuis le panel instruction, <code>false</code> sinon
	 */
	public TraceWidgetDeplacement(final Widget widget, final Widget parentAvant, final Widget parentApres, final int positionParRapportParentAvant, final int positionParRapportParentApres ) {
		super(TypeTrace.WIDGET_DEPLACEMENT);
		this.widget = widget;
		this.parentAvant = parentAvant;
		this.parentApres = parentApres;
		this.positionParRapportParentAvant = positionParRapportParentAvant;
		this.positionParRapportParentApres = positionParRapportParentApres;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
				
		//ajout du widget
		thisXml.addContent(this.widget.toXml());
		
		//ajout de l'ancien parent
		if (this.parentAvant != null) {
			Element ancien = new Element(PARENTANCIEN);
			ancien.setAttribute(POSITIONPARENT, String.valueOf(this.positionParRapportParentAvant));
			ancien.addContent(this.parentAvant.toXml());
			thisXml.addContent(ancien);
		}
		
		//ajout du nouveau parent
		if (this.parentApres != null) {
			Element nouveau = new Element(PARENTNOUVEAU);
			nouveau.setAttribute(POSITIONPARENT, String.valueOf(this.positionParRapportParentApres));
			nouveau.addContent(this.parentApres.toXml());
			thisXml.addContent(nouveau);
		}
		return thisXml;
	}
}