package vue.widget;

import instruction.TypeVariable;
import instruction.VariableModifiable;
import vue.tools.NonClonableException;
import vue.widget.modele.DoWhileWidget;
import vue.widget.modele.ExpressionAndWidget;
import vue.widget.modele.ExpressionDivisionWidget;
import vue.widget.modele.ExpressionEqualToWidget;
import vue.widget.modele.ExpressionModulusWidget;
import vue.widget.modele.ExpressionMultiplicationWidget;
import vue.widget.modele.ExpressionNEqualToWidget;
import vue.widget.modele.ExpressionOperatorInfEqualWidget;
import vue.widget.modele.ExpressionOperatorInfWidget;
import vue.widget.modele.ExpressionOperatorSupEqualWidget;
import vue.widget.modele.ExpressionOperatorSupWidget;
import vue.widget.modele.ExpressionOrWidget;
import vue.widget.modele.ExpressionSubtractionWidget;
import vue.widget.modele.ForWidget;
import vue.widget.modele.IfElseWidget;
import vue.widget.modele.IfWidget;
import vue.widget.modele.InstructionWidget;
import vue.widget.modele.MoteurMovFwdWidget;
import vue.widget.modele.MoteurMovRevWidget;
import vue.widget.modele.MoteurOffWidget;
import vue.widget.modele.RepeatWidget;
import vue.widget.modele.TacheWidget;
import vue.widget.modele.WaitWidget;
import vue.widget.modele.VariableWidget;
import vue.widget.modele.VariableSetValueWidget;
import vue.widget.modele.WhileWidget;
import vue.widget.modele.ExpressionSumWidget;

/**
 * Classe implémentant le design pattern Factory permettant la création de tous les types de widgets.
 */
/**
 * modification CHOUKET Houda
 */
public class FabriqueInstructions {

	/**
	 * Méthode permettant de créer un widget de type "Avance Moteur Marche Avant".
	 *
	 * @return un widget de type "Avance Moteur Marche Avant"
	 */
	public Widget creerWidgetMoteurMovFwd() {
		return new Widget(new MoteurMovFwdWidget());
	}

	/**
	 * Méthode permettant de créer un widget de type "Avance Moteur Marche Arrière".
	 *
	 * @return un widget de type "Avance Moteur Marche Arrière"
	 */
	public Widget creerWidgetMoteurMovRev() {
		return new Widget(new MoteurMovRevWidget());
	}

	/**
	 * Méthode permettant de créer un widget de type "Arrêt Moteur".
	 *
	 * @return un widget de type "Arrêt Moteur"
	 */
	public Widget creerWidgetMoteurOff() {
		return new Widget(new MoteurOffWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Boucle Pour".
	 *
	 * @return un widget complexe de type "Boucle Pour"
	 */
	public Widget creerWidgetFor() {
		return new WidgetCompose(new ForWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Boucle Tant Que".
	 *
	 * @return un widget complexe de type "Boucle Tant que"
	 */
	public Widget creerWidgetWhile() {
		return new WidgetCompose(new WhileWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Boucle Faire Tant Que".
	 *
	 * @return un widget complexe de type "Boucle Faire Tant que"
	 */
	public Widget creerWidgetDoWhile() {
		return new WidgetCompose(new DoWhileWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Répéter".
	 *
	 * @return un widget complexe de type "Répéter"
	 */
	public Widget creerWidgetRepeat() {
		return new WidgetCompose(new RepeatWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Structure Si".
	 *
	 * @return un widget complexe de type "Structure Si"
	 */
	public Widget creerWidgetIf() {
		return new WidgetCompose(new IfWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Structure Si Sinon".
	 *
	 * @return un widget complexe de type "Structure Si Sinon"
	 */
	public Widget creerWidgetIfElse() {
		return new WidgetCompose(new IfElseWidget());
	}

	/**
	 * Méthode permettant de créer un widget de type "Attente".
	 *
	 * @return un widget de type "Attente"
	 */
	public Widget creerWidgetWait() {
		return new Widget(new WaitWidget());
	}

	/**
	 * Méthode permettant de créer un widget de type "Variable".
	 *
	 * @return un widget de type "Variable"
	 */

	/**
	 * Méthode permettant de créer un widget de type "Variable".
	 *
	 * @return un widget de type "Variable"
	 */
	public Widget creerWidgetVariable(VariableModifiable variableModifiable) {
		return new Widget(new VariableWidget(variableModifiable));
	}


	/**
	 * Méthode permettant de créer un widget de type "VariableSetValue".
	 *
	 * @return un widget de type "VariableSetValue"
	 */
	public Widget creerWidgetVariableSetValue() {
		return new Widget(new VariableSetValueWidget());
	}       


	/**
	 * Méthode permettant de créer un widget complexe de type "Tâche".
	 *
	 * @return un widget complexe de type "Tâche"
	 */
	public Widget creerWidgetTache() {
		return new WidgetCompose(new TacheWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (addition).
	 *
	 * @return un widget complexe de type "ExpressionAritm�thique"
	 */
	public Widget creerWidgetExpressionSum() {
		return new WidgetCompose(new ExpressionSumWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (soustraction).
	 *
	 * @return un widget complexe de type "ExpressionAritm�thique"
	 */
	public Widget creerWidgetExpressionSubtraction() {
		return new WidgetCompose(new ExpressionSubtractionWidget());
	}



	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (Multiplication).
	 *
	 * @return un widget complexe de type "ExpressionAritm�thique"
	 */
	public Widget creerWidgetExpressionMultiplication() {
		return new WidgetCompose(new ExpressionMultiplicationWidget());
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (Division).
	 *
	 * @return un widget complexe de type "ExpressionAritm�thique"
	 */
	public Widget creerWidgetExpressionDivision() {
		return new WidgetCompose(new ExpressionDivisionWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (modulo).
	 *
	 * @return un widget complexe de type "ExpressionAritm�thique"
	 */
	public Widget creerWidgetExpressionModulus() {
		return new WidgetCompose(new ExpressionModulusWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (OR).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionOR() {
		return new WidgetCompose(new ExpressionOrWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (AND).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionAND() {
		return new WidgetCompose(new ExpressionAndWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (equal to).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionEqualTO() {
		return new WidgetCompose(new ExpressionEqualToWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (not equal to).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionNEqualTO() {
		return new WidgetCompose(new ExpressionNEqualToWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (operatorsuperieur).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionOperatorSup() {
		return new WidgetCompose(new ExpressionOperatorSupWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (operatorinferieur).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionOperatorInf() {
		return new WidgetCompose(new ExpressionOperatorInfWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (operatorsuperieur).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionOperatorSupEqual() {
		return new WidgetCompose(new ExpressionOperatorSupEqualWidget());
	}
	/**
	 * Méthode permettant de créer un widget complexe de type "Expression" (operatorinferieur).
	 *
	 * @return un widget complexe de type "ExpressionLogique"
	 */
	public Widget creerWidgetExpressionOperatorInfEqual() {
		return new WidgetCompose(new ExpressionOperatorInfEqualWidget());
	}
	/**
	 * Méthode permettant de créér une copie d'un widget.
	 *
	 * @param comp le widget à cloner
	 * @return la copie du widget passé en paramètre
	 * @throws NonClonableException Si on essaye de cloner un widget qui n'est pas clonable
	 */
	public Widget cloner(final Widget comp) throws NonClonableException {
		Widget w = null;
		if (comp.getModele() instanceof InstructionWidget) {
			//w = creerWidgetMoteurFwd();
		}
		else if (comp.getModele() instanceof IfWidget) {
			w = creerWidgetIf();
		}
		else if (comp.getModele() instanceof IfElseWidget) {
			w = creerWidgetIfElse();
		}
		else if (comp.getModele() instanceof TacheWidget) {
			w = creerWidgetTache();
		}
		else if (comp.getModele() instanceof WhileWidget) {
			w = creerWidgetWhile();
		}
		else if (comp.getModele() instanceof DoWhileWidget) {
			w = creerWidgetDoWhile();
		}
		else if (comp.getModele() instanceof MoteurMovFwdWidget) {
			w = creerWidgetMoteurMovFwd();
		}
		else if (comp.getModele() instanceof MoteurMovRevWidget) {
			w = creerWidgetMoteurMovRev();
		}
		else if (comp.getModele() instanceof MoteurOffWidget) {
			w = creerWidgetMoteurOff();
		}
		else if (comp.getModele() instanceof WaitWidget) {
			w = creerWidgetWait();
		}
		/* ajout de widget variable */
		else if (comp.getModele() instanceof VariableWidget) {
			w = creerWidgetVariable((VariableModifiable)comp.getModele().getElementProgramme());
		}
		else if (comp.getModele() instanceof VariableSetValueWidget) {
			w = creerWidgetVariableSetValue();
		}                
		/* */
		else if (comp.getModele() instanceof RepeatWidget) {
			w = creerWidgetRepeat();
		}
		else if (comp.getModele() instanceof ForWidget) {
			w = creerWidgetFor();
		}
		else if (comp.getModele() instanceof ExpressionSumWidget) {
			w = creerWidgetExpressionSum();
		}
		else if (comp.getModele() instanceof ExpressionSubtractionWidget) {
			w = creerWidgetExpressionSubtraction();
		}
		else if (comp.getModele() instanceof ExpressionMultiplicationWidget) {
			w = creerWidgetExpressionMultiplication();
		}
		else if (comp.getModele() instanceof ExpressionDivisionWidget) {
			w = creerWidgetExpressionDivision();
		}
		else if (comp.getModele() instanceof ExpressionModulusWidget) {
			w = creerWidgetExpressionModulus();
		}
		else if (comp.getModele() instanceof ExpressionOrWidget) {
			w = creerWidgetExpressionOR();
		}
		else if (comp.getModele() instanceof ExpressionAndWidget) {
			w = creerWidgetExpressionAND();
		}
		else if (comp.getModele() instanceof ExpressionEqualToWidget) {
			w = creerWidgetExpressionEqualTO();
		}
		else if (comp.getModele() instanceof ExpressionNEqualToWidget) {
			w = creerWidgetExpressionNEqualTO();
		}
		else if (comp.getModele() instanceof ExpressionOperatorSupWidget) {
			w = creerWidgetExpressionOperatorSup();
		}
		else if (comp.getModele() instanceof ExpressionOperatorInfWidget) {
			w = creerWidgetExpressionOperatorInf();
		}
		else if (comp.getModele() instanceof ExpressionOperatorSupEqualWidget) {
			w = creerWidgetExpressionOperatorSupEqual();
		}
		else if (comp.getModele() instanceof ExpressionOperatorInfEqualWidget) {
			w = creerWidgetExpressionOperatorInfEqual();
		}
		if (w == null) {
			throw new NonClonableException("Ajouter le type de widget \"" + comp.getType() + "\"dans la méthode clone");
		}
		w.getModele().setCouleur(comp.getModele().getCouleur());
		return w;
	}
}