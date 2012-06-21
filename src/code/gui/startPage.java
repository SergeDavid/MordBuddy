package code.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import code.Program;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class startPage extends JPanel {
	private static final long serialVersionUID = -3333988765044700564L;

	public startPage() {
		
		JLabel lblMordbuddy = new JLabel("MordBuddy");
		lblMordbuddy.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		JLabel lblVersion = new JLabel("version 0.02");
		
		JLabel lblBySergedavid = new JLabel("By: Serge-David");
		
		JLabel lblForPrivateUse = new JLabel("For private use only");
		
		JButton btnCreateWarband = new JButton("Create");
		btnCreateWarband.setFont(new Font("Tahoma", Font.PLAIN, 36));
		btnCreateWarband.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.gui.change(Gui.pane.create);
			}
		});
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 36));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Program.gui.change(Gui.pane.load);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(132)
							.addComponent(lblMordbuddy, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBySergedavid)
								.addComponent(btnCreateWarband, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblForPrivateUse)
									.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
									.addComponent(lblVersion))
								.addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMordbuddy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCreateWarband, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
						.addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVersion)
						.addComponent(lblBySergedavid)
						.addComponent(lblForPrivateUse))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
