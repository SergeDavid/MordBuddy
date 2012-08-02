package code.gui.popups;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import code.Program;
import code.gui.panels.HeroPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HeroInjuryChart extends PopupBase {
	private static final long serialVersionUID = 1L;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JButton btnCancel;
	private JButton btnAccept;
	private HeroPanel gui;
	
	public HeroInjuryChart(HeroPanel h) {
		gui = h;
		setTitle("Hero Injury Chart");
		setSize(300,200);
		setLocationRelativeTo(null);
		textArea = new JTextArea();
		btnCancel = new JButton("Cancel");
		btnAccept = new JButton("Accept");
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(grabInjuries()));
		
		setListeners();
		setLayout();
	}
	
	private void setListeners() {
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: I want this to update the hero skills object array with an injury object. Then I want to refresh the skills table.
				//gui.hero.skills.add(new injury); and gui.displaySkills();
				if (gui.txtSkills.getText().isEmpty()) {
					gui.txtSkills.setText(Program.injuries.get(comboBox.getSelectedIndex()).name);
				}
				else {
					gui.txtSkills.setText(
							gui.txtSkills.getText()+","+
							Program.injuries.get(comboBox.getSelectedIndex()).name);
				}
				gui.updateWarband();
				dispose();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	private void setLayout() {
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.LEADING, 0, 264, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAccept)
							.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
							.addComponent(btnCancel)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnAccept))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private String[] grabInjuries() {
		String[] s = new String[Program.injuries.size()];
		for (int i = 0; i < s.length; i++) {
			s[i] = Program.injuries.get(i).grabDropdown();
		}
		return s;
	}
}
