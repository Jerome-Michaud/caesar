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
package jscratch.vue.sim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jscratch.modeles.sim.Robot;
import jscratch.modeles.sim.Sensor;
import jscratch.modeles.sim.UltraSonicSensor;


/**
 * Classe qui gère le rendu du robot
 * @author Guillaume Delorme
 *
 */
public class RobotRenderer implements Renderer {
	/**
	 * Le robot à afficher
	 */
	private Robot robot;
	private BufferedImage robotImage;
	private boolean capteurs;
	private boolean collisions;
		
	public RobotRenderer(Robot robot) {
		super();
		
		this.robot = robot;
		this.capteurs = false;
		this.collisions = false;
		
		try {
			robotImage = ImageIO.read(new File("./ressources/simulateur/images/robot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		robot.setLongueur(robotImage.getHeight());
		robot.setLargeur(robotImage.getWidth());
				
		robot.setPointCentral(new Point2D.Double(robot.getX()+robot.getLargeur()/2,robot.getY()+robot.getLongueur()/2));
	}

	/* (non-Javadoc)
	 * @see view.Renderer#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		AffineTransform af = new AffineTransform();
		
		af.translate(robot.getX(), robot.getY());
		af.rotate(robot.getOrientation(), robot.getLargeur() / 2, robot.getLongueur() / 2);
		
		((Graphics2D) g).drawImage(robotImage, af, null);
		if(collisions){
			g.drawRect((int)robot.getPointCentral().getX(),(int)robot.getPointCentral().getY(), 1, 1);
			Point2D[] p = robot.getListePoints();
			for(int i=0; i<32; i++)
			{
				switch (i) {
				case 0:
					g.setColor(Color.BLUE);
					break;
				case 8:
					g.setColor(Color.RED);
					break;
				case 16:
					g.setColor(Color.GREEN);
					break;
				case 24:
					g.setColor(Color.ORANGE);
					break;
				default:
					g.setColor(Color.BLACK);
					break;
				}
				
				g.drawRect((int)p[i].getX(),(int)p[i].getY(), 1, 1);
			}
		}
		
		if(capteurs){
			g.setColor(Color.MAGENTA);
			for(Sensor<? extends Object> s : robot.getSensors())
			{
				g.drawRect((int)s.getPosition().getX(),(int)s.getPosition().getY(),1,1);
				
				if(s instanceof UltraSonicSensor)
				{
					g.drawRect((int)((UltraSonicSensor) s).getPointFinal().getX(),(int)((UltraSonicSensor) s).getPointFinal().getY(), 1, 1);
				}
			}
		}
	}

	/**
	 * retourne le boolean sur l'affichage des capteurs
	 * @return capteurs
	 */
	public boolean getCapteurs() {
		return capteurs;
	}
	
	/**
	 * modifie la valeur du boolean capteurs
	 * 
	 */
	public void setCapteurs(boolean b) {
		capteurs = b;
	}
	
	/**
	 * retourne le boolean sur l'affichage des collisions
	 * @return capteurs
	 */
	public boolean getCollisions() {
		return collisions;
	}
	
	/**
	 * modifie la valeur du boolean collisions
	 * 
	 */
	public void setCollisions(boolean b) {
		collisions = b;
	}
	
}
