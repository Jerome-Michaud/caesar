/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

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
package jscratch.sauvegarde.xml.arborescence;

import java.util.List;
import jscratch.dictionnaires.DicoVariables;
import jscratch.vue.arborescence.ArborescenceTools;
import nxtim.instruction.Variable;
import org.jdom2.Document;
import org.jdom2.Element;
import jscratch.vue.widgets.Widget;

/**
 * @since 1.0
 * @version 1.0
 */
public final class SerialiseurArborescenceXML {

	/**
	 * Default constructor of <code>SauveurXML</code>.
	 *
	 * @since 1.0
	 */
	private SerialiseurArborescenceXML() { }
	
	/**
	 * Permet de sauvegarder l'arborescence et le dictionnaire au format XML.
	 *
	 * @since 1.0
	 * 
	 * @return le document XML prêt à être sauvegarder ou utilisé
	 */
	public static Document save() {
		Document docXml = new Document(new Element("sauvegarde"));

		// Sauvegarde du dictionnaire
		Element dictionnaire = new Element("dictionnaire");
		for (Variable v : DicoVariables.getInstance().getLesVariables()) {
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