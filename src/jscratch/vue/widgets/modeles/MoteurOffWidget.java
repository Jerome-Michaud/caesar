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

import jscratch.vue.widgets.modeles.zones.ListeDeroulante;
import jscratch.vue.widgets.modeles.zones.Zone;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;
import java.awt.Rectangle;

import nxtim.instruction.InstructionMoteurOff;
import nxtim.instruction.Moteur;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type MoteurOff
 * 
 * @since 1.0
 * @version 1.0
 */
public class MoteurOffWidget extends ModeleWidget {
	private ListeDeroulante<Moteur> l;
	
	/**
	 * Constructeur du modèle définissant les différents paramètres du MoteurOff.
	 */
	public MoteurOffWidget() {
		int tX[] = {0, 5, 30, 35, 45, 50, 130, 135, 135, 130, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.MOTEUROFF);
		
		message.put(new Point(5, 17), "Moteur");
		message.put(new Point(95, 17), "arrêt");
		
		this.setElementProgramme(new InstructionMoteurOff());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		l = new ListeDeroulante<Moteur>(Moteur.values(), this);
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);
		
		setInstructionMoteur(l.getValeur());
		
		this.decalageX(-10);
		
		initListeners();
	}
	
	@Override
	public void applyChangeModele(){
		setInstructionMoteur(l.getValeur());
	}
	
	@Override
    public void decalageY(int b,Rectangle r) {
        int i;
        for (i = 8; i < 16; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }
	
	@Override
	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionMoteur(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
	}
	
	/**
	 * Méthode permettant de définir l'instruction moteur du widget
	 * 
	 * @param nom L'instruction Moteur à définir sur le modèle
	 */
	private void setInstructionMoteur(String nom) {
		((InstructionMoteurOff) getElementProgramme()).setMoteur(Moteur.values()[Integer.parseInt(nom)]);
	}
}