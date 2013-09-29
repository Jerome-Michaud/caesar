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
package jscratch.vue.widgets.modeles;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

import jscratch.helpers.FontHelper;

import nxtim.instruction.VariableModifiable;

/**
 *
 * @since 1.0
 * @version 1.0
 */
public class VariableWidget extends ModeleWidget {

	/**
	 * Constructeur du modèle définissant les différents paramètres du Variable.
	 */
	private VariableWidget() { }
	
	/**
	 * Constructeur par défaut de <code>VariableWidget</code>.
	 * 
	 * @param variableModifiable la variable
	 */
	public VariableWidget(VariableModifiable variableModifiable) {
		int tX[] = {0, 3, 7, 10, 10, 7, 3, 0};
		int tY[] = {3, 0, 0,  3,  11, 14, 14,10};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.VARIABLE);

		message.put(new Point(7, 11), variableModifiable.getNom());
		this.setElementProgramme(variableModifiable);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		
        this.attachableBas = false;
        this.attachableHaut = false;
        this.imbricable = false;
        this.attachableInterne = true;
        

		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font){};  
		Rectangle2D bounds = metrics.getStringBounds(variableModifiable.getNom(), null);  
	

		this.decalageX((int) bounds.getWidth()+2);
	}
/*
	@Override
	public void applyChangeModele(){

		VariableModifiable var = ((VariableModifiable) getElementProgramme());
		

	}*/
	@Override
	public void decalageX(int a) {
		int i;
		for (i = 2; i < this.getTabX().length-2; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	/**
	 * Retourne le nom de la variable qui lui est rattaché.
	 * 
	 * @return nom de variable
	 */
	public String getNomVariable() {
		return ((VariableModifiable)this.getElementProgramme()).getNom();
	}
}
