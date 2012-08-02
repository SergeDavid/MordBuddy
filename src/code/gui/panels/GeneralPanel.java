package code.gui.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import code.Program;
import code.gui.Gui;
import code.gui.MainPage;
import code.gui.popups.EquipmentPopup;
import code.xml.SaveWarband;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GeneralPanel extends JPanel {
	private static final long serialVersionUID = -7099283888689089508L;
	private JLabel lblWarbandType;
	private JLabel lblWardStones;
	private JLabel lblUpkeepCosts;
	private JLabel lblWarbandName;
	private JLabel lblRating;
	private JLabel lblStoredEquipment;
	private JLabel lblGoldCrowns;
	private JLabel lblNewLabel;
	private JLabel lblOtherStat;
	private JButton btnSave;
	private JButton btnQuit;
	private JButton btnExploration;
	private JButton btnAddEquipment;
	private JButton btnNewBattle;
	private JTextField name;
	private JTextField type;
	private JTextField goldcrowns;
	private JTextField upkeep;
	private JTextField wardstones;
	private JTextField rating;
	private JTextArea textArea;
	private MainPage main;
	
	public void updateWarband() {
		Program.warband.name = name.getText();
		Program.warband.goldcrowns = Integer.parseInt(goldcrowns.getText());
		Program.warband.upkeep = Integer.parseInt(upkeep.getText());
		Program.warband.wardstones = Integer.parseInt(wardstones.getText());
		Program.warband.rating = Integer.parseInt(rating.getText());
		Program.warband.inventory = textArea.getText();
	}
	
	public GeneralPanel(MainPage t) {
		setBackground(Color.LIGHT_GRAY);
		main = t;
		
		//Name
		lblWarbandName = new JLabel("Warband Name : ");
		name = new JTextField();
		name.setText(Program.warband.name);
		name.setColumns(10);
		
		//Type
		lblWarbandType = new JLabel("Warband Type : ");
		type = new JTextField();
		type.setEditable(false);
		type.setText(Program.warband.type);
		type.setColumns(10);
		
		//Money
		lblGoldCrowns = new JLabel("Gold Crowns : ");
		goldcrowns = new JTextField();
		goldcrowns.setText(""+Program.warband.goldcrowns);
		goldcrowns.setColumns(10);
		lblUpkeepCosts = new JLabel("Upkeep : ");
		upkeep = new JTextField();
		upkeep.setText(""+Program.warband.upkeep);
		upkeep.setColumns(10);
		lblWardStones = new JLabel("Ward Stones : ");
		wardstones = new JTextField();
		wardstones.setText(""+Program.warband.wardstones);
		wardstones.setColumns(10);
		
		//Rating, battle, warband size
		lblRating = new JLabel("Rating : ");
		rating = new JTextField();
		rating.setText(""+Program.warband.rating);
		rating.setColumns(10);
		lblNewLabel = new JLabel("Battles : "+Program.warband.battles);
		lblOtherStat = new JLabel("Warband Size : "+Program.warband.members);
		
		//Equipment
		lblStoredEquipment = new JLabel("Stored Equipment");
		textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				new EquipmentPopup(textArea);
			}
		});
		textArea.setRows(9);
		
		//Buttons
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.RED);
		btnExploration = new JButton("Exploration");
		btnAddEquipment = new JButton("Unused");		
		btnNewBattle = new JButton("New Battle");
		
		setListeners();
		layoutSetup();
	}
	private void setListeners() {
		btnNewBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.updateAllTheStuff();
				Program.warband.battles++;
				for (int i = 0; i < 6; i++) {
					if (Program.warband.heroes[i] != null) Program.warband.heroes[i].exp = Program.warband.heroes[i].exp2;
					if (Program.warband.henchmen[i] != null) Program.warband.henchmen[i].exp = Program.warband.henchmen[i].exp2;
				}
				Program.gui.change(Gui.pane.main);
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.updateAllTheStuff();
				new SaveWarband();
			}
		});
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//TODO: Add in a popup instead of directly quitting.
				Program.baseWarband = null;
				Program.warband = null;
				Program.gui.change(Gui.pane.start);
			}
		});
	}
	
	private void layoutSetup() {
		GroupLayout gl_generalpan = new GroupLayout(this);
		gl_generalpan.setHorizontalGroup(
			gl_generalpan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generalpan.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
						.addComponent(lblStoredEquipment)
						.addGroup(gl_generalpan.createSequentialGroup()
							.addComponent(btnExploration)
							.addGap(18)
							.addComponent(btnAddEquipment)
							.addGap(18)
							.addComponent(btnNewBattle, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_generalpan.createSequentialGroup()
							.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_generalpan.createSequentialGroup()
									.addComponent(lblWarbandName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(name, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblWarbandType))
								.addGroup(gl_generalpan.createSequentialGroup()
									.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGoldCrowns)
										.addComponent(lblWardStones))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
										.addComponent(goldcrowns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(wardstones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(16)
									.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_generalpan.createSequentialGroup()
											.addComponent(lblUpkeepCosts)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(upkeep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_generalpan.createSequentialGroup()
											.addComponent(lblRating)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_generalpan.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
										.addComponent(lblOtherStat)
										.addComponent(lblNewLabel)))
								.addGroup(gl_generalpan.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(type, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_generalpan.setVerticalGroup(
			gl_generalpan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generalpan.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_generalpan.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWarbandName)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWarbandType)
						.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_generalpan.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGoldCrowns)
						.addComponent(lblUpkeepCosts)
						.addComponent(upkeep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(goldcrowns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWardStones)
						.addGroup(gl_generalpan.createParallelGroup(Alignment.BASELINE)
							.addComponent(wardstones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRating)
							.addComponent(rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblOtherStat))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStoredEquipment)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_generalpan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_generalpan.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewBattle, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
						.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExploration, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addComponent(btnAddEquipment, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(82))
		);
		setLayout(gl_generalpan);
	}
}
