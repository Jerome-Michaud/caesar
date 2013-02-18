package jscratch.traces;

import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceCategorieChangement extends Trace {

	/**
	 * Les attributs de la trace.
	 */
	private String ancienne, nouvelle;
	
	/**
	 * Constructeur par défaut de <code>TraceChangementCategorie</code>.
	 */
	public TraceCategorieChangement(final String ancienne, final String nouvelle) {
		super(TypeTrace.CATEGORIE_CHANGEMENT);
		this.ancienne = ancienne;
		this.nouvelle = nouvelle;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
		
		Element avant = new Element(AVANT);
		avant.setText(this.ancienne);
		thisXml.addContent(avant);
		
		Element apres = new Element(APRES);
		apres.setText(this.nouvelle);
		thisXml.addContent(apres);
		
		return thisXml;
	}
}