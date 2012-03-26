package Vue.controller;

import instruction.Instruction;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import traduction.VisiteurNXC;
import traduction.VisiteurTraduction;
import Modeles.TypeWidget;
import Vue.Interface.PanelCodeConsole;
import Vue.Tools.ArborescenceTools;
import Vue.Widget.Widget;
import Vue.Widget.modele.ModeleWidget;
import Vue.Widget.modele.TacheWidget;

public class LanceurTraduction extends MouseAdapter {

	private VisiteurTraduction traducteur;
	private static LanceurTraduction instance = null;
	
	private LanceurTraduction() {
		traducteur = VisiteurNXC.getInstance();
	}
	
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
	
	public void setTraducteur(VisiteurTraduction v) {
		traducteur = v;
	}
}
