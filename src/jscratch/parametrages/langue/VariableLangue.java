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
package jscratch.parametrages.langue;

/**
 * Permet de stocker les clés des fichiers LANG.
 * 
 * @since 1.0
 * @version 1.0
 */
public enum VariableLangue {

	// Clés supplémentaires
	SUP_GAUCHE, SUP_DROITE, SUP_TRUE, SUP_FALSE, SUP_WIDGET, SUP_CAT,
	
	// Clés du menu
	FIC, FIC_NEW, FIC_LOAD_ALGORITHME, FIC_SAVE, FIC_LOAD_PROPERTIES, FIC_QUIT,
	EXP, EXP_NXC, EXP_ROBOT,
	TRA, TRA_EXPORT,
	MOR, MOR_HELP,
	
	// Docking
	DOCK_ED_GRAPH, DOCK_ED_CODE, DOCK_SIM, DOCK_CODE, DOCK_COMP, DOCK_OUTPUT,
	
	// Simulateur (boutons)
	SIM_BUT_EXEC, SIM_BUT_PAUSE, SIM_BUT_STOP, SIM_BUT_DEB, SIM_BUT_DEB_SEN, SIM_BUT_DEB_COL,
	
	// Simulateur (panel gauche robot)
	SIM_PAN_ROB, SIM_PAN_ROB_VITESSE, SIM_PAN_ROB_ROTATION, SIM_PAN_ROB_ORIENTATION, SIM_PAN_ROB_POSITION, SIM_PAN_CAPT,

	// Capteurs
	CAPT_NONE, CAPT_TOUCH, CAPT_COLOR, CAPT_ULTRASONIC, CAPT_LIGHT,
	
	// Compilateur
	COMPIL_EXEC, COMPIL_COMPIL,
	
	// Widgets (catégories)
	CAT_STRUCTURES, CAT_MOTEURS, CAT_CAPTEURS, CAT_TEMPS, CAT_VARIABLES, CAT_EXPRESSIONS;

	@Override
	public String toString() {
		switch(this) {
			case SUP_GAUCHE: return "direction.left";
			case SUP_DROITE: return "direction.right";
			case SUP_TRUE: return "bool.true";
			case SUP_FALSE: return "bool.false";	
			case SUP_WIDGET: return "word.widgets";
			case SUP_CAT: return "word.categories";

			case FIC : return "menu.file";
			case FIC_NEW :return "menu.file.new";
			case FIC_LOAD_ALGORITHME :return "menu.file.load.algorithm";
			case FIC_SAVE: return "menu.file.save";
			case FIC_LOAD_PROPERTIES: return "menu.file.load.properties";
			case FIC_QUIT: return "menu.file.quit";
			case EXP: return "menu.export";
			case EXP_NXC: return "menu.export.nxc";
			case EXP_ROBOT: return "menu.export.robot";
			case TRA: return "menu.trace";
			case TRA_EXPORT: return "menu.trace.export";
			case MOR: return "menu.more";
			case MOR_HELP: return "menu.more.help";
				
			case DOCK_ED_GRAPH: return "interface.dock.edition.graphic";
			case DOCK_ED_CODE: return "interface.dock.edition.code";
			case DOCK_SIM: return "interface.dock.simulation";
			case DOCK_CODE: return "interface.dock.code";
			case DOCK_OUTPUT: return "interface.dock.output";
			case DOCK_COMP: return "interface.dock.compiler";
				
			case SIM_BUT_EXEC: return "interface.simulator.buttons.execute";
			case SIM_BUT_PAUSE: return "interface.simulator.buttons.pause";
			case SIM_BUT_STOP: return "interface.simulator.buttons.stop";
			case SIM_BUT_DEB: return "interface.simulator.buttons.debug";
			case SIM_BUT_DEB_SEN: return "interface.simulator.buttons.debug.sensors";
			case SIM_BUT_DEB_COL: return "interface.simulator.buttons.debug.collisions";
				
			case SIM_PAN_ROB: return "interface.simulator.robot";
			case SIM_PAN_ROB_VITESSE: return "interface.simulator.robot.speed";
			case SIM_PAN_ROB_ROTATION: return "interface.simulator.robot.rotations";
			case SIM_PAN_ROB_ORIENTATION: return "interface.simulator.robot.orientation";
			case SIM_PAN_ROB_POSITION: return "interface.simulator.robot.position";
			case SIM_PAN_CAPT: return "interface.simulator.sensors";
				
			case COMPIL_EXEC: return "interface.compiler.execute";
			case COMPIL_COMPIL: return "interface.compiler.compile";
				
			case CAPT_NONE: return "sensors.none";
			case CAPT_TOUCH: return "sensors.touch";
			case CAPT_COLOR: return "sensors.color";
			case CAPT_ULTRASONIC: return "sensors.ultrasonic";
			case CAPT_LIGHT: return "sensors.light";
				
			case CAT_STRUCTURES: return "categories.structs";
			case CAT_MOTEURS: return "categories.engines";
			case CAT_CAPTEURS: return "categories.sensors";
			case CAT_TEMPS: return "categories.times";
			case CAT_VARIABLES: return "categories.variables";
			case CAT_EXPRESSIONS: return "categories.expressions";
			
			default: return "";
		}
	}	
}