package code;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import code.gui.Gui;

public class Program extends JFrame {
	private static final long serialVersionUID = 2157888685830593633L;
	public static final String name = "Mordheim Buddy";
	public static final String version = "0.04";
	
	//functions
	public static Gui gui;
	public static XmlHandler xml;
	public static boolean xmlReady = false;
	//SetupThread is just implimented once on start up.
	
	//Master Lists
	public static ArrayList<Modifiers> skills = new ArrayList<Modifiers>();
	public static ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	public static ArrayList<Modifiers> magic = new ArrayList<Modifiers>();
	public static ArrayList<Modifiers> injuries = new ArrayList<Modifiers>();
	
	//working list
	public static Warband warband;
	public static Warband baseWarband;//This is what the current warband is ran off of.

	public Program() {
		super(name + "   v" + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(new Dimension(620,410));
	    setUndecorated(false);
		setResizable(true);
	    setLocationRelativeTo(null);
	    
	    //load needed elements
	    xml = new XmlHandler();
	    new SetupThread();
	    gui = new Gui();
	    getContentPane().add(gui);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		new Program();
	}

	public static void newWarband(String s) {
		new code.xml.CreateWarband(s);
		setupNewWarband();
		gui.change(Gui.pane.main);
	}
	public static void loadWarband(String s) {
		new code.xml.LoadWarband(s);
	}

	public static String[] addHeroList() {
		String[] s = new String[baseWarband.totalHeroes];
		for (int i = 0; i < baseWarband.totalHeroes; i++) {
			s[i] = baseWarband.heroes[i].name + " : " + baseWarband.heroes[i].cost + " GC's   (" + baseWarband.heroes[i].min + " min / " + baseWarband.heroes[i].max + " max)";
		}
		return s;
	}
	public static String[] addHenchmenList() {
		String[] s = new String[baseWarband.totalGroups];
		for (int i = 0; i < baseWarband.totalGroups; i++) {
			s[i] = baseWarband.henchmen[i].name + " : " + baseWarband.henchmen[i].cost + " GC's   (" + baseWarband.henchmen[i].min + " min / " + baseWarband.henchmen[i].max + " max)";
		}
		return s;
	}

	public static void addHero(int i, boolean buy) {
		warband.heroes[warband.totalHeroes] = baseWarband.heroes[i].copy();
		if (buy) {warband.goldcrowns-=baseWarband.heroes[i].cost;}
		warband.totalHeroes++;
		warband.members++;
		updateRating();
		gui.depth(1,warband.totalHeroes-1);
	}

	public static void addHenchmen(int i, boolean buy) {
		warband.henchmen[warband.totalGroups] = baseWarband.henchmen[i].copy();
		if (buy) {warband.goldcrowns-=baseWarband.henchmen[i].cost;}
		warband.totalGroups++;
		warband.members++;
		updateRating();
		gui.depth(2,warband.totalGroups-1);
	}
	
	private static void updateRating() {
		int n = 0;
		final int p = 5;
		for (int i = 0; i < 6; i++) {
			if (warband.heroes[i] != null) {n += p + warband.heroes[i].exp;}
			if (warband.henchmen[i] != null) {n += p + warband.henchmen[i].exp;}
		}
		warband.rating = n;
	}

	/**Takes the important settings from the base warband information and ports it over to the new warband.*/
	public static void setupNewWarband() {
		warband = new Warband();
		warband.goldcrowns = baseWarband.goldcrowns;
		warband.name = baseWarband.name;
		warband.type = baseWarband.name;
		warband.inventory = baseWarband.rules;
	}
}
