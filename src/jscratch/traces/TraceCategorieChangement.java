package jscratch.traces;

import nxtim.instruction.Categorie;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceCategorieChangement extends Trace {

	/**
	 * Les attributs de la trace.
	 */
	private Categorie ancienne, nouvelle;
	
	/**
	 * Constructeur par défaut de <code>TraceChangementCategorie</code>.
	 */
	public TraceCategorieChangement(final Categorie ancienne, final Categorie nouvelle) {
		super(TypeTrace.CATEGORIE_CHANGEMENT);
		this.ancienne = ancienne;
		this.nouvelle = nouvelle;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
		
		if (this.ancienne != null) {
			Element avant = new Element(AVANT);
			avant.setText(this.ancienne.toString());
			thisXml.addContent(avant);
		}
		
		Element apres = new Element(APRES);
		apres.setText(this.nouvelle.toString());
		thisXml.addContent(apres);
		
		return thisXml;
	}
}