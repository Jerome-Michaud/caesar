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
package jscratch.vue.ginterface.principales;

import jscratch.vue.ginterface.principales.popups.PopupAjoutVariable;
import jscratch.vue.ginterface.principales.panels.GlassPane;
import jscratch.vue.ginterface.principales.panels.ZoneUtilisateur;
import jscratch.vue.ginterface.principales.panels.PanelCodeConsole;
import jscratch.vue.ginterface.principales.panels.PanelTypeWidget;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import jscratch.vue.ginterface.principales.panels.PanelWidget;
import jscratch.vue.ginterface.principales.panels.PanelInstruction;
import javax.swing.JPopupMenu;
import jscratch.vue.ginterface.principales.panels.PanelCompilateur;
import jscratch.vue.ginterface.principales.panels.ZoneSimulateur;
import jscratch.vue.ginterface.principales.popups.PopupCodeNxc;

/**
 * Facade pour la GUI.
 */
public final class GUI {

	/**
	 * Le constructeur privé de <code>GUI</code>.
	 */
	private GUI() { }

	/**
	 * Permet de récupérer la <code>Fenetre</code>.
	 * 
	 * @return la fenetre
	 */
	public static ApplicationUI getFenetre() {
		return ApplicationUI.getInstance();
	}
	
	/**
	 * Permet de récupérer la <code>GlassPane</code>.
	 * 
	 * @return le glasspane
	 */
	public static GlassPane getGlassPane() {
		return GlassPane.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelCodeConsole</code>.
	 * 
	 * @return le panel code console
	 */
	public static PanelCodeConsole getPanelCodeConsole() {
		return PanelCodeConsole.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelCompilateur</code>.
	 * 
	 * @return le panel compilateur
	 */
	public static PanelCompilateur getPanelCompilateur() {
		return PanelCompilateur.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelCodeGraphique</code>.
	 * 
	 * @return le panel code graphique
	 */
	public static PanelCodeGraphique getPanelCodeGraphique() {
		return PanelCodeGraphique.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelInstruction</code>.
	 * 
	 * @return le panel instruction
	 */
	public static PanelInstruction getPanelInstruction() {
		return PanelInstruction.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelTypeWidgert</code>.
	 * 
	 * @return le panel type widget
	 */
	public static PanelTypeWidget getPanelTypeWidget() {
		return PanelTypeWidget.getInstance();
	}

	/**
	 * Permet de récupérer la <code>PanelWidget</code>.
	 * 
	 * @return le panel widget
	 */
	public static PanelWidget getPanelWidget() {
		return PanelWidget.getInstance();
	}

	/**
	 * Permet de récupérer la <code>ZoneUtilisateur</code>.
	 * 
	 * @return la zone utilisateur
	 */
	public static ZoneUtilisateur getZoneUtilisateur() {
		return ZoneUtilisateur.getInstance();
	}
	
	/**
	 * Permet de créer une nouvelle popup de variable
	 * 
	 * @return la nouvelle popup
	 */
	public static JPopupMenu creerPopupVariable() {
		return new PopupAjoutVariable();
	}
	
	/**
	 * Permet de créer une nouvelle popup de code nxc
	 * 
	 * @return la nouvelle popup
	 */
	public static JPopupMenu creerPopupCodeNxc() {
		return new PopupCodeNxc();
	}

	/**
	 * Permet de créer une nouvelle <code>FenetreAjoutVariable</code>.
	 * 
	 * @return la nouvelle fenetre
	 */
	public static FenetreAjoutVariable creerFenetreAjoutVariable() {
		return new FenetreAjoutVariable();
	}

	/**
	 * Permet de récupérer une nouvelle <code>FenetreSuppressionVariable</code>.
	 * 
	 * @return la nouvelle fenetre de suppresion de variable
	 */
	public static FenetreSupressionVariable creerFenetreSupressionVariable() {
		return new FenetreSupressionVariable();
	}
	
	/**
	 * Permet de créer une nouvelle zone de simulateur.
	 * 
	 * @return la nouvelle zone
	 */
	public static ZoneSimulateur creerZoneSimulateur() {
		return new ZoneSimulateur();
	}
}