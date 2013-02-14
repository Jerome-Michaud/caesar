package jscratch.traces;

/**
 * Définit les différentes traces possible dans l'application.
 * 
 * @since 1.0
 * @version 1.0
 */
public enum TypeTrace {

	WIDGET_AJOUT, WIDGET_SUPPRESSION, WIDGET_DEPLACEMENT, WIDGET_MODIFICATION,
	
	CATEGORIE_CHANGEMENT,
	
	SIMULATEUR_BOUTONS;

	@Override
	public String toString() {
		switch(this) {
			case WIDGET_AJOUT:return "AJOUT";
			case WIDGET_DEPLACEMENT: return "DEPLACEMENT";
			case WIDGET_MODIFICATION: return "MODIFICATION";
			case WIDGET_SUPPRESSION: return "SUPPRESSION";
				
			case CATEGORIE_CHANGEMENT: return "CHANGEMENTCATEGORIE";
				
			case SIMULATEUR_BOUTONS: return "SIMULATEURBOUTONS";
				
			default: return "INCONNU";
		}
	}
	
	public String toProperties() {
		switch(this) {
			case WIDGET_AJOUT:return "widget.ajout";
			case WIDGET_DEPLACEMENT: return "widget.deplacement";
			case WIDGET_MODIFICATION: return "widget.modification";
			case WIDGET_SUPPRESSION: return "widget.suppression";
				
			case CATEGORIE_CHANGEMENT: return "categorie.changement";
				
			case SIMULATEUR_BOUTONS: return "simulateur.boutons";
				
			default: return "inconnu";
		}
	}
}