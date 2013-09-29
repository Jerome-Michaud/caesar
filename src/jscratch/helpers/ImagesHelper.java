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

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Permet de gérer les images.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class ImagesHelper {

	/**
	 * Permet de récupérer une image.
	 * 
	 * @since 1.0
	 * 
	 * @param name nom du fichier
	 * @return l'image
	 */
	public static Image getImage(String name) {
		try {
			URL url = new File("ressources" + File.separator + "images" + File.separator + name).toURI().toURL();
			
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
	 * @since 1.0
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
	
	/**
	 * Permet de redimensionner la taille d'une image
	 * 
	 * @param l'image à redimensionner
	 * @param largeur
	 * @param longueur
	 * 
	 * @return l'image redimensionné
	 */
	public static Image resizeImg(Image img,int width,int height){
		return img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ); 
	}
}