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
import code.gui.popups.changeStats;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loadPage extends JPanel {
	private static final long serialVersionUID = 6623864777126977113L;
	public loadPage() {
		setBackground(Color.GRAY);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.gui.change(Gui.pane.start);
			}
		});
		
		JButton btnStartWarband = new JButton("Load Warband");
		btnStartWarband.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.loadWarband();
			}
		});
		
		JLabel lblChooseAWarband = new JLabel("Choose A Warband");
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			private static final long serialVersionUID = -8277547429892260268L;
			String[] values = new String[] {"Dwarf Hunters", "Orcs and Goblins", "Reikland Mercenaries", "Sisters of Sigmar"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		changeStats internalFrame = new changeStats("New JInternalFrame");
		internalFrame.setClosable(true);
		internalFrame.setResizable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnStartWarband)
									.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
									.addComponent(btnReturn))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblChooseAWarband)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblChooseAWarband)
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturn)
						.addComponent(btnStartWarband))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
