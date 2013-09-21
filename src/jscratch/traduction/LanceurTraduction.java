/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

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
package jscratch.traduction;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import nxtim.instruction.Instruction;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.ModeleWidget;

/**
 * Cette classe s'occupe de lancer la traduction du programme construit avec les widgets.<br/>
 * Utilise le design pattern Singleton.
 */
public final class LanceurTraduction extends Observable {

	/**
	 * Le visiteur qui doit être éxecuté.
	 */
	private VisiteurTraduction traducteur;
	/**
	 * L'instance de
	 * <code>LanceurTraduction</code>.
	 */
	private static LanceurTraduction instance = null;

	/**
	 * Définit le lanceur de traduction.
	 */
	private LanceurTraduction() {
		traducteur = VisiteurNXC.getInstance();
		this.addObserver(GUI.getPanelCodeConsole());
	}

	/**
	 * Donne l'instance unique de la classe.
	 *
	 * @return l'instance
	 */
	public static synchronized LanceurTraduction getInstance() {
		if (instance == null) {
			instance = new LanceurTraduction();
		}
		return instance;
	}
	
	/**
	 * Permet de redémarrer le lanceur traduction.
	 * 
	 * @since 1.0
	 * 
	 * @return le nouveau lanceur
	 */
	public static synchronized LanceurTraduction reset() {
		instance = null;
		return getInstance();
	}

	/**
	 * Permet de lancer la traduction.
	 *
	 * @since 1.0
	 */
	public void lancerTraduction() {
		traducteur.reset();
		List<Instruction> list = trouveTaches();
		for (Instruction inst : list) {
			inst.accepte(traducteur);
		}
		this.setChanged();
		this.notifyObservers(traducteur.getTraduction());
	}

	/**
	 * Trouve les tâches parmi les widgets.<br/>
	 * La traduction est effectuée à partir de celles-ci.
	 *
	 * @return les instructions à traduire
	 */
	private List<Instruction> trouveTaches() {
		List<Instruction> list = new LinkedList<Instruction>();
		for (List<Widget> racine : ArborescenceTools.getInstance().getArborescence()) {
			if (!racine.isEmpty()) {
				Widget tache = racine.get(0);
				ModeleWidget m = tache.getModele();
				if (m.getType() == TypeModeleWidget.TACHE) {
					list.add((Instruction) m.getElementProgramme());
				}
			}
		}
		return list;
	}

	/**
	 * Modifie le traducteur utilisé.<br />
	 * Si n'a jamais été appelé c'est le traducteur vers NXC qui est utilisé.
	 *
	 * @param visiteur le nouveau traducteur
	 */
	public void setTraducteur(VisiteurTraduction visiteur) {
		traducteur = visiteur;
	}
}