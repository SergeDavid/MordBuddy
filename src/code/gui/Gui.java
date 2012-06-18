package code.gui;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Gui extends JPanel {
	private static final long serialVersionUID = -1870754393643021461L;
	public enum pane {start,create,load,main};
	
	public Gui() {
		this.setLayout(new GridLayout(1, 1));
	}
	
	public void change(pane s) {
		if (s == pane.create) {}
		else if (s == pane.load) {}
		else if (s == pane.main) {add(new mainPage());}
		else {add(new mainPage());}
		validate();
	}
	
	@SuppressWarnings("unused")
	private void set(JComponent jp) {
		this.removeAll();
		this.add(jp);
	}

}
