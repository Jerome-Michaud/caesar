package jscratch.vue.ginterface.principales.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import jscratch.helpers.CompilateurHelper;
import jscratch.helpers.ImagesHelper;
import jscratch.helpers.LangueHelper;
import jscratch.helpers.SessionHelper;
import jscratch.parametrages.langue.VariableLangue;

/**
 *
 */
public class PanelCompilateur extends JPanel {

	private static PanelCompilateur instance = new PanelCompilateur();
	private StyledDocument docInfos;
	private SimpleAttributeSet ligneCompil;
	private SimpleAttributeSet ligneInfo;
	private JTextPane panneauInfos;
	private JPanel panelTools;
	private JButton boutComp;
	private JCheckBox checkRun;

	/**
	 * Default constructor of
	 * <code>PanelCompilateur</code>.
	 */
	private PanelCompilateur() {
		this.setLayout(new BorderLayout());
		panneauInfos = new JTextPane(){
			public boolean getScrollableTracksViewportWidth() {
			  Component parent = getParent();
			  ComponentUI ui = getUI();
 
			  return parent != null ? (ui.getPreferredSize(this).width <= parent
				  .getSize().width) : true;
			}
		};
		docInfos = panneauInfos.getStyledDocument();
		panneauInfos.setEditable(false);
		ligneCompil = new SimpleAttributeSet();
		StyleConstants.setForeground(ligneCompil, Color.RED);
		StyleConstants.setBold(ligneCompil, true);
		ligneInfo = new SimpleAttributeSet();
		StyleConstants.setForeground(ligneInfo, Color.BLACK);
		this.add(new JScrollPane(panneauInfos),BorderLayout.CENTER);
		
		this.panelTools = new JPanel(new BorderLayout());
		this.boutComp = new JButton(LangueHelper.getInstance().get(VariableLangue.COMPIL_COMPIL), ImagesHelper.getIcon("compile.png"));
		
		boutComp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CompilateurHelper.exporter(checkRun.isSelected());
			}
		});
		
		this.checkRun = new JCheckBox(LangueHelper.getInstance().get(VariableLangue.COMPIL_EXEC));
		panelTools.add(boutComp,BorderLayout.EAST);
		panelTools.add(checkRun,BorderLayout.WEST);
				
		this.add(panelTools,BorderLayout.SOUTH);
		
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelCompilateur getInstance() {
		return instance;
	}

	public void ecrireDateEtHeure() {
		try {
			Date dateAct = new Date();
			docInfos.insertString(docInfos.getLength(), " ----- "+SessionHelper.formatDate(dateAct) + " à "+SessionHelper.formatHeure(dateAct) + " -----\n", ligneCompil);
		} catch (BadLocationException ex) {
			Logger.getLogger(PanelCompilateur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void ecrireNouvelleLigneInfo(String ligne) {
		try {
			docInfos.insertString(docInfos.getLength(), ligne+"\n", ligneInfo);
		} catch (BadLocationException ex) {
			Logger.getLogger(PanelCompilateur.class.getName()).log(Level.SEVERE, null, ex);
		}
		panneauInfos.setCaretPosition(docInfos.getLength());
	}
}