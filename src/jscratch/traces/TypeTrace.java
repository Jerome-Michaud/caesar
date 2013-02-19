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
	
	SIMULATEUR_BOUTONS, 
	
	ROBOT_ENVOI,
	
	PROPERTIES_CHARGEMENT, 
	
	FICHIER_CHARGEMENT, FICHIER_SAUVEGARDE;

	@Override
	public String toString() {
		switch(this) {
			case WIDGET_AJOUT:return "AJOUT";
			case WIDGET_DEPLACEMENT: return "DEPLACEMENT";
			case WIDGET_MODIFICATION: return "MODIFICATION";
			case WIDGET_SUPPRESSION: return "SUPPRESSION";
				
			case CATEGORIE_CHANGEMENT: return "CHANGEMENTCATEGORIE";
				
			case ROBOT_ENVOI: return "ROBOTENVOI";
				
			case SIMULATEUR_BOUTONS: return "SIMULATEURBOUTONS";
				
			case PROPERTIES_CHARGEMENT: return "PROPERTIESCHANGEMENT";
				
			case FICHIER_CHARGEMENT: return "CHARGEMENT";
			case FICHIER_SAUVEGARDE: return "SAUVEGARDE";	
				
			default: return "INCONNU";
		}
	}
	
	/**
	 * Permet de connaître la partie importante de la clé pour le properties.
	 * 
	 * @return le morceau de la cle
	 */
	public String toProperties() {
		switch(this) {
			case WIDGET_AJOUT:return "widget.ajout";
			case WIDGET_DEPLACEMENT: return "widget.deplacement";
			case WIDGET_MODIFICATION: return "widget.modification";
			case WIDGET_SUPPRESSION: return "widget.suppression";
				
			case CATEGORIE_CHANGEMENT: return "categorie.changement";
				
			case ROBOT_ENVOI: return "robot.transfert";
				
			case SIMULATEUR_BOUTONS: return "simulateur.boutons";
				
			case PROPERTIES_CHARGEMENT: return "properties.changement";
				
			case FICHIER_CHARGEMENT: return "fichier.chargement";
			case FICHIER_SAUVEGARDE: return "fichier.sauvegarde";
			default: return "inconnu";
		}
	}

	/**
	 * Permet de savoit si le type est compatible avec la <code>TraceFichier</code>.
	 * 
	 * @return <code>true</code> si compatible, <code>false</code> sinon
	 */
	public boolean isTraceFichier() {
		switch(this) {
			case ROBOT_ENVOI: return true;
			case PROPERTIES_CHARGEMENT: return true;
			case FICHIER_CHARGEMENT: return true;
			case FICHIER_SAUVEGARDE: return true;
			default: return false;
		}
	}
}