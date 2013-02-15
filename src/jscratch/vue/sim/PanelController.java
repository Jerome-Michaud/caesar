package jscratch.vue.sim;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.javasoft.swing.ButtonBar;
import de.javasoft.swing.SimpleDropDownButton;
import jscratch.controleur.sim.Simulator;
import jscratch.helpers.ImagesHelper;
import jscratch.interpreteur.LanceurInterpreteur;

/**
 * Panel permettant de controller l'execution du simulateur
 * @author Nicolas
 *
 */

public class PanelController extends JPanel implements ActionListener{

	private ImageIcon icon;
	private ButtonBar buttonBar;
	private AbstractButton b1;
	private AbstractButton b2;
	private AbstractButton b3;
	private SimpleDropDownButton b4;
	private JMenuItem m1;
	private JMenuItem m2;
	private JMenuItem m3;
	private boolean pause = false;
	private Simulator simulator;
	private LanceurInterpreteur lanceurInter;
	
	public PanelController(Simulator simulator) {
		
		this.simulator = simulator;
		setLayout(new FlowLayout(10,1, 4));
		
		Image img = ImagesHelper.getImage("icone.png");
		Image newimg = ImagesHelper.resizeImg(img, 15, 15);
		icon = new ImageIcon( newimg );
		
		buttonBar = new ButtonBar();
		
	    b1 = createButton("Exécuter",icon, true, false);	    
	    b2 = createButton("Pause",icon, false, false);
	    b3 = createButton("Stop",icon, false, false);
	    
	    b4 = new SimpleDropDownButton("Debug");
	    b4.setIcon(icon);
	    
	    JPopupMenu popupMenu = b4.getPopupMenu(); 
	    
	    m1 = new JMenuItem("Afficher les points des capteurs");
	    m2 = new JMenuItem("MenuItem 2");
	    m3 = new JMenuItem("MenuItem 3");
	    popupMenu.add(m1);
	    popupMenu.add(m2);
	    popupMenu.add(m3);	    
	    
	    buttonBar.add(b1);
	    buttonBar.add(b2);
	    buttonBar.add(b3);
	    buttonBar.add(b4);
	    this.add(buttonBar);
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    m1.addActionListener(this);
	    m2.addActionListener(this);
	    m3.addActionListener(this);
	}
	
	/**
	 * methode permettant de créer un bouton pour la buttonBar
	 * @param text
	 * @param icon
	 * @param enabled
	 * @param toggleButton
	 * @return
	 */
	private AbstractButton createButton(String text,ImageIcon icon, boolean enabled, boolean toggleButton)
	  {
	    AbstractButton b = null;
	    if (toggleButton)
	      b = new JToggleButton(text)
	      {
	        @Override
	        public Insets getMargin() 
	        {
	          if (super.getMargin() != null)
	            return new Insets(super.getMargin().top, 10, super.getMargin().bottom, 10);
	          return null;
	        }
	      };    
	    else
	      b = new JButton(text)
	      {
	        @Override
	        public Insets getMargin() 
	        {
	          if (super.getMargin() != null)
	            return new Insets(super.getMargin().top, 10, super.getMargin().bottom, 10);
	          return null;
	        }
	      };    
	    b.setEnabled(enabled);
	    Insets margin = b.getMargin();
	    b.setMargin(new Insets(margin.top, 10, margin.bottom, 10));
	    b.setIcon(icon);
	    return b;
	  }
	
	/**
	 * gestion des actions sur les boutons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == b1){
			b2.setEnabled(true);
			b3.setEnabled(true);
			b1.setEnabled(false);
			lanceurInter = new LanceurInterpreteur(simulator.getInterpreteur());
			lanceurInter.start();
		}
		else if(e.getSource() == b2){
			if(!pause){
				pause=true;
				b2.setText("Relance");
				lanceurInter.waitThread();
			}
			else{
				pause=false;
				b2.setText("Pause");
				lanceurInter.notifyThread();
			}
		}
		else if(e.getSource() == b3){
			b2.setEnabled(false);
			b3.setEnabled(false);
			b1.setEnabled(true);
			pause=false;
			lanceurInter.stopThread();
		}
		else if(e.getSource() == m1){

		}
		else if(e.getSource() == m2){
					
		}
		else if(e.getSource() == m3){
			
		}
	}

}
