package sokoban;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**Try making the background images gametokens, 
 * GameToken.setIcon(pass the char at char grid location
 * GameToken.SetPosition*/


public class GameToken extends JLabel {

	/** The Icon for the Floor*/
	private ImageIcon Floor = new ImageIcon(LevelManager.class.getResource("/sokoban/Floor.png"));
	
	protected GameToken(){
		super("");
	}
	
	public void SetPosition(int Xloc, int Yloc){
		
		 setBounds(Xloc, Yloc, Floor.getIconWidth(), Floor.getIconHeight());
	}
}
