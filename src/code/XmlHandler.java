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

	/**Unpacks the master lists (except warbands) into the system*/
	public void unpackUniversal() {
		int precent = 0;
		try {
			File fXmlFile = new File("files/universal.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			precent += 30;

			unpackMasterEquipment(doc.getElementsByTagName("equipment"));
			precent += 20;
			//unpack injury
			precent += 20;
			//unpack magic
			precent += 10;
			//unpack maxstats
			precent += 10;
			//unpack misc
			precent += 10;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Universal unpacking stopped at " + precent + "%");
		}
	}
	private void unpackMasterEquipment(NodeList list) {
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node nNode = list.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Program.equipment.add(
					new Equipment(
						eElement.getNodeName(),
						Equipment.Type.Combat,
						getInt("cost", eElement),
						getInt("available", eElement)
					)
				);
			}
		}
	}
	/**Used by the thread to unpacks the master warband lists*/
	public void unpackAllWarbands() {
		//Grab warband list
		String[] s = {"reikland", "orcs&goblins"};
		for (int i = 0; i < s.length; i++) {//Loop through the list with a while statement
			try {
				File fXmlFile = new File("files/warband_"+s[i]+".xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				band = new Warband();
				
				NodeList list = doc.getElementsByTagName("general");
				for (int temp = 0; temp < list.getLength(); temp++) {
					Node nNode = list.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						band.name = getString("name", eElement);
						band.goldcrowns = getInt("gold", eElement);
					}
				}
				list = doc.getElementsByTagName("heroes");
				for (int dat = 0; dat < list.getLength(); dat++) {
					NodeList datass = doc.getElementsByTagName("hero");
					for (int ass = 0; ass < datass.getLength(); ass++) {
						Node n = datass.item(ass);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) n;
							Heroes hero = new Heroes();
							hero.name = getString("name",e);
							hero.setSkills(getArray("skills",6,e));
							hero.type = getString("race",e);
							hero.setStats(getArray("stats",10,e));
							hero.cost = getInt("cost",e);
							hero.min = getInt("min",e);
							hero.max = getInt("min",e);
							band.heroes[ass] = hero;
						}
					}
				}
				list = doc.getElementsByTagName("heroes");
				for (int dat = 0; dat < list.getLength(); dat++) {
					NodeList datass = doc.getElementsByTagName("hero");
					for (int ass = 0; ass < datass.getLength(); ass++) {
						Node n = datass.item(ass);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) n;
							Henchmen hench = new Henchmen();
							hench.name = getString("name",e);
							hench.type = getString("race",e);
							hench.setStats(getArray("stats",10,e));
							hench.cost = getInt("cost",e);
							hench.min = getInt("min",e);
							hench.max = getInt("min",e);
							hench.total = getInt("size",e);
							hench.promotable = getBoolean("talent",e); 
							band.henchmen[ass] = hench;
						}
					}
				}
				Program.bands.add(band);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	Warband band;
	/**Called to load a saved warband from rosters into the program.*/
	public void loadWarband(String name) {
		Program.warband = unpackWarband("rosters/"+name);
		band = null;
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
			
			//NodeList nList = doc.getElementsByTagName("hiredsword");
			//NodeList nList = doc.getElementsByTagName("dramaticpersona");
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
					hero.setStats(getArray("stats",10,e));
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
					hench.setStats(getArray("stats",10,e));
					hench.skills = getString("skills",e);
					hench.equipment = getString("equipment",e);
					band.henchmen[ass] = hench;
				}
			}
		}
	}
	
	/**Saves your warband into an xml file*/
	public void packWarband(String name) {
		packWarbandGeneral();
		packWarbandHeroes();
		packWarbandHenchmen();
	}
	private void packWarbandGeneral() {}
	private void packWarbandHeroes() {}
	private void packWarbandHenchmen() {}
	
	//These two functions are used to grab the values of xml elements
	private static String getString(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return t;
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
	private static String[] getArray(String t,int l,Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return new String[l];
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue().split(",");
	}
	private static int getInt(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return 0;
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Integer.parseInt(nValue.getNodeValue());
	}
	private static boolean getBoolean(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return false;
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Boolean.parseBoolean(nValue.getNodeValue());
	}
}	