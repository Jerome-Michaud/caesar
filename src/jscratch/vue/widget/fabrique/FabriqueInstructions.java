package jscratch.vue.widget.fabrique;

import java.util.List;
import jscratch.modeles.DicoCouleursCategories;
import jscratch.modeles.DicoVariables;
import jscratch.vue.tools.exceptions.NonChargeableException;
import jscratch.vue.tools.exceptions.NonClonableException;
import jscratch.vue.widget.Widget;
import jscratch.vue.widget.WidgetCompose;
import nxtim.instruction.Condition;
import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.VariableModifiable;
import jscratch.vue.widget.modele.DoWhileWidget;

import jscratch.vue.widget.modele.ExpressionArithmeticWidget;
import jscratch.vue.widget.modele.ExpressionLogicalWidget;
import jscratch.vue.widget.modele.ForWidget;
import jscratch.vue.widget.modele.IfElseWidget;
import jscratch.vue.widget.modele.IfWidget;
import jscratch.vue.widget.modele.InstructionWidget;
import jscratch.vue.widget.modele.MoteurMarcheWidget;
import jscratch.vue.widget.modele.MoteurOffWidget;
import jscratch.vue.widget.modele.RepeatWidget;
import jscratch.vue.widget.modele.TacheWidget;
import jscratch.vue.widget.modele.TempsCourantWidget;
import jscratch.vue.widget.modele.WaitWidget;
import jscratch.vue.widget.modele.VariableWidget;
import jscratch.vue.widget.modele.VariableSetValueWidget;
import jscratch.vue.widget.modele.WhileWidget;
import nxtim.instruction.Categorie;
import nxtim.instruction.Variable;

/**
 * Classe implémentant le design pattern Factory permettant la création de tous les types de widgets.
 * 
 * @since 1.0
 * @version 1.0
 */
public class FabriqueInstructions {

	/**
	 * Méthode permettant de créer un widget de type " Moteur Marche ".
	 *
	 * @return un widget de type " Moteur Marche"
	 */
	public Widget creerWidgetMoteurMarche() {
		return new Widget(new MoteurMarcheWidget());
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
	 * Méthode permettant de créer un widget de type "Temps Courant".
	 *
	 * @return un widget de type "Temps Courant"
	 */
	public Widget creerWidgetTempsCourant() {
		return new Widget(new TempsCourantWidget());
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
		return new Widget(new ExpressionArithmeticWidget(op));
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
		return new Widget(new ExpressionLogicalWidget(op));
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
		} else if (comp.getModele() instanceof MoteurMarcheWidget) {
			w = creerWidgetMoteurMarche();
		} else if (comp.getModele() instanceof MoteurOffWidget) {
			w = creerWidgetMoteurOff();
		} else if (comp.getModele() instanceof WaitWidget) {
			w = creerWidgetWait();
		} else if (comp.getModele() instanceof VariableWidget) {
			w = creerWidgetVariable((VariableModifiable) comp.getModele().getElementProgramme());
		} else if (comp.getModele() instanceof VariableSetValueWidget) {
			w = creerWidgetVariableSetValue();
		} else if (comp.getModele() instanceof TempsCourantWidget) {
			w = creerWidgetTempsCourant();
		} else if (comp.getModele() instanceof RepeatWidget) {
			w = creerWidgetRepeat();
		} else if (comp.getModele() instanceof ForWidget) {
			w = creerWidgetFor();
		} else if (comp.getModele() instanceof ExpressionArithmeticWidget) {
			Operation op = (Operation) comp.getModele().getElementProgramme();
			w = creerWidgetExpressionArithmetic(op.getOperateur());
		} else if (comp.getModele() instanceof ExpressionLogicalWidget) {
			Condition con = (Condition) comp.getModele().getElementProgramme();
			w = creerWidgetExpressionLogical(con.getOperateur());
		}

		if (w == null) {
			throw new NonClonableException("Ajouter le type de widget \"" + comp.getType() + "\"dans la méthode clone");
		}
		
		w.getModele().setCouleur(comp.getModele().getCouleur());
		w.getModele().setCategorie(comp.getModele().getCategorie());
		
		return w;
	}

	/**
	 * Méthode permettant de créér un widget à partir d'informations données.
	 *
	 * @param nomClasse le nom de la classe du widget
	 * @param categorie la catégorie du widget
	 * @param supplement la variable attachée au widget variable, <code>null</code> si pas un widget variable
	 * @return le widget
	 * @throws NonChargeableException Si on essaye de charger un widget qui n'est pas pris en compte
	 */
	public Widget creerWidget(final String nomClasse, final String categorie, final String supplement) throws NonChargeableException {
		Widget w = null;
		if ("IfWidget".equals(nomClasse)) {
			w = creerWidgetIf();
		} else if ("IfElseWidget".equals(nomClasse)) {
			w = creerWidgetIfElse();
		} else if ("TacheWidget".equals(nomClasse)) {
			w = creerWidgetTache();
		} else if ("WhileWidget".equals(nomClasse)) {
			w = creerWidgetWhile();
		} else if ("DoWhileWidget".equals(nomClasse)) {
			w = creerWidgetDoWhile();
		} else if ("MoteurMarcheWidget".equals(nomClasse)) {
			w = creerWidgetMoteurMarche();
		} else if ("MoteurOffWidget".equals(nomClasse)) {
			w = creerWidgetMoteurOff();
		} else if ("WaitWidget".equals(nomClasse)) {
			w = creerWidgetWait();
		} else if ("VariableSetValueWidget".equals(nomClasse)) {
			w = creerWidgetVariableSetValue();
		} else if ("TempsCourantWidget".equals(nomClasse)) {
			w = creerWidgetTempsCourant();
		} else if ("RepeatWidget".equals(nomClasse)) {
			w = creerWidgetRepeat();
		} else if ("ForWidget".equals(nomClasse)) {
			w = creerWidgetFor();
		} else if ("ExpressionArithmeticWidget".equals(nomClasse)) {
			List<Operateur> opes = Operateur.arithmetiques();
			for (Operateur o : opes) {
				if (o.toString().equals(supplement)) {
					w = creerWidgetExpressionArithmetic(o);
					break;
				}
			}
		} else if ("ExpressionLogicalWidget".equals(nomClasse)) {
			List<Operateur> opes = Operateur.logiques();
			for (Operateur o : opes) {
				if (o.toString().equals(supplement)) {
					w = creerWidgetExpressionLogical(o);
					break;
				}
			}
		} else if ("VariableWidget".equals(nomClasse)) {
			Variable[] vars = DicoVariables.getInstance().getLesvariables();
			for (Variable v : vars) {
				if (v.getNom().equals(supplement)) {
					w = creerWidgetVariable((VariableModifiable)v);
					break;
				}
			}
		}

		// Le composant n'est pas dans le if précédent, il doit être ajouté
		if (w == null) {
			throw new NonChargeableException("Impossible de charger le widget " + nomClasse);
		}

		// On remet la couleur du widget suivant sa catégorie
		for (Categorie c : Categorie.values()) {
			if (c.toString().equals(categorie)) {
				w.getModele().setCategorie(c);
				w.getModele().setCouleur(DicoCouleursCategories.getInstance().getCouleur(c));
				break;
			}
		}
		
		return w;
	}
}