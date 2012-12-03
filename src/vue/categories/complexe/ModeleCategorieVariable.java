package vue.categories.complexe;

import java.awt.Color;
import vue.categories.ModeleCategorie;

/**
 *
 * @author Quentin
 */
public class ModeleCategorieVariable extends ModeleCategorie {

	public ModeleCategorieVariable(String nom, Color couleur) {
		super(nom, couleur);
		
		this.getFormesExtras().add(new PolygoneActionPlus());
		this.getFormesExtras().add(new PolygoneActionMoins());
                
	}
	
}
