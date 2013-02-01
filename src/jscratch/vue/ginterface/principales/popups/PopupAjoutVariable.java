package jscratch.vue.ginterface.principales.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import jscratch.dictionnaires.DicoVariables;
import jscratch.vue.ginterface.principales.GUI;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class PopupAjoutVariable extends JPopupMenu {

	/**
	 * Les différents éléments du menu.
	 */
	private JMenuItem ajouter, supprimer;
	
	/**
	 * Le constructeur par défaut de <code>PopupVariables</code>.
	 */
	public PopupAjoutVariable() {
		super("Gérer les variables");
		
		this.ajouter = new JMenuItem("Ajouter une variable");
		this.ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.getFenetreAjoutVariable();
			}
		});
		this.add(this.ajouter);
		
		if (!DicoVariables.getInstance().getDictionnaire().isEmpty()) {
			this.supprimer = new JMenuItem("Supprimer une variable");
			this.supprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					GUI.getFenetreSupressionVariable();
				}
			});
			
			this.add(this.supprimer);
		}
	}
}