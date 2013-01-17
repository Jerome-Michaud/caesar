package jscratch.utils.sim;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Classe qui fourni des méthodes qui simplifient la gestion des documents XML
 * @author Guillaume Delorme
 *
 */
public class XMLUtils {
	private XMLUtils() {}

	/**
	 * Récupérer la racine d'un document XML
	 * @param xmlFile le fichier XML
	 * @return l'élément racine du document XML
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Element getDocumentRoot(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		// Parsage du fichier XML
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		Document doc = docBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		// Recherche de l'élément racine
		NodeList nodeList = doc.getChildNodes();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE)
				return (Element) node;
		}
		
		return null;
	}
	
	/**
	 * Récupérer l'élément fils avec un nom donné
	 * @param element l'élément sur lequel on récupère le fils
	 * @param name le nom des élément fils
	 * @return l'élément fils
	 */
	public static Element getChild(Element element, String name) {
		NodeList nodeList = element.getElementsByTagName(name);
		
		return (Element) nodeList.item(0);
	}
	
	/**
	 * Récupérer la liste des éléments fils avec un nom donné
	 * @param element l'élément sur lequel on récupère les fils
	 * @param name le nom des éléments fils
	 * @return liste des éléments fils
	 */
	public static List<Element> getChildren(Element element, String name) {
		NodeList nodeList = element.getElementsByTagName(name);
		List<Element> elements = new ArrayList<Element>();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE)
				elements.add((Element) node);
		}
		
		return elements;
	}
	
	/**
	 * Récupérer la liste des éléments fils
	 * @param element l'élément sur lequel on récupère les fils
	 * @return liste des éléments fils
	 */
	public static List<Element> getChildren(Element element) {
		return getChildren(element, "*");
	}
	
	/**
	 * Récupérer la valeur d'un élément
	 * @param element l'élément
	 * @return la valeur de l'élément
	 */
	public static String getValue(Element element) {
		return element.getChildNodes().item(0).getNodeValue();
	}
}