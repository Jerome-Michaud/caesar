package sauvegarde.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import sauvegarde.SauvegardeTools;
import vue.tools.ArborescenceTools;
import vue.widget.Widget;
import vue.widget.WidgetCompose;

/**
 *
 * @author Quentin
 */
public class SauvegardeXMLTools implements SauvegardeTools {
	
	/**
	 * L'instance unique de SauvegardeBinaireTools
	 */
	private static SauvegardeXMLTools instance = null;
	
	/**
	 * Le constructeur privé pour éviter la déclaration externe.
	 */
	private SauvegardeXMLTools() { }
	
	/**
	 * Le getter pour récupérer l'instance unique de SauvegardeBinaireTools.
	 * 
	 * @return l'instance unique de SauvegardeBBinaireTools
	 */
	public static SauvegardeXMLTools getInstance() {
		if (instance == null) {
			instance = new SauvegardeXMLTools();
		}
		return instance;
	}
	
	@Override
    public void save() {
		serializeArborescence("C:\\Users\\Quentin\\Documents\\xml.xml");
	}
	
	@Override
    public void load() {
		deserializeArborescence("C:\\Users\\Quentin\\Documents\\xml.xml");
	}
	
	/**
     * Permet la sérialisation de l'arborescence des widgets.
     * @param path Le chemin où sauvegarder le l'arborescence
     */
    private void serializeArborescence(final String path) {
		List<List<Widget>> arbo = ArborescenceTools.getInstance().getArborescence();
		
		Document docXml = new Document(new Element("arborescence"));
		
		for (List<Widget> liste : arbo) {
			Element groupe = new Element("groupe");
			for (Widget widget : liste) {
				groupe.addContent(widget.toXml());
			}
			docXml.getRootElement().addContent(groupe);
		}
		
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		   sortie.output(docXml, new FileOutputStream(fichier));
		} catch (IOException ex){
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "La sauvegarde n'a pas pu être effectuée corectement");
		}
	}
	
	/**
     * Desérialise une arborescence précédemment sauvegardée.
     *
     * @param path Le chemin d'accès à l'arborscence sauvegardée
     */
    private void deserializeArborescence(final String path) {
		try {
			LinkedList<List<Widget>> arbos = null;
			Document docXml = null;
			File fichier = new File(path);
			if (fichier.exists()) {
				try {
					SAXBuilder sxb = new SAXBuilder();
					docXml = sxb.build(fichier);
					
					// Déserialiser
					
					
					
					
				} catch (JDOMException ex) {
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Le fichier fournit n'est pas correct : " + ex.getMessage());
				}
			
				ArborescenceTools.getInstance().initArborescence(arbos, true);
			}
		} catch (IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "La sauvegarde n'a pas pu être chargée corectement");
		}
	}
}
