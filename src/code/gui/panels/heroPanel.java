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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import code.Heroes;
import code.Program;
import code.gui.items.HeroExpItem;
import code.gui.items.NameAndType;
import code.gui.popups.EquipmentPopup;
import code.gui.popups.HeroInjuryChart;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeroPanel extends JPanel {
	private static final long serialVersionUID = 2358897848081414642L;
	
	//Special stuff
	public boolean removed = false;
	private Heroes hero;
	public JTextArea txtEquipment;
	public JTextArea txtSkills;
	private JLabel status;//Alive / Dead
	public JTable hero1_stats;//Stats
	
	//static
	private JLabel lblEquipment;//equipment
	private JLabel lblSkillsAnd;//skills
	private JButton btnNewButton;//advancement
	private JButton btnKill;//+1 exp
	private JButton btnKnockedOut;//injury
	private JButton btnRemove;//remove
	private HeroExpItem lblExpbar;
	public NameAndType basic;
	
	public void updateWarband() {
		hero.name = basic.modelName.getText();
		hero.equipment = txtEquipment.getText();
		hero.skills = txtSkills.getText();
		hero.movement = getStat(0);
		hero.weaponSkill = getStat(1);
		hero.balisticSkill = getStat(2);
		hero.strength = getStat(3);
		hero.toughness = getStat(4);
		hero.wounds = getStat(5);
		hero.inititive = getStat(6);
		hero.attacks = getStat(7);
		hero.leadership = getStat(8);
	}
	private int getStat(int i) {
		return (Integer) hero1_stats.getModel().getValueAt(1, i);
	}
	
	public HeroPanel(int id_num) {
		setBackground(Color.LIGHT_GRAY);
		hero = Program.warband.heroes[id_num];
		basic = new NameAndType(hero.name, hero.type);
		lblExpbar = new HeroExpItem(hero.exp, hero.exp2);
		
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
		btnKill = new JButton("Image");
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
				basic.modelName.setText("I snuggle puppies");
				//Advancement
			}
		});
		lblExpbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (hero.exp2 < hero.maxExp) {
					lblExpbar.colorize(hero.exp, ++hero.exp2);
				}
			}
		});
		btnKnockedOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HeroInjuryChart(HeroPanel.this);
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				basic.modelName.setText("Removed");
				status.setText("Disbanded");
				//Removes the character (To the dead pile!)
				//Program.warband.heroes[i] = null; //TODO: Shuffle the character into oblivion
				//TODO: Add in a pop up with three options. (Remove (keep equipment), Remove Competely, Cancel)
				//Program.gui.change(Gui.pane.main); //TODO: Remove this tab and add in a needed all the crap.
			}
		});
		txtEquipment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				new EquipmentPopup(txtEquipment);
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
								.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
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
						.addGroup(gl_hero1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_hero1.createSequentialGroup()
								.addComponent(status)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblExpbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_hero1.createSequentialGroup()
								.addComponent(basic, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(hero1_stats, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnRemove))))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_hero1.setVerticalGroup(
			gl_hero1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hero1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addComponent(basic, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(hero1_stats, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblExpbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(status))
					.addGap(9)
					.addGroup(gl_hero1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKill, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKnockedOut, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_hero1.createSequentialGroup()
							.addComponent(lblEquipment)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEquipment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblSkillsAnd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSkills, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		this.setLayout(gl_hero1);
	}
}
