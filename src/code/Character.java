package code;

public class Character {
	public String name = "Name";
	public String type = "Type";
	
	enum Race {human,elf,dwarf,orge,halfling,beastman,possessed,vampire,skaven,ghoul};
	public Race race;
	
	enum Stats {M,WS,BS,S,T,W,I,A,Ld,EXP};
	public int movement,weaponSkill,balisticSkill,strength,toughness,wounds,inititive,attacks,leadership,experience = 0;
	public int maxM,maxWS,maxBS,maxS,maxT,maxW,maxI,maxA,maxLd,maxEXP = 5;
	
	public int exp;
	//heroes total = 90, levels at 2,4,6,811,14,17,20,24,28,32,36,41,46,51,57,63,69,76,83,90
	//henchmen total = 14, levels at 2, 5, 9, 14
	public String equipment;
	public String skills;
	//Equipment[] equipped;//Unused right now until I objecterize everything.
	//Skills[] skills;//I need my list of skills, injuries, etc
	
	public Character() {
		
	}
	
	public boolean levelSkill(Stats stats) {
		switch(stats) {
			case M:if (movement < maxM) {movement++;return true;}break;
			case WS:if (weaponSkill < maxWS) {weaponSkill++;return true;}break;
			case BS:if (balisticSkill < maxBS) {balisticSkill++;return true;}break;
			case S:if (strength < maxS) {strength++;return true;}break;
			case T:if (toughness < maxT) {toughness++;return true;}break;
			case W:if (wounds < maxW) {wounds++;return true;}break;
			case I:if (inititive < maxI) {inititive++;return true;}break;
			case A:if (attacks < maxA) {attacks++;return true;}break;
			case Ld:if (leadership < maxLd) {leadership++;return true;}break;
		}
		return false;
	}
	
	public void stats(String string) {
		String[] s = string.split(",");
		movement = Integer.parseInt(s[0]);
		weaponSkill = Integer.parseInt(s[1]);
		balisticSkill = Integer.parseInt(s[2]);
		strength = Integer.parseInt(s[3]);
		toughness = Integer.parseInt(s[4]);
		wounds = Integer.parseInt(s[5]);
		inititive = Integer.parseInt(s[6]);
		attacks = Integer.parseInt(s[7]);
		leadership = Integer.parseInt(s[8]);
		experience = Integer.parseInt(s[9]);
	}
}
