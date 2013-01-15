package jscratch.sauvegarde.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import jscratch.modeles.Erreur;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.vue.ginterface.GUI;
import jscratch.vue.tools.ArborescenceTools;
import jscratch.vue.tools.NonChargeableException;
import jscratch.vue.widget.Widget;

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
	public void save(String path) {
		serializeArborescence(path);
	}

	@Override
	public void load(String path) {
		try {
			deserializeArborescence(path);
			GUI.getPanelCodeGraphique().repaint();
		} catch (NonChargeableException ex) {
			Erreur.afficher(ex);
		}
	}

	/**
	 * Permet la sérialisation de l'arborescence des widgets.
	 *
	 * @param path Le chemin où sauvegarder le l'arborescence
	 */
	private void serializeArborescence(final String path) {
		Document doc = SerialiseurXML.save();
		
		try {
			File fichier = new File(path);
			if (!fichier.exists()) {
				fichier.createNewFile();
			}
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			FileOutputStream fo = new FileOutputStream(fichier);
			sortie.output(doc, fo);
			fo.close();
		} catch (IOException ex) {
			Erreur.afficher(ex, "La sauvegarde n'a pas pu être effectuée corectement");
		}
	}

	/**
	 * Desérialise une arborescence précédemment sauvegardée.
	 *
	 * @param path Le chemin d'accès à l'arborscence sauvegardée
	 */
	private void deserializeArborescence(final String path) throws NonChargeableException {
		try {
			File fichier = new File(path);
			if (fichier.exists()) {
				try {
					SAXBuilder sxb = new SAXBuilder();
		System.out.println("Composants sur pcg : " + GUI.getPanelCodeGraphique().getComponents().length);
					List<List<Widget>> l = DeserialiseurXML.load(sxb.build(fichier));
		System.out.println("Composants sur pcg : " + GUI.getPanelCodeGraphique().getComponents().length);
					ArborescenceTools.getInstance().initArborescence(l, false);
		System.out.println("Composants sur pcg : " + GUI.getPanelCodeGraphique().getComponents().length);
				} catch (JDOMException ex) {
					Erreur.afficher(ex, "Le fichier fournit n'est pas correct");
				}
			}
		} catch (IOException ex) {
			Erreur.afficher(ex, "La sauvegarde n'a pas pu être chargée corectement");
		}
	}
}
