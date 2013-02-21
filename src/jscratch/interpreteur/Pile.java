package jscratch.interpreteur;

import java.util.Stack;

/**
 * Classe Pile pour stocker les données
 *
 * @since 1.0
 * @version 1.0
 */
public class Pile<T> {

	// TODO remplacer Stack par quelque chose de mieux
	private Stack<T> stack;

	/**
	 * Constructeur: initialisation de pile
	 */
	public Pile (){
		stack = new Stack<T>();
	}

	/***
	 * 
	 * @return true si la pile est vide, false sinon
	 */
	public boolean estVide(){
		return stack.empty();
	}

	/***
	 * 
	 * @return sommet de la pile
	 */
	public T sommet(){
		return stack.peek();
	}
	
	/***
	 * Fonction empiler pour empiler un element au sommet de la pile
	 * @param elem
	 */
	public void empile(T elem){
		stack.push(elem);
	} 
	
	/***
	 * Fonction dépiler pour éliminer le sommet de la pile
	 * @return le sommet
	 */
	public T depile(){
		return stack.pop();
	}
	
	/***
	 * 
	 * @return taille de pile
	 */
	public int taille(){
		return stack.size();
	}
	
	/**
	 * Vide la pile.
	 */
	public void nettoyer() {
		stack.clear();
	}
}
