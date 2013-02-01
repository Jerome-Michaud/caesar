package jscratch.vue.widgets;

import java.io.Serializable;

/**
 * Interface regroupant les widgets et le conteneur racine de l'arborescence graphique des widgets.
 */
public interface IWidget extends Serializable {

	/**
	 * Permet de savoir si un IWidget est le conteneur racine ou non dans l'arborescence graphique.
	 *
	 * @return <code>true</code> si le composant est la racine, sinon <code>false</code>
	 */
	public boolean isRacine();
}
