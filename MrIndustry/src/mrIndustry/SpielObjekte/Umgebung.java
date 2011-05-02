package mrIndustry.SpielObjekte;

//import java.awt.Graphics;

import mrIndustry.MrIndustry;
import mrIndustry.SpielObjekt;

public class Umgebung extends SpielObjekt {
	int Gelaende;

	public Umgebung(int Gelaende, int locX, int locY) {
		this.setLocX(locX);
		this.setLocY(locY);
		this.Gelaende = Gelaende;
		this.setHighlight(false);
		switch (this.Gelaende) {
		case 0:
			this.loadTexture("water.png");
			break;
		case 1:
			this.loadTexture("grass.png");
			break;
		case 2:
			this.loadTexture("forrest.png");
			break;
		case 3:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_left.png");
			break;
		case 4:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_top.png");
			break;
		case 5:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_right.png");
			break;
		case 6:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_bot.png");
			break;
		case 7:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_bot_right.png");
			break;
		case 8:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_bot_left.png");
			break;
		case 9:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_top_left.png");
			break;
		case 10:
			this.loadTexture("grass.png");
			this.loadTexture("forrest_top_right.png");
			break;
		case 11:
			this.loadTexture("water.png");
			this.loadTexture("water_left.png");
			break;
		case 12:
			this.loadTexture("water.png");
			this.loadTexture("water_top.png");
			break;
		case 13:
			this.loadTexture("water.png");
			this.loadTexture("water_right.png");
			break;
		case 14:
			this.loadTexture("water.png");
			this.loadTexture("water_bot.png");
			break;
		case 15:
			this.loadTexture("water.png");
			this.loadTexture("water_bot_right.png");
			break;
		case 16:
			this.loadTexture("water.png");
			this.loadTexture("water_bot_left.png");
			break;
		case 17:
			this.loadTexture("water.png");
			this.loadTexture("water_top_left.png");
			break;
		case 18:
			this.loadTexture("water.png");
			this.loadTexture("water_top_right.png");
			break;
		case 19:
			this.loadTexture("water.png");
			this.loadTexture("water_ecke_top_left.png");
			break;
		case 20:
			this.loadTexture("water.png");
			this.loadTexture("water_ecke_top_right.png");
			break;
		case 21:
			this.loadTexture("water.png");
			this.loadTexture("water_ecke_bot_left.png");
			break;
		case 22:
			this.loadTexture("water.png");
			this.loadTexture("water_ecke_bot_right.png");
			break;
		}
	}

}
