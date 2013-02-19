package jscratch.helpers;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Classe qui gère les polices d'écriture de l'application
 * @author Guillaume Delorme
 *
 */
public class FontHelper {
	private static Font widgetFont = loadFont("DroidSans", Font.PLAIN, 12);
	private static Font widgetFontBold = loadFont("DroidSansBold", Font.PLAIN, 12);
	private static Font codeFont = loadFont("DroidSansMono", Font.PLAIN, 11);
	
	/**
	 * Récupération de la police utilisée pour les widgets
	 * @return la police des widgets
	 */
	public static Font getWidgetFont() {
		return widgetFont;
	}
	
	/**
	 * Récupération de la police utilisée pour les widgets en gras
	 * @return la police des widgets en gras
	 */
	public static Font getWidgetFontBold() {
		return widgetFontBold;
	}
	
	/**
	 * Récupération de la police utilisée pour écrire le code console
	 * @return la police pour le code
	 */
	public static Font getCodeFont() {
		return codeFont;
	}

	/**
	 * Charge une police d'écriture depuis un fichier ttf
	 * @param nomFichier le nom du fichier de la police se trouvant dans ressources/fonts
	 */
	private static Font loadFont(String nom, int style, int size) {		
		Font font;
		
		try {
			InputStream myStream = new BufferedInputStream(new FileInputStream("ressources" + File.separator + "fonts" + File.separator + nom + ".ttf"));
			Font ttf = Font.createFont(Font.TRUETYPE_FONT, myStream);
			font = ttf.deriveFont(style, size);
		} catch (Exception e) {
			System.err.println("Erreur lors du chargement de la police d'écriture - chargement d'une police par défaut");
			font = new Font("TimesRoman", Font.PLAIN, 12);
		}

		return font;
	}
}
