package instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DicoVars {

	private static DicoVars instance;
	private HashMap<String, Variable> dict = new HashMap<String, Variable>();

	private DicoVars(){}

	public static DicoVars getInstace(){
		if (instance == null){
			instance = new DicoVars();
		}
		return instance;
	}
	
	
	public void ajouter(Variable v){
		dict.put(v.toString(),v);
	}
	
	public void supprimer(String nom){
		dict.remove(nom);
	}
	
	public List<Variable> getVariablesDeType(TypeVariable type){
		ArrayList<Variable> res = new ArrayList<Variable>();
		for (Variable v: dict.values()){
			if (v.getType()==type){
				res.add(v);
			}
		}
		return res;
	}
	
}
