package jscratch.vue.ginterface.principales.selecteur;

import java.io.File;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jscratch.dictionnaires.DicoTraces;
import jscratch.sauvegarde.filtres.ApplicationFileFilter;
import jscratch.sauvegarde.filtres.CaesarFileFilter;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.sauvegarde.filtres.XmlFileFilter;
import jscratch.sauvegarde.binaire.SauvegardeBinaireTools;
import jscratch.sauvegarde.filtres.NxcFileFilter;
import jscratch.sauvegarde.filtres.PropertiesFileFilter;
import jscratch.sauvegarde.nxc.SauvegardeNxcTools;
import jscratch.sauvegarde.properties.SauvegardePropertiesTools;
import jscratch.sauvegarde.xml.arborescence.SauvegardeArborescenceXMLTools;
import jscratch.sauvegarde.xml.traces.SauvegardeTracesXMLTools;
import jscratch.traces.fabriques.FabriqueTrace;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.ginterface.principales.GUI;

/**
 *
 * @author Quentin
 */
public class SelecteurFichier extends JFileChooser {

	private HashMap<ApplicationFileFilter, SauvegardeTools> sauvegardes;
	private XmlFileFilter xmlArborescence = new XmlFileFilter();
	private XmlFileFilter xmlTraces = new XmlFileFilter();
	private CaesarFileFilter jsc = new CaesarFileFilter();
	private NxcFileFilter nxc = new NxcFileFilter();
	private PropertiesFileFilter pro = new PropertiesFileFilter();

	/**
	 * 
	 * @param type choisi le type du selecteur
	 */
	public SelecteurFichier(final TypeSelecteur type) {
		sauvegardes = new HashMap<ApplicationFileFilter, SauvegardeTools>();
		sauvegardes.put(xmlArborescence, SauvegardeArborescenceXMLTools.getInstance());
		sauvegardes.put(nxc, SauvegardeNxcTools.getInstance());
		sauvegardes.put(jsc, SauvegardeBinaireTools.getInstance());
		sauvegardes.put(pro, SauvegardePropertiesTools.getInstance());
		sauvegardes.put(xmlTraces, SauvegardeTracesXMLTools.getInstance());

		switch(type) {
			case ARBORESCENCE:
				setFileFilter(xmlArborescence);
				addChoosableFileFilter(jsc);
				break;
			case CODE:
				setFileFilter(nxc);
				break;
			case PROPERTIES:
				setFileFilter(pro);
				break;
			case TRACES:
				setFileFilter(xmlTraces);
				break;
		}
		setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	public File sauvegarde() {
		int retour = this.showSaveDialog(GUI.getFenetre());
		if (retour == JFileChooser.APPROVE_OPTION) {
			String path = getSelectedFile().getAbsolutePath();
			ApplicationFileFilter filtreActif = ((ApplicationFileFilter) this.getFileFilter());
			if (!path.endsWith(filtreActif.getExtension())) {
				path += ".";
				path += filtreActif.getExtension();
			}
			boolean ok = true;
			if (new File(path).exists()) {
				int opt = JOptionPane.showConfirmDialog(this, new JLabel("<html>Un fichier portant ce nom existe déjà.<br><br>"
						+ "Souhaitez vous l'écraser ?"), "Fichier existant", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (opt != JOptionPane.YES_OPTION) {
					ok = false;
				}
			}
			if (ok) {
				return sauvegardes.get(filtreActif).save(path);
			}
		}
		
		return null;
	}

	public void chargement() {
		int retour = this.showOpenDialog(GUI.getFenetre());
		if (retour == JFileChooser.APPROVE_OPTION) {
			String path = getSelectedFile().getAbsolutePath();
			sauvegardes.get((ApplicationFileFilter) this.getFileFilter()).load(path);
			GUI.getPanelCodeGraphique().updateSize(ArborescenceTools.getInstance().getArborescence());
		}
	}
}