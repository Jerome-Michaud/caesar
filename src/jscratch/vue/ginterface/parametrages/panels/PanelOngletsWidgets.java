package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYTabbedPane;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import jscratch.dictionnaires.DicoBoutonsCategories;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.helpers.ImagesHelper;
import nxtim.instruction.Categorie;
import org.jdesktop.swingx.JXHeader;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class PanelOngletsWidgets extends PanelParametrage {

	/**
	 * Unique instance of <code>PanelWidgets</code>.
	 */
	private static PanelOngletsWidgets instance = null;

	private List<PanelWidgets> lesPanels = new ArrayList<PanelWidgets>();
	
	/**
	 * Private constructor of <code>PanelWidgets</code>.
	 */
    private PanelOngletsWidgets() {
		this.setLayout(new BorderLayout());
		
		JYTabbedPane tab = new JYTabbedPane();
		int i = 0;
		for (Categorie c : DicoBoutonsCategories.getInstance().getCategories()) {
			PanelWidgets p = new PanelWidgets(DicoWidgetsCategories.getInstance().getWidgets(c, false));
			this.lesPanels.add(p);
			tab.insertTab(c.toString(), null, p, null, i++);
		}
		
		this.add(new JXHeader("Gestion des widgets", "Cette partie permet de définir les widgets qui seront disponibles dans l'application", ImagesHelper.getIcon("info.png")), BorderLayout.NORTH);
		this.add(tab, BorderLayout.CENTER);
	}
	
	/**
	 * Accessor for <code>PanelWidgets</code>.
	 *
	 * @return unique instance of <code>PanelWidgets</code>
	 */
    public static PanelOngletsWidgets getInstance() {
        if (instance == null) {
			instance = new PanelOngletsWidgets();
		}
		return instance;
    }

	@Override
	public void update() {
		for (PanelWidgets pw : this.lesPanels) {
			pw.update();
		}
	}
 }