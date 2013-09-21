/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import jscratch.dictionnaires.DicoWidgetsCategories;
import jscratch.parametrages.properties.VariableProperties;
import jscratch.vue.ginterface.principales.GUI;
import jscratch.vue.widgets.fabrique.FabriqueInstructions;
import jscratch.vue.widgets.Widget;
import nxtim.instruction.Categorie;

/**
 * Cette zone correspond à la zone où sont entreposés les widgets pour que l'utilisateur puisse les prendre.
 *
 * @since 1.0
 * @version 1.0
 */
public final class PanelWidget extends JPanel implements Observer {

	private static PanelWidget instance = new PanelWidget();
	private FabriqueInstructions fabrique;
	private List<Widget> lesWidgets;
	private JTextPane texte;
	private JPanel panelDeWidget;
	private JScrollPane scroll;
	private final int MARGE_X_WIDGET = 5;
	private final int MARGE_Y_WIDGET = 5;

	/**
	 * Constructeur privé de <code>PanelWidget</code>.
	 * 
	 * @since 1.0
	 */
	private PanelWidget() {
		this.lesWidgets = new LinkedList<Widget>();
		this.setBorder(BorderFactory.createTitledBorder("Widgets"));

		this.fabrique = new FabriqueInstructions();
		this.setLayout(new BorderLayout());

		this.texte = new JTextPane();
		this.texte.setSize(this.getPreferredSize());
		this.texte.setEditable(false);
		this.texte.setFocusable(false);
		this.texte.setOpaque(false);
		this.add(this.texte, BorderLayout.NORTH);
		this.panelDeWidget = new JPanel();
		this.panelDeWidget.setLayout(null);
		this.scroll = new JScrollPane(panelDeWidget);
		scroll.setBorder(null);
		this.add(scroll, BorderLayout.CENTER);

		this.setMinimumSize(new Dimension(VariableProperties.X_MAX_INSTRUCTION, 600));

		this.scroll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (GUI.getPanelTypeWidget().getCurrentCategorie() == Categorie.VARIABLES && e.isPopupTrigger()) {
					GUI.creerPopupVariable().show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (GUI.getPanelTypeWidget().getCurrentCategorie() == Categorie.VARIABLES && e.isPopupTrigger()) {
					GUI.creerPopupVariable().show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * Permet de modifier le texte de la catégorie.
	 *
	 * @since 1.0
	 * 
	 * @param texte le nouveau texte
	 */
	public void setText(final String texte) {
		this.texte.setText(texte);
		this.texte.setSize(this.texte.getPreferredSize());
	}

	/**
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelWidget getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @return La fabrique de widgets
	 */
	public FabriqueInstructions getFabrique() {
		return this.fabrique;
	}

	/**
	 * Permet de modifier la liste des widgets à afficher sur X colonnes.
	 *
	 * @since 1.0
	 *
	 * @param nbColonnes Le nombre de colonnes désiré
	 */
	public void setLesWidgets(final int nbColonnes) {
		this.panelDeWidget.removeAll();
		this.lesWidgets = DicoWidgetsCategories.getInstance().getWidgets(GUI.getPanelTypeWidget().getCurrentCategorie(), true);
		placerWidgets(nbColonnes);

		Rectangle boundsGlobales = new Rectangle();

		for (Component c : this.panelDeWidget.getComponents()) {
			boundsGlobales = boundsGlobales.union(c.getBounds());
		}
		boundsGlobales.grow(MARGE_X_WIDGET, MARGE_Y_WIDGET);
		this.panelDeWidget.setPreferredSize(boundsGlobales.getSize());
		this.validate();
		this.repaint();
	}

	/**
	 * Permet d'ajouter le widget à la fin de la liste.
	 *
	 * @since 1.0
	 *
	 * @param widget La widget à ajouter.
	 */
	public void ajouterWidget(Widget widget) {
		this.ajouterWidget(widget, this.lesWidgets.size());
	}

	/**
	 * Permet d'ajouter un widget à l'index définit.
	 *
	 * @since 1.0
	 *
	 * @param widget La widget à ajouter.
	 * @param index L'index où ajouter le widget.
	 */
	public void ajouterWidget(Widget widget, int index) {
		this.lesWidgets.add(index, widget);
	}

	/**
	 * @since 1.0
	 *
	 * @param widget Le widget.
	 * @return L'index du widget passé en paramètre.
	 */
	public int getIndex(Widget w) {
		return this.lesWidgets.indexOf(w);
	}

	/**
	 * @since 1.0
	 *
	 * @param widget Le widget à supprimer.
	 * @return true si le widget est correctement supprimé.
	 */
	public boolean supprimerWidget(Widget widget) {
		return this.lesWidgets.remove(widget);
	}

	/**
	 * Permet de placer les widgets.
	 *
	 * @since 1.0
	 */
	private void placerWidgets(final int colonnes) {
		int i = 1;
		int maxW = 0;
		int x = MARGE_X_WIDGET;
		int yDefaut = MARGE_Y_WIDGET;
		int y = yDefaut;

		for (Widget w : this.lesWidgets) {
			w.setDraggable(false);

			if (maxW < w.getWidth()) {
				maxW = w.getWidth();
			}

			if (this.lesWidgets.size() > 5 && i == this.lesWidgets.size() / colonnes + 1) {
				x += maxW + 20;
				y = yDefaut;
			}

			w.setLocation(x, y);
			y += w.getHeight() + 20;

			this.panelDeWidget.add(w);
			i++;
		}
	}

	/**
	 * Permet de récupérer le panel où sont stockés les widgets.
	 * 
	 * @since 1.0
	 * 
	 * @return le panel
	 */
	public JPanel getPanelDeWidget() {
		return panelDeWidget;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.validate();
	}
}
