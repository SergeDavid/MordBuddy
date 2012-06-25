package code.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import code.Henchmen;
import code.Heroes;
import code.Program;
import code.Warband;
import code.XmlHandler;
import code.gui.Gui;

public class loadWarband {
	Warband band;
	XmlHandler xml = new XmlHandler();
	
	/**Called to load a saved warband from rosters into the program.*/
	public loadWarband(String name) {
		Program.warband = unpackWarband("rosters/"+name);
		Program.gui.change(Gui.pane.main);
	}
	
	/**unpacks a warband from xml into a return, if it fails it will just return an empty warband*/
	private Warband unpackWarband(String name) {
		try {
			File fXmlFile = new File(name+".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			band = new Warband();
			
			unpackWarbandGeneral(doc.getElementsByTagName("general"));
			unpackWarbandHeroes(doc.getElementsByTagName("heroes"), doc);
			unpackWarbandHenchmen(doc.getElementsByTagName("henchmen"), doc);
			return band;
		}
		catch (Exception e) {
			e.printStackTrace();
			return new Warband();
		}
	}
	
	private void unpackWarbandGeneral(NodeList list) {
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node nNode = list.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				band.name = xml.getString("name", eElement);
				band.type = xml.getString("type", eElement);
				band.wardstones = xml.getInt("wardstones", eElement);
				band.upkeep = xml.getInt("upkeep", eElement);
				band.members = xml.getInt("members", eElement);
				band.battles = xml.getInt("battles", eElement);
				band.rating = xml.getInt("rating", eElement);
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
					hero.name = xml.getString("name",e);
					hero.type = xml.getString("type",e);
					hero.setStats(xml.getArray("stats",10,e));
					hero.skills = xml.getString("skills",e);
					hero.equipment = xml.getString("equipment",e);
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
					hench.name = xml.getString("name",e);
					hench.type = xml.getString("type",e);
					hench.members = xml.getInt("members",e);
					hench.setStats(xml.getArray("stats",10,e));
					hench.skills = xml.getString("skills",e);
					hench.equipment = xml.getString("equipment",e);
					band.henchmen[ass] = hench;
				}
			}
		}
	}
}
