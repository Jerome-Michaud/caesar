package jscratch.vue.ginterface.principales.selecteur;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public enum TypeSelecteur {

	ARBORESCENCE, PROPERTIES, CODE;

	@Override
	public String toString() {
		switch(this) {
			case ARBORESCENCE: return "arborescence";
			case PROPERTIES: return "properties";
			case CODE: return "code";
			default: return "inconnu";
		}
	}
}