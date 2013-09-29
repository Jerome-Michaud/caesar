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
package jscratch.vue.arborescence.actions;

import jscratch.vue.widgets.Widget;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Classe utilisée au moment du survol et de la fusion d'un widget et permettant d'encapsuler au sein d'un même objet un widget et le type de survol (au dessus, en dessous ou bien survol d'un zone d'accroche).
 *
 * Cette objet peut également contenir d'autres objets utiles à certains endroits du programme.
 */
public class Action {

	/**
	 * La valeur (au dessus, en dessous ou bien survol d'un zone d'accroche)
	 * associée au widget.
	 */
	private TypeAction val;
	/**
	 * L'index de la liste de zones où trouver le composant qui va devoir
	 * contenir le widget Variable.
	 */
	private int zoneIndex;
	/**
	 * Le point utilisé pour calculer la transtaion à appliquer à la ligne à
	 * dessiner lors du survol d'un zone d'accroche.
	 */
	private Point translate;
	/**
	 * La zone d'accroche en cours de survol.
	 */
	private Rectangle rect;
	/**
	 * Le widget survolé actuellement.
	 */
	private Widget comp;

	/**
	 * Constructeur de la classe Action.
	 *
	 * @param comp Le widget survolé sur lequel va être basée la fusion en cas
	 * de drop
	 * @param val La valeur du survol : <ul> <li>0 : survol par le dessous</li>
	 * <li>1 : survol d'un widget par le dessus</li> <li>2: survol d'une zone
	 * d'accroche</li> <li>-1 : Pas de survol</li> </ul>
	 */
	public Action(final Widget comp, final TypeAction val) {
		this.comp = comp;
		this.val = val;
	}

	/**
	 * Récupération du rectangle symbolisant la zone d'accroche en cours de
	 * survol.
	 *
	 * @return Le rectangle symbolisant la zone d'accroche survolée.<br/> null
	 * si on ne survole pas un zone d'accroche.
	 */
	public Rectangle getRect() {
		return rect;
	}

	/**
	 * Définition du rectangle de zone d'accroche en cas de survol d'un de ces
	 * zones.
	 *
	 * @param rec Le Rectangle symbolisant la zone d'accroche
	 */
	public void setRect(final Rectangle rec) {
		this.rect = rec;
	}

	/**
	 * Récupération du point sur lequel sera basée la translation de la ligne en
	 * cas de survol d'un zone d'accroche.
	 *
	 * @return Le point de translation.<br/> null si on ne survole pas de zone
	 * d'accroche.
	 */
	public Point getTranslate() {
		return translate;
	}

	/**
	 * Définition du point permettant de calculer la translation à appliquer à
	 * la ligne en cas de survol d'une zone d'accroche.
	 *
	 * @param translate Le point permettant de calculer la translation de la
	 * zone d'accroche.
	 */
	public void setTranslate(final Point translate) {
		this.translate = translate;
	}

	/**
	 * Récupération du widget en cours de survol.
	 *
	 * @return Le widget survolé, null si on ne survole pas de widget
	 */
	public Widget getComp() {
		return comp;
	}

	/**
	 * Récupération de la valeur associée au survol du widget.
	 *
	 * @return La valeur associée au survol : <ul> <li>0 : survol par le
	 * dessous</li> <li>1 : survol d'un widget par le dessus</li> <li>2 : survol
	 * d'une zone d'accroche</li> <li>-1 : pas de survol</li> <ul>
	 */
	public int getVal() {
		return val.toInt();
	}

	/**
	 * Récupération du type de l'action
	 *
	 * @return Le type d'action associée au survol : <ul> <li>DESSOUS : survol par le
	 * dessous</li> <li>DESSUS : survol d'un widget par le dessus</li> <li>ACCROCHE : survol
	 * d'une zone d'accroche</li> <li>INTERNE : survol d'une zone d'accroche</li> <li>RIEN : pas de survol</li> <ul>
	 */
	public TypeAction getTypeAction() {
		return val;
	}

	/**
	 * Recupère l'indice ou trouver le composant à fusionner dans un champ texte
	 *
	 * @return l'indice au sein de la liste de zones
	 */
	public int getZoneIndex() {
		return zoneIndex;
	}

	/**
	 * Permet de définir l'indice de la liste de zones ou trouver le composant
	 * ou sera fusionné le widget variable
	 *
	 * @param zoneIndex L'indice de la liste de zones
	 */
	public void setZoneIndex(int zoneIndex) {
		this.zoneIndex = zoneIndex;
	}
}