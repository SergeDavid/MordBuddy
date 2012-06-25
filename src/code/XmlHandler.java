package code;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlHandler {

	Warband band;
	
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
	
	//These two functions are used to grab the values of xml elements
	public String getString(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return t;
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
	public String[] getArray(String t,int l,Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return new String[l];
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue().split(",");
	}
	public int getInt(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return 0;
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Integer.parseInt(nValue.getNodeValue());
	}
	public boolean getBoolean(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) return false;
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Boolean.parseBoolean(nValue.getNodeValue());
	}
}	