package jscratch.dictionnaires;

import java.util.LinkedList;
import java.util.List;
import jscratch.helpers.PropertiesHelper;
import jscratch.traces.Trace;
import jscratch.traces.TypeTrace;

/**
 * Le dictionnaire qui stockera toutes les traces.
 * 
 * @since 1.0
 * @version 1.0
 */
public final class DicoTraces {

	/*
	 * L'instance de <code>DicoTraces</code>.
	 */
	private static DicoTraces instance = null;
	
	/**
	 * Le dico.
	 */
	private static List<Trace> dico;
	
	/**
	 * Default constructor of <code>DicoTraces</code>.
	 */
	private DicoTraces() {
		dico = new LinkedList<Trace>();
	}
	
	/**
	 * Permet de récupérer l'instance unique de <code>DicoTraces</code>.
	 */
	public static DicoTraces getInstance() {
		if (instance == null) {
			instance = new DicoTraces();
		}
		return instance;
	}
	
	/**
	 * Ajout d'une trace.
	 * 
	 * @param type le type de la trace
	 */
	public void ajouterTrace(final Trace trace) {
		boolean traces = Boolean.parseBoolean(PropertiesHelper.getInstance().get("user.trace.active"));
		boolean tracesType = Boolean.parseBoolean(PropertiesHelper.getInstance().get("user.trace.active." + trace.getType().toProperties()));
		if (traces && tracesType) {
			dico.add(trace);
		}
	}
	
	/**
	 * Permet de récupérer toutes les traces.
	 * 
	 * @return les traces
	 */
	public List<Trace> getLesTraces() {
		return dico;
	}
}