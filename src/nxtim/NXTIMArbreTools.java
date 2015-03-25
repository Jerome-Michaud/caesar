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
package nxtim;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jscratch.generation.LanceurGeneration;
import jscratch.interpreteur.ExplorerASTNXC;
import jscratch.interpreteur.MonteurNXTIM;
import jscratch.interpreteur.parser.NXCLexer;
import jscratch.interpreteur.parser.NXCParser;
import jscratch.vue.arborescence.ArborescenceTools;
import jscratch.vue.ginterface.principales.GUI;
import nxtim.instruction.Instruction;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 * Classe implémentant le design pattern Singleton permettant de gérer
 * l'analyse de code NXTIM
 */
public class NXTIMArbreTools extends Observable {
	private static final NXTIMArbreTools instance = new NXTIMArbreTools();
	private final MonteurNXTIM monteur;
	private final ExplorerASTNXC explorer;
	private List<Instruction> taches;
	private boolean widgetsModified = false;
	private boolean generationInProcess = false;
	private final Notifier notifier = new Notifier();
	
	public static NXTIMArbreTools getInstance(){
		return instance;
	}
	
	private NXTIMArbreTools(){
		monteur = new MonteurNXTIM();
		explorer = new ExplorerASTNXC(monteur);
		taches = new LinkedList<Instruction>();
		this.addObserver(GUI.getPanelCodeConsole());
	}	
	
	private void explore(Tree antlrTree){
		explorer.explore(antlrTree);
		
		taches.clear();		
		try{
			taches.add((Instruction)monteur.getModele());
		} catch (EmptyStackException ex){
			//pile est vide, il n'y pas d'instructions à ajouter
		}
	}
	
	public List<Instruction> trouveTaches(){		
		return taches;
	}
	
	/**
	 * Compile le code NXC
	 * 
	 * @param code le code NXC à compiler
	 */
	public void compiler(String code){
		NXCLexer lex = new NXCLexer(new ANTLRStringStream(code));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		NXCParser parser = new NXCParser(tokens);
		
		String output = "";
		try {
			NXCParser.translation_unit_return ret = parser.translation_unit();
			if(parser.getNumberOfSyntaxErrors() != 0) {
					output = "Erreur de syntaxe !";
					for(Object o: parser.getCompilMessages())
						output+= "\n" + o;
			}
			else {
				CommonTree tree = (CommonTree)ret.getTree();
				explore(tree);
							
				//Prévenir la compilation pendant la génération des widgets
				//car ils appellent les observers pendant leur modification
				generationInProcess = true;
				LanceurGeneration.getInstance().lancerGeneration();
				generationInProcess = false;
			} 
		} catch (RecognitionException e) {
			output = e.getMessage();
		}
		
		this.setChanged();
		this.notifyObservers(output);
		widgetsModified = false;
	}
	
	public void updateFromWidgets(){
		if(!generationInProcess){
			taches = ArborescenceTools.getInstance().trouveTaches();
			widgetsModified = true;
		}
	}

	public boolean isWidgetsModified() {
		return widgetsModified;
	}

	public Notifier getObserver() {
		return notifier;
	}
	
	
	public class Notifier implements Observer {
		
		@Override
		public void update(Observable o, Object arg) {		
			NXTIMArbreTools.getInstance().updateFromWidgets();
		}
		
	}
}
