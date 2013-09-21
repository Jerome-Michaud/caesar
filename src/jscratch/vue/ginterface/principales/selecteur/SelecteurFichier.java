/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
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