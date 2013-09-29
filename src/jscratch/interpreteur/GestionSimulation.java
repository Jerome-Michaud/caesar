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
package jscratch.interpreteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jscratch.controleur.sim.Simulator;

public class GestionSimulation{
	
	private Interpreteur interpreteur;
	private Simulator simulator;
	private List<Runnable> runnables;
	private ExecutorService service;
	private InterpreteurListener listener;
	
    public GestionSimulation(Simulator simulator){
    	this.simulator = simulator;
    	this.interpreteur = new Interpreteur(simulator);
    	this.runnables = new ArrayList<Runnable>();
		this.listener = new InterpreteurListener(this);

		runnables.add(this.interpreteur);
		runnables.add(this.simulator);
		service = Executors.newFixedThreadPool(2);
    }         
     
    private static void executeRunnables(final ExecutorService service, List<Runnable> runnables){
    	for(Runnable r : runnables){
            service.execute(r);
        }
        service.shutdown();
    }
    /**
	 * permet de demarrer le controlleur de la simulation
	 */
    public void startThread(){
    	/*System.out.println("Demarre le controlleur");
		System.out.println("Controlleur = "+Thread.currentThread().getName());*/
    	executeRunnables(service, runnables);
    }
    /**
	 * arrete le controller de la simulation
	 */
	public void stopThread() {
		/*System.out.println("Arret du controller de la simulation");
		System.out.println("Controlleur = "+Thread.currentThread().getName());*/
		interpreteur.stopThread();
		simulator.stopThread();
	}
	
	/**
	 * met la simulation en pause
	 */
	public synchronized void waitThread() {
		/*System.out.println("Met en attente le controlleur");
		System.out.println("Controlleur = "+Thread.currentThread().getName());*/
		interpreteur.waitThread();
		simulator.waitThread();
	}
	
	/**
	 * redemarre la simulation
	 */
	public synchronized void notifyThread() {
		/*System.out.println("Redemarre le controlleur");
		System.out.println("Controlleur = "+Thread.currentThread().getName());*/
		interpreteur.notifyThread();
		simulator.notifyThread();
	}
	
	public InterpreteurListener getListener(){
		return listener;
	}
}
