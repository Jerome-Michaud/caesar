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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Rectangle2D;

import jscratch.helpers.FontHelper;
import jscratch.vue.widgets.modeles.zones.ListeDeroulante;
import jscratch.vue.widgets.modeles.zones.Zone;
import nxtim.instruction.CapteurSlot;
import nxtim.instruction.ValeurCapteur;

/**
 *
 * @author Adrien DUROY
 */
public class CapteurWidget extends ModeleWidget {
	private int largeur;
	private final int LARG_EXTREMITE;

	public CapteurWidget() {
		super();

		this.setElementProgramme(new ValeurCapteur(CapteurSlot.A));

		attachableInterne = true;
		attachableHaut = false;
		attachableBas = false;
		imbricable = false;

		final String label = "Capteur";
		Font font = FontHelper.getWidgetFont();
		FontMetrics metrics = new FontMetrics(font) {};
		Rectangle2D sizesText = metrics.getStringBounds(label, null);

		message.put(new Point(5, 15), label);


		ListeDeroulante<CapteurSlot> l = new ListeDeroulante<CapteurSlot>(CapteurSlot.values(), this);
		l.setBounds((int) sizesText.getWidth() + 10, 3, 45, 15);
		this.getLesZonesSaisies().add(l);

		LARG_EXTREMITE = 5;
		largeur = (int) sizesText.getWidth() + LARG_EXTREMITE + l.getWidth();
		int tX[] = {0, 5, this.LARG_EXTREMITE + largeur, largeur + 10, largeur + 10, this.LARG_EXTREMITE + largeur, 5, 0};
		int tY[] = {5, 0, 0, 5, 15, 20, 20, 15};
		this.setTabX(tX);
        this.setTabY(tY);
		setType(TypeModeleWidget.CAPTEUR);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		initListeners();
	}

	@Override
	public void initListeners() {
		((ListeDeroulante) this.getLesZonesSaisies().get(0)).addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				setSlot(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
	}

	private void setSlot(String nameSlot) {
		((ValeurCapteur) getElementProgramme()).setSlot(CapteurSlot.values()[Integer.parseInt(nameSlot)]);
	}
}
