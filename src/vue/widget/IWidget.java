package vue.widget;

import java.io.Serializable;
/**
 * Interface regroupant les widgets et le conteneur racine de l'arborescence graphique des widgets.
 *
 * @author Bastien Andru - Adrien Duroy - Quentin Gosselin
 */
public interface IWidget extends Serializable {
	/**
	 * Permet de savoir si un IWidget est le conteneur racine ou non dans l'aroborescence graphique.
	 * @return true si le composant est la racine, false dans le cas contraire.
	 */
	public boolean isRacine();
}
