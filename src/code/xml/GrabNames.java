package code.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import code.XmlHandler;

/**The purpose of this is to grab the different warband names for createPage and loadPage.*/
public class GrabNames extends XmlHandler {

	/**This grabs all of the warband names to create a new warband from the files/ folder.*/
	public static String[] newWarbands() {
		//Creates an expandable list to save the file names into, grabs all the file names in the selected directory, and then saves only the proper ones with just the important part of the name.
		List<String> results = new ArrayList<String>();
		File[] files = new File("files/").listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		    	if (file.getName().startsWith("warband_") && file.getName().endsWith(".xml"))
		        results.add(file.getName().substring(8, file.getName().length()-4));
		    }
		}
		
		//Creates a string array with the appropiate size, populate it, and then return the string with the names.
		String[] a = new String[results.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = results.get(i);
		}
		return a;
	}
	
	/**This grabs all of the warband names to load a saved warband from the rosters/ folder*/
	public static String[] savedWarbands() {
		List<String> results = new ArrayList<String>();
		File[] files = new File("rosters/").listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		    	if (file.getName().endsWith(".xml"))
		        results.add(file.getName().substring(0, file.getName().length()-4));
		    }
		}
		
		String[] a = new String[results.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = results.get(i);
		}
		return a;
	}
}
