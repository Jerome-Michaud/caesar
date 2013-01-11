package vue.widget;

import instruction.Condition;
import instruction.ExpressionModifiable;
import instruction.Operateur;
import instruction.Operation;
import instruction.VariableModifiable;
import vue.tools.NonChargeableException;
import vue.tools.NonClonableException;
import vue.widget.modele.DoWhileWidget;

import vue.widget.modele.ExpressionArithmeticWidget;
import vue.widget.modele.ExpressionLogicalWidget;
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

/**
 * Classe implémentant le design pattern Factory permettant la création de tous les types de widgets.
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
	 * Méthode permettant de créer un widget complexe de type "Expression".
	 *
	 * @return un widget complexe de type "expression arithmetique"
	 */
	public Widget creerWidgetExpressionArithmetic(Operateur op) {
		return new WidgetCompose(new ExpressionArithmeticWidget(op));
	}

	/**
	 * Méthode permettant de créer un widget complexe de type "Expression".
	 *
	 * @return un widget complexe de type "expression logique"
	 */
	/*public Widget creerWidgetExpressionLogical(Operateur op, ExpressionModifiable expressionModifiable) {
		return new WidgetCompose(new ExpressionLogicalWidget(op, expressionModifiable));
	}*/
	public Widget creerWidgetExpressionLogical(Operateur op) {
		return new WidgetCompose(new ExpressionLogicalWidget(op));
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
		} else if (comp.getModele() instanceof IfWidget) {
			w = creerWidgetIf();
		} else if (comp.getModele() instanceof IfElseWidget) {
			w = creerWidgetIfElse();
		} else if (comp.getModele() instanceof TacheWidget) {
			w = creerWidgetTache();
		} else if (comp.getModele() instanceof WhileWidget) {
			w = creerWidgetWhile();
		} else if (comp.getModele() instanceof DoWhileWidget) {
			w = creerWidgetDoWhile();
		} else if (comp.getModele() instanceof MoteurMovFwdWidget) {
			w = creerWidgetMoteurMovFwd();
		} else if (comp.getModele() instanceof MoteurMovRevWidget) {
			w = creerWidgetMoteurMovRev();
		} else if (comp.getModele() instanceof MoteurOffWidget) {
			w = creerWidgetMoteurOff();
		} else if (comp.getModele() instanceof WaitWidget) {
			w = creerWidgetWait();
		} /* ajout de widget variable */ else if (comp.getModele() instanceof VariableWidget) {
			w = creerWidgetVariable((VariableModifiable) comp.getModele().getElementProgramme());
		} else if (comp.getModele() instanceof VariableSetValueWidget) {
			w = creerWidgetVariableSetValue();
		} /* */ else if (comp.getModele() instanceof RepeatWidget) {
			w = creerWidgetRepeat();
		} else if (comp.getModele() instanceof ForWidget) {
			w = creerWidgetFor();
		} else if (comp.getModele() instanceof ExpressionArithmeticWidget) {
			Operation op = (Operation) comp.getModele().getElementProgramme();
			w = creerWidgetExpressionArithmetic(op.getOperateur());
		} else if (comp.getModele() instanceof ExpressionLogicalWidget) {
			Condition con = (Condition) comp.getModele().getElementProgramme();

			w = creerWidgetExpressionLogical(con.getOperateur());
			//w = creerWidgetExpressionLogical(con.getOperateur(), null);
		}

		if (w == null) {
			throw new NonClonableException("Ajouter le type de widget \"" + comp.getType() + "\"dans la méthode clone");
		}
		w.getModele().setCouleur(comp.getModele().getCouleur());
		return w;
	}

	/**
	 * Méthode permettant de créér une copie d'un widget.
	 *
	 * @param comp le widget à cloner
	 * @return la copie du widget passé en paramètre
	 * @throws NonClonableException Si on essaye de cloner un widget qui n'est pas clonable
	 */
	public Widget creerWidget(final String nomClasse) throws NonChargeableException {
		Widget w = null;
		if ("InstructionWidget".equals(nomClasse)) {
			//w = creerWidgetMoteurFwd();
		} else if ("IfWidget".equals(nomClasse)) {
			w = creerWidgetIf();
		} else if ("IfElseWidget".equals(nomClasse)) {
			w = creerWidgetIfElse();
		} else if ("TacheWidget".equals(nomClasse)) {
			w = creerWidgetTache();
		} else if ("WhileWidget".equals(nomClasse)) {
			w = creerWidgetWhile();
		} else if ("DoWhileWidget".equals(nomClasse)) {
			w = creerWidgetDoWhile();
		} else if ("MoteurMovFwdWidget".equals(nomClasse)) {
			w = creerWidgetMoteurMovFwd();
		} else if ("MoteurMovRevWidget".equals(nomClasse)) {
			w = creerWidgetMoteurMovRev();
		} else if ("MoteurOffWidget".equals(nomClasse)) {
			w = creerWidgetMoteurOff();
		} else if ("WaitWidget".equals(nomClasse)) {
			w = creerWidgetWait();
		} /* ajout de widget variable */ /*else if ("VariableWidget".equals(nomClasse)) {
		 w = creerWidgetVariable((VariableModifiable)comp.getModele().getElementProgramme());
		 }*/ else if ("VariableSetValueWidget".equals(nomClasse)) {
			w = creerWidgetVariableSetValue();
		} /* */ else if ("RepeatWidget".equals(nomClasse)) {
			w = creerWidgetRepeat();
		} else if ("ForWidget".equals(nomClasse)) {
			w = creerWidgetFor();
		}
		/*else if ("ExpressionArithmeticWidget".equals(nomClasse)) {
		 Operation op = (Operation)comp.getModele().getElementProgramme();
		 w = creerWidgetExpressionArithmetic(op.getOperateur());
		 }
		 else if ("ExpressionLogicalWidget".equals(nomClasse)) {
		 Condition con = (Condition)comp.getModele().getElementProgramme();

		 w = creerWidgetExpressionLogical(con.getOperateur());

		 }*/

		if (w == null) {
			throw new NonChargeableException("Impossible de charger le widget " + nomClasse);
		}
		//w.getModele().setCouleur(comp.getModele().getCouleur());
		return w;
	}
}