package code.gui.popups;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class changeStats extends JInternalFrame {
	public changeStats(String string) {
		setTitle("Change Stats");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{58, 39, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 0;
		getContentPane().add(lblType, gbc_lblType);
		
		JLabel lblM = new JLabel(" M ");
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 1;
		gbc_lblM.gridy = 0;
		getContentPane().add(lblM, gbc_lblM);
		
		JLabel lblWs = new JLabel(" WS ");
		GridBagConstraints gbc_lblWs = new GridBagConstraints();
		gbc_lblWs.insets = new Insets(0, 0, 5, 5);
		gbc_lblWs.gridx = 2;
		gbc_lblWs.gridy = 0;
		getContentPane().add(lblWs, gbc_lblWs);
		
		loadSpinners();
		
		JLabel lblBs = new JLabel(" BS ");
		GridBagConstraints gbc_lblBs = new GridBagConstraints();
		gbc_lblBs.insets = new Insets(0, 0, 5, 5);
		gbc_lblBs.gridx = 3;
		gbc_lblBs.gridy = 0;
		getContentPane().add(lblBs, gbc_lblBs);
		
		JLabel lblS = new JLabel(" S ");
		GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.gridx = 4;
		gbc_lblS.gridy = 0;
		getContentPane().add(lblS, gbc_lblS);
		
		JLabel lblT = new JLabel(" T ");
		GridBagConstraints gbc_lblT = new GridBagConstraints();
		gbc_lblT.insets = new Insets(0, 0, 5, 5);
		gbc_lblT.gridx = 5;
		gbc_lblT.gridy = 0;
		getContentPane().add(lblT, gbc_lblT);
		
		JLabel lblMax = new JLabel("Max");
		GridBagConstraints gbc_lblMax = new GridBagConstraints();
		gbc_lblMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblMax.gridx = 0;
		gbc_lblMax.gridy = 2;
		getContentPane().add(lblMax, gbc_lblMax);
		
		JLabel maxM = new JLabel("4");
		GridBagConstraints gbc_maxM = new GridBagConstraints();
		gbc_maxM.insets = new Insets(0, 0, 5, 5);
		gbc_maxM.gridx = 1;
		gbc_maxM.gridy = 2;
		getContentPane().add(maxM, gbc_maxM);
		
		label = new JLabel("4");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 2;
		getContentPane().add(label, gbc_label);
		
		label_1 = new JLabel("3");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 2;
		getContentPane().add(label_1, gbc_label_1);
		
		label_2 = new JLabel("3");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 2;
		getContentPane().add(label_2, gbc_label_2);
		
		label_3 = new JLabel("3");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 2;
		getContentPane().add(label_3, gbc_label_3);
		
		label_4 = new JLabel("1");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 6;
		gbc_label_4.gridy = 2;
		getContentPane().add(label_4, gbc_label_4);
		
		label_5 = new JLabel("3");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 7;
		gbc_label_5.gridy = 2;
		getContentPane().add(label_5, gbc_label_5);
		
		label_6 = new JLabel("1");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 8;
		gbc_label_6.gridy = 2;
		getContentPane().add(label_6, gbc_label_6);
		
		label_7 = new JLabel("7");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 9;
		gbc_label_7.gridy = 2;
		getContentPane().add(label_7, gbc_label_7);
	}
	private JSpinner spinM;
	private JSpinner spinWS;
	private JSpinner spinBS;
	private JSpinner spinS;
	private JSpinner spinT;
	private JSpinner spinW;
	private JSpinner spinI;
	private JSpinner spinA;
	private JSpinner spinLD;
	private void loadSpinners() {
		
		lblW = new JLabel(" W ");
		GridBagConstraints gbc_lblW = new GridBagConstraints();
		gbc_lblW.insets = new Insets(0, 0, 5, 5);
		gbc_lblW.gridx = 6;
		gbc_lblW.gridy = 0;
		getContentPane().add(lblW, gbc_lblW);
		
		lblI = new JLabel(" I ");
		GridBagConstraints gbc_lblI = new GridBagConstraints();
		gbc_lblI.insets = new Insets(0, 0, 5, 5);
		gbc_lblI.gridx = 7;
		gbc_lblI.gridy = 0;
		getContentPane().add(lblI, gbc_lblI);
		
		lblA = new JLabel(" A ");
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 8;
		gbc_lblA.gridy = 0;
		getContentPane().add(lblA, gbc_lblA);
		
		lblLd = new JLabel("LD");
		GridBagConstraints gbc_lblLd = new GridBagConstraints();
		gbc_lblLd.insets = new Insets(0, 0, 5, 0);
		gbc_lblLd.gridx = 9;
		gbc_lblLd.gridy = 0;
		getContentPane().add(lblLd, gbc_lblLd);
		spinM = new JSpinner();
		spinM.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1; gbc_spinner.gridy = 1;
		getContentPane().add(spinM, gbc_spinner);
		
		spinWS = new JSpinner();
		spinWS.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2; gbc_spinner.gridy = 1;
		getContentPane().add(spinWS, gbc_spinner);
		
		spinBS = new JSpinner();
		spinBS.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 3; gbc_spinner.gridy = 1;
		getContentPane().add(spinBS, gbc_spinner);
		
		spinS = new JSpinner();
		spinS.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 4; gbc_spinner.gridy = 1;
		getContentPane().add(spinS, gbc_spinner);
		
		spinT = new JSpinner();
		spinT.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 5; gbc_spinner.gridy = 1;
		getContentPane().add(spinT, gbc_spinner);
		
		spinW = new JSpinner();
		spinW.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 6; gbc_spinner.gridy = 1;
		getContentPane().add(spinW, gbc_spinner);
		
		spinI = new JSpinner();
		spinI.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 7; gbc_spinner.gridy = 1;
		getContentPane().add(spinI, gbc_spinner);
		
		spinA = new JSpinner();
		spinA.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 8; gbc_spinner.gridy = 1;
		getContentPane().add(spinA, gbc_spinner);
		
		spinLD = new JSpinner();
		spinLD.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 9; gbc_spinner.gridy = 1;
		getContentPane().add(spinLD, gbc_spinner);
	}
	private static final long serialVersionUID = 2764227475149197910L;
	private JLabel lblW;
	private JLabel lblI;
	private JLabel lblA;
	private JLabel lblLd;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;

}
