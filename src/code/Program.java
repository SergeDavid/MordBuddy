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
	public static Gui gui;
	public XmlHandler xml;

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
	    gui = new Gui();
	    getContentPane().add(gui);
	    
	    //cheating, this should only be called when you load a warband roster you saved
	    xml.unpackWarband("my_reikan");
	}

	public static Warband warband;
	public static ArrayList<Skill> skills = new ArrayList<Skill>();
	public static ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	public static ArrayList<Magic> magic = new ArrayList<Magic>();
	public static ArrayList<Injury> injuries = new ArrayList<Injury>();
	
	public static void main(String[] args) {
		new Program();
	}
}
