package code.gui.panels;

import javax.swing.JPanel;
import code.gui.items.OtherExpItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**A simple checklist of things to check off as you play to help you remember such as Did you use your armour save? [Check]*/
public class CheckPanel extends JPanel {
	OtherExpItem h;
	int newExp = 10;
	public CheckPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				h.colorize(10,++newExp);
			}
		});
		
		h = new OtherExpItem(10,10);
		add(h);
		
	}
	private static final long serialVersionUID = -2561079656879346541L;

}
