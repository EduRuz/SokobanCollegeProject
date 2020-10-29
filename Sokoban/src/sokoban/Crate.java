package sokoban;

import javax.swing.ImageIcon;

public class Crate extends GameToken {
	/** The Icon for the Green Crate */
	private static ImageIcon GreenCrate = new ImageIcon(LevelManager.class.getResource("/sokoban/GreenCrate.png"));
	/** The Icon for the Silver Crate */
	private static ImageIcon SilverCrate = new ImageIcon(LevelManager.class.getResource("/sokoban/SilverCrate.png"));
	/** The Icon for the Red Crate */
	private static ImageIcon RedCrate = new ImageIcon(LevelManager.class.getResource("/sokoban/RedCrate.png"));
	/** The Icon for the Brown Crate */
	private static ImageIcon BrownCrate = new ImageIcon(LevelManager.class.getResource("/sokoban/BrownCrate.png"));
	
	protected Crate(){
		super();
		setIcon(BrownCrate);
	}
	
	public void SetPosition(int XLoc, int YLoc) {
		
		 setBounds(XLoc, YLoc, BrownCrate.getIconWidth(), BrownCrate.getIconHeight());
	}
}
