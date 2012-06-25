package code;

import code.xml.unpackWarbands;

public class SetupThread extends Thread {
	public SetupThread() {
		super("unpacks required xml files.");
	    start();
	}
	@Override
	public void run() {
		Program.xml.unpackUniversal();//create the master lists
		new unpackWarbands();//Grab the list of warband names "files/warband_[name].xml"
		Program.xmlReady = true;
		System.out.println("Setup thread is done.");
	}

}
