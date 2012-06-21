package code;

public class SetupThread extends Thread {
	public SetupThread() {
		super("unpacks required xml files.");
	    start();
	}
	@Override
	public void run() {
		System.out.println("Giggity");
		Program.xml.unpackUniversal();//create the master lists
		Program.xml.unpackAllWarbands();//Grab the list of warband names "files/warband_[name].xml"
		Program.xmlReady = true;
		System.out.println("Setup thread is done.");
	}

}
