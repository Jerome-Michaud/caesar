package vue.tools;

import vue.ginterface.Fenetre;
import vue.ginterface.PanelCodeGraphique;
import vue.widget.Widget;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modeles.Erreur;
import vue.ginterface.GUI;
/**
 * Classe regroupant différents outils destinés à la sauvegarde et au chargement
 * de projets JScratch
 *
 * @author Andru Bastien
 */
public class SavingTools {
	/**
	 * Permet à l'utilisateur de sauvegarder son projet au format JScratch où il veut.
	 */
    public static void save() {
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(new JScratchFileFilter());
        choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retour = choix.showSaveDialog(GUI.getFenetre()); // TODO : A SUPPRIMER Fenetre.getInstance());
        if(retour == JFileChooser.APPROVE_OPTION) {
            String path = choix.getSelectedFile().getAbsolutePath();
            if(!path.endsWith(JScratchFileFilter.EXT)) {
                path += "." + JScratchFileFilter.EXT;
            }
            boolean ok = true;
            if(new File(path).exists()) {
                int opt = JOptionPane.showConfirmDialog(choix, new JLabel("<html>Un fichier portant ce nom existe déjà.<br><br>"
                        + "Souhaitez vous l'écraser?"), "Fichier existant", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opt != JOptionPane.YES_OPTION) {
                    ok = false;
                }
            }
            if(ok) {
                serializeArborescence(path);
            }
        }
    }
    /**
     * Permet la sérialisation de l'arborescence des widgets.
     * @param path Le chemin où sauvegarder le l'arborescence
     */
    private static void serializeArborescence(String path) {
        try {
            FileOutputStream fichier = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(ArborescenceTools.getInstance().getArborescence());
            oos.flush();
            oos.close();
        } catch (Exception e) {
            Erreur.afficher(e);
        }
    }
    /**
     * Permet à l'utilisateur de charger un projet JScratch précédemment sauvegardé.
     */
    public static void load() {
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(new JScratchFileFilter());
        choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retour = choix.showOpenDialog(GUI.getFenetre()); // TODO : A SUPPRIMER Fenetre.getInstance());
        if (retour == JFileChooser.APPROVE_OPTION) {
            deserializeArborescence(choix.getSelectedFile().getPath());
        }
        GUI.getPanelCodeGraphique().repaint();
    }
    /**
     * Desérialise une arborescence précédemment sauvegardée.
     *
     * @param path Le chemin d'accès à l'arborscence sauvegardée
     */
    private static void deserializeArborescence(String path) {
        try {
            FileInputStream fichier = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fichier);
			LinkedList<List<Widget>> arbos = (LinkedList<List<Widget>>) ois.readObject();
			ArborescenceTools.getInstance().initArborescence(arbos, true);
        } catch (Exception e) {
            Erreur.afficher(e);
        }
    }
}
