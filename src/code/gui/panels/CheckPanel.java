package code.gui.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

/**A simple checklist of things to check off as you play to help you remember such as Did you use your armour save? [Check]*/
public class CheckPanel extends JPanel {
	JButton button;
	public CheckPanel() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel YourTurn = new JLabel("Your Turn");
		add(YourTurn);
		
		button = new JButton(" ");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (button.getBackground() == Color.GREEN) button.setBackground(null);
				else button.setBackground(Color.GREEN);
			}
		});
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		add(button);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JButton button_1 = new JButton(" ");
		add(button_1);
		
		JLabel label_3 = new JLabel("");
		add(label_3);
		
		JButton button_2 = new JButton(" ");
		add(button_2);
		
		JLabel label_4 = new JLabel("");
		add(label_4);
		
		JButton button_3 = new JButton(" ");
		add(button_3);
		
	}
	private static final long serialVersionUID = -2561079656879346541L;

}
