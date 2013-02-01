package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import java.awt.BorderLayout;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.PropertiesHelper;
import org.jdesktop.swingx.JXHeader;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelTraces extends PanelParametrage {

	private static PanelTraces instance = null;
	
	private JYPropertyTable table;
	/**
	 * Default constructor of <code>PanelAutres</code>.
	 */
	private PanelTraces() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		this.table = new JYPropertyTable();
		
		this.table.addProperty("Activer les traces", Boolean.valueOf(p.get("user.trace.active")));
		this.table.addSeparator();
		this.table.addProperty("Traces codes NXC", Boolean.valueOf(p.get("user.trace.active.code")));
		this.table.addProperty("Traces deplacements", Boolean.valueOf(p.get("user.trace.active.deplacement")));
		
		this.add(new JXHeader("La partie 'trace' n'est actuellement pas disponible", "Cette partie n'a pas été implémentée, le changement des ces propriétés n'aura aucun intérêt", ImagesHelper.getIcon("remove.png")), BorderLayout.NORTH);
		this.add(this.table, BorderLayout.CENTER);
	}
	
	public static PanelTraces getInstance() {
		if (instance == null) {
			instance = new PanelTraces();
		}
		return instance;
	}

	@Override
	public void update() { }
}