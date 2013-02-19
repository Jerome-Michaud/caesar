package jscratch.traces;

import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceSimulateurBoutons extends Trace {

	/**
	 * L'action.
	 */
	private String action;
	
	/**
	 * Constructeur privé de <code>TraceBoutonsSimulateur</code>.
	 */
	public TraceSimulateurBoutons(final String action) {
		super(TypeTrace.SIMULATEUR_BOUTONS);
		this.action = action;
	}
	
	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
		
		thisXml.setAttribute(ACTION, this.action);
		
		return thisXml;
	}
}