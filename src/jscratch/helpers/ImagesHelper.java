package jscratch.helpers;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImagesHelper {

	/**
	 * Permet de récupérer une image.
	 * 
	 * @param name nom du fichier
	 * @return l'image
	 */
	public static Image getImage(String name) {
		try {
			URL url = new File("ressources" + File.separator + "images" + File.separator + name).toURI().toURL();
			//ImagesHelper.class.getResource(name);

			if (url != null) {
				try {
					return ImageIO.read(url);
				} catch (IOException ex) {
					ErreurHelper.afficher(ex);
				}
			}
		} catch (MalformedURLException ex) {
			ErreurHelper.afficher(ex);
		}
		return null;
	}

	/**
	 * Permet de récupérer une icône.
	 * 
	 * @param name nom du fichier
	 * @return l'icône
	 */
	public static Icon getIcon(String name) {
		try {
			URL url = new File("ressources" + File.separator + "images" + File.separator + name).toURI().toURL();
			if (url != null) {
				return new ImageIcon(url);
			}
		} catch (MalformedURLException ex) {
			ErreurHelper.afficher(ex);
		}
		return null;
	}
}