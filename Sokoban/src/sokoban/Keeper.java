package sokoban;

import javax.swing.ImageIcon;

/**
 * A class to control the Keeper within the game
 * @author Ruaraidh Canaway
 * */
public class Keeper extends GameToken {
	/** The default icon for the Warehouse Manager */
	private static ImageIcon LookDownOrc = new ImageIcon(LevelManager.class.getResource("/sokoban/OrcDefault.png"));
	/** The Icon when the Warehouse manager is looking up */
	private static ImageIcon LookUpOrc = new ImageIcon(LevelManager.class.getResource("/sokoban/UpOrcSprite.png"));
	/** The Icon when the warehouse manager is looking left */
	private ImageIcon LookLeftOrc = new ImageIcon(LevelManager.class.getResource("/sokoban/LeftOrcSprite.png"));
	/** The Icon when the warehouse manager is looking right */
	private ImageIcon LookRightOrc = new ImageIcon(LevelManager.class.getResource("/sokoban/RightOrcSprite.png"));
	
	protected Keeper(){
		super();
		setIcon(LookDownOrc);
		
	}
	
	public void SetPosition(int XLoc, int YLoc) {
	
		 setBounds(XLoc, YLoc, LookDownOrc.getIconWidth(), LookDownOrc.getIconHeight());
	}
	
public void SpriteChange(Direction D){
	
	switch (D){
	case UP:
		setIcon(LookUpOrc);
		break;
	
	case DOWN:
		setIcon(LookDownOrc);
		break;
		
	case LEFT:
		setIcon(LookLeftOrc);
		break;
		
	case RIGHT:
		setIcon(LookRightOrc);
		break;
	}
	
}
}
