package code.gui;

import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Gui extends JPanel {
	private static final long serialVersionUID = -1870754393643021461L;
	public enum pane {start,create,load,main};
	
	public Gui() {
		this.setLayout(new GridLayout(1, 1));
		change(pane.start);
	}
	
	public void change(pane s) {
		if (s == pane.start) {set(new startPage());}
		else if (s == pane.create) {set(new createPage());}
		else if (s == pane.load) {set(new loadPage());}
		else if (s == pane.main) {set(new mainPage());}
		else {set(new mainPage());}
		validate();
	}
	
	private void set(JComponent jp) {
		removeAll();
		add(jp);
	}

}
