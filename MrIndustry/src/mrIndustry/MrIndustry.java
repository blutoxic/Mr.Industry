package mrIndustry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.ScrollPaneAdjustable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import mrIndustry.SpielObjekte.ZentralLager;
import mrIndustry.SpielObjekte.Rohstoffgebaeude.Eisenmine;
import mrIndustry.SpielObjekte.PrivateObjekte.WohnhausMittelKlasse;
import mrIndustry.SpielObjekte.PrivateObjekte.WohnhausOberKlasse;

public class MrIndustry extends JPanel implements KeyListener, ActionListener,
		MouseMotionListener, MouseWheelListener, MouseListener {
	public static int textureSize = 50;
	static JFrame wnd;
	private int xVal = 0, yVal = 0;
	public Spielkarte map;
	public Graphics backBuffer;
	public Image frontBuffer;
	public JPanel actionBar;
	public JPanel actionBarSouth;
	public JPanel actionBarNorth;
	public JLabel baumenu;
	public JLabel bevoelkerung;
	public JLabel eisen;
	public JLabel kohle;
	public JLabel wood;
	public JLabel nahrung;
	public JButton btn_Gewinnung;
	public JButton btn_Verarbeitung;
	public JButton btn_Dienstleistung;
	public JButton btn_Wohngebäude;
	public JButton btn_Logistik;
	public JButton btn_Sonstiges;
	public JButton mapzentrieren;
	public int mouseX;
	public int mouseY;
	protected boolean moveWithMouse;

	public BauMenue bauMenue;
	static java.util.Random random = new java.util.Random();

	public static void main(String[] args) {

		wnd = new JFrame("MrIndustry");

		wnd.setContentPane(new MrIndustry());

	}

	// public void calcScrollbars() {
	// hbar.setValues(hbar.getValue(), 0, 0,
	// (map.mapsizeX * MrIndustry.textureSize) - wnd.getWidth());
	// vbar.setValues(vbar.getValue(), 0, 0,
	// (map.mapsizeY * MrIndustry.textureSize) - wnd.getHeight());
	// // vbar = new JScrollBar(JScrollBar.VERTICAL, 0, 0, 0, (map.mapsizeY *
	// // MrIndustry.textureSize) - wnd.getHeight());
	// }

	public MrIndustry() {

		this.mouseX = 0;
		this.mouseY = 0;
		wnd.addMouseMotionListener(this);
		wnd.addMouseWheelListener(this);
		wnd.addMouseListener(this);
		wnd.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.out.println(event);
				System.exit(0);
			}
		});
		map = new Spielkarte(20, 20);
		setLayout(new BorderLayout());
		map.newGame();

		wnd.setSize(500, 500);

		/*
		 * bauMenue = new BauMenue(map);
		 * bauMenue.setTitle("Baumenü - Wähle dein Gebäude:");
		 * bauMenue.setVisible(true);
		 */
		actionBar = new JPanel(new GridLayout(7, 1));

		actionBarSouth = new JPanel(new GridLayout(1, 5));
		actionBarNorth = new JPanel(new GridLayout(1, 2));
		baumenu = new JLabel("<HTML><BODY><H3>Baumenü:");
		mapzentrieren = new JButton("Karte Zentrieren");
		wood = new JLabel();
		bevoelkerung = new JLabel();
		eisen = new JLabel();
		kohle = new JLabel();
		wood = new JLabel();
		nahrung = new JLabel();
		btn_Gewinnung = new JButton("Gewinnung");
		btn_Verarbeitung = new JButton("Verarbeitung");
		btn_Dienstleistung = new JButton("Dienstleistung");
		btn_Wohngebäude = new JButton("Wohngebäude");
		btn_Logistik = new JButton("Logistik");
		btn_Sonstiges = new JButton("Sonstiges");
		btn_Gewinnung.addMouseListener(this);
		btn_Verarbeitung.addMouseListener(this);
		btn_Dienstleistung.addMouseListener(this);
		btn_Wohngebäude.addMouseListener(this);
		btn_Logistik.addMouseListener(this);
		btn_Sonstiges.addMouseListener(this);

		// JButton button1 = new JButton("Test");

		// actionBarSouth.ad
		wnd.add(actionBar, BorderLayout.WEST);
		actionBarSouth.add(bevoelkerung);
		actionBarSouth.add(eisen);
		actionBarSouth.add(kohle);
		actionBarSouth.add(wood);
		actionBarSouth.add(nahrung);
		actionBarNorth.add(mapzentrieren);
		actionBar.add(baumenu);
		actionBar.add(btn_Gewinnung);
		actionBar.add(btn_Verarbeitung);
		actionBar.add(btn_Dienstleistung);
		actionBar.add(btn_Wohngebäude);
		actionBar.add(btn_Sonstiges);
		actionBar.add(btn_Logistik);

		btn_Gewinnung.setBackground(new Color(204, 204, 0));
		btn_Verarbeitung.setBackground(new Color(153, 102, 0));
		btn_Dienstleistung.setBackground(new Color(102, 153, 255));
		btn_Wohngebäude.setBackground(new Color(0, 153, 51));
		btn_Sonstiges.setBackground(new Color(204, 204, 204));
		btn_Logistik.setBackground(new Color(180, 60, 60));

		wnd.add(actionBarSouth, BorderLayout.SOUTH);
		wnd.add(actionBarNorth, BorderLayout.NORTH);
		wnd.add(map, BorderLayout.CENTER);

		wnd.setVisible(true);

		this.run();

	}

	public static int rndZahl(int h) {
		return random.nextInt(h);
	}

	class MyAdjustmentListener implements AdjustmentListener {

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			if (e.getAdjustable().getOrientation() == 0) {
				map.setHorizontal(e.getValue());
			} else {
				map.setVertical(e.getValue());
			}
		}
	}

	private void run() {

		while (true) {
			this.wood.setText("" + map.zentralLager.getWood());
			for (int x = 0; x < map.SpielObjekte.length; x++) {
				for (int y = 0; y < map.SpielObjekte[x].length; y++) {
					map.SpielObjekte[x][y].tick();

				}
			}

			wnd.repaint();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void update(Graphics g) {
		super.update(g);
		map.zeichneAlle(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if ((this.textureSize - (e.getScrollAmount() * e.getWheelRotation())) >= 150) {
			this.textureSize = 149;
		} else if ((this.textureSize - (e.getScrollAmount() * e
				.getWheelRotation())) <= 20) {
			textureSize = 21;
		} else {
			this.textureSize = this.textureSize
					- (e.getScrollAmount() * e.getWheelRotation());

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String title = null;

		if (e.getSource() == btn_Gewinnung) {
			bauMenue = new BauMenue(map, 0);
			title = "Gewinnung";
			bauMenue.setTitle("Baumenü Kategorie " + title
					+ " - Wähle dein Gebäude:");
			bauMenue.setVisible(true);

		} else if (e.getSource() == btn_Verarbeitung) {
			bauMenue = new BauMenue(map, 1);
			title = "Verarbeitung";
			bauMenue.setTitle("Baumenü Kategorie " + title
					+ " - Wähle dein Gebäude:");
			bauMenue.setVisible(true);
		} else if (e.getSource() == btn_Dienstleistung) {
			bauMenue = new BauMenue(map, 2);
			title = "Dienstleistung";
			bauMenue.setTitle("Baumenü Kategorie " + title
					+ " - Wähle dein Gebäude:");
			bauMenue.setVisible(true);
		} else if (e.getSource() == btn_Wohngebäude) {
			bauMenue = new BauMenue(map, 3);
			title = "Wohngebäude";
			bauMenue.setTitle("Baumenü Kategorie " + title
					+ " - Wähle dein Gebäude:");
			bauMenue.setVisible(true);
		} else if (e.getSource() == btn_Sonstiges) {
			bauMenue = new BauMenue(map, 4);
			title = "Sonstiges";
			bauMenue.setTitle("Baumenü Kategorie " + title
					+ " - Wähle dein Gebäude:");
			bauMenue.setVisible(true);
		} else if (e.getSource() == btn_Logistik) {
			bauMenue = new BauMenue(map, 5);
			title = "Logistik";
			bauMenue.setTitle("Baumenü Kategorie " + title
					+ " - Wähle dein Gebäude:");
			bauMenue.setVisible(true);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 2 || e.getButton() == 1) {
			this.moveWithMouse = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (e.getButton() == 2 || e.getButton() == 1) {
			this.moveWithMouse = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (this.moveWithMouse) {
			map.setHorizontal(map.getHorizontal() + (1 * (mouseX - e.getX())));

			map.setVertical(map.getVertical() + (1 * (mouseY - e.getY())));

		}
		mouseX = e.getX();
		mouseY = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		xVal = ((map.getHorizontal() + e.getX() - actionBar.getWidth()) - 8)
				/ textureSize;
		yVal = ((map.getVertical() + e.getY()) - (actionBarNorth.getHeight()) - 30)
				/ textureSize;
		int sizeX = (map.getMapsizeX()) * textureSize;
		int sizeY = (map.getMapsizeY()) * textureSize;
		if ((e.getX()) < sizeX && (e.getY()) < sizeY) {
			for (int x = 0; x < map.getSpielObjekte().length; x++) {
				for (int y = 0; y < map.getSpielObjekte().length; y++) {
					map.SpielObjekte[x][y].setHighlight(false);
				}
			}

			if (xVal < map.getMapsizeY() && xVal >= 0
					&& yVal < map.getMapsizeX() && yVal >= 0) {
				map.SpielObjekte[xVal][yVal].setHighlight(true);
			}
		}
	}
}
