package mrIndustry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mrIndustry.MrIndustry;
import mrIndustry.SpielObjekte.PrivateObjekte.WohnhausOberKlasse;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BauMenue extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel Tab_nicht_zweckm;
	private JPanel Tab_Private;
	private JSplitPane jSplitPane1;
	private JLabel lbl_img;
	private JButton btn_bauen;
	private JPanel jPanel3;
	private JPanel jPanel1;
	private JLabel lbl_kosten;
	private JLabel text_desc;
	private JPanel panel_desc;
	private JList List_Gew;
	private JPanel panel_image;
	private JPanel jPanel2;
	private JPanel Tab_Dienstleistungen;
	private JPanel Tab_Verarbeitung;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	// public static void main(String[] args) {
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// BauMenue inst = new BauMenue();
	// inst.setLocationRelativeTo(null);
	// inst.setVisible(true);
	// }
	// });
	// }

	public BauMenue(final Spielkarte map,final int ktype) {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3, "Center");
				jPanel3.setBounds(0, 0, 492, 363);
				{
					
					switch (ktype) {
					case 0:
						jPanel3.setBackground(new Color(204,204,0));
						break;
					case 1:
						jPanel3.setBackground(new Color(153,102,0));
						break;
					case 2:
						jPanel3.setBackground(new Color(102,153,255));
						break;
					case 3:
						jPanel3.setBackground(new Color(0,153,51));
						break;
					case 4:
						jPanel3.setBackground(new Color(204,204,204));
						break;
					case 5:
						jPanel3.setBackground(new Color(180,60,60));
						break;
						
						
					}
					jSplitPane1 = new JSplitPane();
					jPanel3.add(jSplitPane1);
					jSplitPane1.setBounds(12, 12, 468, 339);
					jSplitPane1.setPreferredSize(new java.awt.Dimension(468, 352));
					{
						jPanel2 = new JPanel();
						GridLayout jPanel2Layout = new GridLayout(1, 1);
						jPanel2Layout.setHgap(5);
						jPanel2Layout.setVgap(5);
						jPanel2Layout.setColumns(1);
						
						jPanel2.setLayout(jPanel2Layout);
						jSplitPane1.add(jPanel2, JSplitPane.LEFT);
						
						//jPanel2.setLayout(jPanel2Layout);
						jPanel2.setPreferredSize(new java.awt.Dimension(163, 298));
						{
							panel_image = new JPanel();
							BorderLayout panel_imageLayout = new BorderLayout();
							panel_image.setLayout(panel_imageLayout);
							jPanel2.add(panel_image);
							panel_image.setBounds(0, 128, 144, 132);
							{
								String list_text[][]=SpielObjekt.list_text;
								ListModel List_GewModel = 
									new DefaultComboBoxModel(
											list_text[ktype]);
								List_Gew = new JList();
								panel_image.add(List_Gew, BorderLayout.CENTER);
								List_Gew.setModel(List_GewModel);
								List_Gew.setBounds(0, 0, 105, 127);
								List_Gew.setPreferredSize(new java.awt.Dimension(163, 82));
								List_Gew.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent arg0) {
										
										// BauMenue.setSize(300,200);
										switch (List_Gew.getSelectedIndex()) {
										case 0:
											setTheText(SpielObjekt.arr_desc[ktype][0],
													0,ktype);
											break;
										case 1:
											setTheText(SpielObjekt.arr_desc[ktype][1],
													1,ktype);
											break;
										case 2:
											setTheText(SpielObjekt.arr_desc[ktype][2],
													2,ktype);
											break;
										case 3:
											setTheText(SpielObjekt.arr_desc[ktype][3],
													3,ktype);
											break;
											
											
											
										}
										
										// TODO Auto-generated method stub
									}
									
									public void setTheText(String desc, int btype, int ktype) {
										
										int kosten[][][] = SpielObjekt.kosten;
										
										
										text_desc
										.setText("<HTML><BODY><DIV>"
												+ desc
												+ "</DIV></BODY></HTML>");
										lbl_kosten.setText("<HTML><BODY><DIV>"
												+ "<br/><p>Kosten:</p>"
												+ "Geld:" + kosten[ktype][btype][0]
												                                 + "<br/>Nahrung:"
												                                 + kosten[ktype][btype][1]
												                                                        + "<br/>Kohle:"
												                                                        + kosten[ktype][btype][2]
												                                                                               + "<br/>Eisen:"
												                                                                               + kosten[ktype][btype][3]
												                                                                                                      + "<br/>Arbeiter/Bevölkerung:"
												                                                                                                      + kosten[ktype][btype][4]
												                                                                                                                             + "<br/>Holz:"
												                                                                                                                             + kosten[ktype][btype][5]
												                                                                                                                                                    + "</DIV></BODY></HTML>");
									}
								});
							}
							{
								jPanel1 = new JPanel();
								BorderLayout jPanel1Layout = new BorderLayout();
								jPanel1.setLayout(jPanel1Layout);
								panel_image.add(jPanel1, BorderLayout.SOUTH);
								jPanel1.setPreferredSize(new java.awt.Dimension(163, 260));
								{
									lbl_img = new JLabel();
									jPanel1.add(lbl_img, BorderLayout.SOUTH);
									lbl_img.setText("Image goes here...");
									lbl_img.setPreferredSize(new java.awt.Dimension(163, 98));
								}
							}
						}
					}
					{
						panel_desc = new JPanel();
						BoxLayout panel_descLayout = new BoxLayout(panel_desc, javax.swing.BoxLayout.Y_AXIS);
						jSplitPane1.add(panel_desc, JSplitPane.RIGHT);
						panel_desc.setPreferredSize(new java.awt.Dimension(296, 303));
						panel_desc.setLayout(panel_descLayout);
						{
							text_desc = new JLabel();
							panel_desc.add(text_desc);
							text_desc.setText("<HTML><BODY><DIV>Beschreibung</DIV></BODY></HTML>");
							text_desc.setVerticalAlignment(JLabel.TOP);
						}
						{
							lbl_kosten = new JLabel();
							panel_desc.add(lbl_kosten);
							lbl_kosten.setText("Kosten");
						}
						{
							btn_bauen = new JButton();
							panel_desc.add(btn_bauen);
							btn_bauen.setText("<HTML><BODY><H3>Auswahl Bauen");
							btn_bauen.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									System.out.println(SpielObjekt.kosten[ktype][List_Gew.getSelectedIndex()][6]);
									
									//setVisible(false);
									// TODO Auto-generated method
									// stub
									
								}
							});
						}
					}
				}
			}
			{
				
				
				
			}
			pack();
			this.setSize(508, 401);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
			
		this.zeichne(getGraphics());
	}
	
	public void zeichne(Graphics g) {
		g.drawRect(200,200,200,200);
		try {
			g.drawImage(ImageIO.read(new File("house.png")), 20,20, 20, 20,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//g.drawImage((BufferedImage) WohnhausOberKlasse.textureImages, 20,20,200,200, null);
	}

}
