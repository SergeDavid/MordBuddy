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
import code.gui.items.NameAndType;
import code.gui.items.OtherExpItem;
import code.gui.popups.EquipmentPopup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HenchPanel extends JPanel {
	private static final long serialVersionUID = 4127661315485367563L;
	public JTable statsTable;
	private JLabel hero1_status;
	private JLabel lblEquipment;
	private JTextArea equipArea;
	private JLabel lblSkillsAnd;
	private JTextArea skillArea;
	private JLabel lblNewLabel;
	private JTextField textField;
	
	private OtherExpItem expbar;
	public NameAndType basic;
	private Henchmen hench;
	
	public void updateWarband() {
		hench.name = basic.modelName.getText();
		hench.equipment = equipArea.getText();
		hench.skills = skillArea.getText();
		hench.movement = getStat(0);
		hench.weaponSkill = getStat(1);
		hench.balisticSkill = getStat(2);
		hench.strength = getStat(3);
		hench.toughness = getStat(4);
		hench.wounds = getStat(5);
		hench.inititive = getStat(6);
		hench.attacks = getStat(7);
		hench.leadership = getStat(8);
	}
	private int getStat(int i) {
		return (Integer) statsTable.getModel().getValueAt(1, i);
	}
	
	public HenchPanel(int id_num) {
		setBackground(Color.LIGHT_GRAY);
		hench = Program.warband.henchmen[id_num];
		//name
		basic = new NameAndType(hench.name, hench.type);
		
		//Type
		expbar = new OtherExpItem(hench.exp, hench.exp2);
		expbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (hench.exp2 < hench.maxExp) {
					expbar.colorize(hench.exp, ++hench.exp2);
				}
			}
		});
		
		//Stats
		statsTable = new JTable();
		statsTable.setRowSelectionAllowed(false);
		statsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"M", "WS", "BS", "S", "T", "W", "I", "A", "Ld", "Exp"},
				{hench.movement, hench.weaponSkill, hench.balisticSkill, hench.strength, hench.toughness, hench.wounds, hench.inititive, hench.attacks, hench.leadership, hench.exp},
			},
			new String[] {
				"movement", "weaponSkill", "ballisticSkill", "strength", "toughness", "wounds", "inititive", "attacks", "leadership", "experience"
			}
		));
		for (int i = 0; i < 9; i++) {
			statsTable.getColumnModel().getColumn(i).setPreferredWidth(38);
		}
		
		//Buttons
		JButton btnNewButton = new JButton("Advancement");
		btnNewButton.setToolTipText("Roll on the Advancement Table");
		btnNewButton.setBackground(Color.GREEN);
		JButton btnKill = new JButton("Add Guy");
		JButton btnKnockedOut = new JButton("Injury Chart");
		btnKnockedOut.setBackground(Color.ORANGE);
		btnKnockedOut.setToolTipText("Roll on the Injury Table");
		JButton btnRemove = new JButton("Remove");
		btnRemove.setToolTipText("Adds the chararacter to the dead list.");
		btnRemove.setBackground(Color.RED);
		
		//Status
		hero1_status = new JLabel("Alive and Fit");
		hero1_status.setToolTipText("This is used to display important info like the character is alive / dead");
		
		//Equipment
		lblEquipment = new JLabel("Equipment");
		equipArea = new JTextArea();
		equipArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				new EquipmentPopup(equipArea);
			}
		});
		equipArea.setRows(4);
		equipArea.setText(hench.equipment);
		
		//Skills
		lblSkillsAnd = new JLabel("Skills, Injuries, Etc");
		skillArea = new JTextArea();
		skillArea.setRows(3);
		skillArea.setText(hench.skills);
		
		//blablabla
		lblNewLabel = new JLabel("Members : ");
		textField = new JTextField();
		textField.setText(""+hench.members);
		textField.setColumns(10);
		
		//Layout
		GroupLayout gl_hero1 = new GroupLayout(this);
		gl_hero1.setHorizontalGroup(
			gl_hero1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hero1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnKill, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(10)
									.addComponent(skillArea, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSkillsAnd)
								.addComponent(lblEquipment)
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_hero1.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnRemove)
										.addComponent(equipArea, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addComponent(basic, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addComponent(expbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(statsTable, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(hero1_status)))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_hero1.setVerticalGroup(
			gl_hero1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hero1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hero1.createParallelGroup(Alignment.BASELINE)
						.addComponent(basic, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(hero1_status)
						.addComponent(statsTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_hero1.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(expbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKill, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(124))
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(lblEquipment)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(equipArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSkillsAnd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(skillArea, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		this.setLayout(gl_hero1);
	}
}
