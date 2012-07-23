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

public class CreateWarband extends XmlHandler {
	String type;
	Warband band;
	
	/**Called to load a saved warband from rosters into the program.*/
	public CreateWarband(String name) {
		type = name;
		Program.baseWarband = unpackWarband("files/warband_"+name + ".xml");
		Program.setupNewWarband();
		Program.gui.change(Gui.pane.main);
	}
	
	/**unpacks a warband from xml into a return, if it fails it will just return an empty warband*/
	private Warband unpackWarband(String name) {
		try {
			File fXmlFile = new File(name);
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
	
	/**Unpacks all the base information for the warband such as starting goldcrowns, maximum members, and the different special skills the characters can take.*/
	private void unpackWarbandGeneral(NodeList list) {
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node nNode = list.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				band.name = getString("name", eElement);
				band.type = type;
				band.membersMax = getInt("maxsize", eElement);
				band.membersMin = getInt("minsize", eElement);
				band.rules = getString("rules", eElement);
				band.skills = getString("skills", eElement);
				band.goldcrowns = getInt("gold", eElement);
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
					hero.type = getString("name",e);
					hero.setStats(getArray("stats",10,e));
					hero.setSkills(getArray("skillTypes",10,e));
					hero.min = getInt("min",e);
					hero.max = getInt("max",e);
					hero.cost = getInt("cost",e);
					//hero.race = code.Character.Race.valueOf(getString("race",e));//TODO: Fix
					hero.skills = getString("skills",e);
					hero.magic = getString("magic",e);
					hero.equipment = getString("equipment",e);
					band.heroes[ass] = hero;
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
					hench.type = getString("name",e);
					hench.setStats(getArray("stats",10,e));
					
					hench.skills = getString("skills",e);
					hench.equipment = getString("equipment",e);
					
					hench.cost = getInt("cost",e);
					hench.min = getInt("min",e);
					hench.max = getInt("max",e);
					//hench.race = code.Character.Race.valueOf(getString("race",e));//TODO: Fix
					hench.total = getInt("size",e);
					
					band.henchmen[ass] = hench;
					band.totalGroups++;
				}
			}
		}
	}
}
