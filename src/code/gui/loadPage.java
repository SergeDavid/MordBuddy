package code.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import code.Program;
import code.xml.GrabNames;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadPage extends JPanel {
	private static final long serialVersionUID = 6623864777126977113L;
	JButton btnStartWarband;
	JButton btnReturn;
	JLabel lblChooseAWarband;
	JList list;
	
	public LoadPage() {
		setBackground(Color.GRAY);
		
		btnReturn = new JButton("Return");
		btnStartWarband = new JButton("Load Warband");
		lblChooseAWarband = new JLabel("Choose A Warband");
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			private static final long serialVersionUID = -8277547429892260268L;
			String[] values = GrabNames.savedWarbands();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		setListeners();
		createLayout();
	}

	private void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnStartWarband)
									.addPreferredGap(ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
									.addComponent(btnReturn))
								.addComponent(lblChooseAWarband))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseAWarband)
					.addGap(24)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturn)
						.addComponent(btnStartWarband))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	private void setListeners() {
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.gui.change(Gui.pane.start);
			}
		});
		btnStartWarband.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() != null) {
					Program.loadWarband(list.getSelectedValue().toString());
				}
				else {
					Program.gui.change(Gui.pane.start);
				}
			}
		});
	}
}
