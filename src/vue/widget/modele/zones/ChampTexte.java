package vue.widget.modele.zones;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Cette classe représente un champ texte particulier intégrable dans un widget.
 */
public class ChampTexte extends JPanel implements Zone {
    
    private JTextField textField;
    /*
     * Etat à 0 quand on affiche uniquement le champ texte
     */
    int etat; 
    
    
    
	/**
	 * Constructeur faisant appel au constructeur équivalent de la classe mère.
	 */
	public ChampTexte() {
		super();
                this.setOpaque(false);
                this.setLayout(new BorderLayout());
                textField = new JTextField();
                this.add(textField);
                etat = 0;
                this.validate();
	}
	
	/**
	 * Récupère le texte du champ texte.
	 * @return la valeur du champ texte.
	 */
	@Override
	public String getValeur() {
            if (etat == 0){
		return textField.getText();
            }else{
                return "";
            }
	}
	/**
	 * Modifie le texte du champ texte.
	 * @param v le nouveau texte du champ.
	 */
	@Override
	public void setValeur(String v) {
            if (etat == 0){
		this.textField.setText(v);
            }
	}
}