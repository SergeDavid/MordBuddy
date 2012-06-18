package code;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import code.gui.Gui;

public class XmlHandler {
	
	public XmlHandler() {
		unpackUniversal();
	}
	private void unpackUniversal() {
		//TODO: opens universal.xml
		//master equipment list
		//master injury list (will have to hook into the character stats somehow)
		//master magic / prayer list
		//master maxstats list
	}
	
	Warband band;
	/**Loads a saved warband into use*/
	public void unpackWarband(String name) {
		try {
			File fXmlFile = new File("rosters/"+name+".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			band = new Warband();
			
			unpackWarbandGeneral(doc.getElementsByTagName("general"));
			unpackWarbandHeroes(doc.getElementsByTagName("heroes"), doc);
			unpackWarbandHenchmen(doc.getElementsByTagName("henchmen"), doc);
			
			//NodeList nList = doc.getElementsByTagName("hiredsword");
			//NodeList nList = doc.getElementsByTagName("dramaticpersona");
			Program.warband = band;
			Program.gui.change(Gui.pane.main);
		}
		catch (Exception e) {e.printStackTrace();}
	}
	private void unpackWarbandGeneral(NodeList list) {
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node nNode = list.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println(eElement.getNodeName());
				band.name = getString("name", eElement);
				band.type = getString("type", eElement);
				band.wardstones = getInt("wardstones", eElement);
				band.upkeep = getInt("upkeep", eElement);
				band.members = getInt("members", eElement);
				band.battles = getInt("battles", eElement);
				band.rating = getInt("rating", eElement);
			}
		}
	}
	private void unpackWarbandHeroes(NodeList list, Document doc) {
		for (int dat = 0; dat < list.getLength(); dat++) {//keeps the following from throwing errors by only trying to open elements that are present.
			NodeList datass = doc.getElementsByTagName("hero");//Grabs hero data
			for (int ass = 0; ass < datass.getLength(); ass++) {
				Node n = datass.item(ass);
				if (n.getNodeType() == Node.ELEMENT_NODE) {//Applies hero data to your hero.
					Element e = (Element) n;
					Heroes hero = new Heroes();
					hero.name = getString("name",e);
					hero.type = getString("type",e);
					hero.stats(getString("stats",e));
					hero.skills = getString("skills",e);
					hero.equipment = getString("equipment",e);
					band.heroes[ass] = hero;
				}
			}
		}
	}
	private void unpackWarbandHenchmen(NodeList list, Document doc) {
		for (int dat = 0; dat < list.getLength(); dat++) {//keeps the following from throwing errors by only trying to open elements that are present.
			NodeList datass = doc.getElementsByTagName("group");//Grabs henchmen data
			for (int ass = 0; ass < datass.getLength(); ass++) {
				Node n = datass.item(ass);
				if (n.getNodeType() == Node.ELEMENT_NODE) {//Applies henchmen data to your henchmen.
					Element e = (Element) n;
					Henchmen hench = new Henchmen();
					hench.name = getString("name",e);
					hench.type = getString("type",e);
					hench.members = getInt("members",e);
					hench.stats(getString("stats",e));
					hench.skills = getString("skills",e);
					hench.equipment = getString("equipment",e);
					band.henchmen[ass] = hench;
				}
			}
		}
	}
	
	/**Saves your warband into an xml file*/
	public void packWarband(String name) {
		
	}
	
	private static String getString(String sTag, Element eElement) {
		try {
			NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
			Node nValue = (Node) nlList.item(0);
			return nValue.getNodeValue();
		}
		catch (Exception e) {return "";}
	}
	private static int getInt(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Integer.parseInt(nValue.getNodeValue());
	}
}	