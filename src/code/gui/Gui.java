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
		if (s == pane.start) {set(new TitlePage());}
		else if (s == pane.create) {set(new CreatePage());}
		else if (s == pane.load) {set(new LoadPage());}
		else if (s == pane.main) {set(new MainPage());}
		//else if (s == pane.update) {set(new mainPage());}
		else {set(new MainPage());}
	}
	
	private void set(JComponent jp) {
		removeAll();
		add(jp);
		validate();
	}

	public void depth(int i, int j) {
		set(new MainPage(i,j));
	}

}
