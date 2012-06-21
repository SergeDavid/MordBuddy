package code;

public class Character {
	public String name = "Name";//
	public String type = "Type";//Captain, Youngblood, Warrior, etc.
	public int cost = 1;//Cost to buy in game, upkeep is half this.
	
	//How many you can take in a warband, zero max is unlimited.
	public int min = 0;
	public int max = 0;
	
	//The different races the character can be.
	enum Race {human,elf,dwarf,orge,halfling,beastman,possessed,vampire,skaven,ghoul};
	public Race race;
	
	//Stats, TODO: Revamp it with max being pulled from universal.
	enum Stats {M,WS,BS,S,T,W,I,A,Ld,EXP};
	public int movement,weaponSkill,balisticSkill,strength,toughness,wounds,inititive,attacks,leadership,experience = 0;
	public int maxM,maxWS,maxBS,maxS,maxT,maxW,maxI,maxA,maxLd,maxEXP = 10;
	
	//Experience, TODO: hero levels and total along with henchmen levels and total should be put into universal
	public int exp;
	public int levels;//Marks how many levels the character needs to advance for.
	//heroes total = 90, levels at 2,4,6,811,14,17,20,24,28,32,36,41,46,51,57,63,69,76,83,90
	//henchmen total = 14, levels at 2, 5, 9, 14
	
	//Equipment and Sats
	public String equipment;
	public String skills;
	//ArrayList<Equipment> equipped = new ArrayList<Equipment>();//Unused right now until I objecterize everything.
	//Skills[] skills;
	//Magic
	//Injuries
	
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
	
	public void setStats(String[] s) {
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
