package vue.controller;

import instruction.Instruction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import modeles.TypeWidget;

import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;
import vue.Interface.PanelCodeConsole;
import vue.tools.ArborescenceTools;
import vue.widget.Widget;
import vue.widget.modele.ModeleWidget;
/**
 * Cette classe s'occupe de lancer la traduction du programme construit avec les widgets.
 * Utilise le design pattern Singleton.
 * @author Adrien DUROY
 */
public class LanceurTraduction extends MouseAdapter {

	private VisiteurTraduction traducteur;
	private static LanceurTraduction instance = null;
	
	private LanceurTraduction() {
		traducteur = VisiteurNXC.getInstance();
	}
	
	/**
	 * Donne l'instance unique de la classe.
	 * @return l'instance.
	 */
	public synchronized static LanceurTraduction getInstance() {
		if(instance == null)
			instance = new LanceurTraduction();
		return instance;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		traducteur.reset();
		List<Instruction> list = trouveTaches();
		for(Instruction inst : list)
			inst.accepte(traducteur);
		System.out.println(traducteur.getTraduction());
		PanelCodeConsole.getInstance().setText(traducteur.getTraduction());
	}
	
	/**
	 * Trouve les tâches parmis les widgets.
	 * La traduction est effectuée à partir de celles-ci.
	 * @return les instructions à traduire.
	 */
	private List<Instruction> trouveTaches() {
		List<Instruction> list = new LinkedList<Instruction>();
    	for(List<Widget> racine : ArborescenceTools.getInstance().getArborescence())
    	{
    		if(!racine.isEmpty())
    		{
    			Widget tache = racine.get(0);
    			ModeleWidget m = tache.getModele();
    			if( m.getType() == TypeWidget.TACHE){
    				System.out.println("Tâche trouvée : Faire traduction");
    				list.add((Instruction) m.getElementProgramme());
    			}
    		}
    	}
    	return list;
    }
	
	/**
	 * Modifie le traducteur utilisé.
	 * Si n'a jamais été appelé c'est le traducteur vers NXC qui est utilisé.
	 * @param v le nouveau traducteur
	 */
	public void setTraducteur(VisiteurTraduction v) {
		traducteur = v;
	}
}
