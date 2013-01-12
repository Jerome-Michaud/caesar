package jscratch.sauvegarde.xml;

import java.util.List;
import jscratch.modeles.DicoVariables;
import jscratch.vue.tools.ArborescenceTools;
import nxtim.instruction.Variable;
import org.jdom2.Document;
import org.jdom2.Element;
import jscratch.vue.widget.Widget;

public class SerialiseurXML {

	/**
	 * Default constructor of <code>SauveurXML</code>.
	 */
	private SerialiseurXML() { }
	
	/**
	 * Permet de sauvegarder l'arborescence et le dictionnaire au format XML.
	 * 
	 * @return le document XML prêt à être sauvegarder ou utilisé
	 */
	public static Document save() {
		Document docXml = new Document(new Element("sauvegarde"));

		// Sauvegarde du dictionnaire
		Element dictionnaire = new Element("dictionnaire");
		for (Variable v : DicoVariables.getInstance().getLesvariables()) {
			Element variable = new Element("variable");
			variable.setAttribute("nom", v.getNom());	
			variable.setAttribute("type", v.getType().toString());
			dictionnaire.addContent(variable);
		}
		docXml.getRootElement().addContent(dictionnaire);
		
		
		// Sauvegarde de l'arborescence
		List<List<Widget>> arbo = ArborescenceTools.getInstance().getArborescence();
		Element arborescence = new Element("arborescence");
		for (List<Widget> liste : arbo) {
			Element groupe = new Element("groupe");
			for (Widget widget : liste) {
				groupe.addContent(widget.toXml());
			}
			arborescence.addContent(groupe);
		}
		docXml.getRootElement().addContent(arborescence);
		
		return docXml;
	}
}