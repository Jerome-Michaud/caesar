package Vue.Interface;

import Vue.Widget.IWidget;
import Vue.Widget.Widget;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelCodeGraphique extends JPanel implements IWidget {

    private static PanelCodeGraphique instance = new PanelCodeGraphique();

    private PanelCodeGraphique() {
        this.setMinimumSize(new Dimension(400, 600));
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder("Code graphique"));
    }

    public static PanelCodeGraphique getInstance() {
        return instance;
    }

    public boolean isRacine() {
        return true;
    }
	
	public void removeAll() {
		//suppression des anciens composants
		for (int i = 0;i < this.getComponents().length;i++) {
			if (this.getComponent(i) instanceof Widget) {
				this.remove(this.getComponent(i));
			}
		}
	}
}
