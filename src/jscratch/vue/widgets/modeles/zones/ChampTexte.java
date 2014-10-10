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
package jscratch.vue.widgets.modeles.zones;

import java.awt.BorderLayout;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import jscratch.dictionnaires.DicoTraces;
import jscratch.traces.fabriques.FabriqueTrace;
import jscratch.traduction.LanceurTraduction;
import jscratch.vue.widgets.modeles.ModeleWidget;
import jscratch.vue.widgets.modeles.TypeModeleWidget;
import jscratch.vue.widgets.Widget;

import org.jdom2.Element;

/**
 * Cette classe représente un champ texte particulier intégrable dans un widget.
 */
public class ChampTexte extends JPanel implements Zone {

	public static final int ETAT_SAISIE = 0;
	public static final int ETAT_CONTIENT_WIDGET = 1;
	private Widget widgetContenu;
	private JTextField textField;
	private List<TypeModeleWidget> typesWidgetsAcceptes;
	private int minimumWidth;
	private ModeleWidget widgetParent;
	private String valTempTextField;
	/*
	 * Etat à ETAT_SAISIE (0) quand on affiche uniquement le champ texte
	 * Etat à ETAT_CONTIENT_WIDGET (1) quand on affiche les widgets contenus
	 */
	int etat;

	private String valTempTexte;

	/**
	 * Constructeur faisant appel au constructeur équivalent de la classe mère.
	 */
	public ChampTexte(int minimumWidth, final ModeleWidget widgetParent) {
		this.minimumWidth = minimumWidth;
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.textField = new JNumberTextField();
		this.widgetContenu = null;
		this.add(textField, BorderLayout.CENTER);
		this.etat = ETAT_SAISIE;
		this.widgetParent = widgetParent;

		this.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				composantSupp(e);
			}
		});
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				valTempTextField = ((JTextField)e.getSource()).getText();

			}
			@Override
			public void focusLost(FocusEvent e) {
				// Le Widget parent du champtexte manque!
				DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceWidgetModification((Widget)widgetContenu, (Zone)((JTextField)e.getSource()).getParent(), valTempTextField, textField.getText()));
				valTempTextField = ((JTextField)e.getSource()).getText();

			}
		});


		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateTextFieldWidth(e);
				widgetParent.applyChangeModele();
				LanceurTraduction.getInstance().lancerTraduction();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateTextFieldWidth(e);
				widgetParent.applyChangeModele();
				LanceurTraduction.getInstance().lancerTraduction();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateTextFieldWidth(e);
				widgetParent.applyChangeModele();
				LanceurTraduction.getInstance().lancerTraduction();
			}
		});

		this.typesWidgetsAcceptes = new LinkedList<TypeModeleWidget>();

		this.validate();
	}

	private void composantSupp(ContainerEvent e) {
		if (e.getChild() == widgetContenu && e.getComponent() == this) {
			setWidgetContenu(null);
		}
	}

	private void updateTextFieldWidth(DocumentEvent e) {
		try {
			int width = Math.max(this.minimumWidth,(int) new FontMetrics(textField.getFont()) {} .getStringBounds(e.getDocument().getText(0, e.getDocument().getLength()), null).getWidth()+10);

			Rectangle bnds = this.getBounds();
			bnds.width = width;

			decaleWidgetParents(this, width - this.getWidth());
			textField.setSize(width, textField.getHeight());
			this.setBounds(bnds);
		} catch (BadLocationException ex) {
			Logger.getLogger(ChampTexte.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public boolean ajouterTypeWidgetAccepte(TypeModeleWidget type) {
		return this.typesWidgetsAcceptes.add(type);
	}

	public boolean accepteTypeWidget(TypeModeleWidget type) {
		return this.typesWidgetsAcceptes.contains(type);
	}

	/**
	 * Recupère la valeur actuelle du champ texte.
	 *
	 * Deux cas possibles:
	 * Soit le champ texte ne contient pas de widget et on retourne la valeur du champ texte
	 * Soit le champ texte contient un widget, auquel cas on retourne le nom de la variable.
	 *
	 * @return la valeur du champ texte.
	 */
	@Override
	public String getValeur() {
		if (etat == ETAT_SAISIE) {
			return textField.getText();
		} else if (etat == ETAT_CONTIENT_WIDGET) {
			return textField.getText();
		} else {
			return "";
		}

	}

	/**
	 *
	 * @return le contenu du widget
	 */
	public Widget getContentWidget() {

		return widgetContenu;
	}

	/**
	 * Retourne 1 si le contenu du champ est un widget.
	 */
	public boolean isContentWidget() {
		return etat == 1;

	}

	public ModeleWidget getWidgetParent() {
		return widgetParent;
	}

	/**
	 * Modifie le texte du champ texte.
	 *
	 * @param v le nouveau texte du champ.
	 */
	@Override
	public void setValeur(String v) {
		if (etat == ETAT_SAISIE) {
			this.textField.setText(v);
		}
	}

	public void setWidgetContenu(Widget w) {
		this.removeAll();
		int oldW = this.getWidth();
		Widget wc = this.getWidgetContenu();

		if (w == null) {
			this.etat = ETAT_SAISIE;
			this.setComponent(textField);
			DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceWidgetModification((Widget) this.getParent(), this, wc, this.getValeur()));

		} else {
			this.etat = ETAT_CONTIENT_WIDGET;
			this.textField.setSize(this.getSize());
			this.setComponent(w);
			DicoTraces.getInstance().ajouterTrace(FabriqueTrace.creerTraceWidgetModification((Widget) this.getParent(), this, this.getValeur(),wc));


		}
		int decal = this.getWidth() - oldW;
		//Appel à la méthode de redimensionnement en X, avec si nécessaire appel recursif pour le redimensionnement des parents
		decaleWidgetParents(this, decal);
		this.widgetContenu = w;
		widgetParent.applyChangeModele();
		LanceurTraduction.getInstance().lancerTraduction();
	}

	/**
	 * Méthode récursive de redimensionnement d'un widget en largeur ainsi que de ses parents
	 *
	 * @param w Le composant pour lequel on cherche à redimensionner le parent
	 * @param decal La valeur de l'agrandissement
	 */
	private void decaleWidgetParents(JComponent w, int decal) {
		Widget parent = null;
		int positionX = 0;
		boolean champ = false;
		//Si le parent est un widget (quand on a remonté tous les champs textes de la zone sur laquelle on travaille)
		if (w.getParent() instanceof Widget) {
			//Alors on stocke ce parent pour travailer dessus
			parent = ((Widget) (w.getParent()));
			positionX = w.getX();
		} else if (w.getParent() instanceof ChampTexte) {//Si le parent est un champTexte ...
			if (w.getParent().getParent() instanceof Widget) {
				/*... alors on regarde si le parent du parent est un widget,
				 * ceci afin de remonter au delà de la contenance du ChampTexte
				 * et donc travailler sur le ChamTexte en lui même				  *
				 */
				parent = (Widget) (w.getParent().getParent());
				positionX = w.getParent().getX();
				//Booleen permettant d'effectuer des actions supplémentaires plus loin dans ce cas
				champ = true;
			}
		}

		//Si on a définit que le parent du composant courant nous intéressait ...
		if (parent != null) {
			//... alors on entame les procédures de redimensionnement
			parent.getModele().decalageX(decal);
			parent.setForme(false);
			parent.getModele().decalerComposantsSuivantsX(positionX, decal);
			//Dans le cas on l'on trvaille sur un ChampTexte, des actions supplémentaires sont nécessaires
			if (champ) {
				//On agrandit les bounds du composant en lui même
				ChampTexte par = ((ChampTexte) w.getParent());
				Rectangle rect = par.getBounds();
				rect.width += decal;
				par.setBounds(rect);
			}
			//Lancement de l'appel récursif à partir du parent
			decaleWidgetParents(parent, decal);
		}
	}

	private void setComponent(JComponent comp) {
		calculateNewBounds(comp);
		this.add(comp, BorderLayout.CENTER);
	}

	@Override
	public int getEtat() {
		return this.etat;
	}

	/**
	 * Empêche la zone de prendre du texte. La seule chose possible est de mettre un widget dedans.
	 */
	public void supprimerTexte() {
		this.textField.setEditable(false);
		this.textField.setEnabled(false);
	}

	@Override
	public Element toXml() {
		Element zone = new Element("zone");
		zone.setAttribute("isWidget", String.valueOf(this.etat == ETAT_CONTIENT_WIDGET));

		if (this.etat == ETAT_SAISIE) {
			zone.setAttribute("valeur", this.getValeur());
		} else if (this.etat == ETAT_CONTIENT_WIDGET) {
			zone.addContent(this.widgetContenu.toXml());
		}
		return zone;
	}

	public Widget getWidgetContenu() {
		return widgetContenu;
	}

	@Override
	public int getPositionX() {
		return this.getX();
	}

	@Override
	public int getPositionY() {
		return this.getY();
	}

	@Override
	public void setPositionX(int posX) {
		this.setLocation(posX, this.getY());
	}

	@Override
	public void setPositionY(int posY) {
		this.setLocation(this.getX(),posY);
	}

	private void calculateNewBounds(JComponent comp) {
		int translate = 0 - ((comp.getHeight() / 2) - (this.getHeight() / 2));
		Rectangle bnds = this.getBounds();
		bnds.translate(0, translate);
		bnds.setSize(comp.getSize());
		this.setBounds(bnds);
	}
}
