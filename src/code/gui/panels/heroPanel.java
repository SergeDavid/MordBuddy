package code.gui.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import code.Heroes;
import code.Program;
import code.gui.items.HeroExpItem;

public class HeroPanel extends JPanel {
	private static final long serialVersionUID = 2358897848081414642L;
	
	//Special stuff
	public boolean removed = false;
	private Heroes hero;
	
	//Modifiable
	public JTextField name;
	private JTextArea txtEquipment;
	private JTextArea txtSkills;
	
	//non-editable
	public JTextField type;
	private JLabel status;//Alive / Dead
	public JTable hero1_stats;//Stats
	
	//static
	private JLabel lblEquipment;//equipment
	private JLabel lblSkillsAnd;//skills
	public JButton btnNewButton;//advancement
	private JButton btnKill;//+1 exp
	private JButton btnKnockedOut;//injury
	private JButton btnRemove;//remove
	private JLabel label1;//name
	private JLabel label2;//type
	private HeroExpItem lblExpbar;
	
	public void updateWarband(int i) {
		System.out.println(name.getText() + " has been saved, i hope.");
		Program.warband.heroes[i].name = name.getText();
		Program.warband.heroes[i].equipment = txtEquipment.getText();
		Program.warband.heroes[i].skills = txtSkills.getText();
		Program.warband.heroes[i].movement = getStat(0);
		Program.warband.heroes[i].weaponSkill = getStat(1);
		Program.warband.heroes[i].balisticSkill = getStat(2);
		Program.warband.heroes[i].strength = getStat(3);
		Program.warband.heroes[i].toughness = getStat(4);
		Program.warband.heroes[i].wounds = getStat(5);
		Program.warband.heroes[i].inititive = getStat(6);
		Program.warband.heroes[i].attacks = getStat(7);
		Program.warband.heroes[i].leadership = getStat(8);
	}
	private int getStat(int i) {
		return (Integer) hero1_stats.getModel().getValueAt(1, i);
	}
	
	public HeroPanel(int id_num) {
		setBackground(Color.LIGHT_GRAY);
		hero = Program.warband.heroes[id_num];
		//name
		label1 = new JLabel("Name");
		name = new JTextField();
		name.setText(hero.name);
		name.setColumns(10);
		lblExpbar = new HeroExpItem(hero.exp, hero.exp2);
		
		//Type
		label2 = new JLabel("Type");
		type = new JTextField();
		type.setText(hero.type);
		type.setColumns(10);
		
		//Stats
		hero1_stats = new JTable();
		hero1_stats.setRowSelectionAllowed(false);
		hero1_stats.setModel(new DefaultTableModel(
			new Object[][] {
				{"M", "WS", "BS", "S", "T", "W", "I", "A", "Ld"},
				{hero.movement, 
				 hero.weaponSkill,
				 hero.balisticSkill,
				 hero.strength,
				 hero.toughness,
				 hero.wounds,
				 hero.inititive,
				 hero.attacks,
				 hero.leadership},
			},
			new String[] {
				"movement", "weaponSkill", "ballisticSkill", "strength", "toughness", "wounds", "inititive", "attacks", "leadership"
			}
		));
		for (int i = 0; i < 9; i++) {
			hero1_stats.getColumnModel().getColumn(i).setPreferredWidth(38);
		}
		
		//Buttons
		btnNewButton = new JButton("Advancement");
		btnNewButton.setToolTipText("Roll on the Advancement Table");
		btnNewButton.setBackground(Color.GREEN);
		btnKill = new JButton("+1 Exp");
		btnKnockedOut = new JButton("Injury Chart");
		btnKnockedOut.setToolTipText("Roll on the Injury Table");
		btnKnockedOut.setBackground(Color.ORANGE);
		btnRemove = new JButton("Remove");
		btnRemove.setToolTipText("Adds the chararacter to the dead list.");
		btnRemove.setBackground(Color.RED);
		
		//Status
		status = new JLabel("Alive and Fit");
		status.setToolTipText("This is used to display important info like the character is alive / dead");
		
		//Equipment
		lblEquipment = new JLabel("Equipment");
		txtEquipment = new JTextArea();
		txtEquipment.setRows(4);
		txtEquipment.setText(hero.equipment);
		
		//Skills
		lblSkillsAnd = new JLabel("Skills, Injuries, Etc");
		txtSkills = new JTextArea();
		txtSkills.setRows(3);
		txtSkills.setText(hero.skills);
		setListeners();
		setLayout();
	}
	private void setListeners() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("I snuggle puppies");
				//Advancement
			}
		});
		btnKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (hero.exp2 < hero.maxExp) {
					lblExpbar.colorize(hero.exp, ++hero.exp2);
				}
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("Removed");
				status.setText("Disbanded");
				//Removes the character (To the dead pile!)
				//Program.warband.heroes[i] = null; //TODO: Shuffle the character into oblivion
				//TODO: Add in a pop up with three options. (Remove (keep equipment), Remove Competely, Cancel)
				//Program.gui.change(Gui.pane.main); //TODO: Remove this tab and add in a needed all the crap.
			}
		});
	}
	private void setLayout() {
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
								.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(10)
									.addComponent(txtSkills, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSkillsAnd)
								.addComponent(lblEquipment)
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(14)
									.addComponent(txtEquipment, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(label1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(hero1_stats, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_hero1.createSequentialGroup()
									.addComponent(label2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(type, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_hero1.createSequentialGroup()
									.addGap(10)
									.addComponent(status)))
							.addGap(18)
							.addComponent(lblExpbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_hero1.setVerticalGroup(
			gl_hero1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hero1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hero1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label1)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(19))
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(hero1_stats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addGroup(gl_hero1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label2)
								.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(status))
						.addComponent(lblExpbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKill, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(lblEquipment)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEquipment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSkillsAnd)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtSkills, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		this.setLayout(gl_hero1);
	}
}
