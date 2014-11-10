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
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.Condition;
import nxtim.instruction.Expression;
import nxtim.instruction.NonLogique;
import nxtim.instruction.Variable;

/**
 * Cette classe modélise la forme graphique du Widget représentant la négation logique.
 * @author ayden
 *
 */
public class NonLogiqueWidget extends ModeleWidget {

	private int largeur;

	private final int LARG_EXTREMITE;

	private ChampTexte f;
	/**
	 * @param args
	 */
	public NonLogiqueWidget() {
		this.LARG_EXTREMITE = 10;
		final int LARG_CHAMP = 14;

		final String op = "Non";
		message.put(new Point(this.LARG_EXTREMITE, 15), op);

		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font){};
		Rectangle2D bounds = metrics.getStringBounds(op, null);

		f = new ChampTexte(LARG_CHAMP, this);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_LOGIQUE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.NEGATION);
		f.setBounds(this.LARG_EXTREMITE + ((int) bounds.getWidth()) + 5, 3, LARG_CHAMP, 14);
		f.supprimerTexte();
		this.getLesZonesSaisies().add(f);

		this.largeur = LARG_CHAMP + 5 + (int) bounds.getWidth();
		int tabX[] = {0, 10, 10 + largeur, largeur + this.LARG_EXTREMITE * 2, this.LARG_EXTREMITE + largeur, 10};
		int tabY[] = {10, 0, 0, 10, 20, 20};

		this.setTabX(tabX);
		this.setTabY(tabY);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		//propriétés d'attachement du widget
		this.attachableBas = false;
		this.attachableHaut = false;
		this.imbricable = false;
		this.attachableInterne = true;
		this.setType(TypeModeleWidget.NEGATION);

		//modèle
		this.setElementProgramme(new NonLogique());

		// Recalcule la largeur du widget.
		this.setTailleX();
		this.setTailleY();
	}

	@Override
	public void applyChangeModele(){
		NonLogique expLog = ((NonLogique) getElementProgramme());

		Widget widget = f.getContentWidget();
		if (widget != null) {
			Expression varMem = (Expression) widget.getElementProgramme();
			if(varMem instanceof Condition) {
				expLog.setCondition((Condition) varMem);
			} else if(varMem instanceof NonLogique) {
				expLog.setCondition((NonLogique) varMem);
			} else {
				expLog.setCondition((Variable) varMem);
			}
		} else {
			expLog.setCondition((Condition) null);
		}
	}

	@Override
	public void decalageX(int x) {
		for (int i = 2; i < this.getTabX().length-1; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}
}
