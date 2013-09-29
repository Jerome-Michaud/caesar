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
package jscratch.modeles.sim;

import java.awt.Color;

/**
 * Enumération des couleurs NXC pour le capteur de couleur
 * @author Guillaume Delorme
 *
 */
public enum ColorValue {
	INPUT_BLACKCOLOR (1, new Color(0, 0, 0), "Noir"),
	INPUT_BLUECOLOR (2, new Color(0, 0, 255), "Bleu"),
	INPUT_GREENCOLOR (3, new Color(0, 255, 0), "Vert"),
	INPUT_YELLOWCOLOR (4, new Color(255, 255, 0), "Jaune"),
	INPUT_REDCOLOR (5, new Color(255, 0, 0), "Rouge"),
	INPUT_WHITECOLOR (6, new Color(255, 255, 255), "Blanc");
	
	private final int value;
	private final Color color;
	private final String name;
	
	ColorValue(int value, Color color, String name) {
		this.value = value;
		this.color = color;
		this.name = name;
	}
	
	public static ColorValue getSimilarColor(Color color2) {
		double diffPlusProche = Double.MAX_VALUE;
		ColorValue couleurPlusProche = null;
		
		for (ColorValue color1 : ColorValue.values()) {
			double diff = Math.pow(color2.getRed() - color1.getColor().getRed(), 2) + 
					Math.pow(color2.getGreen() - color1.getColor().getGreen(), 2) +
					Math.pow(color2.getBlue() - color1.getColor().getBlue(), 2);
			
			if (diff < diffPlusProche) {
				diffPlusProche = diff;
				couleurPlusProche = color1;
			}
		}
		
		return couleurPlusProche;		
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return name;
	}	
}