package vue.ginterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import vue.controller.LanceurTraduction;
/**
 * Panneau d'affichage du code traduit.
 * 
 * @since 1.0
 * @version 1.0
 */
public class PanelCodeConsole extends JPanel {
	/**
	 * SINGLETON.
	 *
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
		this.setBorder(BorderFactory.createTitledBorder("Aperçu code console"));
		
		this.add(textarea, BorderLayout.CENTER);
		
		this.textarea.addMouseListener(LanceurTraduction.getInstance());
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
}
