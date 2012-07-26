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

/**This loads a selected warband from a saved roster.*/
public class LoadWarband extends XmlHandler {
	Warband band;
	
	/**Called to load a saved warband from rosters into the program.*/
	public LoadWarband(String name) {
		Program.warband = unpackWarband("rosters/"+name + ".xml");
		new code.xml.CreateWarband(Program.warband.type);
		Program.gui.change(Gui.pane.main);
	}
	
	/**unpacks a warband from xml to Program.warband, changes the gui, and then loads the base warband into Program.warband*/
	private Warband unpackWarband(String name) {
		try {
			File fXmlFile = new File(name);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			band = new Warband();
			band.savedName = name.substring(8,name.length()-4);
			
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
				band.name = getString("name", eElement);
				band.goldcrowns = getInt("gold", eElement);
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
					hero.setStats(getArray("stats",11,e));
					hero.skills = getString("skills",e);
					hero.equipment = getString("equipment",e);
					band.heroes[ass] = hero;
					band.members++;
					band.totalHeroes++;
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
					hench.setStats(getArray("stats",11,e));
					hench.skills = getString("skills",e);
					hench.equipment = getString("equipment",e);
					band.henchmen[ass] = hench;
					band.members+=hench.members;
					band.totalGroups++;
				}
			}
		}
	}
}
