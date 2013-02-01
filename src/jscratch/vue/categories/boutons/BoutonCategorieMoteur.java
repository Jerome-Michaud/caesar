package jscratch.vue.categories.boutons;

import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Classe permettant l'instanciation du bouton catégorie "Moteur".
 *
 * @since 1.0
 * @version
 * Historique des versions :
 * <ul>
 * <li>
 * 1.0 : 3 widgets disponibles :
 * <ul>
 * <li>Avancer</li>
 * <li>Reculer</li>
 * <li>Arrêter</li>
 * <ul>
 * </li>
 * <ul>
 */
public class BoutonCategorieMoteur extends BoutonCategorie {

	/**
	 * Définit le bouton catégorie
	 * <code>Moteur</code>.
	 */
	public BoutonCategorieMoteur() {
		super(new ModeleCategorie(Categorie.MOTEUR));

		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.MOTEUR, GUI.getPanelWidget().getFabrique().creerWidgetMoteurMarche());
		DicoWidgetsCategories.getInstance().ajouterWidget(Categorie.MOTEUR, GUI.getPanelWidget().getFabrique().creerWidgetMoteurOff());
	}

	@Override
	public int getNbColonnes() {
		return 1;
	}
}