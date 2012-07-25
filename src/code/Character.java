package code;

public class Character {
	public String name = "Name";
	public String type = "Type";//Captain, Youngblood, Warrior, etc.
	public int cost = 1;//Cost to buy in game, upkeep is half this.
	
	//How many you can take in a warband, zero max is unlimited.
	public int min = 0;
	public int max = 0;
	
	//The different races the character can be.
	public enum Race {human,elf,dwarf,orge,halfling,beastman,possessed,vampire,skaven,ghoul};
	public Race race = Race.human;
	
	enum Stats {M,WS,BS,S,T,W,I,A,Ld,EXP};
	public int movement,weaponSkill,balisticSkill,strength,toughness,wounds,inititive,attacks,leadership = 0;
	public int exp;
	public int exp2;//Second exp gauge showing how much exp you have gained since the last time you hit the battle button.
	public final int maxExp = 14;
	
	public String equipment;
	public String skills;
	public String magic;
	
	public Character() {
		
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
		exp = exp2 = Integer.parseInt(s[9]);
	}
	public String getStats() {
		return 
			movement+","+
			weaponSkill+","+
			balisticSkill+","+
			strength+","+
			toughness+","+
			wounds+","+
			inititive+","+
			attacks+","+
			leadership+","+
			exp+","+
			exp2;//TODO
	}
}
