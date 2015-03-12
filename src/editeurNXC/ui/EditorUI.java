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
package editeurNXC.ui;

import editeurNXC.parser.NXCDefs;
import editeurNXC.utils.ButtonTabComponent;
import editeurNXC.utils.MyKeyAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import jscratch.vue.ginterface.principales.ApplicationUI;
import jscratch.vue.ginterface.principales.GUI;
import nxtim.NXTIMArbreTools;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.FileLocation;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.TextEditorPane;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchEngine;

/**
 * Classe de l'interface de l'editeur.
 */
public class EditorUI  extends JTabbedPane {

	private static final long serialVersionUID = 652027320050530897L;
	private static AutoCompletion ac; //permet d'avoir l'autocompletion sur l'editeur
	private static final SyntaxScheme scheme = new SyntaxScheme(new Font(Font.MONOSPACED, Font.PLAIN, 14));
	//styles pour les mots cles trouvés dans le code de l'utilisateur
	static {
		Font locBold = new Font(Font.MONOSPACED, Font.BOLD, 14);
		Font locItalic = new Font(Font.MONOSPACED, Font.ITALIC, 14);
		scheme.styles[Token.PREPROCESSOR].foreground = new Color(128, 64, 0);
		scheme.styles[Token.RESERVED_WORD].foreground = new Color(0, 0, 255);
		scheme.styles[Token.RESERVED_WORD].font = locBold;
		scheme.styles[Token.DATA_TYPE].foreground = new Color(128, 0, 255);
		scheme.styles[Token.LITERAL_BOOLEAN].foreground = new Color(255, 128, 0);
		scheme.styles[Token.LITERAL_BOOLEAN].font = locBold;
		scheme.styles[Token.LITERAL_NUMBER_DECIMAL_INT].foreground = new Color(255, 128, 0);
		scheme.styles[Token.LITERAL_NUMBER_FLOAT].foreground = new Color(255, 128, 0);
		scheme.styles[Token.LITERAL_NUMBER_HEXADECIMAL].foreground = new Color(255, 128, 0);
		scheme.styles[Token.LITERAL_CHAR].foreground = new Color(128, 128, 128);
		scheme.styles[Token.LITERAL_STRING_DOUBLE_QUOTE].foreground = new Color(128, 128, 128);
		scheme.styles[Token.OPERATOR].foreground = new Color(0, 0, 128);
		scheme.styles[Token.COMMENT_EOL].foreground = new Color(0, 128, 0);
		scheme.styles[Token.COMMENT_EOL].font = locItalic;
		scheme.styles[Token.COMMENT_MULTILINE].foreground = new Color(0, 128, 0);
		scheme.styles[Token.COMMENT_MULTILINE].font = locItalic;
		scheme.styles[Token.FUNCTION].foreground = new Color(0, 128, 128);
		scheme.styles[Token.VARIABLE].foreground = new Color(0, 128, 255);
	}

	private static JPopupMenu popupMenu;

	private static int nextNew = 1;
	private final Map<File, RTextScrollPane> filesToTabs; // table regroupant fichier et onglet
	private final Map<RTextScrollPane, File> tabsToFiles; // table regroupant onglet et fichier
	public final  Map<RTextScrollPane, Boolean> tabToModify; // table regroupant onglet et boolean de modification

	// Find & replace
	private String search;
	private boolean matchCase;
	private boolean wholeWord;
	private boolean useRegex;

	private static EditorUI instance;
	private static MyKeyAdapter myKeyAdapter; // permet d'avoir l'etoile sur tous fichier ayant subi une modification

	/**
	 * Constructeur, initialise les parametres
	 */
	private EditorUI() {
		//permet de reconnaitre les mots cles
		AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		atmf.putMapping("NXC", "editeurNXC.utils.NXCTokenMaker");

		this.setFocusable(true);
		this.addFocusListener(new FocusListener() {
			// Arrivée du focus  
			@Override
			public void focusGained(FocusEvent e) {
				if(NXTIMArbreTools.getInstance().isWidgetsModified()){
					((TextEditorPane) ((RTextScrollPane) getSelectedComponent()).getTextArea())
							.setText(GUI.getPanelCodeConsole().getText());
					GUI.getPanelCodeConsole().update(null, "");
				}
				ApplicationUI.getInstance().minimizeZoneCodeConsole();
			}
			// Perte de focus
			@Override
			public void focusLost(FocusEvent e) {
			}

		});
		
		this.setPreferredSize(new Dimension(400, 300));
		this.filesToTabs = new HashMap<File, RTextScrollPane>();
		this.tabsToFiles = new HashMap<RTextScrollPane, File>();
		tabToModify = new HashMap<RTextScrollPane, Boolean>();
		//ajout d'un onglet
		this.newTab();
		///scroll
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	/**
	 * Donne l'instance de l'éditeur (singleton).
	 * @return l'instance de l'éditeur.
	 */
	public static EditorUI getInstance() {
		if (instance == null) {
			instance = new EditorUI();
		}
		return instance;
	}

	/**
	 * Modifie la pop up
	 * @param locJpm
	 */
	public static void setDefaultPopupMenu(JPopupMenu locJpm) {
		popupMenu = locJpm;
	}

	/**
	 * Met le contenu d'un fichier dans un conteneur de texte
	 * @param parFile
	 * @return le conteneur texte créé.
	 * @throws IOException
	 */
	private static RTextScrollPane createTab(File parFile) throws IOException {
		FileLocation locFileLoc = null;
		if (parFile != null) {
			locFileLoc = FileLocation.create(parFile);
		}
		TextEditorPane locEdit = new TextEditorPane(TextEditorPane.INSERT_MODE, true, locFileLoc);
		//applique les styles sur les mots clés
		locEdit.setSyntaxEditingStyle("NXC");
		locEdit.setSyntaxScheme(scheme);
		locEdit.setTabSize(4);
		locEdit.setPopupMenu(popupMenu);
		myKeyAdapter = new MyKeyAdapter();
		locEdit.addKeyListener(myKeyAdapter);

		RTextScrollPane locTab = new RTextScrollPane(locEdit);
		// place l'auto completion sur le texte
		CompletionProvider provider = createCompletionProvider();
		ac = new AutoCompletion(provider);
		ac.install(locEdit);
		return locTab;
	}

	/**
	 * Crée un onglet vide
	 */
	public final void newTab() {
		try {
			RTextScrollPane locTab = createTab(null);
			this.addTab("new " + nextNew++ +"   ", locTab);
			tabToModify.put(locTab, false);
			this.setSelectedComponent(locTab);
			this.setTabComponentAt(this.getSelectedIndex(), new ButtonTabComponent(this));
			this.tabsToFiles.put(locTab, null);
		} catch (IOException ex) {/* ne peut pas arriver, car on crée un onglet vide */}
	}

	/**
	 * Crée un onglet avec un fichier
	 * @param parFile
	 * @throws IOException
	 */
	public void newTab(File parFile) throws IOException {
		RTextScrollPane locTab = this.filesToTabs.get(parFile);
		if (locTab != null) {
			this.setSelectedComponent(locTab);
		}
		else {
			try {
				locTab = createTab(parFile); // on cree un onglet avec le contenu du fichier
				this.addTab(parFile.getName()+"   ", locTab);
				tabToModify.put(locTab, false);
				// si un onglet est present, et qu'il est vide et crée par defaut, il est fermer et on ouvre notre onglet
				// a la place
				if (this.getTabCount() == 2 && !this.getCurrentEditor().isLocalAndExists() && !this.getCurrentEditor().isDirty()) {
					this.close();
				}

				this.setSelectedComponent(locTab);
				this.setTabComponentAt(this.getSelectedIndex(), new ButtonTabComponent(this));

				this.filesToTabs.put(parFile, locTab);
				this.tabsToFiles.put(locTab, parFile);
			} catch (FileNotFoundException ex) {}
		}
	}

	/**
	 * Précise si l'onglet correspond à un fichier ou si il s'agit d'un "nouvel onglet" jamais enregistré
	 * @return <code>true</code> s'il n'y a pas de fichier associé à l'onglet.
	 */
	public boolean needSaveAs() {
		return this.tabsToFiles.get((RTextScrollPane) this.getSelectedComponent()) == null;
	}

	/**
	 * sauvegarde du code dans le fichier correspondant
	 */
	public void save() {
		try {
			((TextEditorPane) ((RTextScrollPane) this.getSelectedComponent()).getTextArea()).save();

			int index = instance.getSelectedIndex();
			String nameItem = instance.getTitleAt(index);
			String newName = nameItem.substring(0, nameItem.length() - 2 );
			instance.setTitleAt(index,  newName+ "   ");
			tabToModify.put((RTextScrollPane) this.getSelectedComponent(), false);

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Un problème est survenu lors de l'enregistrement.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * sauvegarde sous,
	 * @param parFile
	 */
	public void saveAs(File parFile) {
		try {
			RTextScrollPane locTab = (RTextScrollPane) this.getSelectedComponent();
			((TextEditorPane) locTab.getTextArea()).saveAs(FileLocation.create(parFile));

			this.filesToTabs.put(parFile, locTab);
			File locFile = this.tabsToFiles.put(locTab, parFile);
			if (locFile != null) {
				this.filesToTabs.remove(locFile);
			}
			int index = instance.getSelectedIndex();
			String nameItem = parFile.getName();
			String newName = nameItem.substring(0, nameItem.length());
			instance.setTitleAt(index,  newName+ "   ");

			if(tabToModify.get(this.getSelectedComponent())) {
				tabToModify.put((RTextScrollPane) this.getSelectedComponent(), false);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Un problème est survenu lors de l'enregistrement.", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * ferme un onglet par rapport a sa position
	 * @param i
	 */
	public void close(int i) {
		RTextScrollPane locTab = (RTextScrollPane) this.getComponentAt(i);
		File locFile = this.tabsToFiles.remove(locTab);
		this.filesToTabs.remove(locFile);
		this.tabToModify.remove(locFile);
		this.remove(locTab);
		if (this.getTabCount() == 0) {
			this.newTab();
		}
	}

	/**
	 * ferme l'onglet courant
	 */
	public void close() {
		RTextScrollPane locTab = (RTextScrollPane) this.getSelectedComponent();
		File locFile = this.tabsToFiles.remove(locTab);
		this.filesToTabs.remove(locFile);
		this.tabToModify.remove(locFile);
		this.remove(locTab);
		if (this.getTabCount() == 0) {
			this.newTab();
		}
	}

	/**
	 * action annuler
	 */
	public void undo() {
		((RTextScrollPane) this.getSelectedComponent()).getTextArea().undoLastAction();
		modification();
	}

	/**
	 * action refaire
	 */
	public void redo() {
		((RTextScrollPane) this.getSelectedComponent()).getTextArea().redoLastAction();
		modification();
	}

	/**
	 * action couper
	 */
	public void cut() {
		((RTextScrollPane) this.getSelectedComponent()).getTextArea().cut();
		modification();
	}

	/**
	 * action copier
	 */
	public void copy() {
		((RTextScrollPane) this.getSelectedComponent()).getTextArea().copy();
	}

	/**
	 * action coller
	 */
	public void paste() {
		((RTextScrollPane) this.getSelectedComponent()).getTextArea().paste();
		modification();
	}

	/**
	 * action selectionner tout
	 */
	public void selectAll() {
		((RTextScrollPane) this.getSelectedComponent()).getTextArea().selectAll();
	}

	/**
	 * action trouver
	 * @param search le mot a trouver
	 * @param sens sens de recherche, forward ou backward
	 * @param matchCase case sensitive
	 * @param wholeWord mot entier
	 * @param useRegex expression reguliere
	 */
	public void find(String search,boolean sens, boolean matchCase, boolean wholeWord, boolean useRegex) {
		this.search = search;
		this.matchCase = matchCase;
		this.wholeWord = wholeWord;
		this.useRegex = useRegex;
		this.findNext(sens);
	}

	/**
	 * trouve une chaine de caracteres
	 * @param sens sens de recherche, forward ou backward
	 */
	public void findNext(boolean sens) {
		SearchEngine.find(((RTextScrollPane) this.getSelectedComponent()).getTextArea(), search, sens, matchCase, wholeWord, useRegex);
	}

	/**
	 * remplace une chaine de caracteres recherche par une autre
	 * @param search le mot cherche
	 * @param replace le mot remplacant
	 * @param sens sens de recherche, forward ou backward
	 * @param matchCase case sensitive
	 * @param wholeWord mot entier
	 * @param useRegex expression reguliere
	 */
	public void replace(String search, String replace,boolean sens, boolean matchCase, boolean wholeWord, boolean useRegex) {
		this.search = search;
		this.matchCase = matchCase;
		this.wholeWord = wholeWord;
		this.useRegex = useRegex;
		SearchEngine.replace(((RTextScrollPane) this.getSelectedComponent()).getTextArea(), search, replace, sens, matchCase, wholeWord, useRegex);
	}

	/**
	 * remplace toutes les occurences d'une chaine de caracteres
	 * @param search le mot cherche
	 * @param replace le mot remplacant
	 * @param matchCase case sensitive
	 * @param wholeWord mot entier
	 * @param useRegex expression reguliere
	 */
	public void replaceAll(String search, String replace, boolean matchCase, boolean wholeWord, boolean useRegex) {
		this.search = search;
		this.matchCase = matchCase;
		this.wholeWord = wholeWord;
		this.useRegex = useRegex;
		SearchEngine.replaceAll(((RTextScrollPane) this.getSelectedComponent()).getTextArea(), search, replace, matchCase, wholeWord, useRegex);
	}

	/**
	 * retourne le conteneur courant
	 * @return le conteneur courant.
	 */
	public TextEditorPane getCurrentEditor() {
		return (TextEditorPane) ((RTextScrollPane) this.getSelectedComponent()).getTextArea();
	}

	/**
	 * retourne un boolean precisant si le code à été modifier depuis la derniere sauvegarde
	 * @param item
	 * @return <code>true</code> si le code a été modifié.
	 */
	public boolean isModify(RTextScrollPane item){
		return tabToModify.get(item);
	}

	/**
	 * Affiche la modification.
	 */
	public void modification(){
		if(!tabToModify.get(this.getSelectedComponent())) {
			myKeyAdapter.fichierModifier();
		}
	}

	/**
	 * retourne le texte de l'onglet courant
	 * @return le texte de l'onglet courant.
	 */
	public String getProg() {
		return ((TextEditorPane) ((RTextScrollPane) this.getSelectedComponent()).getTextArea()).getText();
	}

	/**
	 * retourne le titre de l'onglet courant
	 * @return le titre de l'onglet courant.
	 */
	public String getTitle() {
		return this.getTitleAt(this.getSelectedIndex());
	}

	private static CompletionProvider createCompletionProvider() {

		// A DefaultCompletionProvider is the simplest concrete implementation
		// of CompletionProvider.  This provider has no understanding of
		// language semantics. It simply checks the text entered up to the
		// caret position for a match against known completions. This is all
		// that is needed in the majority of cases.
		DefaultCompletionProvider provider = new DefaultCompletionProvider();
		//Ajout des constantes pour l'auto-complétion
		for (Map.Entry<String, String> entry : NXCDefs.constants.entrySet()) {
			provider.addCompletion(new BasicCompletion(provider, entry.getKey()));
		}

		return provider;
	}
}