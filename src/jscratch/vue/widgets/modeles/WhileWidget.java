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
package jscratch.vue.widgets.modeles;

import java.awt.Point;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;

import jscratch.parametrages.properties.VariableProperties;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.Condition;
import nxtim.instruction.InstructionWhile;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type While.
 * 
 * @since 1.0
 * @version 1.0
 */
public class WhileWidget extends ModeleWidget {
	private ChampTexte f;
	/**
	 * Constructeur du modèle définissant les différents paramètres du While.
	 */
	public WhileWidget(){
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135,/**/ 135, 130,/**/ 55,50,40,35, /**/10, 5,/**/ 5, 10,/**/35,40,50,55,/**/130,135,                                 /**/135,130,/**/50,45,35,30,/**/5,0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5,/**/ 20, 25,/**/25,30,30,25, /**/25, 30,/**/ 35, 40,/**/40,45,45,40,/**/40, 45,                         /**/50,55,/**/55,60,60,55,/**/55,50};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeModeleWidget.WHILE);

		//this.setMessage("While");
		message.put(new Point(5, 17), "Tant que");
		message.put(new Point(85, 17), "faire");

		int widthChamp = 20;
		f = new ChampTexte(widthChamp, this);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_LOGIQUE);
		f.setBounds(60, 3, widthChamp, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		this.setElementProgramme(new InstructionWhile());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(VariableProperties.ZONE_ACCROCHE_PAR_DEFAULT);

		this.decalageX(-20);
	}

	@Override
	public void applyChangeModele(){		
		Widget contentWidget = f.getContentWidget();
		InstructionWhile whileIns = ((InstructionWhile) getElementProgramme());

		// On met à jour la condition dans l'elementProgramme si elle existe
		if (whileIns != null) {
			if (contentWidget != null) {			
				Condition cond = (Condition) contentWidget.getElementProgramme();
				whileIns.setCondition(cond);
			} else {
				whileIns.rmCondition();
			}
		}		
	}

	@Override
	public void decalageX(final int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		for (i = 22; i < 26; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	@Override
	public void decalageY(int b,Rectangle r) {
		int i;
		for (i = 16; i < tabY.length; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}
}
