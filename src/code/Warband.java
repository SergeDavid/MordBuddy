package code;

public class Warband {
	//The different lists of characters you can have or currently have.
	public Heroes[] heroes = new Heroes[6];//Your 6 total heroes
	public Henchmen[] henchmen = new Henchmen[6];//Your 6 total henchmen groups
	public int totalHeroes;//How many heroes are there total
	public int totalGroups;
	public String inventory;//Warband unequipped equipment.
	
	//General information
	public String name;
	public String type;//The name of the base warband files/warband_[type].xml
	public int goldcrowns;
	
	//For saved warbands
	public int wardstones;
	public int upkeep;//manditory goldcrowns you need to pay for each game from hiredswords (and anything else) cost.
	public int battles;
	public int members;
	public int rating;
	public String savedName;
	
	//For base warbands
	public int membersMax;//maximum heroes and henchmen you can take at once.
	public int membersMin;//minimum heroes and henchmen you can take at once.
	public String skills;//warband specific skills TODO: Not sure what to do with this... Maybe something like Universal.skills.allSpecial -> Universal.skills.special;
	public String rules;//Warband rules such as animosity.
}
