package jscratch.vue.ginterface;

import java.io.File;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jscratch.sauvegarde.filtres.ApplicationFileFilter;
import jscratch.sauvegarde.filtres.JScratchFileFilter;
import jscratch.sauvegarde.SauvegardeTools;
import jscratch.sauvegarde.filtres.XmlFileFilter;
import jscratch.sauvegarde.binaire.SauvegardeBinaireTools;
import jscratch.sauvegarde.filtres.NxcFileFilter;
import jscratch.sauvegarde.nxc.SauvegardeNxcTools;
import jscratch.sauvegarde.xml.SauvegardeXMLTools;

/**
 *
 * @author Quentin
 */
public class SelecteurFichier extends JFileChooser {

	private HashMap<ApplicationFileFilter, SauvegardeTools> sauvegardes;
	private XmlFileFilter xml = new XmlFileFilter();
	private JScratchFileFilter jsc = new JScratchFileFilter();
	private NxcFileFilter nxc = new NxcFileFilter();

	/**
	 * 
	 * @param code <code>true</code>, si le selecteur n'accepte que les fichiers NXC
	 */
	public SelecteurFichier(final boolean code) {
		sauvegardes = new HashMap<ApplicationFileFilter, SauvegardeTools>();
		sauvegardes.put(xml, SauvegardeXMLTools.getInstance());
		sauvegardes.put(nxc, SauvegardeNxcTools.getInstance());
		sauvegardes.put(jsc, SauvegardeBinaireTools.getInstance());

		if (!code) {
			setFileFilter(xml);
			addChoosableFileFilter(jsc);
		}
		else {
			setFileFilter(nxc);
		}
		setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	public void sauvegarde() {
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
				sauvegardes.get(filtreActif).save(path);
			}
		}
	}

	public void chargement() {
		int retour = this.showOpenDialog(GUI.getFenetre());
		if (retour == JFileChooser.APPROVE_OPTION) {
			String path = getSelectedFile().getAbsolutePath();
			sauvegardes.get((ApplicationFileFilter) this.getFileFilter()).load(path);
		}
	}
}
