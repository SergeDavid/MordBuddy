package code.gui.popups;

import javax.swing.JFrame;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class PopupBase extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public PopupBase() {
		getContentPane().setBackground(Color.GRAY);
		
		JLabel lblCloseCombatRanged = new JLabel("Close Combat, Ranged (and black powder), Armour, Misc, Skills, Magic, Injuries");
		getContentPane().add(lblCloseCombatRanged, BorderLayout.CENTER);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Closes both Q_Q
		requestFocusInWindow();
		requestFocus();
		setVisible(true);
		
		getContentPane().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
	}

}
