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
		
	public RobotRenderer(Robot robot) {
		super();
		
		this.robot = robot;
		
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
		g.setColor(Color.MAGENTA);
		for(Sensor<? extends Object> s : robot.getSensors())
		{
			g.drawRect((int)s.getPosition().getX(),(int)s.getPosition().getY(),1,1);
			
			if(s instanceof UltraSonicSensor)
			{
				g.setColor(Color.ORANGE);
<<<<<<< HEAD
				g.drawRect((int)((UltraSonicSensor) s).getPositionFinal().getX(),(int)((UltraSonicSensor) s).getPositionFinal().getY(), 1, 1);
=======
				g.drawRect((int)((UltraSonicSensor) s).getPointFinal().getX(),(int)((UltraSonicSensor) s).getPointFinal().getY(), 1, 1);
>>>>>>> 37f209697bdda91b1de9819cfa31f5cbc308fc9a
			}
		}
	}
	
}
