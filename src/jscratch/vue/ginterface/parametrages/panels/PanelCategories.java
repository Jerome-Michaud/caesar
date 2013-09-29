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
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import jscratch.parametrages.properties.VariableProperties;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelCategories extends PanelParametrage {

	/**
	 * Unique instance of <code>PanelCategories</code>.
	 */
	private static PanelCategories instance = null;

	private JYPropertyTable table;
	
	/**
	 * Private constructor of <code>PanelCategories</code>.
	 */
    private PanelCategories() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Afficher le nombre de widget dans les catégories", VariableProperties.AFFICHAGE_NOMBRE_WIDGET);
		this.table.addSeparator();
		this.table.addProperty("Texte structures", p.get("user.categorie.message.structures"));
		this.table.addProperty("Texte moteur", p.get("user.categorie.message.moteurs"));
		this.table.addProperty("Texte capteurs", p.get("user.categorie.message.capteurs"));
		this.table.addProperty("Texte temps", p.get("user.categorie.message.temps"));
		this.table.addProperty("Texte variables", p.get("user.categorie.message.variables"));
		this.table.addProperty("Texte expressions", p.get("user.categorie.message.expressions"));
		
		this.add(new JXHeader("Gestion des catégories", "Cette partie permet de configurer certaines parties de l'application en relation avec les catégories", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}

	/**
	 * Accessor for <code>PanelCategories</code>.
	 *
	 * @return unique instance of <code>PanelCategories</code>
	 */
    public static PanelCategories getInstance() {
        if (instance == null) {
			instance = new PanelCategories();
		}
		return instance;
    }

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		PropertyTableModel modele = this.table.getModel();
		
		p.set("user.categorie.afficher.nombrewidget", modele.getPropertyValue(0).toString());
		p.set("user.categorie.message.structures", modele.getPropertyValue(2).toString());
		p.set("user.categorie.message.moteurs", modele.getPropertyValue(3).toString());
		p.set("user.categorie.message.capteurs", modele.getPropertyValue(4).toString());
		p.set("user.categorie.message.temps", modele.getPropertyValue(5).toString());
		p.set("user.categorie.message.variables", modele.getPropertyValue(6).toString());
		p.set("user.categorie.message.expressions", modele.getPropertyValue(7).toString());
	}
 }