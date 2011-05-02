package mrIndustry.SpielObjekte.PrivateObjekte;

import mrIndustry.SpielObjekte.PrivatesObjekt;

public class WohnhausMittelKlasse extends PrivatesObjekt {
	public WohnhausMittelKlasse(int locX, int locY) {
		this.setLocX(locX);
		this.setLocY(locY);
		
		this.loadTexture("grass.png");
		//Neue Haus-Textur:
		this.loadTexture("house.png");
		
	}

}
