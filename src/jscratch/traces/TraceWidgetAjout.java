package jscratch.traces;

import jscratch.vue.widgets.Widget;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceWidgetAjout extends Trace {

	/**
	 * Les widgets importants.
	 */
	private Widget widget, parent;
	private int  positionParRapportParent;
	
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
	public TraceWidgetAjout(final Widget widget, final Widget parentApres, final int positionParRapportParent) {
		super(TypeTrace.WIDGET_AJOUT);
		this.widget = widget;
		this.parent = parentApres;
		this.positionParRapportParent=positionParRapportParent;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
				
		//ajout du widget
		thisXml.addContent(this.widget.toXml());
				
		//ajout du nouveau parent
		if (this.parent != null) {
			Element nouveau = new Element(PARENTNOUVEAU);
			nouveau.setAttribute(POSITIONPARENT, String.valueOf(positionParRapportParent));
			nouveau.addContent(this.parent.toXml());
			thisXml.addContent(nouveau);
		}
		return thisXml;
	}
}