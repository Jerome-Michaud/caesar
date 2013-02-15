package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import de.javasoft.swing.table.PropertyTableModel;
import java.awt.BorderLayout;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import jscratch.parametrages.Variables;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelCategories extends PanelParametrage {

	/**
	 * Unique instance of <code>PanelCategories</code>.
	 */
	private static PanelCategories instance = null;

	private JYPropertyTable table;
	
	/**
	 * Private constructor of <code>PanelCategories</code>.
	 */
    private PanelCategories() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Afficher le nombre de widget dans les catégories", Variables.AFFICHAGE_NOMBRE_WIDGET);
		this.table.addSeparator();
		this.table.addProperty("Texte structures", p.get("user.categorie.message.structures"));
		this.table.addProperty("Texte moteur", p.get("user.categorie.message.moteurs"));
		this.table.addProperty("Texte capteurs", p.get("user.categorie.message.capteurs"));
		this.table.addProperty("Texte temps", p.get("user.categorie.message.temps"));
		this.table.addProperty("Texte variables", p.get("user.categorie.message.variables"));
		this.table.addProperty("Texte expressions", p.get("user.categorie.message.expressions"));
		
		this.add(new JXHeader("Gestion des catégories", "Cette partie permet de configurer certaines parties de l'application en relation avec les catégories", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}

	/**
	 * Accessor for <code>PanelCategories</code>.
	 *
	 * @return unique instance of <code>PanelCategories</code>
	 */
    public static PanelCategories getInstance() {
        if (instance == null) {
			instance = new PanelCategories();
		}
		return instance;
    }

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		PropertyTableModel modele = this.table.getModel();
		
		p.set("user.categorie.afficher.nombrewidget", modele.getPropertyValue(0).toString());
		p.set("user.categorie.message.structures", modele.getPropertyValue(2).toString());
		p.set("user.categorie.message.moteurs", modele.getPropertyValue(3).toString());
		p.set("user.categorie.message.capteurs", modele.getPropertyValue(4).toString());
		p.set("user.categorie.message.temps", modele.getPropertyValue(5).toString());
		p.set("user.categorie.message.variables", modele.getPropertyValue(6).toString());
		p.set("user.categorie.message.expressions", modele.getPropertyValue(7).toString());
	}
 }