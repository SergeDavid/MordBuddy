package code.gui.items;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class HeroExpItem extends JPanel {
	JPanel[] checkBox = new JPanel[90];
	private int[] heroExp = new int[]{2,4,6,8,11,14,17,20,24,28,32,36,41,46,51,57,63,69,76,83,90};
	private static final long serialVersionUID = 1L;

	public HeroExpItem(int oldExp, int newExp) {
		setPreferredSize(new Dimension(384,48));
		setBackground(Color.DARK_GRAY);
		
		setLayout(new GridLayout(3, 90, 2, 2));
		
		for (int i = 0; i < 90; i++) {
			checkBox[i] = new JPanel();
			add(checkBox[i]);
		}
		colorize(oldExp,newExp);
	}
	public void colorize(int oldExp, int newExp) {
		for (int i = 0; i < 90; i++) {
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
