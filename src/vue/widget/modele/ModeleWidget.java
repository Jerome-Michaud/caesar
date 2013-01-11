package vue.widget.modele;

import vue.widget.modele.zones.Zone;
import instruction.IElementProgramme;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import modeles.TypeWidget;
import vue.widget.modele.zones.ChampTexte;

/**
 * Classe abstraite permet de définir une structure commune pour chaque widget.
 * Cette classe implemente Serializable.
 *
 * @author Bastien Andru - Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public abstract class ModeleWidget implements Serializable {
    /*
     * Constante donnant la hauteur du "décrochement" des widgets.
     */

    public static final int OFFSET = 5;
    /**
     * Liste des abscisses pour chaque point composant la forme du widget.
     */
    protected int[] tabX;
    /**
     * Liste des ordonnées pour chaque point composant la forme du widget.
     */
    protected int[] tabY;
    /**
     * La couleur de fond du widget.
     */
    private Color couleur;
    /**
     * La forme du widget.
     */
    private Polygon forme;
    /**
     * Hashmap stockant les messages affichés sur le widget et les points où ils
     * doivent se positionner.
     */
    protected HashMap<Point, String> message;
    /**
     * Le type du widget choisit parmis l'enumeration TypeWidget.
     */
    private TypeWidget type;
    /**
     * La largeur du widget.
     */
    private int tailleX;
    /**
     * La hauteur du widget.
     */
    private int tailleY;
    /**
     * Booléen permettant de définir s'il faut afficher les conditions d'arrêt
     * sur le haut ou le bas du widget (différence entre While et DoWhile).
     */
    private boolean conditionHaute;
    /**
     * Booleen permettant de définir si un widget peut avoir un widget accroché
     * à lui en haut.
     */
    protected boolean attachableHaut;
    /**
     * Booléen permettant de définir si un widget peut avoir un widget accroché
     * à lui en bas.
     */
    protected boolean attachableBas;
    /**
     * Booléen permettant de définir si un peut etre utilisé au sein d'un autre
     * widget en tant que valeur
     */
    protected boolean attachableInterne;
    /**
     * Booléen permettant de définir si un widget peut être placé dans un widget
     * complexe.
     */
    protected boolean imbricable;
    /**
     * Liste des zones où pourront être imbriqués d'autres widgets.
     */
    protected List<Rectangle> zonesAccroches;
    /**
     * Élément du programme de traduction.
     */
    private IElementProgramme elementProgramme;
    /**
     * Liste des zones de saisies du widget.
     */
    private List<Zone> lesZonesSaisies;

    /**
     * Constructeur initialisant différentes valeurs du modèle.
     */
    public ModeleWidget() {
        this.conditionHaute = true;
        this.attachableBas = true;
        this.attachableHaut = true;
        this.attachableInterne = false;
        this.imbricable = true;
        this.zonesAccroches = new LinkedList<Rectangle>();
        this.lesZonesSaisies = new LinkedList<Zone>();
        this.message = new HashMap<Point, String>();
    }

    /**
     * Méthode abstraite permettant d'initialiser les listeners du modèle.
     */
    public abstract void initListeners();

    /**
     * Méthode permettant de récupérer l'élement de programme du modèle.
     *
     * @return L'élément de programme du modèle.
     */
    public IElementProgramme getElementProgramme() {
        return this.elementProgramme;
    }

    /**
     * Permet de définir l'élément de programme du widget.
     *
     * @param element Le nouvel élément de programe du modèle
     */
    public void setElementProgramme(IElementProgramme element) {
        this.elementProgramme = element;
    }

    /**
     * Méthode permettant de récupérer les zones de saise du modèle.
     *
     * @return La liste de zones de saisies du modèle.
     */
    public List<Zone> getLesZonesSaisies() {
        return lesZonesSaisies;
    }

    /**
     * Méthode permettant de définir les zones de saisie du programme.
     *
     * @param lesZonesSaisies Les nouvelles zones de saisie du programme
     */
    public void setLesZonesSaisies(List<Zone> lesZonesSaisies) {
        this.lesZonesSaisies = lesZonesSaisies;
    }

    /**
     * Permet de connaître la position de la condition au sein du modèle.
     *
     * @return true si la condition doit être affichée en haut, false dans le
     * cas contraire.
     */
    public boolean isConditionHaute() {
        return conditionHaute;
    }

    /**
     * Définie si la condition de la boucle doit être affichée en haut ou non.
     *
     * @param conditionHaute true si la condition doit être affichée en haut,
     * false sinon
     */
    public void setConditionHaute(boolean conditionHaute) {
        this.conditionHaute = conditionHaute;
    }

    /**
     * Récupère les zones d'accroche du widget.
     *
     * @return La liste de zones d'accroche du widget.
     */
    public List<Rectangle> getZonesAccroches() {
        return zonesAccroches;
    }

    /**
     * Méthode permettant de récupérer un tableau d'entier représentant les
     * coordonnées des abscisses de la forme du widget.
     *
     * @return Le tableau d'entier représentant les coordonnées des abscisses de
     * la forme du widget.
     */
    public int[] getTabX() {
        return tabX;
    }

    /**
     * Méthode permettant de définir un tableau représentant les coordonnées des
     * abscisses de la forme du widget.
     *
     * @param tabX Le tableau représentant les coordonnées des abscisses de la
     * forme du widget
     */
    public void setTabX(int[] tabX) {
        this.tabX = tabX;
    }

    /**
     * Méthode permettant de récupérer un tableau d'entier représentant les
     * coordonnées des ordonnées de la forme du widget.
     *
     * @return Le tableau d'entier représentant les coordonnées des ordonnées de
     * la forme du widget.
     */
    public int[] getTabY() {
        return tabY;
    }

    /**
     * Méthode permettant de définir un tableau représentant les coordonnées des
     * ordonnées de la forme du widget.
     *
     * @param tabY Le tableau représentant les coordonnées des ordonnées de la
     * forme du widget.
     */
    public void setTabY(int[] tabY) {
        this.tabY = tabY;
    }

    /**
     * Accède à la couleur de fond du widget.
     *
     * @return Le couleur de fond du widget.
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Modifie la couleur de fond du le widget.
     *
     * @param couleur La nouvelle couleur de fond du widget
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * Accède à la largeur du widget.
     *
     * @return La largeur du widget.
     */
    public int getTailleX() {
        return tailleX;
    }

    /**
     * Recalcule la largeur du widget.
     */
    public void setTailleX() {
        this.tailleX = this.getXMax() - this.getXMin();
    }

    /**
     * Accède à la hauteur du widget.
     *
     * @return la hauteur du widget.
     */
    public int getTailleY() {
        return tailleY;
    }

    /**
     * Recalcule la hauteur du widget.
     */
    public void setTailleY() {
        this.tailleY = this.getYMax() - this.getYMin();
    }

    /**
     * Récupère la plus petite abscisse possible du widget.
     *
     * @return la plus petite abscisse.
     */
    public int getXMin() {
        int max = this.tabX[0];
        for (Integer i : tabX) {
            max = Math.min(max, i);
        }
        return max;
    }

    /**
     * Récupére la plus grande abscisse possible du widget
     *
     * @return la plus grande abscisse.
     */
    public int getXMax() {
        int max = this.tabX[0];
        for (Integer i : tabX) {
            max = Math.max(max, i);
        }
        return max;
    }

    /**
     * Récupère la plus petite ordonnée possible du widget.
     *
     * @return la plus petite ordonnée.
     */
    public int getYMin() {
        int max = this.tabY[0];
        for (Integer i : tabY) {
            max = Math.min(max, i);
        }
        return max;
    }

    /**
     * Récupére la plus grande ordonnée possible du widget
     *
     * @return la plus grande ordonnée.
     */
    public int getYMax() {
        int max = this.tabY[0];
        for (Integer i : tabY) {
            max = Math.max(max, i);
        }
        return max;
    }

    /**
     * Récupère la forme du widget.
     *
     * @return La forme du widget.
     */
    public Polygon getForme() {
        return forme;
    }

    /**
     * Modifie la forme du widget.
     *
     * @return la nouvelle forme du widget.
     */
    public void setForme(Polygon forme) {
        this.forme = forme;
    }

    /**
     * Accède au type du widget.
     *
     * @return le type du widget.
     */
    public TypeWidget getType() {
        return type;
    }

    /**
     * Modifie le type du widget.
     *
     * @param type le nouveau type.
     */
    public void setType(TypeWidget type) {
        this.type = type;
    }

    /**
     * Permet de savoir si on peut attacher un widget en bas de ce widget ou
     * non.
     *
     * @return true si on peut attacher un widget au bas de ce widget, false
     * dans le cas contraire.
     */
    public boolean isAttachableBas() {
        return attachableBas;
    }

    /**
     * Permet de savoir si on peut attacher un widget en haut de ce widget ou
     * non.
     *
     * @return true si on peut attacher un widget au haut de ce widget, false
     * dans le cas contraire.
     */
    public boolean isAttachableHaut() {
        return attachableHaut;
    }


    /**
     * Permet de savoir si on peut utiliser ce widget pour l'utiliser en guise de valeur
     * en le droppant dans un ChampTexte
     *
     * @return true si on peut utiliser ce widget pour l'utiliser en guise de valeur 
     * (cas du widget variable), false dans le cas contraire.
     * 
     * @see ChampTexte
     */
    public boolean isAttachableInterne() {
        return attachableInterne;
    }

    /**
     * Permet de savoir si on peut attacher ce widget dans un widget composé
     * (dans une zone d'accroche).
     *
     * @return true si on peut attacher ce widget dans un widget composé, false
     * dans le cas contraire.
     */
    public boolean isImbricable() {
        return imbricable;
    }

    /**
     * Méthode abstraite permettant d'augmenter ou diminuer la largeur du composant.
     *
	 * Un comportement de base a été définit est ce comportement doit être redefinit pour des widgets plus complexes
	 * 
     * @param x La valeur de l'agrandissement à appliquer
     */

    public void decalageX(int x){
		int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

    /**
     * Méthode abstraite permettant d'augmenter ou diminuer la hauteur du composant
	 * 
	 * Si la méthode n'a pas été redéfinie dans les classes concrètes filles, aucune action n'est effectuée
     *
     * @param x La valeur de l'agrandissement à appliquer
     * @param r Le rectangle à augmenter également
     */

    public void decalageY(int x,Rectangle r){}

    /**
     * Méthode permettant de récupérer la liste des messages du widget.
     *
     * @return la liste des messages de widgets et leurs coordonnées.
     */
    public HashMap<Point, String> getMessage() {
        return this.message;
    }
}