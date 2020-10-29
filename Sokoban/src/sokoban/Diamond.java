package sokoban;

import javax.swing.ImageIcon;

public class Diamond extends GameToken {
	/** The Icon for the Diamonds */
	private static ImageIcon Diamond = new ImageIcon(LevelManager.class.getResource("/sokoban/Diamond.png"));
	
	protected Diamond(){
		super();
		setIcon(Diamond);
	}
	
	public void SetPosition(int XLoc, int YLoc) {
		
		 setBounds(XLoc, YLoc, Diamond.getIconWidth(), Diamond.getIconHeight());
	}
}
