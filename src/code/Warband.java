package code;

public class Warband {
	//Warbands are saved in groups by game so (<0>blablabla</0><1>after first battle</1><2>after second battle</2>)
	
	public Heroes[] heroes = new Heroes[6];//Your 6 total heroes
	public Heroes[] deadheroes;//A list of discarded heroes to be trashed when the program closes or the next battle is called
	public Henchmen[] henchmen = new Henchmen[6];//Your 6 total henchmen groups
	public Henchmen[] deadhenchmen;//Same as deadHeroes
	public Character[] hiredsword;
	
	public String name = "my_warband";
	public String type = "Mercenary";
	public int goldcrowns = 500;
	public int wardstones = 0;
	public int upkeep = 0;
	public int miscupkeep = 0;//Misc upkeep from special things like campaign hideout or what not
	public int battles = 0;
	public int members = 0;
	public int rating = 0;
	
	public Equipment[] inventory;
}
