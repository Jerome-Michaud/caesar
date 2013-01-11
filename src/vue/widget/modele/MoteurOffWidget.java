package vue.widget.modele;

import vue.widget.modele.zones.ListeDeroulante;
import vue.widget.modele.zones.Zone;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

import modeles.TypeWidget;

import java.awt.Rectangle;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.Moteur;
/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type MoteurOff
 * 
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class MoteurOffWidget extends ModeleWidget {
	/**
	 * Constructeur du modèle définissant les différents paramètres du MoteurOff.
	 */
	public MoteurOffWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.MOTEUROFF);
		
		//this.setMessage("Moteur           off");
		message.put(new Point(5, 17), "Moteur");
		message.put(new Point(95, 17), "off");
		
		this.setElementProgramme(new InstructionMoteurOff());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante<Moteur> l = new ListeDeroulante<Moteur>(Moteur.values());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);
		
		setInstructionMoteur(l.getValeur());
		
		this.decalageX(-20);
		
		initListeners();
	}
	
	@Override
    public void decalageY(int b,Rectangle r) {
        int i;
        for (i = 8; i < 16; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
	
	@Override
	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionMoteur(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
	}
	
	/**
	 * Méthode permettant de définir l'instruction moteur du widget
	 * 
	 * @param nom L'instruction Moteur à définir sur le modèle
	 */
	private void setInstructionMoteur(String nom) {
		((InstructionMoteurOff) getElementProgramme()).setMoteur(Moteur.values()[Integer.parseInt(nom)]);
	}
}