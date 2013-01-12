package jscratch.vue.categories;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import jscratch.vue.categories.complexe.PolygoneAction;
import jscratch.vue.categories.complexe.EtatPolygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

import javax.swing.SwingUtilities;
import jscratch.modeles.DicoWidgetsCategories;
import nxtim.instruction.Categorie;
import jscratch.vue.ginterface.GUI;
import jscratch.vue.tools.Variables;

/**
 * Classe permettant de définir les différents comportements des boutons catégories.
 *
 * @since 1.0
 * @version 1.0
 */
public abstract class BoutonCategorie extends JComponent {

	/**
	 * @see Vue.Categories.ModeleCategorie
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
	/**
	 * La taille de la police.
	 */
	private static final int TAILLE = 12;

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

		// Extras
		for (PolygoneAction poly : this.modele.getFormesExtras()) {
			g2d.setColor(poly.getCouleur());
			g2d.fillPolygon(poly.getPolygon());
			g2d.setColor(Color.BLACK);
			g2d.drawPolygon(poly.getPolygon());
		}

		// Ecritures
		g2d.setColor(Color.WHITE);
		g2d.setFont(this.font);
		g2d.drawString(this.modele.getMessage(), 15, 17);
		super.paintComponent(g);
	}

	/**
	 * Définit le bouton de catégorie.
	 *
	 * @param modele le modèle du bouton
	 */
	public BoutonCategorie(final ModeleCategorie modele) {
		this.font = new Font("TimesRoman", Font.PLAIN, TAILLE);
		this.modele = modele;
		this.fond = Color.LIGHT_GRAY;
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
				sourisRelachee();
			}

			@Override
			public void mousePressed(final MouseEvent e) {
				super.mousePressed(e);
				sourisAppuyee();
			}
		});
	}

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
			this.fond = Variables.GRIS_SURVOLE;
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
			this.fond = Variables.GRIS_INACTIF;
		}

		for (PolygoneAction poly : this.modele.getFormesExtras()) {
			poly.setEtat(EtatPolygon.INACTIF);
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

		for (PolygoneAction poly : this.modele.getFormesExtras()) {
			Rectangle r = poly.getBounds();
			r = SwingUtilities.convertRectangle(this, r, GUI.getGlassPane());

			if (r.contains(p)) {
				poly.setEtat(EtatPolygon.ACTIF);
				poly.executerAction();
			} else {
				poly.setEtat(EtatPolygon.INACTIF);

			}
		}

		if (!active) {
			for (BoutonCategorie b : GUI.getPanelTypeWidget().getLesCategories()) {
				b.font = new Font("TimesRoman", Font.PLAIN, TAILLE);
				b.fond = Variables.GRIS_INACTIF;
				b.active = false;
				b.repaint();
			}
			this.font = new Font("TimesRoman", Font.BOLD, TAILLE);
			this.active = true;
			this.fond = Variables.GRIS_ACTIF;


		}
		GUI.getPanelWidget().setLesWidgets(DicoWidgetsCategories.getInstance().getWidgets(this.modele.getCategorie()));
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
}