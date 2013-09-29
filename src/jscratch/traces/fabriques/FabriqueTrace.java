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
package jscratch.traces.fabriques;

import java.io.File;
import jscratch.exceptions.IncompatibleTypeForTraceException;
import jscratch.helpers.ErreurHelper;
import jscratch.traces.Trace;
import jscratch.traces.TraceCategorieChangement;
import jscratch.traces.TraceFichier;
import jscratch.traces.TraceSimulateurBoutons;
import jscratch.traces.TraceWidgetAjout;
import jscratch.traces.TraceWidgetDeplacement;
import jscratch.traces.TraceWidgetModification;
import jscratch.traces.TraceWidgetSuppression;
import jscratch.traces.TypeTrace;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.Zone;
import nxtim.instruction.Categorie;

/**
 * @since 1.0
 * @version 1.0
 */
public class FabriqueTrace {

	/**
	 * Constructeur privé de <code>FabriqueTrace</code>.
	 */
    private FabriqueTrace() { }
	
	/**
	 * Permet de créer une trace pour <code>CHANGEMENT_CATEGORIE</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param ancienne l'ancienne catégorie
	 * @param nouvelle la nouvelle catégorie
	 * @return la trace
	 */
	public static Trace creerTraceChangementCategorie(final Categorie ancienne, final Categorie nouvelle) {
		return new TraceCategorieChangement(ancienne, nouvelle);
	}
	
	/**
	 * Permet de créer une trace pour <code>SIMULATEUR_BOUTONS</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param action l'action
	 * @return la trace
	 */
	public static Trace creerTraceBoutonsSimulateur(final String action) {
		return new TraceSimulateurBoutons(action);
	}
	
	/**
	 * Permet de créer une trace en rapport aux fichier.
	 * 
	 * @since 1.0
	 * 
	 * @param type le type
	 * @param fichier le fichier
	 * @return la trace
	 */
	private static Trace creerTraceFichier(final TypeTrace type, final File fichier) {
		try {
			return new TraceFichier(type, fichier);
		} catch (IncompatibleTypeForTraceException ex) {
			ErreurHelper.afficher(ex);
		}
		return null;
	}
	
	/**
	 * Permet de créer une trace pour <code>ROBOT_ENVOI</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param fichier le fichier
	 * @return la trace
	 */
	public static Trace creerTraceEnvoiRobot(final File fichier) {
		return creerTraceFichier(TypeTrace.ROBOT_ENVOI, fichier);
	}
	
	/**
	 * Permet de créer une trace pour <code>FICHIER_SAUVEGARDE</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param fichier le fichier
	 * @return la trace
	 */
	public static Trace creerTraceSauvegarde(final File fichier) {
		return creerTraceFichier(TypeTrace.FICHIER_SAUVEGARDE, fichier);
	}
	
	/**
	 * Permet de créer une trace pour <code>FICHIER_CHARGEMENT</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param fichier le fichier
	 * @return la trace
	 */
	public static Trace creerTraceChargement(final File fichier) {
		return creerTraceFichier(TypeTrace.FICHIER_CHARGEMENT, fichier);
	}
	
	/**
	 * Permet de créer une trace pour <code>PROPERTIES_CHARGEMENT</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param fichier le fichier
	 * @return la trace
	 */
	public static Trace creerTraceChargementProperties(final File fichier) {
		return creerTraceFichier(TypeTrace.PROPERTIES_CHARGEMENT, fichier);
	}
 
	/**
	 * Permet de créer une trace pour <code>WIDGET_AJOUT</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param parent le parent
	 * @return la trace
	 */
	public static Trace creerTraceWidgetAjout(final Widget widget, final Widget parent, final int positionParRapportParent) {
		return new TraceWidgetAjout(widget, parent, positionParRapportParent);
	}
	
	/**
	 * Permet de créer une trace pour <code>WIDGET_SUPPRESSION</code>.
	 *
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @return la trace
	 */
	public static Trace creerTraceWidgetSuppression(final Widget widget) {
		return new TraceWidgetSuppression(widget);
	}
	
	/**
	 * Permet de créer une trace pour <code>WIDGET_MODIFICATION</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param zone la zone
	 * @param widgetContenu le widget (avant)
	 * @param valeurApres la valeur (apres)
	 * @return la trace
	 */
	public static Trace creerTraceWidgetModification(final Widget widget, final Zone zone, final Widget widgetContenu, final String valeurApres) {
		return new TraceWidgetModification(widget, zone, widgetContenu, valeurApres);
	}
	
	/**
	 * Permet de créer une trace pour <code>FICHIER_SAUVEGARDE</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param zone la zone
	 * @param valeurAvant la valeur (avant)
	 * @param widgetContenu le widget (apres)
	 * @return la trace
	 */
	public static Trace creerTraceWidgetModification(final Widget widget, final Zone zone, final String valeurAvant, final Widget widgetContenu) {
		return new TraceWidgetModification(widget, zone, valeurAvant, widgetContenu);
	}
	
	/**
	 * Permet de créer une trace pour <code>FICHIER_SAUVEGARDE</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param zone la zone
	 * @param valeurAvant la valeur (avant)
	 * @param valeurApres la valeur (apres)
	 * @return la trace
	 */
	public static Trace creerTraceWidgetModification(final Widget widget, final Zone zone, final String valeurAvant, final String valeurApres) {
		return new TraceWidgetModification(widget, zone, valeurAvant, valeurApres);
	}
	
	/**
	 * Permet de créer une trace pour <code>WIDGET_MODIFICATION</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @param parentAvant le parent (avant)
	 * @param parentApres le parent (apres)
	 * @return la trace
	 */
	public static Trace creerTraceWidgetDeplacement(final Widget widget, final Widget parentAvant, final Widget parentApres, final int emplacement, final int position) {
		return new TraceWidgetDeplacement(widget, parentAvant, parentApres, emplacement, position);
	}
}