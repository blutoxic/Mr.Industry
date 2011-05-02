package mrIndustry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;

public class SpielObjekt {

	public static String[][] list_text = {
			{ "Bergwerk", "Eisenmine", "Försterei", "Farm" },
			{ "Autofabrik", "Werkzeugfabrik" }, { "Markt", "Bar", "Theater" },
			{ "Unterschicht", "Mittelschicht", "Oberschicht" },
			{ "Statue", "Park" }, { "Strassenstück" } };

	/*
	 * Index von kosten[][][x]: Geld:0 Nahrung:1 Kohle:2 Eisen:3 Arbeiter:4
	 * Holz:5 Index von kosten[][x][]:
	 * Eisenmine,Försterei,Farm,Autofabrik,Werkzeugfabrik,Markt,Bar,Theater
	 * Wohngeb.unter.,Wohngeb.mittel.,Wohngeb.ober.,Statue,Park,Strasse Index
	 * von kosten[x][][]: Gewinnung,Verarbeitung,Dienstleistung,private
	 * Gebäude,Sonstiges,Logistik
	 */
	// Bergwerk[0]:
	public static int[][][] kosten = {
			{ { 12000, 3500, 0, 3000, 15, 4500,0 },
					{ 10000, 4000, 3000, 2500, 20, 5000,1 },
					{ 8000, 5000, 2000, 2500, 25, 2000,2 },
					{ 15000, 1000, 2500, 3000, 10, 3000,3 } },
			{ { 15000, 1000, 2500, 3500, 15, 3000,4 },
					{ 10000, 800, 3000, 2500, 10, 3500,5 } },
			{ { 4000, 3000, 3000, 3000, 10, 3000,6 },
					{ 2500, 1000, 500, 800, 5, 1500,7 },
					{ 4000, 1500, 1000, 1000, 20, 1500,8 } },
			{ { 1000, 500, 100, 500, 0, 1000,9 },
					{ 3000, 2000, 500, 1200, 0, 2000,10 },
					{ 5000, 2000, 500, 2200, 0, 2500,11 } },
			{ { 10000, 1000, 0, 3000, 0, 500,12 },
					{ 11000, 1100, 500, 1500, 0, 1000,13 } },
			{ { 500, 200, 200, 100, 0, 100,14 } } };

	static String abh = "<p>Abhängigkeit der Position:</p>";
	public static String[][] arr_desc = {
			{
					"<h3>Bergwerk</h3>Das Bergwerk dient zur Gewinnung des Rohstoffs Kohle."
							+ abh
							+ "<br/>Das Gebäude muss auf einem Kohlevorkommen erbaut werden.",
					"<h3>Eisenmine</h3>Die Eisenmine dient zur Gewinnung des Rohstoffs Eisen."
							+ abh
							+ "<br/>Das Gebäude muss auf einem Eisenvorkommen erbaut werden.",
					"<h3>Försterei</h3>Die Försterei dient zur Gewinnung des Rohstoffs Holz."
							+ abh
							+ "<br/>Das Gebäude muss an einem Wald erbaut werden.",
					"<h3>Farm</h3>Die Farm dient zur Gewinnung des Rohstoffs Nahrung."
							+ abh
							+ "<br/>Das Gebäude muss auf einer Wiese gebaut werden." },
			{
					"<h3>Autofabrik</h3>Die Autofabrik baut und verkauft Autos."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen.",
					"<h3>Werkzeugfabrik</h3>Die Werkzeugfabrik stellt Werkzeuge her und verkauft diese."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen." },
			{
					"<h3>Markt</h3>Der Markt ermöglicht dir Rohstoffe einzukaufen oder diese in Geld umzuwandeln."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen.",
					"<h3>Bar</h3>Die Bar erbringt Gewinn in Form von Geld."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen.",
							"<h3>Theater</h3>Das Theater erbringt Gewinn in Form von Geld."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen."},
			{
					"<h3>Wohngebäude Unterschicht</h3>Das Gebäude welches Bewohner hat welche am wenigsten Steuern zahlen können."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen.",
					"<h3>Wohngebäude Mittelschicht</h3>Das Gebäude welches Bewohner hat welche am mittelmässig Steuern zahlen können."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen.",
					"<h3>Wohngebäude Oberschicht</h3>Das Gebäude welches Bewohner hat welche am meisten Steuern zahlen können."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen." },
			{
					"<h3>Statue von Mr. Industry</h3>Eine grosse Statue, welche das Aussehen der Siedlung aufwertet."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen.",
					"<h3>Park</h3>Ein Park welcher die Bewohner der Siedlung zum Entspannen einlädt."
							+ abh
							+ "<br/>Das Gebäude darf nicht auf Hindernissen stehen." },
			{ "<h3>Strassenstück</h3>Ein Strassenstück welches die Abwicklung der Logistik in der Siedlung ermöglicht. Die Kosten werden pro Strassenstück (oder auch Strassenparzelle) abgerechnet."
					+ abh
					+ "<br/>Das Bauwerk darf nicht auf Hindernissen stehen. Die Strasse muss zwingend mit mindestens einem Gebäude und dem Strassennetz welches mit dem Hauptlager verbunden ist verbunden sein. Die Strasse ist also immer in einem Stück." } };
	protected static Map<String, BufferedImage> textureImages = new HashMap<String, BufferedImage>();
	int locX;
	int locY;
	int mapsizeX;
	int mapsizeY;
	boolean dragdrop;
	boolean highlight;

	public void tick() {

	}

	public boolean getDragDrop() {
		return dragdrop;
	}

	public void setDragDrop(boolean dragdrop) {
		this.dragdrop = dragdrop;
	}

	public boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	protected Vector<BufferedImage> texture;

	public void addTexture(BufferedImage texture) {
		this.texture.add(texture);
	}

	public void zeichne(Graphics g, int x, int y) {
		for (int i = 0; i < texture.size(); i++) {
			if (getDragDrop() == true) {
				// g.drawImage((BufferedImage) texture.elementAt(i), xVal * 150,
				// MrIndustry.yVal * 150, null);
			} else {
				g.drawImage((BufferedImage) texture.elementAt(i), this.locX
						* MrIndustry.textureSize - x, this.locY
						* MrIndustry.textureSize - y, MrIndustry.textureSize,
						MrIndustry.textureSize, null);
			}
		}
		if (getHighlight() == true) {
			g.setColor(Color.YELLOW);
			g.drawRect(this.locX * MrIndustry.textureSize - x, this.locY
					* MrIndustry.textureSize - y, MrIndustry.textureSize - 1,
					MrIndustry.textureSize - 1);
			g.setColor(Color.BLACK);
		}
	}

	public SpielObjekt() {
		this.texture = new Vector<BufferedImage>();
	}

	public void loadTexture(String filename) {
		if (textureImages.get(filename) == null) {
			try {
				textureImages.put(filename, ImageIO.read(new File(filename)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(filename + " not found!");
			}

		}
		texture.add(textureImages.get(filename));
	}

	public Calendar now() {
		Calendar cal = Calendar.getInstance();
		return cal;
	}
}
