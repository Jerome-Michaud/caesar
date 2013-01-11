package jscratch.vue.categories.complexe;

/**
 *
 * @author Quentin
 */
public enum EtatPolygon {

	SURVOLE, INACTIF, ACTIF;

	@Override
	public String toString() {
		switch (this) {
			case SURVOLE:
				return "Survole";
			case INACTIF:
				return "Inactif";
			case ACTIF:
				return "Actif";
			default:
				return "Erreur";
		}
	}
}
