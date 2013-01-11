package jscratch.vue.categories.complexe;

import nxtim.instruction.Categorie;
import jscratch.vue.categories.ModeleCategorie;

/**
 *
 * @author Quentin
 */
public class ModeleCategorieVariable extends ModeleCategorie {

	public ModeleCategorieVariable(Categorie categorie) {
		super(categorie);

		this.getFormesExtras().add(new PolygoneActionPlus());
		this.getFormesExtras().add(new PolygoneActionMoins());
	}
}
