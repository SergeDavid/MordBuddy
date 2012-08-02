package code.gui.popups;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import code.Program;

public class EquipmentPopup extends PopupBase {
	private JList textArea;
	private JComboBox comboBox;
	private String[][] s = new String[5][];
	private JTextArea list;
	
	public EquipmentPopup(JTextArea l) {
		setTitle("Equipment Select");
		setSize(300,200);
		setLocationRelativeTo(null);
		
		list = l;
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Combat", "Ranged", "Powder", "Armour", "Misc"}));
		populateStrings();
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: add/remove item from a list of equipment then update the appropiate textbox
				// if (inlist(selected, list) {list.get(selected).size++})
				// esle list.add(selected)
				//
				// for removing
				// if (list.get(selected).size <= 1) {list.remove(selected)}
				// esle {list.get(selected).size--;}
				// refresh();
				if (list.getText().isEmpty()) list.setText(""+textArea.getSelectedValue());
				else list.setText(list.getText()+","+textArea.getSelectedValue());
				dispose();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		textArea = new JList();
		changeContents();
		JScrollPane scrollPane = new JScrollPane(textArea);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	
	private void populateStrings() {
		s[0] = new String[Program.equipment.size()];
		for (int i = 0; i < s[0].length; i++) {
			s[0][i] = Program.equipment.get(i).name;
		}
	}

	/**Currently puts the names of all of the equipment options into a single list
	 * TODO: Separate them and let the comboBox change what type to pull from.*/
	private void changeContents() {
		textArea.setModel(new AbstractListModel() {
			private static final long serialVersionUID = 1L;
			String[] values = s[0];
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
	
	private static final long serialVersionUID = 1L;

}
