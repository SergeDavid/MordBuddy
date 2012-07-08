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
import code.xml.saveWarband;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class GeneralPanel extends JPanel {
	private static final long serialVersionUID = -7099283888689089508L;
	private JTextField name;
	private JTextField type;
	private JTextField goldcrowns;
	private JTextField upkeep;
	private JTextField wardstones;
	private JTextField rating;
	
	public GeneralPanel() {
		//Name
		JLabel lblWarbandName = new JLabel("Warband Name : ");
		name = new JTextField();
		name.addInputMethodListener(new InputMethodListener() {
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				Program.warband.name = name.getText();
				System.out.println(Program.warband.name);
			}
			public void caretPositionChanged(InputMethodEvent event) {}
		});
		name.setText(Program.warband.name);
		name.setColumns(10);
		
		//Type
		JLabel lblWarbandType = new JLabel("Warband Type : ");
		type = new JTextField();
		type.setText(Program.warband.type);
		type.setColumns(10);
		
		//Money
		JLabel lblGoldCrowns = new JLabel("Gold Crowns : ");
		goldcrowns = new JTextField();
		goldcrowns.setText(""+Program.warband.goldcrowns);
		goldcrowns.setColumns(10);
		JLabel lblUpkeepCosts = new JLabel("Upkeep : ");
		upkeep = new JTextField();
		upkeep.setText(""+Program.warband.upkeep);
		upkeep.setColumns(10);
		JLabel lblWardStones = new JLabel("Ward Stones : ");
		wardstones = new JTextField();
		wardstones.setText(""+Program.warband.wardstones);
		wardstones.setColumns(10);
		
		//Rating, battle, warband size
		JLabel lblRating = new JLabel("Rating : ");
		rating = new JTextField();
		rating.setText(""+Program.warband.rating);
		rating.setColumns(10);
		JLabel lblNewLabel = new JLabel("Battles : "+Program.warband.battles);
		JLabel lblOtherStat = new JLabel("Warband Size : "+Program.warband.members);
		
		//Equipment
		JLabel lblStoredEquipment = new JLabel("Stored Equipment");
		JTextArea textArea = new JTextArea();
		textArea.setRows(9);
		
		//Buttons
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Started to save the warband");//TODO println
				new saveWarband();
			}
		});
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(Color.RED);
		JButton btnExploration = new JButton("Exploration");
		JButton btnAddEquipment = new JButton("Add Equipment");		
		JButton btnNewBattle = new JButton("New Battle");
		
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
