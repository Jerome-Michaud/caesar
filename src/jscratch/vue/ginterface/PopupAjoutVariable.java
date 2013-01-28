package jscratch.vue.ginterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import jscratch.modeles.DicoVariables;

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
	protected PopupAjoutVariable() {
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