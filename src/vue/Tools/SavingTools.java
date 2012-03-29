package vue.Tools;

import vue.Interface.Fenetre;
import vue.Interface.PanelCodeGraphique;
import vue.Widget.Widget;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modeles.Erreur;

public class SavingTools {

    public static void save() {
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(new JScratchFileFilter());
        choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retour = choix.showSaveDialog(Fenetre.getInstance());
        if (retour == JFileChooser.APPROVE_OPTION) {
            String path = choix.getSelectedFile().getAbsolutePath();
            if (!path.endsWith(JScratchFileFilter.ext)) {
                path += "." + JScratchFileFilter.ext;
            }
            boolean ok = true;
            if (new File(path).exists()) {
                int opt = JOptionPane.showConfirmDialog(choix, new JLabel("<html>Un fichier portant ce nom existe déjà.<br><br>"
                        + "Souhaitez vous l'écraser?"), "Fichier existant", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opt != JOptionPane.YES_OPTION) {
                    ok = false;
                }
            }
            if (ok){
                serializeArborescence(path);
            }
        }
    }

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

    public static void load() {
        JFileChooser choix = new JFileChooser();
        choix.addChoosableFileFilter(new JScratchFileFilter());
        choix.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retour = choix.showOpenDialog(Fenetre.getInstance());
        if (retour == JFileChooser.APPROVE_OPTION) {
            deserializeArborescence(choix.getSelectedFile().getPath());
        }
        PanelCodeGraphique.getInstance().repaint();
    }

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
