package mrIndustry.SpielObjekte;

import java.util.Calendar;
import java.util.Date;

import mrIndustry.MrIndustry;
import mrIndustry.SpielObjekt;

public class ZentralLager extends SpielObjekt {
	protected int wood;
	protected Date lastTime;
	protected Calendar now;

	public ZentralLager(int locX, int locY, boolean drag) {

		wood = 200;

		this.setLocX(locX);
		this.setLocY(locY);
		this.setDragDrop(drag);
		this.loadTexture("grass.png");
		// Neue Haus-Textur:
		this.loadTexture("house.png");
		lastTime = this.now().getTime();

	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public void tick() {
		now=this.now();
		if (now.getTime().getSeconds() - lastTime.getSeconds()==10) {
					wood=wood+1;
		lastTime=this.now().getTime();
	}
	}


}