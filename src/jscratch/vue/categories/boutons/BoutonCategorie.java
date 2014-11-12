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
package jscratch.vue.categories.boutons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

import javax.swing.SwingUtilities;

import jscratch.helpers.FontHelper;
import jscratch.dictionnaires.DicoTraces;
import jscratch.helpers.PropertiesHelper;
import jscratch.vue.categories.ModeleCategorie;
import nxtim.instruction.Categorie;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.parametrages.properties.VariableProperties;
import jscratch.traces.fabriques.FabriqueTrace;

/**
 * Classe permettant de définir les différents comportements des boutons catégories.
 */
public abstract class BoutonCategorie extends JComponent {

	/**
	 * @see ModeleCategorie
	 */
	private ModeleCategorie modele;

	/**
	 * La police de caractère.
	 */
	private Font font;
	/**
	 * La couleur de fond.
	 */
	private Color fond;
	/**
	 * La position par défaut du bouton.
	 */
	private Point defaultPos;
	/**
	 * L'état du bouton
	 * <code>true</code> si activé.
	 */
	private boolean active = false;

	@Override
	public void paintComponent(final Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// Formes de base (icône + corps)
		g2d.setColor(this.modele.getCouleur());
		g2d.fillPolygon(this.modele.getFormeCouleur());
		g2d.setColor(this.fond);
		g2d.fillPolygon(this.modele.getFormeTexte());
		g2d.setColor(Color.BLACK);
		g2d.drawPolygon(this.modele.getFormeCouleur());
		g2d.drawPolygon(this.modele.getFormeTexte());

		// Ecritures
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.setFont(this.font);
		g2d.drawString(this.modele.getMessage(VariableProperties.AFFICHAGE_NOMBRE_WIDGET), 15, 17);
		super.paintComponent(g);
	}

	/**
	 * Définit le bouton de catégorie.
	 *
	 * @param modele le modèle du bouton
	 */
	public BoutonCategorie(final ModeleCategorie modele) {
		this.font = FontHelper.getWidgetFont();
		this.modele = modele;
		this.fond = VariableProperties.GRIS_INACTIF;
		this.setFont(this.font);
		this.setFocusable(true);
		this.setOpaque(false);
		this.setForme();

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(final MouseEvent e) {
				super.mouseEntered(e);
				sourisEntree();
			}

			@Override
			public void mouseExited(final MouseEvent e) {
				super.mouseExited(e);
				sourisSortie();
			}

			@Override
			public void mouseReleased(final MouseEvent e) {
				super.mouseReleased(e);
				
				DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceChangementCategorie(
						GUI.getPanelTypeWidget().getCurrentCategorie(),
						((BoutonCategorie) e.getSource()).getCategorie()));
				
				sourisRelachee();
			}

			@Override
			public void mousePressed(final MouseEvent e) {
				super.mousePressed(e);
				sourisAppuyee();
			}
		});
		
		ajouterWidgets();
	}
	
	/**
	 * Permet d'ajouter des widgets.
	 */
	public abstract void ajouterWidgets();

	/**
	 * Calcul les bounds du composant en fonction du polygone gris.
	 *
	 * @since 1.0
	 */
	private void setForme() {
		int maxX = 0;
		for (Integer i : this.modele.getFormeTexte().xpoints) {
			maxX = Math.max(maxX, i);
		}

		int maxY = 0;
		for (Integer i : this.modele.getFormeTexte().ypoints) {
			maxY = Math.max(maxY, i);
		}

		this.setBounds(0, 0, maxX + 1, maxY + 1);
		this.setPreferredSize(new Dimension(maxX, maxY));
	}

	/**
	 * Comportement lorsque la souris est sur le bouton.
	 *
	 * @since 1.0
	 */
	private void sourisEntree() {
		if (!active) {
			this.fond = VariableProperties.GRIS_SURVOLE;
			this.repaint();
		}
	}

	/**
	 * Comportement lorsque la souris sort du bouton.
	 *
	 * @since 1.0
	 */
	private void sourisSortie() {
		if (!active) {
			this.fond = VariableProperties.GRIS_INACTIF;
		}

		this.repaint();
	}

	/**
	 * Comportement lors du relachement du clic.
	 *
	 * @since 1.0
	 */
	private void sourisRelachee() {
		this.setLocation(this.defaultPos);

		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, GUI.getGlassPane());

		if (!active) {
			for (BoutonCategorie b : GUI.getPanelTypeWidget().getLesCategories()) {
				b.font = FontHelper.getWidgetFont();
				b.fond = VariableProperties.GRIS_INACTIF;
				b.active = false;
				b.repaint();
			}
			font = FontHelper.getWidgetFontBold();
			this.active = true;
			this.fond = VariableProperties.GRIS_ACTIF;


		}
		String text = PropertiesHelper.getInstance().get("user.categorie.message." + GUI.getPanelTypeWidget().getCurrentCategorie().toProperties().toLowerCase());
		GUI.getPanelWidget().setText(text);
		GUI.getPanelWidget().setLesWidgets(getNbColonnes());
	}

	/**
	 * Comportement lors du clic avec la souris.
	 *
	 * @since 1.0
	 */
	private void sourisAppuyee() {
		this.defaultPos = new Point(this.getLocation());
		Point p = this.getLocation();
		p.x++;
		p.y++;
		this.setLocation(p);


	}

	/**
	 * Définit si la catégorie est active ou non.
	 *
	 * @param b <code>true</code> si la catégorie est active, sinon <code>false</code>
	 */
	public void setActive(final boolean b) {
		this.active = b;
	}

	/**
	 * Retourne vrai si le bouton est actif
	 *
	 * @return true
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * Retourne la catégorie liée au bouton.
	 * @return la catégorie
	 */
	public Categorie getCategorie() {
		return this.modele.getCategorie();
	}

	/**
	 * Donne le nombre de colonne pour la catégorie.
	 * 
	 * @return le nombre colonne
	 */
	public abstract int getNbColonnes();
}
