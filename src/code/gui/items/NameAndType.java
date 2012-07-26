package code.gui.items;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class NameAndType extends JPanel {
	private static final long serialVersionUID = 1L;
	public JTextField modelName;
	public JTextField modelType;
	public NameAndType(String name, String type) {
		setBackground(Color.LIGHT_GRAY);
		JLabel lblName = new JLabel("Name");
		
		modelName = new JTextField(name);
		modelName.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		
		modelType = new JTextField(type);
		modelType.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(modelName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(modelType, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
					.addGap(102))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(modelName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblType))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(modelType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
