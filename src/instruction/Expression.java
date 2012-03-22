package instruction;

import traduction.VisiteurTraduction;
/**
 * Une expression est un morceau de code d'un programme qui donne une valeur et
 * qui n'est pas nécessairement une instruction (opération, condition, variable).
 * Elle peut être traduite dans plusieurs langages différents.
 * @author Adrien DUROY, Bastien AUBRY, Ivan MELNYCHENKO
 */
public interface Expression {
	void accepte(VisiteurTraduction v);
}
