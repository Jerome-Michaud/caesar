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
package editeurNXC.utils;

import editeurNXC.ui.EditorUI;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * classe permettant d'avoir une notification visuelle de la modification du contenu d'un fichier
 * ceci s'applique a un onglet de l'editeur
 *
 * @author SAGOT Raïssa
 *
 */
public class MyKeyAdapter extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		EditorUI instance = EditorUI.getInstance();

		int code = e.getKeyCode();

		if (controlPress(code) && !instance.tabToModify.get((RTextScrollPane) instance.getSelectedComponent())) {
			fichierModifier();
		}
	}

	/**
	 * ajoute l'etoile de notification a l'onglet courant de l'editeur
	 */
	public void fichierModifier() {
		EditorUI instance = EditorUI.getInstance();

		instance.tabToModify.put((RTextScrollPane) instance.getSelectedComponent(), true);

		int index = instance.getSelectedIndex();
		String nameItem = instance.getTitleAt(index);
		instance.setTitleAt(index, nameItem.substring(0, nameItem.length() - 3) + " *");


	}

	/**
	 * verifie le code de la touche pressée par l'utilisateur
	 *
	 * @param code
	 * @return
	 */
	private boolean controlPress(int code) {
		if (code != KeyEvent.VK_ALT && code != KeyEvent.VK_ALT_GRAPH && code != KeyEvent.VK_CAPS_LOCK && code != KeyEvent.VK_CONTROL && code != KeyEvent.VK_DOWN && code != KeyEvent.VK_LEFT && code != KeyEvent.VK_UP && code != KeyEvent.VK_RIGHT && code != KeyEvent.VK_WINDOWS && code != KeyEvent.VK_SHIFT && code != KeyEvent.VK_END && code != KeyEvent.VK_PAGE_DOWN && code != KeyEvent.VK_PAGE_UP && code != KeyEvent.VK_PRINTSCREEN && code != KeyEvent.VK_ESCAPE && code != KeyEvent.VK_INSERT && code != KeyEvent.VK_PAUSE && code != KeyEvent.VK_NUM_LOCK && code != KeyEvent.VK_F1 && code != KeyEvent.VK_F2 && code != KeyEvent.VK_F3 && code != KeyEvent.VK_F4 && code != KeyEvent.VK_F5 && code != KeyEvent.VK_F6 && code != KeyEvent.VK_F7 && code != KeyEvent.VK_F8 && code != KeyEvent.VK_F9 && code != KeyEvent.VK_F10 && code != KeyEvent.VK_F11 && code != KeyEvent.VK_F12 && code != 36 && code != 0 && code != 525) {
			return true;
		} else {
			return false;
		}
	}
}