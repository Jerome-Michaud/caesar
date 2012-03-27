package Modeles;

import instruction.TypeVariable;
import instruction.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DicoVars {

	private static DicoVars instance;
	private HashMap<String, Variable> dictionnaire;

	private DicoVars(){
		dictionnaire = new HashMap<String, Variable>();
	}

	public synchronized static DicoVars getInstance() {
		if (instance == null){
			instance = new DicoVars();
		}
		return instance;
	}
	
	
	public void ajouter(Variable v){
		if(!v.getNom().isEmpty())
			dictionnaire.put(v.getNom(),v);
	}
	
	public void supprimer(String nom){
		dictionnaire.remove(nom);
	}
	
	public List<Variable> getVariablesDeType(TypeVariable type){
		ArrayList<Variable> res = new ArrayList<Variable>();
		for (Variable v: dictionnaire.values()){
			if (v.getType()==type){
				res.add(v);
			}
		}
		return res;
	}
	
	public HashMap<String, Variable> getDictionnaire() {
		return this.dictionnaire;
	}

	public Variable[] getLesvariables() {
		return (Variable[]) dictionnaire.values().toArray(new Variable[0]);
	}
}
