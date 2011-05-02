package mrIndustry.SpielObjekte.Rohstoffgebaeude;

import mrIndustry.SpielObjekte.Rohstoffgewinnung;

public class Eisenmine extends Rohstoffgewinnung {
	public Eisenmine(int locX, int locY) {
		this.setLocX(locX);
		this.setLocY(locY);
		this.loadTexture("grass.png");
		this.loadTexture("eisenmine.png");
		
	}

}
