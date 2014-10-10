/*
Copyright (C) Université du Maine (2013)

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier.

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant
donné sa spécificité de logiciel libre, qui peut le rendre complexe à
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement,
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.helpers;

import java.awt.Font;
import java.awt.FontMetrics;
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

	public static int getLongueur(String texte) {
		FontMetrics metrics = new FontMetrics(getWidgetFont()) { };
		return (int)metrics.getStringBounds(texte, null).getWidth();
	}
}
