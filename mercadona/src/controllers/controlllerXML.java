package controllers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class controlllerXML {

	public controlllerXML() {

	}

	/**
	 * Obtiene el correo de emergenccia del archivo de configuración
	 * @return
	 */
	public String getcorreo() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		String correo="";

		try {
			// Creo un documentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Obtengo el documento, a partir del XML
			Document documento = builder.parse(new File("config/config.xml"));

			// Cojo todas las etiquetas serie del documento
			NodeList listaCoches = documento.getElementsByTagName("AppConfig");

			// Recorro las etiquetas
			for (int i = 0; i < listaCoches.getLength(); i++) {
				// Cojo el nodo actual
				Node nodo = listaCoches.item(i);
				// Compruebo si el nodo es un elemento
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					// Lo transformo a Element
					Element e = (Element) nodo;
					// Obtengo sus hijos
					NodeList hijos = e.getChildNodes();
					for (int j = 0; j < hijos.getLength(); j++) {
						// Obtengo al hijo actual
						Node hijo = hijos.item(j);
						// Compruebo si es un nodo
						if (hijo.getNodeType() == Node.ELEMENT_NODE) {
								correo = hijo.getTextContent();

							// System.out.println("Propiedad: " + hijo.getNodeName() + ", Valor: " +
							// hijo.getTextContent());
						}

					}
				}

			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correo;
	}

}
