package code;

public class Equipment {
	String name = "item";
	enum Type {Combat, Range, Blackpowder, Defence, Misc, Special};
	Type type = Type.Combat;
	int rarity = 0;//0 is common
	int cost = 1;
	
	public Equipment(String n, Type t, int c, int r) {
		name = n;
		type = t;
		cost = c;
		rarity = r;
	}
}
