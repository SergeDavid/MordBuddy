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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createPage extends JPanel {
	private static final long serialVersionUID = 6623864777126977113L;
	public createPage() {
		setBackground(Color.GRAY);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.gui.change(Gui.pane.start);
			}
		});
		
		JButton btnStartWarband = new JButton("Start Warband");
		btnStartWarband.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.newWarband();
			}
		});
		
		JLabel lblChooseAWarband = new JLabel("Choose A Warband");
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			private static final long serialVersionUID = -8277547429892260268L;
			String[] values = Program.warbandNames();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnStartWarband)
									.addPreferredGap(ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
									.addComponent(btnReturn))
								.addComponent(lblChooseAWarband))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseAWarband)
					.addGap(18)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturn)
						.addComponent(btnStartWarband))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
