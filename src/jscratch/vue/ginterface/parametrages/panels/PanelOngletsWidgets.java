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
package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYTabbedPane;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.ImagesHelper;
import nxtim.instruction.Categorie;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelOngletsWidgets extends PanelParametrage {

	/**
	 * Unique instance of <code>PanelWidgets</code>.
	 */
	private static PanelOngletsWidgets instance = null;

	private List<PanelWidgets> lesPanels = new ArrayList<PanelWidgets>();
	
	/**
	 * Private constructor of <code>PanelWidgets</code>.
	 */
    private PanelOngletsWidgets() {
		this.setLayout(new BorderLayout());
		
		JYTabbedPane tab = new JYTabbedPane();
		int i = 0;
		for (Categorie c : DicoBoutonsCategories.getInstance().getCategories()) {
			PanelWidgets p = new PanelWidgets(DicoWidgetsCategories.getInstance().getWidgets(c, false));
			this.lesPanels.add(p);
			tab.insertTab(c.toString(), null, p, null, i++);
		}
		
		this.add(new JXHeader("Gestion des widgets", "Cette partie permet de définir les widgets qui seront disponibles dans l'application", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(tab, BorderLayout.CENTER);
	}
	
	/**
	 * Accessor for <code>PanelWidgets</code>.
	 *
	 * @return unique instance of <code>PanelWidgets</code>
	 */
    public static PanelOngletsWidgets getInstance() {
        if (instance == null) {
			instance = new PanelOngletsWidgets();
		}
		return instance;
    }

	@Override
	public void update() {
		for (PanelWidgets pw : this.lesPanels) {
			pw.update();
		}
	}
 }