package jscratch.traces.fabriques;

import java.io.File;
import jscratch.exceptions.IncompatibleTypeForTrace;
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
	public Trace creerTraceChangementCategorie(final String ancienne, final String nouvelle) {
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
	public Trace creerTraceBoutonsSimulateur(final String action) {
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
	private Trace creerTraceFichier(final TypeTrace type, final File fichier) {
		try {
			return new TraceFichier(type, fichier);
		} catch (IncompatibleTypeForTrace ex) {
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
	public Trace creerTraceEnvoiRobot(final File fichier) {
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
	public Trace creerTraceSauvegarde(final File fichier) {
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
	public Trace creerTraceChargement(final File fichier) {
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
	public Trace creerTraceChargementProperties(final File fichier) {
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
	public Trace creerTraceWidgetAjout(final Widget widget, final Widget parent) {
		return new TraceWidgetAjout(widget, parent);
	}
	
	/**
	 * Permet de créer une trace pour <code>WIDGET_SUPPRESSION</code>.
	 *
	 * @since 1.0
	 * 
	 * @param widget le widget
	 * @return la trace
	 */
	public Trace creerTraceWidgetSuppression(final Widget widget) {
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
	public Trace creerTraceWidgetModification(final Widget widget, final Zone zone, final Widget widgetContenu, final String valeurApres) {
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
	public Trace creerTraceWidgetModification(final Widget widget, final Zone zone, final String valeurAvant, final Widget widgetContenu) {
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
	public Trace creerTraceWidgetModification(final Widget widget, final Zone zone, final String valeurAvant, final String valeurApres) {
		return new TraceWidgetModification(widget, zone, valeurAvant, valeurApres);
	}
	
	public Trace creerTraceWidgetDeplacement(final Widget widget, final Widget parentAvant, final Widget parentApres) {
		return new TraceWidgetDeplacement(widget, parentAvant, parentApres);
	}
}