package modeles;

public class Erreur {

	public static void afficher(Exception e) {
		//JOptionPane.showMessageDialog(Fenetre.getInstance(), e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		System.exit(1);
	}
}
