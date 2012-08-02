package code;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlHandler {
	//These two functions are used to grab the values of xml elements
	public String getString(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) {return "";}
		if (e.getElementsByTagName(t).item(0).getChildNodes().item(0) == null) {return "";}
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getTextContent();
	}
	public String[] getArray(String t,int l,Element e) {
		if (e.getElementsByTagName(t).item(0) == null) {return new String[1];}
		if (e.getElementsByTagName(t).item(0).getChildNodes().item(0) == null) {return new String[1];}
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue().split(",");
	}
	public int getInt(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) {return 0;}
		if (e.getElementsByTagName(t).item(0).getChildNodes().item(0) == null) {return 0;}
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Integer.parseInt(nValue.getNodeValue());
	}
	public boolean getBoolean(String t, Element e) {
		if (e.getElementsByTagName(t).item(0) == null) {return false;}
		if (e.getElementsByTagName(t).item(0).getChildNodes().item(0) == null) {return false;}
		NodeList nlList = e.getElementsByTagName(t).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return Boolean.parseBoolean(nValue.getNodeValue());
	}
}	