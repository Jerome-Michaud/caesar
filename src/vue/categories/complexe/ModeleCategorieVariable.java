package vue.categories.complexe;

import nxtim.instruction.Categorie;
import vue.categories.ModeleCategorie;

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
