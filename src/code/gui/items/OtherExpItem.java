package code.gui.items;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class OtherExpItem extends JPanel {
	JPanel[] checkBox = new JPanel[14];
	private int[] heroExp = new int[]{2,5,9,14};
	private static final long serialVersionUID = 1L;

	public OtherExpItem(int oldExp, int newExp) {
		setPreferredSize(new Dimension(182,18));//2*14=28+14*11=182
		setBackground(Color.DARK_GRAY);
		
		setLayout(new GridLayout(1, 14, 2, 2));
		
		for (int i = 0; i < 14; i++) {
			checkBox[i] = new JPanel();
			//checkBox[i].setMinimumSize(new Dimension(11,11));
			add(checkBox[i]);
		}
		colorize(oldExp,newExp);
	}
	public void colorize(int oldExp, int newExp) {
		for (int i = 0; i < 14; i++) {
			if (inArray(i+1, heroExp)) {
				if (i <= oldExp-1) checkBox[i].setBackground(Color.ORANGE);
				else if (i <= newExp-1) checkBox[i].setBackground(Color.GREEN);
				else checkBox[i].setBackground(Color.LIGHT_GRAY);
			}
			else if (i <= oldExp-1) checkBox[i].setBackground(Color.RED);
			else if (i <= newExp-1) checkBox[i].setBackground(new Color(0,150,0));
		}
	}
	private boolean inArray(int n, int[] h) {
		for (int a = 0; a < h.length; a++) if (h[a] == n) return true;
		return false;
	}
}
