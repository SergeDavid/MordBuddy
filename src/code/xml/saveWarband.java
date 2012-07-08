package code.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import code.Henchmen;
import code.Heroes;
import code.Program;

public class saveWarband {
	/**Saves your warband into an xml file*/
	public saveWarband() {
		//If the folder doesn't exist, create it so we can save our save files inside it.
		File directory = new File("rosters/");
		if (!directory.exists()) {if (directory.mkdir()) {System.out.println("created directory");} else {return;}}
		
		//Saves the game in a property file (since it is easy)
		try {
			FileWriter fstream = new FileWriter("rosters/" + Program.warband.name + ".xml");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("<warband>\n" + packWarbandGeneral() + packWarbandHeroes() + packWarbandHenchmen() + "</warband>");
			out.close();
		} 
		catch (Exception e) {System.out.println("Couldn't Save");e.printStackTrace();}
	}
	private String packWarbandGeneral() {
		return 
		"	<general>\n"+
		"		<name>"+Program.warband.name+"</name>\n"+
		"		<type>"+Program.warband.type+"</type>\n"+
		"		<gold>"+Program.warband.goldcrowns+"</gold>\n"+
		"		<wardstones>"+Program.warband.wardstones+"</wardstones>\n"+
		"		<battles>"+Program.warband.battles+"</battles>\n"+
		"		<upkeep>"+Program.warband.upkeep+"</upkeep>\n"+
		"		<members>"+Program.warband.members+"</members>\n"+
		"		<rating>"+Program.warband.rating+"</rating>\n"+
		"	</general>\n";
	}
	private String packWarbandHeroes() {
		String txt = "	<heroes>\n";
		for (Heroes hero : Program.warband.heroes) {
			if (hero == null) continue;
			txt +=
			"		<hero>\n"+
			"			<name>"+hero.name+"</name>\n"+
			"			<type>"+hero.type+"</type>\n"+
			"			<stats>"+hero.getStats()+"</stats>\n"+
			"			<skills>"+hero.skills+"</skills>\n"+
			"			<equipment>"+hero.equipment+"</equipment>\n"+
			"		</hero>\n";
		}
		return txt + "	</heroes>\n";
	}
	private String packWarbandHenchmen() {
		String txt = "	<henchmen>\n";
		for (Henchmen group : Program.warband.henchmen) {
			if (group == null) continue;
			txt +=
			"		<group>\n"+
			"			<name>"+group.name+"</name>\n"+
			"			<type>"+group.type+"</type>\n"+
			"			<stats>"+group.getStats()+"</stats>\n"+
			"			<skills>"+group.skills+"</skills>\n"+
			"			<equipment>"+group.equipment+"</equipment>\n"+
			"			<members>"+group.members+"</members>\n"+
			"		</group>\n";
		}
		return txt + "	</henchmen>\n";
	}
}
