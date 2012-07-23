package code.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import code.Program;
import code.gui.panels.AddPanel;
import code.gui.panels.CheckPanel;
import code.gui.panels.GeneralPanel;
import code.gui.panels.HenchPanel;
import code.gui.panels.HeroPanel;

public class MainPage extends JTabbedPane {
	JTabbedPane heropan;
	JTabbedPane henchpan;
	JTabbedPane hiredswords;
	JPanel other;
	CheckPanel checklist;
	JPanel personae;
	GeneralPanel general;
	
	public MainPage(int t, int b) {
		setstuff();
		setSelectedIndex(t);
		switch (t) {
			case 1:heropan.setSelectedIndex(b);break;
			case 2:henchpan.setSelectedIndex(b);break;
			case 3:hiredswords.setSelectedIndex(b);break;
		}
	}
	public MainPage() {
		setstuff();
	}
	private void setstuff() {
		//The different panels needed
				heropan = new JTabbedPane();
				henchpan = new JTabbedPane();
				hiredswords = new JTabbedPane();
				other = new JPanel();
				checklist = new CheckPanel();
				personae = new JPanel();
				general = new GeneralPanel(this);
				
				this.addTab("General", null, general, null);
				this.addTab("Heroes", null, heropan, null);
				this.addTab("Henchmen", null, henchpan, null);
				this.addTab("Hired Swords", null, hiredswords, null);
				this.addTab("Dramatis Personae", null, personae, null);
				this.addTab("Other", null, other, null);
				this.addTab("CheckList", null, checklist, null);
				
				boolean hithero = true;
				boolean hithench = true;
				for (int i = 0; i < 6; i++) {
					if (Program.warband.heroes[i] != null) {//Add Hero
						heroes[i] = new HeroPanel(i);
						heropan.addTab(heroes[i].type.getText(), null, heroes[i], null);
					}
					else if (hithero) {
						AddPanel newpanel = new AddPanel("heroes",Program.addHeroList());
						heropan.addTab("Add", null, newpanel, null);
						hithero = false;
					}
					if (Program.warband.henchmen[i] != null) {//Add Henchmen
						henchmen[i] = new HenchPanel(i);
						henchpan.addTab(henchmen[i].type.getText(), null, henchmen[i], null);
					}
					else if (hithench) {
						AddPanel newpanel = new AddPanel("henchmen",Program.addHenchmenList());
						henchpan.addTab("Add", null, newpanel, null);
						hithench = false;
					}
					//Add hiredswords
					//add desperatepersona
				}
	}
	private HeroPanel[] heroes = new HeroPanel[6];
	private HenchPanel[] henchmen = new HenchPanel[6];
	private static final long serialVersionUID = 1026031560130367420L;
	
	public void updateAllTheStuff() {
		general.updateWarband();
		for (int i = 0; i < 6; i++) {
			if (heroes[i] != null) heroes[i].updateWarband(i);
		}
	}
}