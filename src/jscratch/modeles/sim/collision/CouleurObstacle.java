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
package jscratch.modeles.sim.collision;

import java.awt.Color;

/**
 * Enumération qui contient les couleurs possibles pour les obstacles
 * @author Guillaume Delorme
 *
 */
public enum CouleurObstacle {
	BLACK (new Color(0, 0, 0)),
	BLUE (new Color(38, 173, 228)),
	CYAN (new Color(118, 188, 173)),
	DARK_GRAY (new Color(51, 51, 51)),
	GRAY (new Color(130, 130, 130)),
	GREEN (new Color(136, 196, 37)),
	LIGHT_GRAY (new Color(220, 220, 220)),
	MAGENTA (new Color(210, 77, 108)),
	ORANGE (new Color(243, 134, 48)),
	PINK (new Color(255, 158, 157)),
	RED (new Color(207, 70, 71)),
	WHITE (new Color(255, 255, 255)),
	YELLOW (new Color(249, 212, 35));
	
	private final Color couleur;
	
	CouleurObstacle(Color couleur) {
		this.couleur = couleur;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	/**
	 * Récupère la couleur depuis une chaine de caractère
	 * @param couleur la chaine de la couleur
	 * @return la couleur si elle existe, noir sinon
	 */
	public static CouleurObstacle fromString(String couleur) {
		for (CouleurObstacle c : CouleurObstacle.values()) {
			if (c.toString().equalsIgnoreCase(couleur)) {
				return c;
			}
		}
		
		return BLACK;
	}
}
