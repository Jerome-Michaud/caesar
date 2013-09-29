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
package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import jscratch.helpers.PropertiesHelper;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Cette zone correspond à la zone où l'utilisateur peut intéragir.<br />
 * Permet de regrouper les 2 panels :
 * <ul>
 * <li>PanelInstruction</li>
 * <li>PanelCodeGraphique</li>
 * </ul>
 *
 * @since 1.0
 * @version 1.0
 */
public final class ZoneUtilisateur extends JPanel {

	/**
	 * Instance unique de <code>ZoneUtilisateur</code>.
	 */
	private static ZoneUtilisateur instance = null;
	private JScrollPane scrollCodeGraphique;

	/**
	 * @since 1.0
	 */
	private ZoneUtilisateur() {
		this.setLayout(new BorderLayout());
		PanelCodeGraphique p = GUI.getPanelCodeGraphique();
		
		scrollCodeGraphique = new JScrollPane(p);
		scrollCodeGraphique.setBorder(null);
		p.setScrollPane(scrollCodeGraphique);		
		this.reset();
		this.add(scrollCodeGraphique, BorderLayout.CENTER);
	}

	/**
	 * @since 1.0
	 *
	 * @return L'unique instance de ZoneUtilisateur.
	 */
	public static ZoneUtilisateur getInstance() {
		if (instance == null) {
			instance = new ZoneUtilisateur();
		}
		return instance;
	}
	
	/**
	 * Permet de modifier l'objet en fonction des properties
	 */
	public void reset() {
		if (Boolean.valueOf(PropertiesHelper.getInstance().get("user.interface.afficher.categories"))) {
			this.add(GUI.getPanelInstruction(), BorderLayout.WEST);
		}
		else {
			this.remove(GUI.getPanelInstruction());
		}
	}
}
