package jscratch.interpreteur;

import jscratch.interpreteur.parser.NXCParser;
import org.antlr.runtime.tree.Tree;

/**
 * Explorateur d'un arbre syntaxique d'ANTLR pour un code NXC.
 * 
 * @author Adrien DUROY
 */
public class ExplorerASTNXC {
    private final Object mutexMonteur;
    private MonteurProgramme monteur;

    public ExplorerASTNXC(MonteurProgramme monteur) {
        mutexMonteur = new Object();
        this.monteur = monteur;
    }

    public void explore(Tree antlrTree) {
        synchronized(mutexMonteur) {
            monteur.reset();
            exploration(antlrTree);
        }
    }

    private void exploration(Tree tree) {
        int nbChild = tree.getChildCount();
        switch(tree.getType()) {
			/* Traitements préfixes */
            case NXCParser.ROOT:
                for(int i = 0; i < nbChild; i++) {
                    exploration(tree.getChild(i));
                }
                System.out.println("Fin (ROOT atteint)");
            case NXCParser.TASK_DEFINITION:
                traitementTache(tree, nbChild);
                break;
			case NXCParser.VAR_DECLARATION:
				traitementDeclaration(tree, nbChild);
				break;
			case NXCParser.WHILE:
				traitementWhile(tree);
				break;
			case NXCParser.IF:
				if(nbChild == 2) {//if seul
					traitementIf(tree);
				}
				else {//if avec else
					traitementIfElse(tree);
				}
				break;
			case NXCParser.FOR:
				traitementFor(tree);
				break;
			case NXCParser.FUNC_CALL:
				traitementAppelFonction(tree, nbChild);
				break;
            default:
				//Exploration des fils
                for(int i = 0; i < nbChild; i++) {
                    exploration(tree.getChild(i));
                }
				/* traitements postfixes */
				switch(tree.getType()) {
					case NXCParser.DECIMAL_LITERAL:
						System.out.println("constante int " + tree.getText());
						monteur.constante(tree.getText(), "int");
						break;
					case NXCParser.STRING_LITERAL:
						System.out.println("constante string " + tree.getText());
						monteur.constante(tree.getText(), "string");
						break;
					case NXCParser.CHARACTER_LITERAL:
						System.out.println("constante char " + tree.getText());
						monteur.constante(tree.getText(), "char");
						break;
					case NXCParser.FLOAT_LITERAL:
						System.out.println("constante double " + tree.getText());
						monteur.constante(tree.getText(), "double");
						break;
					case NXCParser.PLUS:
					case NXCParser.MINUS:
					case NXCParser.STAR:
					case NXCParser.DIVIDE:
						System.out.println("operation " + tree.getText());
						monteur.operation(tree.getText());
						break;
					case NXCParser.GREATERTHAN:
					case NXCParser.GREATEREQUAL:
					case NXCParser.LESSTHAN:
					case NXCParser.LESSEQUAL:
					case NXCParser.EQUAL:
						System.out.println("condition " + tree.getText());
						monteur.condition(tree.getText());
						break;
					case NXCParser.ASSIGN:
						System.out.println("affectation");
						monteur.affectation();
						break;
					case NXCParser.IDENTIFIER:
						System.out.println("Variable " + tree.getText());
						monteur.variable(tree.getText());
						break;
					case NXCParser.ARGUMENTS:
						System.out.println(nbChild + " arguments");
						break;
					case NXCParser.STATEMENTS:
						System.out.println(nbChild + " instructions");
						break;
					default:
						System.out.println(tree.getText() + " : " + tree.getType());
					case NXCParser.INITIALIZER:
						break;
				}
                break;
        }
    }

	/* Gère l'exploration d'une tâche */
    private void traitementTache(Tree tree, int nbChild) {
        if(nbChild == 3) {
            String nom = tree.getChild(1).getText();
			int nbElemCorps = tree.getChild(2).getChildCount();//STATEMENTS
			for(int i = 0; i < nbElemCorps; i++) {
				exploration(tree.getChild(2).getChild(i));
			}
			System.out.println("Tâche " + nom + " (" + nbElemCorps + ")");
			monteur.tache(nom, nbElemCorps);
        }
    }
	
	/* Gère l'exploration d'une déclaration de variable */
	private void traitementDeclaration(Tree tree, int nbChild) {
		if(nbChild >= 2) {
			String type = convertTypeVar(tree.getChild(0).getText());
			String var = tree.getChild(1).getText();
			if(nbChild == 2) {
				System.out.println("Déclaration de " + type + " " + var);
				monteur.declaration(type, var);
			}
			else if(nbChild == 3) {// Declaration + initialisation
				exploration(tree.getChild(2));
				System.out.println("Déclaration initialisation de " + type + " " + var);
				monteur.declarationInitialisation(type, var);
			}
		}
	}
	
	/* Gère l'exploration d'un for */
	private void traitementFor(Tree tree) {
		int nbSousChild;
		//DO
		nbSousChild = tree.getChild(0).getChildCount();
		for(int i = 0; i < nbSousChild; i++) {
			exploration(tree.getChild(0).getChild(i));
		}
		//WHILE
		nbSousChild = tree.getChild(1).getChildCount();
		for(int i = 0; i < nbSousChild; i++) {
			exploration(tree.getChild(1).getChild(i));
		}
		//REPEAT
		nbSousChild = tree.getChild(2).getChildCount();
		for(int i = 0; i < nbSousChild; i++) {
			exploration(tree.getChild(2).getChild(i));
		}
		//STATEMENTS
		int nbStatements = tree.getChild(3).getChildCount();
		for(int i = 0; i < nbStatements; i++) {
			exploration(tree.getChild(3).getChild(i));
		}
        System.out.println("for (" + nbStatements + ")");
	}
	
	/* Gère l'exploration d'un appel de fonction */
	private void traitementAppelFonction(Tree tree, int nbChild) {
		String nom = tree.getChild(0).getText();
		int nbArgs = tree.getChild(1).getChildCount();//ARGS
		for(int i = 0; i < nbArgs; i++) {
			exploration(tree.getChild(1).getChild(i));
		}
		System.out.println("fonction " + nom + " (args " + nbArgs + ")");
		monteur.fonctionAppel(nom, nbArgs);
	}
	
	/* Gère l'exploration d'un while */
	private void traitementWhile(Tree tree) {
		exploration(tree.getChild(0));//Condition
		int nbInsts = tree.getChild(1).getChildCount();
		for(int i = 0; i < nbInsts; i++) {//STATEMENTS
			exploration(tree.getChild(1).getChild(i));
		}
		System.out.println("while (" + nbInsts + ")");
		monteur.bwhile(nbInsts);
	}
	
	/* Gère l'exploration d'un if seul */
	private void traitementIf(Tree tree) {
		exploration(tree.getChild(0));//Condition
		int nbInsts = tree.getChild(1).getChildCount();
		for(int i = 0; i < nbInsts; i++) {//STATEMENTS
			exploration(tree.getChild(1).getChild(i));
		}
		System.out.println("if (" + nbInsts + ")");
		monteur.si(nbInsts);
	}
	
	/* Gère l'exploration d'un if suivi d'un else */
	private void traitementIfElse(Tree tree) {
		//if
		exploration(tree.getChild(0));//Condition
		int nbInsts = tree.getChild(1).getChildCount();
		for(int i = 0; i < nbInsts; i++) {//STATEMENTS
			exploration(tree.getChild(1).getChild(i));
		}

		Tree childElse0 = tree.getChild(2).getChild(0);
		int nbInst2 = childElse0.getChildCount();
		switch(childElse0.getType()) {
			case NXCParser.STATEMENTS://else
				for(int i = 0; i < nbInst2; i++) {
					exploration(childElse0.getChild(i));
				}
				break;
			default://else if
				nbInst2 = tree.getChild(2).getChildCount();
				exploration(childElse0);
				break;
		}
		System.out.println("ifelse (" + nbInsts + ", " + nbInst2 + ")");
		monteur.siSinon(nbInsts, nbInst2);
	}
	
	/* Convertie le nom d'un type de l'arbre généré par le parser en un nom plus lisible */
	private String convertTypeVar(String typeFromAST) {
		if(typeFromAST.equals("T_S16") || typeFromAST.equals("T_U16")) {
			return "int";
		}
		else if(typeFromAST.equals("T_S32") || typeFromAST.equals("T_U32")) {
			return "long";
		}
		else if(typeFromAST.equals("T_FLOAT")) {
			return "float";
		}
		else if(typeFromAST.equals("T_STRING")) {
			return "string";
		}
		return "";
	}
}
