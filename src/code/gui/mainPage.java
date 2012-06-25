package code.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import code.Program;
import code.gui.panels.AddPanel;
import code.gui.panels.GeneralPanel;
import code.gui.panels.henchPanel;
import code.gui.panels.heroPanel;

public class mainPage extends JTabbedPane {
	public mainPage() {
		JTabbedPane heropan = new JTabbedPane();
		JTabbedPane henchpan = new JTabbedPane();
		JTabbedPane hiredswords = new JTabbedPane();
		JPanel other = new JPanel();
		JPanel personae = new JPanel();
		general = new GeneralPanel();
		
		this.addTab("General", null, general, null);
		this.addTab("Heroes", null, heropan, null);
		this.addTab("Henchmen", null, henchpan, null);
		this.addTab("Hired Swords", null, hiredswords, null);
		this.addTab("Dramatis Personae", null, personae, null);
		this.addTab("Other", null, other, null);
		
		boolean hithero = true;
		boolean hithench = true;
		for (int i = 0; i < 6; i++) {
			if (Program.warband.heroes[i] != null) {//Add Hero
				heroes[i] = new heroPanel(i);
				heropan.addTab(heroes[i].type.getText(), null, heroes[i], null);
			}
			else if (hithero) {
				AddPanel newpanel = new AddPanel();
				heropan.addTab("Add", null, newpanel, null);
				hithero = false;
			}
			if (Program.warband.henchmen[i] != null) {//Add Henchmen
				henchmen[i] = new henchPanel(i);
				henchpan.addTab(henchmen[i].type.getText(), null, henchmen[i], null);
			}
			else if (hithench) {
				AddPanel newpanel = new AddPanel();
				henchpan.addTab("Add", null, newpanel, null);
				hithench = false;
			}
			//Add hiredswords
			//add desperatepersona
		}
	}
	private GeneralPanel general;
	private heroPanel[] heroes = new heroPanel[6];
	private henchPanel[] henchmen = new henchPanel[6];
	private static final long serialVersionUID = 1026031560130367420L;
}