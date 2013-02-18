package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import de.javasoft.swing.table.PropertyTableModel;
import java.awt.BorderLayout;
import java.io.File;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import jscratch.parametrages.Variables;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelAutres extends PanelParametrage {

	private static PanelAutres instance = null;
	
	private JYPropertyTable table;
	
	/**
	 * Default constructor of <code>PanelAutres</code>.
	 */
	private PanelAutres() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Chemin vers le compilateur",  new File(Variables.CHEMIN_ACCES_NBC));
		this.table.addProperty("Emplacement du fichier properties",  p.get("user.chemin.properties.distant"));
		
		this.add(this.table);
		
		this.add(new JXHeader("La partie 'autres' permet de configurer diverses informations", "Vous pouvez modifier les informations comme l'url du compilateur, le chemin vers le properties distant, etc.", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}
	
	public static PanelAutres getInstance() {
		if (instance == null) {
			instance = new PanelAutres();
		}
		return instance;
	}

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		PropertyTableModel modele = this.table.getModel();
		
		p.set("user.chemin.compilateur", modele.getPropertyValue(0).toString());
		p.set("user.chemin.properties.distant", modele.getPropertyValue(1).toString());
	}
}