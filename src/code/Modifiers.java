package code;

/**Use this for Skills, Magic, */
public class Modifiers {
	public String name;
	public String rule;
	public int min;//min dice roll needed if one is needed (like injury or magic)
	public int max;//max dice roll needed if one is needed (like injury)
	enum Type {//Mostly used for skills
		Combat,Shooting,Academic,Strength,Speed,Special,
		Other};//Other = default
	Type type = Type.Other;
	
	public String grabDropdown() {
		return name + " roll(" + min + " / " + max + ")";
	}
	
	public void setType(String s) {
		if (s == "combat") type=Type.Combat;
		else if (s == "shooting") type=Type.Shooting;
		else if (s == "academic") type=Type.Academic;
		else if (s == "strength") type=Type.Strength;
		else if (s == "speed") type=Type.Speed;
		else type=Type.Special;
	}
}
