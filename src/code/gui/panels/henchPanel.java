package code.gui.panels;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import code.Henchmen;
import code.Program;

public class HenchPanel extends JPanel {
	private static final long serialVersionUID = 4127661315485367563L;
	public JTextField hero1_name;
	public JTextField type;
	public JTable hero1_stats;
	private JLabel hero1_status;
	private JLabel lblEquipment;
	private JTextArea txtrAxeHelmetSword;
	private JLabel lblSkillsAnd;
	private JTextArea txtrTrickShotStep;
	private JLabel lblNextLevel;
	private JLabel lblLevelsGained;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnAddGuy;
	
	public HenchPanel(int id_num) {
		Henchmen hench = Program.warband.henchmen[id_num];
		//name
		JLabel hero1_label1 = new JLabel("Name");
		hero1_name = new JTextField();
		hero1_name.setText(hench.name);
		hero1_name.setColumns(10);
		
		//Type
		JLabel hero1_label2 = new JLabel("Type");
		type = new JTextField();
		type.setText(hench.type);
		type.setColumns(10);
		
		//Stats
		hero1_stats = new JTable();
		hero1_stats.setRowSelectionAllowed(false);
		hero1_stats.setModel(new DefaultTableModel(
			new Object[][] {
				{"M", "WS", "BS", "S", "T", "W", "I", "A", "Ld", "Exp"},
				{hench.movement, hench.weaponSkill, hench.balisticSkill, hench.strength, hench.toughness, hench.wounds, hench.inititive, hench.attacks, hench.leadership, hench.experience},
			},
			new String[] {
				"movement", "weaponSkill", "ballisticSkill", "strength", "toughness", "wounds", "inititive", "attacks", "leadership", "experience"
			}
		));
		for (int i = 0; i < 9; i++) {
			hero1_stats.getColumnModel().getColumn(i).setPreferredWidth(38);
		}
		
		//Buttons
		JButton btnNewButton = new JButton("Advancement");
		btnNewButton.setToolTipText("Roll on the Advancement Table");
		btnNewButton.setBackground(Color.GREEN);
		JButton btnKill = new JButton("+1 Exp");
		JButton btnKnockedOut = new JButton("Injury Chart");
		btnKnockedOut.setBackground(Color.ORANGE);
		btnKnockedOut.setToolTipText("Roll on the Injury Table");
		JButton btnRemove = new JButton("Remove");
		btnRemove.setToolTipText("Adds the chararacter to the dead list.");
		btnRemove.setBackground(Color.RED);
		
		//Status
		hero1_status = new JLabel("Alive and Fit");
		hero1_status.setToolTipText("This is used to display important info like the character is alive / dead");
		lblNextLevel = new JLabel("Next Level : 2");
		lblLevelsGained = new JLabel("Levels Gained : 0");
		
		//Equipment
		lblEquipment = new JLabel("Equipment");
		txtrAxeHelmetSword = new JTextArea();
		txtrAxeHelmetSword.setRows(4);
		txtrAxeHelmetSword.setText(hench.equipment);
		
		//Skills
		lblSkillsAnd = new JLabel("Skills, Injuries, Etc");
		txtrTrickShotStep = new JTextArea();
		txtrTrickShotStep.setRows(3);
		txtrTrickShotStep.setText(hench.skills);
		
		//blablabla
		lblNewLabel = new JLabel("Number : ");
		textField = new JTextField();
		textField.setText(""+hench.members);
		textField.setColumns(10);
		btnAddGuy = new JButton("Add Guy");
		
		//Layout
		GroupLayout gl_hero1 = new GroupLayout(this);
		gl_hero1.setHorizontalGroup(
			gl_hero1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hero1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(hero1_label1)
									.addGap(10)
									.addComponent(hero1_name, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(hero1_label2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(type, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(hero1_stats, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLevelsGained)
										.addComponent(lblNextLevel))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(hero1_status)
									.addGap(66)
									.addComponent(btnRemove))
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnKill, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(10)
									.addComponent(txtrTrickShotStep, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSkillsAnd)
								.addComponent(lblEquipment)
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(14)
									.addComponent(txtrAxeHelmetSword, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnAddGuy, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_hero1.setVerticalGroup(
			gl_hero1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hero1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.BASELINE)
								.addComponent(hero1_label1)
								.addComponent(hero1_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(hero1_label2)
								.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(hero1_status))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_hero1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(hero1_stats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(lblLevelsGained)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_hero1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNextLevel)
										.addComponent(lblNewLabel)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKill, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddGuy, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(90))
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(lblEquipment)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtrAxeHelmetSword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSkillsAnd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtrTrickShotStep, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		this.setLayout(gl_hero1);
	}
}
