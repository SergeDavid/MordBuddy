package code;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import code.etc.Injury;
import code.etc.Magic;
import code.etc.Skill;
import code.gui.Gui;

public class Program extends JFrame {
	private static final long serialVersionUID = 2157888685830593633L;
	private static final String name = "Mordheim Buddy";
	private static final String version = "0.02";
	
	//functions
	public static Gui gui;
	public static XmlHandler xml;
	/**Set to true when the SetupThread is finished.*/
	public static boolean xmlReady = false;
	//SetupThread is just implimented once on start up.
	
	//Master Lists
	public static ArrayList<Warband> bands = new ArrayList<Warband>();
	public static ArrayList<Skill> skills = new ArrayList<Skill>();
	public static ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	public static ArrayList<Magic> magic = new ArrayList<Magic>();
	public static ArrayList<Injury> injuries = new ArrayList<Injury>();
	
	//working list
	public static Warband warband;

	public Program() {
		super(name + "   v" + version);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(new Dimension(620,410));
	    setUndecorated(false);
		setResizable(true);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	    //load needed elements
	    xml = new XmlHandler();
	    new SetupThread();
	    gui = new Gui();
	    getContentPane().add(gui);
	}
	
	public static void main(String[] args) {
		new Program();
	}

	/**loads an empty warband and changes the gui*/
	public static void newWarband() {
		warband = new Warband();
		//TODO: set default warband reference
		//TODO: modify the warband bases on special modifiers from the default (base gold, type, etc)
		gui.change(Gui.pane.main);
	}
	public static void loadWarband() {
		xml.loadWarband("my_reikan");
	}

	public static String[] warbandNames() {
		String[] a = new String[bands.size()];
		for (int i = 0; i < bands.size() ; i++) {
			a[i] = bands.get(i).name;
		}
		return a;
	}
}
