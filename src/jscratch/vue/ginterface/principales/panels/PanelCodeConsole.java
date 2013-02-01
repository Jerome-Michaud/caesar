package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Panneau d'affichage du code traduit.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelCodeConsole extends JPanel implements Observer {

	/**
	 * @since 1.0
	 */
	private static PanelCodeConsole instance = new PanelCodeConsole();
	private JTextArea textarea;

	/**
	 * @since 1.0
	 */
	private PanelCodeConsole() {
		this.textarea = new JTextArea();
		this.textarea.setEditable(false);
		this.textarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(100, 600));
		this.setBorder(BorderFactory.createTitledBorder("Code NXC"));

		this.add(textarea, BorderLayout.CENTER);
		
		this.textarea.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (!textarea.getText().isEmpty() && e.isPopupTrigger()) {
					GUI.getPopupCodeNxc().show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelCodeConsole getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @param texte Le texte à afficher dans la zone.
	 */
	public void setText(String texte) {
		this.textarea.setText(texte);
	}
	
	/**
	 * @since 1.0
	 *
	 * @return la traduction
	 */
	public String getText() {
		return this.textarea.getText();
	}
	
	@Override
	public void update(Observable o, Object o1) {
		// Mise à jour du texte dans la zone, envoyer le code au format String pas un objet
		this.setText(o1.toString());
		this.repaint();
	}
}