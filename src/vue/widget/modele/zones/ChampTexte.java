package vue.widget.modele.zones;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modeles.TypeWidget;
import vue.widget.Widget;

/**
 * Cette classe représente un champ texte particulier intégrable dans un widget.
 */
public class ChampTexte extends JPanel implements Zone {

    private Widget widgetContenu;
    private JTextField textField;
    private List<TypeWidget> typesWidgetsAcceptes;
    /*
     * Etat à 0 quand on affiche uniquement le champ texte
     * Etat à 1 quand on affiche les widgets contenus
     */
    int etat;

    /**
     * Constructeur faisant appel au constructeur équivalent de la classe mère.
     */
    public ChampTexte() {
        super();
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        textField = new JTextField();
        widgetContenu = null;
        this.add(textField, BorderLayout.CENTER);
        etat = 0;
        this.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentRemoved(ContainerEvent e) {
                composantSupp(e);
            }
        });
        
        this.typesWidgetsAcceptes = new LinkedList<TypeWidget>();
        
        this.validate();
    }

    private void composantSupp(ContainerEvent e) {
        System.out.println("Child : "+e.getChild().toString() +"------ Comp : " +e.getComponent().toString());
        System.out.println("widget : "+widgetContenu);
        if (e.getChild() == widgetContenu && e.getComponent() == this) {
            setWidgetContenu(null);
        }
    }

    public boolean ajouterTypeWidgetAccepte(TypeWidget type){
        return this.typesWidgetsAcceptes.add(type);
    }
    
    public boolean accepteTypeWidget(TypeWidget type){
        return this.typesWidgetsAcceptes.contains(type);
    }
    
    /**
     * Récupère le texte du champ texte.
     *
     * @return la valeur du champ texte.
     */
    @Override
    public String getValeur() {
        if (etat == 0) {
            return textField.getText();
        } else if (etat == 1) {
            return textField.getText();
        } else {
            return "";
        }
    }

    /**
     * Modifie le texte du champ texte.
     *
     * @param v le nouveau texte du champ.
     */
    @Override
    public void setValeur(String v) {
        if (etat == 0) {
            this.textField.setText(v);
        }
    }

    public void setWidgetContenu(Widget w) {
        System.out.println(this.getComponents().length);
        this.removeAll();
        System.out.println(this.getComponents().length);
        if (w == null) {
            this.etat = 0;
            this.setComponent(textField);
        } else {
            this.etat = 1;
            this.setComponent(w);
        }
        this.revalidate();
        this.repaint();
        this.widgetContenu = w;
    }

    private void setComponent(JComponent comp) {
        this.setSize(comp.getSize());
        this.add(comp, BorderLayout.CENTER);
    }
}
