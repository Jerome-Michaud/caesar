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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import jscratch.traduction.LanceurTraduction;
import jscratch.vue.widgets.modeles.ModeleWidget;

import org.jdom2.Element;

/**
 * Classe représentant une liste déroulante particulière qui pourra être insérée au sein d'un widget.
 *
 * @author Vincent Besnard - Quentin Gosselin
 * @param <T> Le type des valeurs de la liste.
 */
public class ListeDeroulante<T> extends JComboBox implements Zone {

	/**
	 * Constructeur du composant faisant appel au constructeur équivalent de la classe mère.
	 *
	 * @param a un tableau représentant les items qui seront présents dans la liste déroulante
	 */
	public ListeDeroulante(T[] a, final ModeleWidget widgetParent) {
		super(a);
		
		// Détection des changements pour la mise à jour de la traduction
		this.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				widgetParent.applyChangeModele();
				LanceurTraduction.getInstance().lancerTraduction();
			}
		});
	}

	/**
	 * Modifie la valeur selectionée de la liste déroulante.
	 *
	 * @param v L'indice de l'élèment à sélectionner
	 */
	@Override
	public void setValeur(String v) {
		this.setSelectedIndex(Integer.parseInt(v));
	}

	/**
	 * Récupère la valeur de l'élément selectionné.
	 *
	 * @return la valeur de l'élément.
	 */
	@Override
	public String getValeur() {
		return String.valueOf(this.getSelectedIndex());
	}

	@Override
	public int getEtat() {
		return -1;
	}

	@Override
	public Element toXml() {
		Element zone = new Element("zone");
		zone.setAttribute("valeur", this.getValeur());
				
		return zone;
	}

	@Override
	public int getPositionX() {
		return this.getX();
	}

	@Override
	public void setPositionX(int posX) {
		this.setLocation(posX, this.getY());
	}

	@Override
	public int getPositionY() {
		return this.getY();
	}

	@Override
	public void setPositionY(int posY) {
		this.setLocation(this.getX(),posY);
	}
}
