package code;

public class Heroes extends Character {
	boolean skillCombat,skillShooting,skillAcademic,skillStrength,skillSpeed,skillSpecial;//true / false if they can take said skill type
	public final int maxExp = 90;
	
	public Heroes() {
	}
	
	public void setSkills(String[] s) {
		skillCombat = Boolean.parseBoolean(s[0]);
		skillShooting = Boolean.parseBoolean(s[1]);
		skillAcademic = Boolean.parseBoolean(s[2]);
		skillStrength = Boolean.parseBoolean(s[3]);
		skillSpeed = Boolean.parseBoolean(s[4]);
		skillSpecial = Boolean.parseBoolean(s[5]);
	}
	
	/**Unpretty as I should be able to just transfer all of the variables in one or two lines, but this will work for now. TODO*/
	public Heroes copy() {
		Heroes h = new Heroes();
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
		h.experience = experience;
		h.exp = exp;
		h.exp2 = exp2;
		h.equipment = equipment;
		h.skills = skills;
		h.magic = magic;
		h.skillCombat = skillCombat;
		h.skillShooting = skillShooting;
		h.skillAcademic = skillAcademic;
		h.skillStrength = skillStrength;
		h.skillSpeed = skillSpeed;
		h.skillSpecial = skillSpecial;
		return h;
	}
}
