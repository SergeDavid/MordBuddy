package code;

public class Equipment {
	public String name = "item";
	public enum Type {Combat, Range, Blackpowder, Defence, Misc, Special};
	public Type type = Type.Combat;
	public int rarity = 0;//0 is common
	public int cost = 1;

	public void setType(String s) {
		if (s == "combat") type = Type.Combat;
		else if (s == "range") type = Type.Range;
		else if (s == "blackpowder") type = Type.Blackpowder;
		else if (s == "armour") type = Type.Defence;
		else type = Type.Misc;
	}
}
