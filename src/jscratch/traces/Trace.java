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

import java.util.Date;
import jscratch.helpers.SessionHelper;
import org.jdom2.Element;

/**
 * Définit une trace.
 * 
 * @since 1.0
 * @version 1.0
 */
public abstract class Trace {
	
	protected final String HEURE = "heure";
	protected final String TYPETRACE = "type";
	protected final String ISWIDGET = "isWidget";
	protected final String AVANT = "avant";
	protected final String APRES = "apres";
	protected final String TRACE = "trace";
	protected final String NOMFICHIER = "url";
	protected final String FORMATFICHIER = "format";
	protected final String ACTION = "action";
	protected final String PARENTANCIEN = "ancienParent";
	protected final String PARENTNOUVEAU = "nouveauParent";
	protected final String POSITIONPARENT = "positionParRapportParent";
	protected final String ID = "id";
	
	
	
	/**
	 * Type.
	 */
	private TypeTrace type;
	
	/**
	 * Heure d'apparition.
	 */
	private String heure;
	
	/**
	 * Constructeur par défaut de <code>Trace</code>.
	 */
	public Trace(TypeTrace type) {
		this.type = type;
		this.heure = SessionHelper.formatHeure(new Date());
	}
	
	/**
	 * Permet de récupérer le type de la trace.
	 * 
	 * 
	 * @return le type de la trace
	 */
	public TypeTrace getType() {
		return this.type;
	}
	
	/**
	 * Permet de récupérer l'heure de la trace.
	 * 
	 * @since 1.0
	 * 
	 * @return l'heure au format 
	 */
	public String getHeure() {
		return this.heure;
	}

	@Override
	public String toString() {
		return this.heure + " : " + this.getType();
	}
	
	/**
	 * Permet d'avoir comment le widget doit se sérialiser.
	 * 
	 * @since 1.0
	 * 
	 * @return la trace en format XML
	 */
	public Element toXml() {
		Element thisXml = new Element(TRACE);
		thisXml.setAttribute(TYPETRACE, this.type.toString());
		thisXml.setAttribute(HEURE, this.heure);
		
		return thisXml;
	}
}