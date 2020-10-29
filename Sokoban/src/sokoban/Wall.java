package sokoban;

import javax.swing.ImageIcon;

public class Wall extends GameToken {
	/** The Icon for Walls */
	private static ImageIcon WallSprite = new ImageIcon(LevelManager.class.getResource("/sokoban/GreyWall .png"));
	
	protected Wall(){
		super();
		setIcon(WallSprite);
	}
	
	public void SetPosition(int XLoc, int YLoc) {
		
		 setBounds(XLoc, YLoc, WallSprite.getIconWidth(), WallSprite.getIconHeight());
	}
}
