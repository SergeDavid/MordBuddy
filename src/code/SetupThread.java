package code;

import code.xml.LoadUniversal;

public class SetupThread extends Thread {
	public SetupThread() {
		super("unpacks universal lists.");
	    start();
	}
	@Override
	public void run() {
		new LoadUniversal();
		Program.xmlReady = true;
		System.out.println("Setup thread is done.");
	}

}
