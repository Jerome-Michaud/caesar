package jscratch.vue.widget.modele;

import jscratch.vue.widget.modele.zones.ChampTexte;
import jscratch.vue.widget.modele.zones.Zone;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

import jscratch.modeles.DicoVariables;
import jscratch.vue.tools.Variables;
import nxtim.instruction.Affectation;
import nxtim.instruction.Condition;
import nxtim.instruction.InstructionFor;
import nxtim.instruction.Operateur;
import nxtim.instruction.Operation;
import nxtim.instruction.TypeVariable;
import nxtim.instruction.Variable;
import nxtim.instruction.VariableConstante;

/**
 * Classe héritant de ModeleWidget et implémentant
 * <code>Serializable</code> modélisant la forme d'un widget de type For.
 */
public class ForWidget extends ModeleWidget {

    /**
     * Constructeur du modele définissant les différents paramètres du For.
     */
    public ForWidget() {
        int[] tX = {0, 5,/*
             * 
             */ 30, 35, 45, 50,/*
             * 
             */ 130, 135,/*
             * 
             */ 135, 130,/*
             * 
             */ 55, 50, 40, 35, /*
             * 
             */ 10, 5,/*
             * 
             */ 5, 10,/*
             * 
             */ 35, 40, 50, 55,/*
             * 
             */ 130, 135, /*
             * 
             */ 135, 130,/*
             * 
             */ 50, 45, 35, 30,/*
             * 
             */ 5, 0};
        int[] tY = {5, 0,/*
             * 
             */ 0, 5, 5, 0,/*
             * 
             */ 0, 5,/*
             * 
             */ 20, 25,/*
             * 
             */ 25, 30, 30, 25, /*
             * 
             */ 25, 30,/*
             * 
             */ 35, 40,/*
             * 
             */ 40, 45, 45, 40,/*
             * 
             */ 40, 45, /*
             * 
             */ 50, 55,/*
             * 
             */ 55, 60, 60, 55,/*
             * 
             */ 55, 50};

        this.setTabX(tX);
        this.setTabY(tY);
        this.setTailleX();
        this.setTailleY();
        this.setType(TypeModeleWidget.FOR);

        //this.setMessage("For");
        message.put(new Point(5, 17), "Pour");
        message.put(new Point(94, 17), "condition :");
        message.put(new Point(210, 17), "pas :");

        this.setElementProgramme(new InstructionFor());
        this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
        this.zonesAccroches.add(Variables.ZONE_ACCROCHE_PAR_DEFAULT);

        //variable
        ChampTexte lv = new ChampTexte();
        lv.supprimerTexte();
		lv.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
        lv.setBounds(55, 3, 35, 20);
        this.getLesZonesSaisies().add(lv);

		//valeur logique
        ChampTexte ff = new ChampTexte();
        ff.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_LOGIQUE);
        ff.setBounds(155, 3, 50, 20);
        this.getLesZonesSaisies().add(ff);
		
        //pas
        ChampTexte fp = new ChampTexte();
        fp.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		fp.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		fp.supprimerTexte();
        fp.setBounds(240, 3, 20, 20);
        fp.setValeur("1");
        this.getLesZonesSaisies().add(fp);

        this.decalageX(138);

        if (DicoVariables.getInstance().getLesvariables().length > 0) {
            //setCondition(DicoVariables.getInstance().getLesvariables()[Integer.parseInt(lv.getValeur())], Operateur.comparaisonA()[Integer.parseInt(lo.getValeur())], ff.getValeur());
            //setIteration(DicoVariables.getInstance().getLesvariables()[Integer.parseInt(lv.getValeur())], fp.getValeur());
            //setInitialization(DicoVariables.getInstance().getLesvariables()[Integer.parseInt(lv.getValeur())], fd.getValeur());
        }
        initListeners();
    }

    @Override
    public void decalageX(final int a) {
        int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        for (i = 22; i < 26; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }
	
    @Override
    public void decalageY(final int b, final Rectangle r) {
        int i;
        for (i = 16; i < tabY.length; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
	
    @Override
    public void initListeners() {
        for (Zone z : this.getLesZonesSaisies()) {
            ((JComponent) z).addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(final FocusEvent arg0) {
                    Variable v = DicoVariables.getInstance().getLesvariables()[Integer.parseInt(((Zone) getLesZonesSaisies().get(0)).getValeur())];
                    String deb = ((Zone) getLesZonesSaisies().get(1)).getValeur();
                    Operateur o = Operateur.comparaisonA()[Integer.parseInt(((Zone) getLesZonesSaisies().get(2)).getValeur())];
                    String fin = ((Zone) getLesZonesSaisies().get(3)).getValeur();
                    String pas = ((Zone) getLesZonesSaisies().get(4)).getValeur();

                    setCondition(v, o, fin);
                    setIteration(v, pas);
                    setInitialization(v, deb);
                }
            });
        }

    }

    /**
     * Méthode permettant de définir la condition d'arrêt de la boucle.
     *
     * @param v La variable de la condition
     * @param o L'opérateur de la condition
     * @param fin La valeur e la condition d'arrêt
     */
    public void setCondition(final Variable v, final Operateur o, final String fin) {
        Condition cond = new Condition(o, v, new VariableConstante(TypeVariable.INT, "", fin));
        ((InstructionFor) getElementProgramme()).setCondition(cond);
    }

    /**
     * Méthode de définition de l'initialisation de la boucle.
     *
     * @param v La variable la boucle
     * @param deb La valeur de début
     */
    public void setInitialization(final Variable v, final String deb) {
        Affectation aff = new Affectation(false);
        aff.setMembreGauche(v);
        aff.setMembreDroit(new VariableConstante(TypeVariable.INT, "", deb));
        ((InstructionFor) getElementProgramme()).setInitialisation(aff);
    }

    /**
     * Méthode de définition de la valeur d'augmentation après une itération.
     *
     * @param v La variable concernée
     * @param pas La valeur du pas pour une itération
     */
    public void setIteration(final Variable v, final String pas) {
        Affectation aff = new Affectation(false);
        aff.setMembreGauche(v);
        Operation op = new Operation(Operateur.ADDITION, v, new VariableConstante(TypeVariable.INT, "", pas));
        aff.setMembreDroit(op);
        ((InstructionFor) getElementProgramme()).setIteration(aff);
    }
}