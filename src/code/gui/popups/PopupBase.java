package code.gui.popups;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

/**Parent class for all of the popup menues. Handles all the basic setup and closing.*/
public class PopupBase extends JFrame {
	private static final long serialVersionUID = 1L;
	public PopupBase() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {}
			public void windowLostFocus(WindowEvent arg0) {dispose();}
		});
		getContentPane().setBackground(Color.GRAY);
		setVisible(true);
		requestFocus();
	}
}
