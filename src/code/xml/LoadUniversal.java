package code.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import code.Equipment;
import code.Modifiers;
import code.Program;
import code.Race;
import code.XmlHandler;

public class LoadUniversal extends XmlHandler {
	
	/**Called to load a saved warband from rosters into the program.*/
	public LoadUniversal() {
		unpackUniversal("files/universal.xml");
	}
	
	/**unpacks a warband from xml to Program.warband, changes the gui, and then loads the base warband into Program.warband*/
	private void unpackUniversal(String name) {
		System.out.println("Extracting Universal...");
		try {
			File fXmlFile = new File(name);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			unpackMaxStats(doc.getElementsByTagName("maxStats"));System.out.println("Races unpacked.");
			unpackMagic(doc.getElementsByTagName("magic"), doc);System.out.println("Magic unpacked.");
			unpackInjuries(doc.getElementsByTagName("injury"));System.out.println("Injuries unpacked.");
			unpackSkills(doc.getElementsByTagName("skills"));System.out.println("Skills unpacked.");
			unpackEquipment(doc.getElementsByTagName("equipment"), doc);System.out.println("Equipment unpacked.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Universe is now unpacked.");
	}
	
	private void unpackMaxStats(NodeList list) {
		NodeList types = list.item(0).getChildNodes();
		for (int i = 0; i < types.getLength(); i++) {
			if (types.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) types.item(i);
				Race r = new Race();
				r.name = e.getNodeName();
				r.setMax(e.getTextContent().split(","));
				Program.races.add(r);
			}
		}
	}
	private void unpackMagic(NodeList list, Document doc) {
		NodeList types = list.item(0).getChildNodes();
		for (int i = 0; i < types.getLength(); i++) {
			if (types.item(i).getNodeType() == Node.ELEMENT_NODE) {
				NodeList items = doc.getElementsByTagName(types.item(i).getNodeName()).item(0).getChildNodes();
				for (int j = 0; j < items.getLength(); j++) {
					if (items.item(j).getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) items.item(j);
						Modifiers m = new Modifiers();
						m.name = e.getNodeName();
						//m.setType(types.item(i).getNodeName());
						Program.magic.add(m);
					}
				}
			}
		}
	}
	private void unpackInjuries(NodeList list) {
		NodeList i = list.item(0).getChildNodes();
		for (int temp = 0; temp < i.getLength(); temp++) {
			Node n = i.item(temp);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;
				Modifiers m = new Modifiers();
				m.name = e.getNodeName();
				m.min = getInt("min", e);
				m.max = getInt("max", e);
				Program.injuries.add(m);
			}
		}
	}
	private void unpackSkills(NodeList list) {
		//TODO: Copy/Paste from equipment
	}
	
	private void unpackEquipment(NodeList list, Document doc) {
		//Grabs the true child list and then loops through them
		NodeList types = list.item(0).getChildNodes();
		for (int i = 0; i < types.getLength(); i++) {
			//If statement removes non-nodes that I can't use.
			if (types.item(i).getNodeType() == Node.ELEMENT_NODE) {
				//Repeat since I have elements nested in others like this. 
				//<equipment>list
				//	<combat>first loop
				//		<sword>second loop
				NodeList items = doc.getElementsByTagName(types.item(i).getNodeName()).item(0).getChildNodes();
				for (int j = 0; j < items.getLength(); j++) {
					if (items.item(j).getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) items.item(j);
						Equipment m = new Equipment();
						m.name = e.getNodeName();
						m.rarity = getInt("available", e);
						m.cost = getInt("cost", e);
						m.setType(types.item(i).getNodeName());
						Program.equipment.add(m);
					}
				}
			}
		}
	}
}
