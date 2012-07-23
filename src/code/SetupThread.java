package code;

public class SetupThread extends Thread {
	public SetupThread() {
		super("unpacks required xml files.");
	    start();
	}
	@Override
	public void run() {
		Program.xml.unpackUniversal();//create the master lists
		//TODO: Going to change this probably to something like 
		//unpackSpecies();//Max stats mostly
		//unpackEquipment();//All close combat, ranged, and misc equipment
		//unpackSkills();//All of the available skills
		//unpackInjuries();//All possible injury results
		//unpackMagic();//All magic across all of the different warbands
		Program.xmlReady = true;
		System.out.println("Setup thread is done.");
	}

}
