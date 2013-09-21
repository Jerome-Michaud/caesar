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
package jscratch.traces;

import jscratch.vue.widgets.Widget;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceWidgetDeplacement extends Trace {

	/**
	 * Les widgets importants.
	 */
	private Widget widget, parentAvant, parentApres;
	private int positionParRapportParentAvant, positionParRapportParentApres;
	
	/**
	 * Constructeur par défaut de <code>TraceDeplacementWidget</code>.
	 * 
	 * @since 1.0
	 * 
	 * @param widget le widget deplacé
	 * @param parentAvant le parent avant déplacement
	 * @param parentApres le parent après déplacement
	 * @param isAjout <code>true</code> si le widget est ajouté depuis le panel instruction, <code>false</code> sinon
	 */
	public TraceWidgetDeplacement(final Widget widget, final Widget parentAvant, final Widget parentApres, final int positionParRapportParentAvant, final int positionParRapportParentApres ) {
		super(TypeTrace.WIDGET_DEPLACEMENT);
		this.widget = widget;
		this.parentAvant = parentAvant;
		this.parentApres = parentApres;
		this.positionParRapportParentAvant = positionParRapportParentAvant;
		this.positionParRapportParentApres = positionParRapportParentApres;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
				
		//ajout du widget
		thisXml.addContent(this.widget.toXml());
		
		//ajout de l'ancien parent
		if (this.parentAvant != null) {
			Element ancien = new Element(PARENTANCIEN);
			ancien.setAttribute(POSITIONPARENT, String.valueOf(this.positionParRapportParentAvant));
			ancien.addContent(this.parentAvant.toXml());
			thisXml.addContent(ancien);
		}
		
		//ajout du nouveau parent
		if (this.parentApres != null) {
			Element nouveau = new Element(PARENTNOUVEAU);
			nouveau.setAttribute(POSITIONPARENT, String.valueOf(this.positionParRapportParentApres));
			nouveau.addContent(this.parentApres.toXml());
			thisXml.addContent(nouveau);
		}
		return thisXml;
	}
}