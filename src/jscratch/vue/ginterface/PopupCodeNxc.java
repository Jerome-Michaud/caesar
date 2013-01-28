package jscratch.vue.ginterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @since 1.0
 * @version 1.0
 */
class PopupCodeNxc extends JPopupMenu {

	/**
	 * Les différents éléments du menu.
	 */
	private JMenuItem sauvegarder;
	
	/**
	 * Le constructeur par défaut de <code>PopupCodeNxc</code>.
	 */
	protected PopupCodeNxc() {
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