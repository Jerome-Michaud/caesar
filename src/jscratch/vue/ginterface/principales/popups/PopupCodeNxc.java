package jscratch.vue.ginterface.principales.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import jscratch.vue.ginterface.principales.SelecteurFichier;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class PopupCodeNxc extends JPopupMenu {

	/**
	 * Les différents éléments du menu.
	 */
	private JMenuItem sauvegarder;
	
	/**
	 * Le constructeur par défaut de <code>PopupCodeNxc</code>.
	 */
	public PopupCodeNxc() {
		super("Gérer le code NXC");
		
		this.sauvegarder = new JMenuItem("Sauvegarder");
		this.sauvegarder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SelecteurFichier(true).sauvegarde();
			}
		});
		this.add(this.sauvegarder);
	}
}