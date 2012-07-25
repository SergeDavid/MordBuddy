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

import code.Henchmen;
import code.Heroes;
import code.Program;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPanel extends JPanel {

		String group;
		JLabel lblSelectWhatKind;
		JComboBox comboBox;
		JLabel lblGoldCrowns;
		JTabbedPane main;
		JTextArea txtrCostsGold;
		
	public AddPanel(String type, String[] s) {
		lblSelectWhatKind = new JLabel("Select a group to recruit to your warband.");
		lblSelectWhatKind.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ChangeTextArea(comboBox.getSelectedIndex());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(s));
		group = type;
		lblGoldCrowns = new JLabel("Gold Crowns : " + Program.warband.goldcrowns);
		
		JButton btnHire = new JButton("Recruit (Costs)");
		btnHire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (group == "heroes") {Program.addHero(comboBox.getSelectedIndex(), true);}
				else if (group == "henchmen") {Program.addHenchmen(comboBox.getSelectedIndex(), true);}
				else {Program.addHenchmen(comboBox.getSelectedIndex(), true);}
			}
		});
		
		JButton btnFree = new JButton("Recruit (Free)");
		btnFree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (group == "heroes") {Program.addHero(comboBox.getSelectedIndex(), false);}
				else if (group == "henchmen") {Program.addHenchmen(comboBox.getSelectedIndex(), false);}
				else {Program.addHenchmen(comboBox.getSelectedIndex(), false);}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		
		JLabel lblWarbandsTreasury = new JLabel("Warband's Treasury");
		
		JSeparator separator_1 = new JSeparator();
		
		txtrCostsGold = new JTextArea();
		ChangeTextArea(0);
		txtrCostsGold.setRows(8);
		txtrCostsGold.setColumns(64);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectWhatKind)
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWarbandsTreasury)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblGoldCrowns)))
					.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnHire)
					.addGap(18)
					.addComponent(btnFree)
					.addContainerGap(350, Short.MAX_VALUE))
				.addComponent(separator_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(544, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrCostsGold)
					.addGap(56))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelectWhatKind)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWarbandsTreasury)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGoldCrowns)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrCostsGold, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHire, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFree, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	protected void ChangeTextArea(int i) {
		String r;
		if (group == "heroes") {
			Heroes h = Program.baseWarband.heroes[i];
			r = "Cost: " + h.cost+ "\r\n";
			r += "Skills: Combat, Shooting, Academic, Strength, Speed, Special\r\n";//TODO
			r += "Stats: M-"+h.movement+", WS-"+h.weaponSkill+", BS-"+h.balisticSkill+", S-"+h.strength+", T-"+h.toughness+", W-"+h.wounds+", I-"+h.inititive+", A-"+h.attacks+", Ld-"+h.leadership+"\r\n";
			r += "Rules: " + h.skills+ "\r\n";
		}
		else {
			Henchmen h = Program.baseWarband.henchmen[i];
			r = "Cost: " + h.cost+ "\r\n";
			r += "Stats: M-"+h.movement+", WS-"+h.weaponSkill+", BS-"+h.balisticSkill+", S-"+h.strength+", T-"+h.toughness+", W-"+h.wounds+", I-"+h.inititive+", A-"+h.attacks+", Ld-"+h.leadership+"\r\n";
			r += "Rules: " + h.skills+ "\r\n";
		}
		txtrCostsGold.setText(r);
		
	}
	private static final long serialVersionUID = -5725685136460953179L;
}
