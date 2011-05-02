package mrIndustry;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mrIndustry.SpielObjekte.Umgebung;
import mrIndustry.SpielObjekte.ZentralLager;
import mrIndustry.SpielObjekte.PrivateObjekte.WohnhausMittelKlasse;
import mrIndustry.SpielObjekte.PrivateObjekte.WohnhausOberKlasse;
import mrIndustry.SpielObjekte.Rohstoffgebaeude.Eisenmine;

public class Spielkarte extends JPanel {

	public SpielObjekt SpielObjekte[][];
	int mapsizeX;
	int mapsizeY;
	int horizontal;

	int map_array[][];

	public SpielObjekt[][] getSpielObjekte() {
		return SpielObjekte;
	}

	public void setSpielObjekte(SpielObjekt[][] spielObjekte) {
		SpielObjekte = spielObjekte;
	}

	public int getMapsizeX() {
		return mapsizeX;
	}

	public void setMapsizeX(int mapsizeX) {
		this.mapsizeX = mapsizeX;
	}

	public int getMapsizeY() {
		return mapsizeY;
	}

	public void setMapsizeY(int mapsizeY) {
		this.mapsizeY = mapsizeY;
	}

	public int getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}

	int vertical;
	ZentralLager zentralLager;

	public void addNew(int type) {

		this.add(new WohnhausOberKlasse(0, 0, false));

	}

	public Spielkarte(int sizeX, int sizeY) {

		this.mapsizeX = sizeX;
		this.mapsizeY = sizeY;
		this.horizontal = 0;
		this.vertical = 0;
		setLayout(new GridLayout(sizeX, sizeY));
		this.SpielObjekte = new SpielObjekt[this.mapsizeX][this.mapsizeX];
		this.map_array = generateLand(10);
		this.map_array = generateForrest(4);

	}

	public int[][] getMapArray() {
		return map_array;
	}

	public void setMapArray(int map_array[][]) {
		this.map_array = map_array;
	}

	public int[][] generateLand(int freq) {
		int w = getMapsizeX();
		int h = getMapsizeY();
		int map_array[][] = new int[w][h];
		for (int x = 1; x < w-3; x++) {
			for (int y = 2; y < h-3; y++) {
				if (MrIndustry.rndZahl(100) <= freq) {
					
					map_array[x][y] = 1;

				}
			}

		}

		for (int x = 4; x < w-4; x++) {
			for (int y = 4; y < h-4; y++) {
				for (int z = 0; z < freq * 5;) {
					if (x > 1 && y > 1 && x < w - 1 && y < h - 1) {
					if (map_array[x][y] == 1) {
						
							switch (MrIndustry.rndZahl(7)) {
							case 0:
								map_array[x][y + 1] = 1;
							case 1:
								map_array[x][y - 1] = 1;
							case 2:
								map_array[x + 1][y] = 1;
							case 3:
								map_array[x - 1][y] = 1;
							case 4:
								map_array[x + 1][y + 1] = 1;
							case 5:
								map_array[x - 1][y - 1] = 1;
							case 6:
								map_array[x + 1][y - 2] = 1;
								break;
							case 7:
								map_array[x - MrIndustry.rndZahl(3)][y + MrIndustry.rndZahl(3)] = 1;
								break;

							}
						}
						if (map_array[x][y] == 0) {
							
						}

					}
					break;
					// map_array[x][y+MrIndustry.rndZahl(2)] = type;
					// map_array[y+MrIndustry.rndZahl(2)][x] = type;
					// System.out.println("true");
				}

			}
		}
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (x > 0 && y > 0 && x < w - 1 && y < h - 1) {
					if (map_array[x][y] == 0) {
						if (map_array[x + 1][y] == 1) {
							map_array[x][y] = 11;
						} else if (map_array[x][y + 1] == 1) {
							map_array[x][y] = 12;
						} else if (map_array[x - 1][y] == 1) {
							map_array[x][y] = 13;
						} else if (map_array[x][y - 1] == 1) {
							map_array[x][y] = 14;
						} else if (map_array[x + 1][y] == 0
								&& map_array[x + 1][y + 1] == 1
								&& map_array[x][y + 1] == 0) {
							map_array[x][y] = 15;
						}

						else if (map_array[x - 1][y] != 1
								&& map_array[x][y + 1] != 1
								&& map_array[x - 1][y + 1] == 1) {
							map_array[x][y] = 16;
						}

						else if (map_array[x - 1][y] != 1
								&& map_array[x][y + 1] != 1
								&& map_array[x - 1][y - 1] == 1) {
							map_array[x][y] = 17;
						}

						else if (map_array[x + 1][y] != 1
								&& map_array[x + 1][y - 1] >= 1
								&& map_array[x][y - 1] != 1) {
							map_array[x][y] = 18;
						}

						else if (map_array[x - 1][y] == 1
								&& map_array[x][y - 1] == 1) {
							map_array[x][y] = 19;
						}

						if (map_array[x + 1][y] == 1
								&& map_array[x][y - 1] == 1
								&& map_array[x + 1][y - 1] == 1) {
							map_array[x][y] = 20;
						}

						if (map_array[x + 1][y] == 1
								&& map_array[x + 1][y + 1] == 1
								&& map_array[x][y + 1] == 1) {
							map_array[x][y] = 21;
						}

						if (map_array[x + 1][y] == 1
								&& map_array[x + 1][y + 1] == 1
								&& map_array[x][y + 1] == 1) {
							map_array[x][y] = 22;
						}

						/*
						 * else if (map_array[x + 1][y] == 0 && map_array[x +
						 * 1][y+1] == 0 && map_array[x][y+1] == 1) {
						 * map_array[x][y] = 18; }
						 */
						/*
						 * if (map_array[x][y] == 0) { if (map_array[x + 1][y]
						 * == 0 && map_array[x + 1][y+1] == 0 &&
						 * map_array[x][y+1] == 0) { map_array[x][y] = 15; }}
						 */
						/*
						 * if (map_array[x][y + 1] == 0) { map_array[x][y] = 12;
						 * } if (map_array[x - 1][y] == 0) { map_array[x][y] =
						 * 13; } if (map_array[x][y - 1] == 0) { map_array[x][y]
						 * = 14; } if (map_array[x - 1][y - 1] == 0) {
						 * map_array[x][y] = 15; } if (map_array[x + 1][y - 1]
						 * == 0) { map_array[x][y] = 16; } if (map_array[x +
						 * 1][y + 1] == 0) { if (map_array[x + 1][y] == 0) {
						 * map_array[x][y] = 3; } else { map_array[x][y] = 17; }
						 * } if (map_array[x - 1][y + 1] == 0) { map_array[x][y]
						 * = 18; }
						 */
					}
				}
			}
		}
		return map_array;

	}

	public int[][] generateForrest(int freq) {
		int[][][] pattern1 = new int[4][4][4];

		pattern1[0][0][0] = 1;
		pattern1[0][0][1] = 9;
		pattern1[0][0][2] = 3;
		pattern1[0][0][3] = 8;

		pattern1[0][1][0] = 1;
		pattern1[0][1][1] = 4;
		pattern1[0][1][2] = 2;
		pattern1[0][1][3] = 6;

		pattern1[0][2][0] = 1;
		pattern1[0][2][1] = 4;
		pattern1[0][2][2] = 2;
		pattern1[0][2][3] = 6;

		pattern1[0][3][0] = 1;
		pattern1[0][3][1] = 10;
		pattern1[0][3][2] = 5;
		pattern1[0][3][3] = 7;

		pattern1[1][0][0] = 9;
		pattern1[1][0][1] = 3;
		pattern1[1][0][2] = 3;
		pattern1[1][0][3] = 8;

		pattern1[1][1][0] = 4;
		pattern1[1][1][1] = 2;
		pattern1[1][1][2] = 2;
		pattern1[1][1][3] = 6;

		pattern1[1][2][0] = 10;
		pattern1[1][2][1] = 5;
		pattern1[1][2][2] = 5;
		pattern1[1][2][3] = 7;

		pattern1[1][3][0] = 1;
		pattern1[1][3][1] = 1;
		pattern1[1][3][2] = 1;
		pattern1[1][3][3] = 1;
		// int arr_pattern[][]=
		int w = getMapsizeX();
		int h = getMapsizeY();
		int map_array[][] = getMapArray();
		int possible = 0;
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {

				/*
				 * int rndw = MrIndustry.rndZahl(w); int rndh =
				 * MrIndustry.rndZahl(h);
				 */
				// map_array[x][y] = 2;
				if (MrIndustry.rndZahl(100) <= freq) {
					for (int z = 0; z < 4; z++) {
						for (int q = 0; q < 4; q++) {

							if (z + x < w && q + y < h) {
								if (map_array[z + x][q + y] == 1) {
									possible += 1;
								}
							}

							// System.out.println(possible);
							// possible = true;
							if (possible == 16) {
								// switch (MrIndustry.rndZahl(3)) {
								// case 0:
								int rnd = MrIndustry.rndZahl(3);
								for (int a = 0; a < 4; a++) {
									for (int b = 0; b < 4; b++) {
										if (a + x < w && b + y < h) {
											switch (rnd) {
											case 1:
												map_array[a + x][b + y] = pattern1[0][a][b];
												break;
											case 2:
												map_array[a + x][b + y] = pattern1[1][a][b];
												break;
											}

										}
									}
								}

								// case 1:

								// }

								// if (map_array[x-1][y-1]>0 &&
								// map_array[x-1][y-1]<3)

								// map_array[x][rndw] = 2;

								// map_array[y][rndh] = 2;

							}

						}

					}
				}
			}
			possible = 0;
		}

		return map_array;
	}

	public void add(SpielObjekt Obj) {
		this.SpielObjekte[Obj.locX][Obj.locY] = Obj;
	}

	public void newGame() {
		int[][] map_array = getMapArray();

		for (int x = 0; x < this.SpielObjekte.length; x++) {
			for (int y = 0; y < this.SpielObjekte[x].length; y++) {

				this.SpielObjekte[x][y] = new Umgebung(map_array[x][y], x, y);

			}
		}
		this.add(new Eisenmine(1, 1));
		this.add(new WohnhausOberKlasse(3, 2, false));
		this.add(new WohnhausMittelKlasse(4, 2));
		zentralLager = new ZentralLager(10, 10, false);
		this.add(zentralLager);

	}

	public void zeichneAlle(Graphics g) {

		for (int x = 0; x < this.SpielObjekte.length; x++) {
			for (int y = 0; y < this.SpielObjekte[x].length; y++) {

				this.SpielObjekte[x][y].zeichne(g, this.horizontal,
						this.vertical);
			}
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.zeichneAlle(g);
	}

}
