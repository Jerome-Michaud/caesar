package jscratch.traces;

import java.util.Date;
import jscratch.helpers.SessionHelper;
import org.jdom2.Element;

/**
 * Définit une trace.
 * 
 * @since 1.0
 * @version 1.0
 */
public abstract class Trace {
	
	protected final String HEURE = "heure";
	protected final String TYPETRACE = "type";
	protected final String ISWIDGET = "isWidget";
	protected final String AVANT = "avant";
	protected final String APRES = "apres";
	protected final String TRACE = "trace";
	protected final String NOMFICHIER = "url";
	protected final String FORMATFICHIER = "format";
	protected final String ACTION = "action";
	protected final String PARENTANCIEN = "ancienParent";
	protected final String PARENTNOUVEAU = "nouveauParent";
	protected final String EMPLACEMENT = "emplacement";
	protected final String POSITION = "position";
	protected final String ID = "id";
	
	
	
	/**
	 * Type.
	 */
	private TypeTrace type;
	
	/**
	 * Heure d'apparition.
	 */
	private String heure;
	
	/**
	 * Constructeur par défaut de <code>Trace</code>.
	 */
	public Trace(TypeTrace type) {
		this.type = type;
		this.heure = SessionHelper.formatHeure(new Date());
	}
	
	/**
	 * Permet de récupérer le type de la trace.
	 * 
	 * 
	 * @return le type de la trace
	 */
	public TypeTrace getType() {
		return this.type;
	}
	
	/**
	 * Permet de récupérer l'heure de la trace.
	 * 
	 * @since 1.0
	 * 
	 * @return l'heure au format 
	 */
	public String getHeure() {
		return this.heure;
	}

	@Override
	public String toString() {
		return this.heure + " : " + this.getType();
	}
	
	/**
	 * Permet d'avoir comment le widget doit se sérialiser.
	 * 
	 * @since 1.0
	 * 
	 * @return la trace en format XML
	 */
	public Element toXml() {
		Element thisXml = new Element(TRACE);
		thisXml.setAttribute(TYPETRACE, this.type.toString());
		thisXml.setAttribute(HEURE, this.heure);
		
		return thisXml;
	}
}