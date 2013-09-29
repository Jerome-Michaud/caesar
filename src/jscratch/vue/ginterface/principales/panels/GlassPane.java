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
package jscratch.vue.ginterface.principales.panels;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import jscratch.helpers.ImagesHelper;

/**
 * Permet de créer l'objet de type GlassPane.
 *
 * @author Bastien
 * @since 1.0
 * @version 1.0
 */
public final class GlassPane extends JPanel implements Observer {

	/**
	 * L'instance unique du GlassPane.
	 */
	private static final GlassPane instance = new GlassPane();
	private Point pointLigne;
	private Rectangle rectFusion;
	public static final int EPAISSEUR_LIGNE = 5;
	public static final int EPAISSEUR_RECT = 3;
	public static final int MARGE_RECT = 5;
	private int longueurLigne;
	private boolean drawRemoveImage;
	private Point deleteIconPosition;
	private Image deleteImage;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if (drawRemoveImage) {
			g2d.drawImage(deleteImage, this.deleteIconPosition.x, this.deleteIconPosition.y, null);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (pointLigne != null) {
			g2d.setStroke(new BasicStroke(EPAISSEUR_LIGNE));
			g2d.drawLine(pointLigne.x, pointLigne.y, pointLigne.x + longueurLigne, pointLigne.y);
		}
		if (rectFusion != null) {
			g2d.setStroke(new BasicStroke(EPAISSEUR_RECT));
			g2d.drawRoundRect(rectFusion.x, rectFusion.y, rectFusion.width, rectFusion.height, 5, 5);
		}
	}

	/**
	 * @since 1.0
	 */
	private GlassPane() {
		this.pointLigne = null;
		this.rectFusion = null;
		this.longueurLigne = 0;
		this.deleteImage = ImagesHelper.getImage("cross-circle-big.png");
		this.setDeleteIconPosition(null);
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de GlassPane.
	 */
	public static GlassPane getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @param pointLigne Le nouveau point pour l'affichage de la ligne de
	 * fusion.
	 */
	public void setPointLigneSurEcran(Point pointLigne) {
		if (pointLigne != null) {
			SwingUtilities.convertPointFromScreen(pointLigne, this);
		}
		this.pointLigne = pointLigne;
	}

	/**
	 * @since 1.0
	 *
	 * @param rectFusion Le nouveau rectangle à dessiner sur le glasspane
	 */
	public void setRectFusion(Rectangle rectFusion) {
		this.rectFusion = rectFusion;
	}

	/**
	 * @since 1.0
	 *
	 * @param epaisseur L'épaisseur voulue pour le trait de fusion.
	 */
	public void setLongueurLigne(int epaisseur) {
		this.longueurLigne = epaisseur;
	}

	@Override
	public void update(Observable o, Object o1) {
		this.repaint();
	}

	public void setDeleteIconPosition(Point pt) {
		this.drawRemoveImage = (pt != null);
		this.deleteIconPosition = pt;

	}
}
