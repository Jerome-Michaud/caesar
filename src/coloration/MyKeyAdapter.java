package coloration;

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