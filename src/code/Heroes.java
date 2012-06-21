package code;

public class Heroes extends Character {
	boolean skillCombat,skillShooting,skillAcademic,skillStrength,skillSpeed,skillSpecial;//true / false if they can take said skill type
	
	public Heroes() {
		experience = 20;
		maxEXP = 40;
	}
	public void setSkills(String[] s) {
		skillCombat = Boolean.parseBoolean(s[0]);
		skillShooting = Boolean.parseBoolean(s[1]);
		skillAcademic = Boolean.parseBoolean(s[2]);
		skillStrength = Boolean.parseBoolean(s[3]);
		skillSpeed = Boolean.parseBoolean(s[4]);
		skillSpecial = Boolean.parseBoolean(s[5]);
	}
}
