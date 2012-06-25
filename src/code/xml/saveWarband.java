package code.xml;

public class saveWarband {
	/**Saves your warband into an xml file*/
	public void packWarband(String name) {
		//name is used for name.xml for saving and will not change after you change the name of your warband (they'll be different)
		packWarbandGeneral();
		packWarbandHeroes();
		packWarbandHenchmen();
		packHenchmen();
		packDramatis();
	}
	private void packWarbandGeneral() {
		//save name
		//save stats
	}
	private void packWarbandHeroes() {
		//loops through the heroes and saves their info
	}
	private void packWarbandHenchmen() {
		//loops through the henchmen and saves their info
	}
	private void packHenchmen() {
		//loops through the hired swords and saves their info
	}
	private void packDramatis() {
		//adds your single Dramatis(ies) to the list
	}
}
