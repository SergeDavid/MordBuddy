package code;

/**Use this for Skills, Magic, */
public class Modifiers {
	String name;
	String rule;
	int min;//min dice roll needed if one is needed (like injury or magic)
	int max;//max dice roll needed if one is needed (like injury)
	enum Type {//Mostly used for skills
		Combat,Shooting,Academic,Strength,Speed,Special,
		Other};//Other = default
	Type type = Type.Other;
}
