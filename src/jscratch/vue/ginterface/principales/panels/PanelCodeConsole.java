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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import jscratch.helpers.FontHelper;
import jscratch.vue.ginterface.principales.GUI;

/**
 * Panneau d'affichage du code traduit.
 *
 * @since 1.0
 * @version 1.0
 */
public final class PanelCodeConsole extends JPanel implements Observer {

	/**
	 * @since 1.0
	 */
	private static PanelCodeConsole instance = new PanelCodeConsole();
	private JTextArea textarea;

	/**
	 * @since 1.0
	 */
	private PanelCodeConsole() {
		this.textarea = new JTextArea();
		this.textarea.setEditable(false);
		this.textarea.setFont(FontHelper.getCodeFont());
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(100, 600));

		this.add(textarea, BorderLayout.CENTER);

		this.textarea.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (!textarea.getText().isEmpty() && e.isPopupTrigger()) {
					GUI.creerPopupCodeNxc().show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	public static PanelCodeConsole getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @param texte Le texte à afficher dans la zone.
	 */
	public void setText(String texte) {
		this.textarea.setText(texte);
	}

	/**
	 * @since 1.0
	 *
	 * @return la traduction
	 */
	public String getText() {
		return this.textarea.getText();
	}

	@Override
	public void update(Observable o, Object o1) {
		// Mise à jour du texte dans la zone, envoyer le code au format String pas un objet
		this.setText(o1.toString());
		this.repaint();
	}
}