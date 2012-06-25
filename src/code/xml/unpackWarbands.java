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

public class unpackWarbands {
	
	Warband band;
	XmlHandler xml = new XmlHandler();
	
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
				
				unpackGeneral(doc.getElementsByTagName("general"));
				unpackHeroes(doc.getElementsByTagName("heroes"),doc);
				unpackHenchmen(doc.getElementsByTagName("henchmen"),doc);
				Program.bands.add(band);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void unpackGeneral(NodeList list) {
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node nNode = list.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				band.name = xml.getString("name", eElement);
				band.goldcrowns = xml.getInt("gold", eElement);
			}
		}
	}

	private void unpackHeroes(NodeList list, Document doc) {
		for (int dat = 0; dat < list.getLength(); dat++) {
			NodeList datass = doc.getElementsByTagName("hero");
			for (int ass = 0; ass < datass.getLength(); ass++) {
				Node n = datass.item(ass);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) n;
					Heroes hero = new Heroes();
					hero.name = xml.getString("name",e);
					hero.setSkills(xml.getArray("skills",6,e));
					hero.type = xml.getString("race",e);
					hero.setStats(xml.getArray("stats",10,e));
					hero.cost = xml.getInt("cost",e);
					hero.min = xml.getInt("min",e);
					hero.max = xml.getInt("min",e);
					band.heroes[ass] = hero;
				}
			}
		}
	}
	
	private void unpackHenchmen(NodeList list, Document doc) {
		for (int dat = 0; dat < list.getLength(); dat++) {
			NodeList datass = doc.getElementsByTagName("group");
			for (int ass = 0; ass < datass.getLength(); ass++) {
				Node n = datass.item(ass);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) n;
					Henchmen group = new Henchmen();
					group.name = xml.getString("name",e);
					group.type = xml.getString("race",e);
					group.setStats(xml.getArray("stats",10,e));
					group.cost = xml.getInt("cost",e);
					group.min = xml.getInt("min",e);
					group.max = xml.getInt("min",e);
					band.henchmen[ass] = group;
				}
			}
		}
	}
}
