package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import de.javasoft.swing.table.PropertyTableModel;
import java.awt.BorderLayout;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import org.jdesktop.swingx.JXHeader;

/**
 * @since 1.0
 * @version 1.0
 */
public final class PanelTraces extends PanelParametrage {

	private static PanelTraces instance = null;
	
	private JYPropertyTable table;

	/**
	 * Default constructor of <code>PanelAutres</code>.
	 */
	private PanelTraces() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Gérer les traces ('False' = aucune trace)", Boolean.valueOf(p.get("user.trace.active")));
		this.table.addSeparator();
		this.table.addProperty("Ajout d'un widget dans le code",Boolean.valueOf(p.get("user.trace.active.widget.ajout")));
		this.table.addProperty("Déplacement d'un widget dans le code",Boolean.valueOf(p.get("user.trace.active.widget.deplacement")));
		this.table.addProperty("Suppression d'un widget du code",Boolean.valueOf(p.get("user.trace.active.widget.suppression")));
		this.table.addProperty("Modification d'un widget",Boolean.valueOf(p.get("user.trace.active.widget.modification")));
		this.table.addSeparator();
		this.table.addProperty("Changement de catégorie", Boolean.valueOf(p.get("user.trace.active.categorie.changement")));
		this.table.addSeparator();
		this.table.addProperty("Utilisation du simulateur", Boolean.valueOf(p.get("user.trace.active.simulateur.boutons")));
		this.table.addSeparator();
		this.table.addProperty("Changement de configuration", Boolean.valueOf(p.get("user.trace.active.properties.changement")));
		
		this.add(new JXHeader("La partie 'trace' permet de configurer les traces", "Dans cette partie, vous pouvez définir quelles traces seront utilisées dans l'application", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}
	
	public static PanelTraces getInstance() {
		if (instance == null) {
			instance = new PanelTraces();
		}
		return instance;
	}

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		PropertyTableModel modele = this.table.getModel();
		
		p.set("user.trace.active", modele.getPropertyValue(0).toString());
		
		p.set("user.trace.active.widget.ajout", modele.getPropertyValue(2).toString());
		p.set("user.trace.active.widget.deplacement", modele.getPropertyValue(3).toString());
		p.set("user.trace.active.widget.suppression", modele.getPropertyValue(4).toString());
		p.set("user.trace.active.widget.modification", modele.getPropertyValue(5).toString());
		
		p.set("user.trace.active.categorie.changement", modele.getPropertyValue(7).toString());
		
		p.set("user.trace.active.simulateur.boutons", modele.getPropertyValue(9).toString());
		
		p.set("user.trace.active.properties.changement", modele.getPropertyValue(11).toString());
	}
}