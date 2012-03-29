package vue.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import vue.controller.LanceurTraduction;

public class PanelCodeConsole extends JPanel {

	private static PanelCodeConsole instance = new PanelCodeConsole();
	private JTextArea textarea;

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

	public static PanelCodeConsole getInstance() {
		return instance;
	}
	
	public void setText(String text) {
		this.textarea.setText(text);
	}
}
