/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author quentin
 */
public class PanelInstruction extends JPanel {
    private static final PanelInstruction instance = new PanelInstruction();
    public static final int xMax = 300;
    
    private PanelInstruction() {
	this.setLayout(new BorderLayout());
	
	this.setMinimumSize(new Dimension(300, 800));
	this.setPreferredSize(new Dimension(300, 800));
	
	this.add(PanelTypeWidget.getInstance(), BorderLayout.NORTH);
	this.add(PanelWidget.getInstance(), BorderLayout.CENTER);
    }

    public static PanelInstruction getInstance() {
        return instance;
    }
 }
