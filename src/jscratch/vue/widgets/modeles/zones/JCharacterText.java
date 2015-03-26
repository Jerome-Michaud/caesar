/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jscratch.vue.widgets.modeles.zones;

import javax.swing.JTextField;

/**
 *
 * @author daoumi
 */
public class JCharacterText extends JTextField {
	private static final String BLANK = "";
	public static final String FM_CHARACTER = "azertyuiopqsdfghjklmwxcvbn";

	public JCharacterText(String text, int columns) {
		super("", 5);
	}

	public String getString() {
		String variable = null;
		variable = new String(getSelectedText());
		return variable;
	}
	
	public void setString (String value) {
		setText(value);
	}
			
	
}
