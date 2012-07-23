package code.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import code.Program;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TitlePage extends JPanel {
	private static final long serialVersionUID = -3333988765044700564L;
	private JTextArea infoBox;

	public TitlePage() {
		setBackground(Color.GRAY);
		
		JLabel lblMordbuddy = new JLabel("MordBuddy");
		lblMordbuddy.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		JLabel lblVersion = new JLabel("version " + Program.version);
		
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
		
		infoBox = new JTextArea();
		infoBox.setWrapStyleWord(true);
		infoBox.setRows(8);
		infoBox.setLineWrap(true);
		infoBox.setText("This program is specifically for private use along with a copy of the rules. I created this program for easier management of my warband since I can change my skills, stats, and model count much easier then with a pencil. If you found this program online and it was not hosted by GitHub by Serge-David then someone else is distributing it without my consent. This program is only allowed to be hosted on GitHub by me as an open source version control and backup system. Thank you for using MordBuddy, hope you enjoy it.");
		infoBox.setEditable(false);
		//infoBox.setLineWrap(true);
		infoBox.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(infoBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(132)
							.addComponent(lblMordbuddy, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCreateWarband, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblBySergedavid)
							.addGap(18)
							.addComponent(lblForPrivateUse)
							.addPreferredGap(ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
							.addComponent(lblVersion)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMordbuddy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCreateWarband, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVersion)
						.addComponent(lblBySergedavid)
						.addComponent(lblForPrivateUse))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
