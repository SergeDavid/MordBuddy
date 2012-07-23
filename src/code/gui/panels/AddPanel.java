package code.gui.panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import code.Program;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPanel extends JPanel {

		String group;
		JLabel lblSelectWhatKind;
		JComboBox comboBox;
		JLabel lblGoldCrowns;
		JTabbedPane main;
		
	public AddPanel(String type, String[] s) {
		lblSelectWhatKind = new JLabel("Select what kind you want");
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(s));
		group = type;
		lblGoldCrowns = new JLabel("Gold Crowns : " + Program.warband.goldcrowns);
		
		JButton btnHire = new JButton("Hire");
		btnHire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (group == "heroes") {Program.addHero(comboBox.getSelectedIndex(), true);}
				else if (group == "henchmen") {Program.addHenchmen(comboBox.getSelectedIndex(), true);}
				else {Program.addHenchmen(comboBox.getSelectedIndex(), true);}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectWhatKind)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(68)
									.addComponent(lblGoldCrowns))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(btnHire)))
					.addContainerGap(307, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectWhatKind)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoldCrowns))
					.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
					.addComponent(btnHire)
					.addGap(141))
		);
		setLayout(groupLayout);
	}
	private static final long serialVersionUID = -5725685136460953179L;
}
