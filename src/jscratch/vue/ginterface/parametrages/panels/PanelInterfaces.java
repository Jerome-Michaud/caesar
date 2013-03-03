package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import de.javasoft.swing.table.PropertyTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import nxtim.instruction.Categorie;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelInterfaces extends PanelParametrage {

	private static PanelInterfaces instance = null;
	
	private JYPropertyTable table;
	
	/**
	 * Default constructor of <code>PanelAutres</code>.
	 */
	private PanelInterfaces() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Afficher le panel widgets",  Boolean.valueOf(p.get("user.interface.afficher.categories")));
		this.table.addSeparator();
		
		for (Categorie c : Categorie.values()) {
			this.table.addProperty(c.toString(), new Color(Integer.parseInt(p.get("user.couleur." + c.toString()))));
		}
		
		this.add(this.table);
		
		this.add(new JXHeader("Gestion de l'interface", "Cette partie permet de configurer l'interface de l'application", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}
	
	public static PanelInterfaces getInstance() {
		if (instance == null) {
			instance = new PanelInterfaces();
		}
		return instance;
	}

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		PropertyTableModel modele = this.table.getModel();
		
		p.set("user.interface.afficher.categories", modele.getPropertyValue(0).toString());
		
		for (int i = 2;i < 8;i++) {
			p.set("user.couleur." + modele.getPropertyKey(i), String.valueOf(((Color)modele.getPropertyValue(i)).getRGB()));
		}
	}
}