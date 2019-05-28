package test;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Settings {

	private File file = new File("src/config.xml");
	private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder dBuilder;
	private Document doc;

	public Settings() {
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(file);
		} catch (SAXException | IOException | ParserConfigurationException ignored) {
			System.out.println(ignored);
		}
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	}
}