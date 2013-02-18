package jscratch.traces;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public enum TypeModificationWidget {

	WIDGET_VALEUR, VALEUR_WIDGET, VALEUR_VALEUR;

	@Override
	public String toString() {
		switch(this) {
			case WIDGET_VALEUR: return "WIDGET_VALEUR";
			case VALEUR_WIDGET: return "VALEUR_WIDGET";
			case VALEUR_VALEUR: return "VALEUR_VALEUR";
			default: return "INCONNU";
		}
	}
	
	/**
	 * Permet de savoir si avant modification, le contenu est un widget.
	 * 
	 * @since 1.0
	 * 
	 * @return <code>true</code> si la valeur avant est un widget, <code>false</code> sinon
	 */
	public boolean isWidgetAvant() {
		return this.equals(WIDGET_VALEUR);
	}
	
	/**
	 * Permet de savoir si après modification, le contenu est un widget.
	 * 
	 * @since 1.0
	 * 
	 * @return <code>true</code> si la valeur apres est un widget, <code>false</code> sinon
	 */
	public boolean isWidgetApres() {
		return this.equals(VALEUR_WIDGET);
	}
}