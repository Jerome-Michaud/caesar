/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.generation;

import java.awt.Container;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import jscratch.dictionnaires.DicoTraces;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.exceptions.ComposantIntrouvableException;
import jscratch.exceptions.NonClonableException;
import jscratch.helpers.ErreurHelper;
import jscratch.traces.fabriques.FabriqueTrace;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.arborescence.DragAndDropTools;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.ginterface.principales.ApplicationUI;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.ginterface.principales.panels.PanelCodeGraphique;
import jscratch.vue.ginterface.principales.panels.PanelTypeWidget;
import jscratch.vue.widgets.IWidget;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.WidgetCompose;
import jscratch.vue.widgets.modeles.ModeleWidget;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import jscratch.vue.widgets.modeles.VariableWidget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import jscratch.vue.widgets.modeles.zones.Zone;
import nxtim.instruction.Affectation;
import nxtim.instruction.Capteur;
import nxtim.instruction.CapteurSlot;
import nxtim.instruction.Categorie;
import nxtim.instruction.Expression;
import nxtim.instruction.ExpressionComplexe;
import nxtim.instruction.IElementProgramme;
import nxtim.instruction.Instruction;
import nxtim.instruction.InstructionAttente;
import nxtim.instruction.InstructionConfigCapteurs;
import nxtim.instruction.InstructionDeclaration;
import nxtim.instruction.InstructionDeclarationAffectation;
import nxtim.instruction.InstructionDeclarationCapteur;
import nxtim.instruction.InstructionDoWhile;
import nxtim.instruction.InstructionFor;
import nxtim.instruction.InstructionIf;
import nxtim.instruction.InstructionIfElse;
import nxtim.instruction.InstructionIncrementation;
import nxtim.instruction.InstructionMoteurMov;
import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.InstructionMoteurRotate;
import nxtim.instruction.InstructionRAZRotationMoteur;
import nxtim.instruction.InstructionRepeat;
import nxtim.instruction.InstructionTache;
import nxtim.instruction.InstructionWhile;
import nxtim.instruction.NonLogique;
import nxtim.instruction.Operateur;
import nxtim.instruction.RotationMoteur;
import nxtim.instruction.TempsCourant;
import nxtim.instruction.ValeurCapteur;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableCapteur;
import nxtim.instruction.VariableModifiable;

/**
 *
 * @author PC
 */
public class VisiteurWidgetGenerationNXC implements VisiteurWidgetGeneration{
	
	private static VisiteurWidgetGenerationNXC instance = new VisiteurWidgetGenerationNXC();
	private static final ArborescenceTools arbo = ArborescenceTools.getInstance();
	
	private Widget widget;
	private int prochWidgetZone = 0;
	private int prochVarZone = 0;

	private VisiteurWidgetGenerationNXC() {
		super();
	}
	
	@Override
	public Widget getWidget(){
		return widget;
	}

	/**
	 * Donne l'instance unique de VisiteurGeneration.
	 *
	 * @return l'instance de VisiteurGeneration
	 */
	public static synchronized VisiteurWidgetGenerationNXC getInstance() {
		return instance;
	}
	
	private Widget getWidgetExistant(Categorie cat, TypeModeleWidget type){
		List<Widget> widgets = DicoWidgetsCategories.getInstance().getWidgets(cat,false);
		for(Widget w: widgets){
			if(w.getModele().getType() == type){
				return w;
			}
		}
		return null;
	}
	
	private Widget getVariableExistante(String name){
		List<Widget> widgets = DicoWidgetsCategories.getInstance().getWidgets(Categorie.VARIABLES,false);
		for(Widget w: widgets){
			if(w.getModele().getType() == TypeModeleWidget.VARIABLE && 
					name.equals(((VariableWidget)w.getModele()).getNomVariable())){
				return w;
			}
		}
		return null;
	}
	
	private Widget getExpressionExistante(Operateur op){
		List<Widget> widgets = DicoWidgetsCategories.getInstance().getWidgets(Categorie.EXPRESSIONS, false);
		for(Widget w: widgets){
			IElementProgramme elem = w.getModele().getElementProgramme();
			if( (elem instanceof ExpressionComplexe) && ((ExpressionComplexe)elem).getOperateur() == op){
				return w;
			}
		}
		return null;
	}
	
	private Widget getWidgetClone(Categorie cat, TypeModeleWidget type, Widget parent){
		Widget clone = null;
		try {
			clone = GUI.getPanelWidget().getFabrique().cloner(getWidgetExistant(cat, type));
			clone.setDraggable(true);
			if(parent != null){
				Iterator<List<Widget>> iter = ((WidgetCompose)parent).getMapZone().values().iterator();
				List<Widget> lst = null;
				for(int i = 0; i <= prochWidgetZone; ++i){
					lst = iter.next();
				}
				prochWidgetZone = 0;
				lst.add(clone);
				clone.defParent((IWidget) parent);
						
				if (parent.isComplexe() || (parent.parent() != null && !parent.parent().isRacine()) ) {
					((WidgetCompose) parent).applyChangeModele();						
				}
			}
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}		
		return clone;
	}
	
	private void ajouterVariable(Variable var){
		// Ajout dans le dictionnaire
		ApplicationUI.getInstance().getDicoVariables().ajouter(var);
					
		// Mise à jour des widgets liés au variables
		DicoWidgetsCategories.getInstance().updateWidgetsVariables();
					
		// Mise à jour du panel widget
		updateWidgetPanel(Categorie.VARIABLES);
	}
	
	private void ajouterVariableWidgetClone(Variable var, Widget parent, int zone){
		try {
			Widget clone = GUI.getPanelWidget().getFabrique().cloner(getVariableExistante(var.getNom()));
			clone.setDraggable(true);
			clone.defParent(parent.parent());
				
			Zone z = parent.getModele().getLesZonesSaisies().get(zone);
			((ChampTexte) z).setWidgetContenu(clone);			
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}
	}
	
	private Widget getExprWidgetClone(Operateur op, Widget parent){
		Widget clone = null;
		try {
			clone = GUI.getPanelWidget().getFabrique().cloner(getWidgetExistant(Categorie.VARIABLES, TypeModeleWidget.SETVALUEVARIABLE));
			clone.setDraggable(true);
			if(parent != null){
				Iterator<List<Widget>> iter = ((WidgetCompose)parent).getMapZone().values().iterator();
				List<Widget> lst = null;
				for(int i = 0; i <= prochWidgetZone; ++i){
					lst = iter.next();
				}
				prochWidgetZone = 0;
				lst.add(clone);
				clone.defParent((IWidget) parent);
						
				if (parent.isComplexe() || (parent.parent() != null && !parent.parent().isRacine()) ) {
					((WidgetCompose) parent).applyChangeModele();						
				}
			}
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}		
		return clone;
	}
	
	private Widget ajouterExprWidgetClone(Operateur op, Widget parent, int zone){
		Widget clone = null;
		try {
			clone = GUI.getPanelWidget().getFabrique().cloner(getExpressionExistante(op));
			clone.setDraggable(true);
			clone.defParent(parent.parent());
			
			Zone z = parent.getModele().getLesZonesSaisies().get(zone);
			((ChampTexte) z).setWidgetContenu(clone);
		} catch (Exception ex) {
			ErreurHelper.afficher(ex);
		}		
		return clone;
	}
	
	/**
	 * Méthode récursive permettant de passer un widget d'un conteneur à
	 * l'autre. Si le widget passé en paramètre est de type complexe, cette
	 * méthode est de nouveau appelée pour chacun de ses fils.
	 *
	 * @param wi Le widget à passer sur un autre Panel
	 * @param destination Le panel de destination du widget
	 */
	private void ajouterSurPanel(Widget wi, Container destination) {
		if (wi.isComplexe()) {
			for (List<Widget> lw : ((WidgetCompose) wi).getMapZone().values()) {
				for (Widget w : lw) {
					ajouterSurPanel(w, destination);
				}
			}
		}
		destination.add(wi);
	}
	
	private void updateWidgetPanel(Categorie categorie){
		if (GUI.getPanelTypeWidget().getCurrentCategorie() == categorie) {
				for (BoutonCategorie bc : PanelTypeWidget.getInstance().getLesCategories()) {
					if (bc.getCategorie() == categorie) {
						GUI.getPanelWidget().setLesWidgets(bc.getNbColonnes());
						break;
					}
				}
			}
	}

	@Override
	public void visiter(InstructionDeclaration instructionDeclaration) {
		Widget parent = widget;
		
		Variable var = instructionDeclaration.getMembre();
		if (var != null) {
			ajouterVariable(var);					
			widget = getWidgetClone(instructionDeclaration.getCategorie(), 
						TypeModeleWidget.DECLARERVARIABLE, parent);
			
			var.accepte(this);			
		}
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionDeclarationAffectation instructionDeclarationAffectation) {
		Widget parent = widget;
		
		Variable var = instructionDeclarationAffectation.getMembre();
		if (var != null) {
			ajouterVariable(var);					
			widget = getWidgetClone(Categorie.VARIABLES, 
						TypeModeleWidget.DECLARERVARIABLE, parent);
			
			var.accepte(this);			
		}
		
		widget = parent;
				
		Expression ex = instructionDeclarationAffectation.getMembreDroit();
		if (ex != null) {
			Affectation affectation = new Affectation((VariableModifiable) var, ex, true);
			affectation.accepte(this);
		}
	}

	@Override
	public void visiter(InstructionIf instructionIf) {
		Widget parent = widget;
		
		Expression cond = instructionIf.getCondition();
		if (cond != null) {
			widget = getWidgetClone(instructionIf.getCategorie(), 
						TypeModeleWidget.IF, parent);
			cond.accepte(this);
		}
		
		for (Instruction is : instructionIf.getEnfants()) {
			is.accepte(this);
		}
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionIfElse inst) {
		Widget parent = widget;
		
		//If
		Expression cond = inst.getCondition();
		if (cond != null) {
			widget = getWidgetClone(inst.getCategorie(), 
						TypeModeleWidget.IFELSE, parent);
			cond.accepte(this);
		}
		
		for (Instruction is : inst.getEnfantsIf()) {
			is.accepte(this);
		}
		
		//Else		
		for (Instruction is : inst.getEnfantsElse()) {
			prochWidgetZone = 1;
			is.accepte(this);
		}
		widget = parent;
	}

	@Override
	public void visiter(InstructionWhile inst) {
		Widget parent = widget;
		
		Expression cond = inst.getCondition();
		if (cond != null) {
			widget = getWidgetClone(inst.getCategorie(), 
						TypeModeleWidget.WHILE, parent);
			cond.accepte(this);
		}
		
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionDoWhile inst) {
		Widget parent = widget;
		
		Expression cond = inst.getCondition();
		if (cond != null) {
			widget = getWidgetClone(inst.getCategorie(), 
						TypeModeleWidget.DOWHILE, parent);
			cond.accepte(this);
		}
		
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		
		widget = parent;
	}

	
	
	@Override
	public void visiter(InstructionTache inst) {		
		widget = getWidgetClone(inst.getCategorie(), TypeModeleWidget.TACHE, null);
		widget.setLocation(20, 20);
		
		if(inst.getNom().equals("main")){
			PanelTypeWidget.getInstance().supprimerTachePrincipale();
			updateWidgetPanel(Categorie.STRUCTURES);
		}		
		
		try{
			arbo.ajouterWidgets(Arrays.asList(widget) , null, true);
		} catch (ComposantIntrouvableException ex) {
			ErreurHelper.afficher(ex);
		}
		
		for (Instruction is : inst.getEnfants()) {
			is.accepte(this);
		}
		
		try{
			DragAndDropTools.getInstance().dragGroupeWidget(arbo.getSuivants(widget, true), widget.getLocation());
		} catch (ComposantIntrouvableException ex) {
			ErreurHelper.afficher(ex);
		}	
		
		PanelCodeGraphique p = GUI.getPanelCodeGraphique();		
		ajouterSurPanel(widget, p );
		widget.defParent((IWidget) p);		
		arbo.updateWidgets();
		p.updateSize(arbo.getArborescence());
	}

	@Override
	public void visiter(TempsCourant exp) {
		Widget parent = widget;
		
		widget = getWidgetClone(exp.getCategorie(), 
						TypeModeleWidget.TEMPSCOURANT, parent);
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionAttente inst) {
		Widget parent = widget;
		
		Expression ex = inst.getExpression();
		if (ex != null) {
			widget = getWidgetClone(inst.getCategorie(), 
						TypeModeleWidget.WAIT, parent);
			
			prochVarZone = 0;
			ex.accepte(this);		
		}
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionMoteurMov inst) {
		Widget parent = widget;
		
		widget = getWidgetClone(inst.getCategorie(), 
						TypeModeleWidget.MOTEURMARCHE, parent);
		
		//if (inst.isReverse())
		
		widget.getModele().getLesZonesSaisies().get(0).setValeur(""+inst.getMoteur().ordinal());

		Expression ex = inst.getExpression();
		if (ex != null) {
			prochVarZone = 1;
			ex.accepte(this);
		}
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionMoteurOff inst) {
		Widget parent = widget;
		
		widget = getWidgetClone(inst.getCategorie(), 
						TypeModeleWidget.MOTEUROFF, parent);
		widget.getModele().getLesZonesSaisies().get(0).setValeur(""+inst.getMoteur().ordinal());
		
		widget = parent;
	}

	//TODO
	@Override
	public void visiter(InstructionFor instructionFor) {
		Widget parent = widget;
		
		Expression ini = instructionFor.getInitialisation();
		Expression cond = instructionFor.getCondition();
		Expression iter = instructionFor.getIteration();
		
		if (ini != null && cond != null && iter != null) {
			widget = getWidgetClone(instructionFor.getCategorie(), 
						TypeModeleWidget.FOR, parent);						
			ini.accepte(this);
			
			prochVarZone = 1;
			cond.accepte(this);
			
			prochVarZone = 2;
			iter.accepte(this);
			
			for (Instruction inst : instructionFor.getEnfants()) {
				inst.accepte(this);
			}		
		}
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionRepeat instructionRepeat) {
		Widget parent = widget;
		
		Expression exp = instructionRepeat.getExpression();
		if (exp != null) {
			widget = getWidgetClone(instructionRepeat.getCategorie(), 
						TypeModeleWidget.REPEAT, parent);			
			exp.accepte(this);
			
			for (Instruction inst : instructionRepeat.getEnfants()) {
				inst.accepte(this);
			}
		}
		
		widget = parent;
	}

	@Override
	public void visiter(Variable variable) {
		Widget parent = widget;
		
		if (variable.isConstante()) {
			Zone z = widget.getModele().getLesZonesSaisies().get(prochVarZone);
			((ChampTexte) z).setValeur(variable.getValeur());
		} else {
			ajouterVariableWidgetClone(variable, parent, prochVarZone);
		}
		prochVarZone = 0;
		widget = parent;				
	}

	@Override
	public void visiter(Affectation affectation) {
		if (affectation.isInstruction()) {
			Widget parent = widget;
			
			widget = getExprWidgetClone(Operateur.AFFECTATION, parent);

			Expression membre = affectation.getMembreDroit();
			if (membre != null) {
				membre.accepte(this);
			}

			membre = affectation.getMembreGauche();
			if (membre != null) {
				prochVarZone = 1;
				membre.accepte(this);
			}

			widget = parent;
		}
	}

	@Override
	public void visiter(ExpressionComplexe expr) {
		Widget parent = widget;
		Operateur op = expr.getOperateur();
		if( op != null ){
			widget = ajouterExprWidgetClone(op, parent, 0);
			
			Expression membre = expr.getMembreGauche();
			if (membre != null) {
				membre.accepte(this);
			}
			
			membre = expr.getMembreDroit();
			if (membre != null) {
				prochVarZone = 1;
				membre.accepte(this);
			}
		}
		
		widget = parent;
	}

	@Override
	public void visiter(NonLogique nonLog) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void visiter(InstructionDeclarationCapteur inst) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void visiter(VariableCapteur variableCapteur) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void visiter(InstructionMoteurRotate instructionMoteurRotate) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	//TODO
	@Override
	public void visiter(InstructionIncrementation instructionIncrementation) {
		Widget parent = widget;
		Operateur op = (Operateur) instructionIncrementation.getOperateur();
		if( op != null ){
			widget = ajouterExprWidgetClone(op, parent, 0);
			
			instructionIncrementation.getVariable().accepte(this);
		}
		widget = parent;
	}

	@Override
	public void visiter(ValeurCapteur valCapteur) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void visiter(RotationMoteur rotMoteur) {
		Widget parent = widget;
		
		widget = getWidgetClone(rotMoteur.getCategorie(), 
						TypeModeleWidget.MOTEURNOMBREROTATION, parent);
		widget.getModele().getLesZonesSaisies().get(0).setValeur(""+rotMoteur.getMoteur().ordinal());
		
		widget = parent;
	}

	@Override
	public void visiter(InstructionRAZRotationMoteur razMoteur) {
		Widget parent = widget;
		
		widget = getWidgetClone(razMoteur.getCategorie(), 
						TypeModeleWidget.MOTEURRAZ, parent);
		widget.getModele().getLesZonesSaisies().get(0).setValeur(""+razMoteur.getMoteur().ordinal());
		
		widget = parent;
	}

	//TODO
	@Override
	public void visiter(InstructionConfigCapteurs confCapt) {
		Widget parent = widget;
		
		widget = getWidgetClone(confCapt.getCategorie(), 
						TypeModeleWidget.CAPTEURCONFIG, parent);
				
		Capteur capt = confCapt.getCapteurAuSlot(CapteurSlot.A);
		if(capt != null)
			widget.getModele().getLesZonesSaisies().get(0).setValeur(""+capt.ordinal());
		
		capt = confCapt.getCapteurAuSlot(CapteurSlot.B);
		if(capt != null)
			widget.getModele().getLesZonesSaisies().get(1).setValeur(""+capt.ordinal());
		
		capt = confCapt.getCapteurAuSlot(CapteurSlot.C);
		if(capt != null)
			widget.getModele().getLesZonesSaisies().get(2).setValeur(""+capt.ordinal());

		capt = confCapt.getCapteurAuSlot(CapteurSlot.D);
		if(capt != null)
			widget.getModele().getLesZonesSaisies().get(3).setValeur(""+capt.ordinal());
		
		widget = parent;
	}
	
}
