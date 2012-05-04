package vue.widget;

import vue.tools.NonClonableException;
import vue.widget.modele.*;
/**
 * Classe implémentant le design pattern Factory permettant la création de tous
 * les types de widgets.
 *
 * @author Quentin Gosselin
 */
public class FabriqueInstructions {

	/**
	 * Méthode permettant de créer un widget de type "Avance Moteur Marche Avant".
	 *
	 * @return Un widget de type "Avance Moteur Marche Avant"
	 */
	public Widget creerWidgetMoteurMovFwd() {
        return new Widget(new MoteurMovFwdWidget());
    }
	/**
	 * Méthode permettant de créer un widget de type "Avance Moteur Marche Arrière"
	 *
	 * @return Un widget de type "Avance Moteur Marche Arrière"
	 */
    public Widget creerWidgetMoteurMovRev() {
        return new Widget(new MoteurMovRevWidget());
    }
    /**
	 * Méthode permettant de créer un widget de type "Arrêt Moteur"
	 *
	 * @return Un widget de type "Arrêt Moteur"
	 */
    public Widget creerWidgetMoteurOff() {
        return new Widget(new MoteurOffWidget());
    }
	
    /**
     * Méthode permettant de créer un widget complexe de type "Boucle Pour"
     *
     * @return Un widget complexe de type "Boucle Pour"
     */
	public Widget creerWidgetFor() {
    	return new WidgetCompose(new ForWidget());
    }
	/**
	 * Méthode permettant de créer un widget complexe de type "Boucle Tant Que"
	 *
	 * @return Un widget complexe de type "Boucle Tant que"
	 */
    public Widget creerWidgetWhile() {
    	return new WidgetCompose(new WhileWidget());
    }
    /**
     * Méthode permettant de créer un widget complexe de type "Boucle Faire Tant Que"
     *
     * @return Un widget complexe de type "Boucle Faire Tant que"
     */
    public Widget creerWidgetDoWhile() {
        return new WidgetCompose(new DoWhileWidget());
    }
    /**
     * Méthode permettant de créer un widget complexe de type "Répéter"
     *
     * @return Un widget complexe de type "Répéter"
     */
	public Widget creerWidgetRepeat() {
    	return new WidgetCompose(new RepeatWidget());
    }
    
	/**
	 * Méthode permettant de créer un widget complexe de type "Structure Si"
	 *
	 * @return Un widget complexe de type "Structure Si"
	 */
	public Widget creerWidgetIf() {
        return new WidgetCompose(new IfWidget());
    }
	/**
	 * Méthode permettant de créer un widget complexe de type "Structure Si Sinon"
	 *
	 * @return Un widget complexe de type "Structure Si Sinon"
	 */
	public Widget creerWidgetIfElse() {
        return new WidgetCompose(new IfElseWidget());
    }
	/**
	 * Méthode permettant de créer un widget de type "Attente"
	 *
	 * @return Un widget de type "Attente"
	 */
    public Widget creerWidgetWait() {
        return new Widget(new WaitWidget());
    }
    /**
     * Méthode permettant de créer un widget complexe de type "Tâche"
     *
     * @return Un widget complexe de type "Tâche"
     */
	public Widget creerWidgetTache() {
        return new WidgetCompose(new TacheWidget());
    }
	/**
	 * Méthode permettant de créér une copie d'un widget.
	 *
	 * @param comp Le widget à cloner
	 * @return La copie du widget passé en paramètre
	 * @throws NonClonableException Si on essaye de cloner un widget qui n'est
	 * pas clonable, une exception est levée
	 */
	public Widget cloner(Widget comp) throws NonClonableException {
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
		else if (comp.getModele() instanceof RepeatWidget) {
			w = creerWidgetRepeat();
		}
		else if (comp.getModele() instanceof ForWidget) {
			w = creerWidgetFor();
		}
		if (w == null) {
			throw new NonClonableException("Ajouter le type de widget \"" + comp.getType() + "\"dans la méthode clone");
		}
		w.getModele().setCouleur(comp.getModele().getCouleur());
		return w;
	}
}
