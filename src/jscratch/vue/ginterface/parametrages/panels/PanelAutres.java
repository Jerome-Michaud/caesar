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
package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import de.javasoft.swing.table.PropertyTableModel;
import java.awt.BorderLayout;
import java.io.File;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import jscratch.parametrages.properties.VariableProperties;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelAutres extends PanelParametrage {

	private static PanelAutres instance = null;
	
	private JYPropertyTable table;
	
	/**
	 * Default constructor of <code>PanelAutres</code>.
	 */
	private PanelAutres() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Chemin vers le compilateur",  new File(VariableProperties.CHEMIN_ACCES_NBC));
		this.table.addProperty("Emplacement du fichier properties",  p.get("user.chemin.properties.distant"));
		
		this.add(this.table);
		
		this.add(new JXHeader("La partie 'autres' permet de configurer diverses informations", "Vous pouvez modifier les informations comme l'url du compilateur, le chemin vers le properties distant, etc.", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}
	
	public static PanelAutres getInstance() {
		if (instance == null) {
			instance = new PanelAutres();
		}
		return instance;
	}

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		PropertyTableModel modele = this.table.getModel();
		
		p.set("user.chemin.compilateur", modele.getPropertyValue(0).toString());
		p.set("user.chemin.properties.distant", modele.getPropertyValue(1).toString());
	}
}