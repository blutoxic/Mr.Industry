package mrIndustry.SpielObjekte.PrivateObjekte;

import mrIndustry.SpielObjekte.PrivatesObjekt;

public class WohnhausOberKlasse extends PrivatesObjekt {
	public WohnhausOberKlasse(int locX, int locY, boolean drag) {
		this.setLocX(locX);
		this.setLocY(locY);
		this.setDragDrop(drag);
		this.loadTexture("grass.png");
		this.loadTexture("house.png");
		
	}

}
