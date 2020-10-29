package sokoban;

import javax.swing.ImageIcon;

public class BackgroundImage extends GameToken {
	/** the Icon for the Grass  */
	private static ImageIcon Grass = new ImageIcon(LevelManager.class.getResource("/sokoban/Grass.jpg"));
	/** The Icon for the Lava*/
	private static ImageIcon Lava = new ImageIcon(LevelManager.class.getResource("/sokoban/Lava.jpg"));
	/** The Icon for the Floor*/
	private static ImageIcon Floor = new ImageIcon(LevelManager.class.getResource("/sokoban/Floor.png"));
	/** The Icon for the Ice*/
	private static ImageIcon Ice = new ImageIcon(LevelManager.class.getResource("/sokoban/Ice.jpg"));
	/** The Icon for the Cloud*/
	private static ImageIcon Cloud = new ImageIcon(LevelManager.class.getResource("/sokoban/Cloud.png"));
	/** The Icon for the clouds with lightning*/
	private static ImageIcon CloudwL = new ImageIcon(LevelManager.class.getResource("/sokoban/CloudLightning.png"));
	/** The Icon for the Sky*/
	private static ImageIcon Sky = new ImageIcon(LevelManager.class.getResource("/sokoban/Sky.jpg"));
	/** The Icon for the Water*/
	private static ImageIcon Water = new ImageIcon(LevelManager.class.getResource("/sokoban/Water.png"));
	
	
	protected BackgroundImage(){
		super();
		setIcon(Floor);
	}

	public void SetPosition(int XLoc, int YLoc) {
		
		 setBounds(XLoc, YLoc, Floor.getIconWidth(), Floor.getIconHeight());
	}
	
	public void ChangeIcon(char Icon){
		
		switch(Icon){
		
		case 'g':
			setIcon(Grass);
		break;
		case 'L':
			setIcon(Lava);
		break;
		case 'I':
			setIcon(Ice);
		break;
		case 'c':
			setIcon(Cloud);
		break;
		case 'l':
			setIcon(CloudwL);
		break;
		case 'y':
			setIcon(Sky);
		break;
		case 'w':
			setIcon(Water);
		break;
			
		
		}
	}
	
	public void setFloor(){
		setIcon(Floor);
	}
	public void setGrass(){
		setIcon(Grass);
	}
	public void setLava(){
		setIcon(Lava);
	}
	public void setIce(){
		setIcon(Ice);
	}
	public void setCloud(){
		setIcon(Cloud);
	}
	public void setCloudwL(){
		setIcon(CloudwL);
	}
	public void setSky(){
		setIcon(Sky);
	}
	public void setWater(){
		setIcon(Water);
	}
}

