package code;

public class Henchmen extends Character {
	public int total;//Max henchmen that can join
	public int members = 1;//How many henchmen in the group
	boolean promotable = true;//Can get thatladsgottalent
	
	/**Unpretty as I should be able to just transfer all of the variables in one or two lines, but this will work for now. TODO*/
	public Henchmen copy() {
		Henchmen h = new Henchmen();
		h.name = name;
		h.type = type;
		h.cost = cost;
		h.min = min;
		h.max = max;
		h.race = race;
		h.movement = movement;
		h.weaponSkill = weaponSkill;
		h.balisticSkill = balisticSkill;
		h.strength = strength;
		h.toughness = toughness;
		h.wounds = wounds;
		h.inititive = inititive;
		h.attacks = attacks;
		h.leadership = leadership;
		h.exp = exp;
		h.exp2 = exp2;
		h.equipment = equipment;
		h.skills = skills;
		h.magic = magic;
		h.promotable = promotable;
		return h;
	}
}
