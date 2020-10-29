package sokoban;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import uk.org.asch.swing.GridPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelManager {
	/** The custom panel used to display the grid and its contents */
	protected static GridPanel pnlDisplay;
	/** The main frame for the application */
	public JFrame frmInterface;
	/** Grid for managing the game icons */
	private static Level gamegrid;
	/**The integer to keep track of how many moves the user has made in one game*/
	private static int Count = 0;
	/** The label to display the move counter to the user */
	private static JLabel lblCounter;
	/** The integer to control what level is loaded when the restart level button is pressed */
	public static int LevelNo;
	/** The 2D array of characters for the text file to be stored as*/
	private static char[][] charGrid;
	/** The Character the Player controls*/
	private static Keeper keeper;
	
	public LevelManager(){
		initialize();
		StartUp();

		KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		kfm.addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
						keeper.SpriteChange(Direction.UP);
						gamegrid.MoveSprite(Direction.UP, keeper);
						return true;
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
						keeper.SpriteChange(Direction.DOWN);
						gamegrid.MoveSprite(Direction.DOWN, keeper);
						return true;
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
						keeper.SpriteChange(Direction.LEFT);
						gamegrid.MoveSprite(Direction.LEFT, keeper);
						return true;
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
						keeper.SpriteChange(Direction.RIGHT);
						gamegrid.MoveSprite(Direction.RIGHT, keeper);
						return true;
					}
				}
				return false;
			}
		});
	}
	/*** Initialize the contents of the frame.*/
	private void initialize() {
		frmInterface = new JFrame();
		frmInterface.setBounds(100, 100, 680, 560);
		frmInterface.setTitle("Sokoban!");
		frmInterface.setIconImage(
				Toolkit.getDefaultToolkit().getImage(LevelManager.class.getResource("/sokoban/OrcfrmIcon.png")));
		frmInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInterface.getContentPane().setLayout(null);

		pnlDisplay = new GridPanel(new Dimension(15, 15), new Dimension(30, 30),
				"/sokoban/GridImageRed.jpg");
		pnlDisplay.setBounds(188, 44, 466, 466);
		frmInterface.getContentPane().add(pnlDisplay);

		lblCounter = new JLabel("0");
		lblCounter.setIcon(null);
		lblCounter.setBounds(586, 19, 40, 14);
		frmInterface.getContentPane().add(lblCounter);

		JLabel lblCounterText = new JLabel("Moves:");
		lblCounterText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCounterText.setBounds(530, 19, 46, 14);
		frmInterface.getContentPane().add(lblCounterText);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDisplay.removeAll();
				pnlDisplay.updateUI();
				gamegrid.Reset();
				CounterReset();
				LevelNo = 1;	
				
				try {
					gamegrid.LoadLevel(LevelNo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewGame.setBounds(10, 7, 168, 23);
		frmInterface.getContentPane().add(btnNewGame);

		JButton btnLevel2 = new JButton("Level 2");
		btnLevel2.setEnabled(false);
			btnLevel2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pnlDisplay.removeAll();
					pnlDisplay.updateUI();
					gamegrid.Reset();
					CounterReset();
					LevelNo = 2;
					
					try {
						gamegrid.LoadLevel(LevelNo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
		
		btnLevel2.setBounds(38, 69, 140, 23);
		frmInterface.getContentPane().add(btnLevel2);

		JButton btnLevel3 = new JButton("Level 3");
		btnLevel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDisplay.removeAll();
				pnlDisplay.updateUI();
				gamegrid.Reset();
				CounterReset();
				LevelNo = 3;
				
				try {
					gamegrid.LoadLevel(LevelNo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLevel3.setEnabled(false);
		btnLevel3.setBounds(38, 103, 140, 23);
		frmInterface.getContentPane().add(btnLevel3);

		JButton btnLevel4 = new JButton("Level 4");
		btnLevel4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDisplay.removeAll();
				pnlDisplay.updateUI();
				gamegrid.Reset();
				CounterReset();
				LevelNo = 4;
				
				try {
					gamegrid.LoadLevel(LevelNo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLevel4.setEnabled(false);
		btnLevel4.setBounds(38, 137, 140, 23);
		frmInterface.getContentPane().add(btnLevel4);

		JButton btnLevel5 = new JButton("Level 5");
		btnLevel5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pnlDisplay.removeAll();
				pnlDisplay.updateUI();
				gamegrid.Reset();
				CounterReset();
				LevelNo = 5;
				
				try {
					gamegrid.LoadLevel(LevelNo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLevel5.setBounds(38, 171, 140, 23);
		btnLevel5.setEnabled(false);
		frmInterface.getContentPane().add(btnLevel5);

		JButton btnRestart = new JButton("Restart Level");
		btnRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDisplay.removeAll();
				pnlDisplay.updateUI();
				
				switch (LevelNo){
					
				case 1:
					//try {
						//Level1 NewGame = new Level1();
						//NewGame.CreateLevel1();
					//} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						//}
					break;
				case 2:
//					//Level2 Level2 = new Level2();
//					try {
//					//Level2.CreateLevel2();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//				}
					break;
					
				case 3:
//					//Level3 level3 = new Level3();
//					try {
//					//level3.CreateLevel3();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//				}
					break;
					
				case 4:
//					//Level4 level4 = new Level4();
//					try {
//					//level4.CreateLevel4();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//				}
					break;
					
				case 5:
//					//Level5 level5 = new Level5();
//					try {
//					//level5.CreateLevel5();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//				}
					break;
				}
			}
		});
		btnRestart.setBounds(188, 7, 168, 23);
		frmInterface.getContentPane().add(btnRestart);

		JLabel lblLevelSelection = new JLabel("Level Selection");
		lblLevelSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelection.setBounds(10, 44, 103, 14);
		frmInterface.getContentPane().add(lblLevelSelection);

		JButton btnLvl2Lock = new JButton("");
		btnLvl2Lock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Input = JOptionPane.showInputDialog("Please Enter the password for level 2");
				String Password = "jackesmuchohomo";
				if (Input.equals(Password)) {
					btnLevel2.setEnabled(true);
					btnLvl2Lock.setEnabled(false);
				}
				
			}
		});
		btnLvl2Lock.setBounds(10, 69, 26, 23);
		btnLvl2Lock.setIcon(new ImageIcon(LevelManager.class.getResource("/sokoban/lock2.png")));
		frmInterface.getContentPane().add(btnLvl2Lock);

		JButton btnLvl3Lock = new JButton("");
		btnLvl3Lock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Input = JOptionPane.showInputDialog("Please Enter the password for level 2");
				String Password = "chub";
				if (Input.equals(Password)) {
					btnLevel2.setEnabled(true);
					btnLevel3.setEnabled(true); 
					btnLvl2Lock.setEnabled(false);
					btnLvl3Lock.setEnabled(false);
				}
			}
		});
		btnLvl3Lock.setIcon(new ImageIcon(LevelManager.class.getResource("/sokoban/lock2.png")));
		btnLvl3Lock.setBounds(10, 103, 26, 23);
		frmInterface.getContentPane().add(btnLvl3Lock);

		JButton btnLvl4Lock = new JButton("");
		btnLvl4Lock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Input = JOptionPane.showInputDialog("Please Enter the password for level 2");
				String Password = "pugut";
				if (Input.equals(Password)) {
					btnLevel2.setEnabled(true);
					btnLevel3.setEnabled(true);
					btnLevel4.setEnabled(true);
					
					btnLvl2Lock.setEnabled(false);
					btnLvl3Lock.setEnabled(false);
					btnLvl4Lock.setEnabled(false);
				}
			}
		});
		btnLvl4Lock.setIcon(new ImageIcon(LevelManager.class.getResource("/sokoban/lock2.png")));
		btnLvl4Lock.setBounds(10, 137, 26, 23);
		frmInterface.getContentPane().add(btnLvl4Lock);

		JButton btnLvl5Lock = new JButton("");
		btnLvl5Lock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Input = JOptionPane.showInputDialog("Please Enter the password for level 2");
				String Password = "somethingclever";
				if (Input.equals(Password)) {
					btnLevel2.setEnabled(true);
					btnLevel3.setEnabled(true);
					btnLevel4.setEnabled(true);
					btnLevel5.setEnabled(true);
					
					btnLvl2Lock.setEnabled(false);
					btnLvl3Lock.setEnabled(false);
					btnLvl4Lock.setEnabled(false);
					btnLvl5Lock.setEnabled(false);
				}
			}
		});
		btnLvl5Lock.setIcon(new ImageIcon(LevelManager.class.getResource("/sokoban/lock2.png")));
		btnLvl5Lock.setBounds(10, 171, 26, 23);
		frmInterface.getContentPane().add(btnLvl5Lock);
		
		JLabel lblControls = new JLabel("Controls:");
		lblControls.setBounds(10, 218, 111, 14);
		frmInterface.getContentPane().add(lblControls);
		
		JLabel lblNewLabel = new JLabel("Up -      Up Arrow or W");
		lblNewLabel.setBounds(10, 243, 168, 14);
		frmInterface.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Down - Down Arrow or S");
		lblNewLabel_1.setBounds(10, 268, 168, 14);
		frmInterface.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Left -    Left Arrow or A");
		lblNewLabel_2.setBounds(10, 293, 168, 14);
		frmInterface.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Right -  Right Arrow or D");
		lblNewLabel_3.setBounds(10, 318, 168, 14);
		frmInterface.getContentPane().add(lblNewLabel_3);
		frmInterface.setVisible(true);
	}
	
	/** The intro screen Method*/
	private void StartUp(){
		gamegrid = new Level(pnlDisplay);
		LevelNo = new Integer(LevelNo);
		keeper = new Keeper();
		Point Loc = gamegrid.convert(7, 7);
		keeper.SetPosition(Loc.x, Loc.y);
		pnlDisplay.add(keeper);
		pnlDisplay.repaint();
	}
	
	/** Keeps track of how many moves the user has made */
	private static void Counter() {
		String Counter = "";
		Count++;
		Counter = Integer.toString(Count);
		lblCounter.setText(Counter);
	}
	
	/** Resets the counter to zero*/
	private void CounterReset(){
		String Counter = "";
		Count = 0;
		Counter = Integer.toString(Count);
		lblCounter.setText(Counter);		
	}
	
	/**Returns the current level integer*/
	public static int LevelCheck(){
		return LevelNo;
		}
	
	/** Displays Message to screen when level has been completed */
	public static void LevelWin(){
		ImageIcon level1Win = new ImageIcon(LevelManager.class.getResource("/sokoban/Level1Complete.png"));
		ImageIcon level2Win = new ImageIcon(LevelManager.class.getResource("/sokoban/Level2Complete.png"));
		ImageIcon level3Win = new ImageIcon(LevelManager.class.getResource("/sokoban/Level3Complete.png"));
		ImageIcon level4Win = new ImageIcon(LevelManager.class.getResource("/sokoban/Level4Complete.png"));
		ImageIcon level5Win = new ImageIcon(LevelManager.class.getResource("/sokoban/Level5Complete.png"));
		ImageIcon Congrats = new ImageIcon(LevelManager.class.getResource("/sokoban/Congratulations.png"));
		Dimension TitleSize = new Dimension(level3Win.getIconWidth(), level3Win.getIconHeight());
		JLabel Congratz = new JLabel("");
		JLabel Icon = new JLabel("");
		switch(LevelNo){
		case 1:	//Icon = gamegrid.AddSprite(1, 2, level1Win, TitleSize);
				//Congratz = gamegrid.AddSprite(1, 10, Congrats, TitleSize);
				pnlDisplay.add(Icon,0);
				pnlDisplay.add(Congratz,0);
			break;
		case 2:	//Icon = gamegrid.AddSprite(1, 2, level2Win, TitleSize);
				//Congratz = gamegrid.AddSprite(1, 10, Congrats, TitleSize);
				pnlDisplay.add(Icon,0);
				pnlDisplay.add(Congratz,0);
			break;
		case 3:	//Icon = gamegrid.AddSprite(1, 2, level3Win, TitleSize);
				//Congratz = gamegrid.AddSprite(1, 10, Congrats, TitleSize);
				pnlDisplay.add(Icon,0);
				pnlDisplay.add(Congratz,0);
			break;
		case 4:	//Icon = gamegrid.AddSprite(1, 2, level4Win, TitleSize);
				//Congratz = gamegrid.AddSprite(1, 10, Congrats, TitleSize);
				pnlDisplay.add(Icon,0);
				pnlDisplay.add(Congratz,0);
			break;
		case 5:	//Icon = gamegrid.AddSprite(1, 2, level5Win, TitleSize);
				//Congratz = gamegrid.AddSprite(1, 10, Congrats, TitleSize);
				pnlDisplay.add(Icon,0);
				pnlDisplay.add(Congratz,0);
			break;
		}
		pnlDisplay.repaint();
	}

	/** Takes the text file string array and converts it to a 2 dimensional array of Chars then adds images to the screen 
	 * depending on what chars are in the text file **/
	public static void ReadFileContents(String[] Data) {
		
		int height = Data.length;
		int width = Data[0].length();
		charGrid = new char[height][];
		pnlDisplay.removeAll();
		pnlDisplay.updateUI();
		
		for (int i = 0; i < height; i++) {
			charGrid[i] = Data[i].toCharArray();
			for (int j = 0; j < width; j++) {
			
				Point Loc = gamegrid.convert(j, i);
				
				BackgroundImage floortest = new BackgroundImage();
				floortest.setFloor();
				
				
				switch (charGrid[i][j]) {
				
				case 'W':
					Wall wall = new Wall();
					wall.SetPosition(Loc.x, Loc.y);
					if (wall != null) {
						wall = gamegrid.addWall(wall, j, i);
						pnlDisplay.add(wall);		
					}
				break;
				case 's':
					BackgroundImage floor = new BackgroundImage();
					floor.setFloor();
 					//floor.SetPosition(Loc.x, Loc.y);
 					//pnlDisplay.add(floor);
 					
					floortest.SetPosition(Loc.x, Loc.y);
 					pnlDisplay.add(floortest);
 					
					
				break;
				case 'S':
					BackgroundImage floor2 = new BackgroundImage();
					keeper.SetPosition(Loc.x, Loc.y);
					floor2.setFloor();
					//floor2.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(keeper,0);
					//pnlDisplay.add(floor2);
					floortest.SetPosition(Loc.x, Loc.y);
 					pnlDisplay.add(floortest);
					
				break;
				case 'C':
					Crate crate = new Crate();
					BackgroundImage floor4 = new BackgroundImage();
					crate.SetPosition(Loc.x, Loc.y);
					//floor4.setFloor();
					//floor4.SetPosition(Loc.x, Loc.y);
					//pnlDisplay.add(floor4);
					crate = gamegrid.addCrate(crate, j, i);
					pnlDisplay.add(crate,1);
					floortest.SetPosition(Loc.x, Loc.y);
 					pnlDisplay.add(floortest);
				break;
				case 'D':
					Diamond diamond = new Diamond();
					BackgroundImage floor3 = new BackgroundImage();
					diamond.SetPosition(Loc.x, Loc.y);
					floor3.setFloor();
					floor3.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(floor3);
					pnlDisplay.add(diamond,8);
					
				break;
				case 'g':
					BackgroundImage grass = new BackgroundImage();
					grass.setGrass();
					grass.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(grass);
					
				break;
				case 'L':
					BackgroundImage Lava = new BackgroundImage();
					Lava.setLava();
					Lava.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(Lava);
					
				break;
				case 'I':
					BackgroundImage Ice = new BackgroundImage();
					Ice.setIce();
					Ice.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(Ice);
					
				break;
				case 'c':
					BackgroundImage Cloud = new BackgroundImage();
					Cloud.setCloud();
					Cloud.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(Cloud);
					
				break;
				case 'l':
					BackgroundImage CloudL = new BackgroundImage();
					CloudL.setCloudwL();
					CloudL.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(CloudL);
				break;
				case 'y':
					BackgroundImage sky = new BackgroundImage();
					sky.setSky();
					sky.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(sky);
				break;
				case 'w':
					BackgroundImage Water = new BackgroundImage();
					Water.setWater();
					Water.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(Water);

				break;
				case 'i':
					BackgroundImage Cloud2 = new BackgroundImage();
					BackgroundImage Sky2 = new BackgroundImage();
					Cloud2.setCloud();
					Sky2.setSky();
					Cloud2.SetPosition(Loc.x, Loc.y);
					Sky2.SetPosition(Loc.x, Loc.y);
					pnlDisplay.add(Cloud2);
					pnlDisplay.add(Sky2);
				break;
				}
				pnlDisplay.repaint();
			}
		}
	}
}
