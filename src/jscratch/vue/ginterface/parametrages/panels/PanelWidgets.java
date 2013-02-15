package jscratch.vue.ginterface.parametrages.panels;

import de.javasoft.swing.JYPropertyTable;
import de.javasoft.swing.table.PropertyTableModel;
import java.awt.BorderLayout;
import java.util.List;
import jscratch.helpers.PropertiesHelper;
import jscratch.vue.widgets.Widget;

/**
 * @since 1.0
 * @version 1.0
 */
public class PanelWidgets extends PanelParametrage {

	private JYPropertyTable table;
	
	private List<Widget> liste;
	
	/**
	 * Constructeur par défaut désactivé.
	 */
	private PanelWidgets() { }
	
	/**
	 * Constructeur par défaut de <code>PanelWidgets</code>.
	 */
    public PanelWidgets(final List<Widget> liste) {
		this.liste = liste;
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		this.setLayout(new BorderLayout());
		
		this.table = new JYPropertyTable();
		
		for (Widget w : this.liste) {
			String v = p.get("user.widget.afficher." + w.getModele().getType().toString(), true);
			if (v == null || v.isEmpty()) {
				this.table.addProperty(w.getModele().getType().toString(), true);
			}
			else {
				this.table.addProperty(w.getModele().getType().toString(), Boolean.valueOf(v));
			}
		}
		
		this.add(this.table, BorderLayout.CENTER);
	}

	@Override
	public void update() {
		PropertiesHelper p = PropertiesHelper.getInstance();
		
		PropertyTableModel modele = this.table.getModel();
		for (int i = 0;i < modele.getRowCount(); i++) {
			p.set("user.widget.afficher." + modele.getPropertyKey(i).toString(), modele.getPropertyValue(i).toString());
		}
	}
 }