package sokoban;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import uk.org.asch.swing.GridPanel;

public class Level {
	/** Creates the grid that sits on the panel*/
	private GridPanel gridpanel;
	
	private GameToken[][] Grid;
	
	private boolean[][] IsWall;
	
	private boolean[][] IsCrate;
	
	public Level(GridPanel gridpanel){
		this.gridpanel = gridpanel;
		this.Grid = new GameToken[gridpanel.getGridSize().height][gridpanel.getGridSize().width];
		this.IsWall = new boolean[gridpanel.getGridSize().height][gridpanel.getGridSize().width];
		this.IsCrate = new boolean[gridpanel.getGridSize().height][gridpanel.getGridSize().width];
	}
	
	public void Reset (){
		
	}
	/** Converts the passed Point*/
	public Point convert(int Xloc, int Yloc){
		Point GridP = new Point(Xloc,Yloc);
		Point Location = gridpanel.convertFromLogical(GridP);
		return Location;
	}
	
	public Wall addWall(Wall wall, int Xloc, int Yloc){
		Point GridPoint = new Point(Xloc, Yloc);
		this.Grid[GridPoint.y][GridPoint.x] = wall;
		this.IsWall[Yloc][Xloc] = true;
		return wall;
	}
	
	public Crate addCrate(Crate crate, int Xloc, int Yloc){
		Point GridPoint = new Point(Xloc, Yloc);
		this.Grid[GridPoint.y][GridPoint.x] = crate;
		this.IsCrate[Yloc][Xloc] = true;
		return crate;
	}
	
	public void MoveSprite(Direction d, Keeper keeper){
		
		Point p = gridpanel.convertFromPhysical(keeper.getLocation());
		Point q = getLocation(p,d);
		Point z = getLocation(q,d);
		
		if (q!= null){
			if (this.IsWall[q.y][q.x] == true){
				return;
			}
			else if (this.IsCrate[q.y][q.x] == true && 
					 this.IsCrate[z.y][z.x] == false && 
					 this.IsWall[z.y][z.x] == false){
				moveCrate(q,d);
				keeper.setLocation(gridpanel.convertFromLogical(q));
			}
			else {
				keeper.setLocation(gridpanel.convertFromLogical(q));// when crate is moved on top of a diamond in level 1, you can then step on the crate
		}
	}
}

	public void moveCrate(Point p, Direction d){
		 
		Point q = getLocation(p,d);
		Point z = gridpanel.convertFromLogical(q);
		
		Grid[p.y][p.x].setLocation(z);
		Grid[q.y][q.x] = Grid[p.y][p.x];
		IsCrate[p.y][p.x] = false;
		IsCrate[q.y][q.x] = true;
	}
	/** To get new location for the warehouse keeper after input to move */
	private Point getLocation(Point p, Direction d){
	    Point q = null;
	    switch (d) {
	    case UP:
	        if (p.y > 0) {
	            q = new Point(p.x, p.y - 1);
	        }
	        break;
	    case DOWN:
	         
	            q = new Point(p.x, p.y + 1);
	        
	        break;
	    case LEFT:
	        if (p.x > 0) {
	            q = new Point(p.x - 1, p.y);
	        }
	        break;
	    case RIGHT:
	         
	            q = new Point(p.x + 1, p.y);
	    }
	    return q;
	}

	public void LoadLevel(int LevelNo) throws FileNotFoundException, IOException{
		String FileName = "";
		switch(LevelNo){
		
		case 1:
			FileName = "src/sokoban/Level1.txt";
			File DataFile = new File(FileName);
			String Data[] = ReadFile(DataFile);
			LevelManager.ReadFileContents(Data);
			break;
		case 2:
			FileName = "src/sokoban/Level2.txt";
			File DataFile2 = new File(FileName);
			String Data2[] = ReadFile(DataFile2);
			LevelManager.ReadFileContents(Data2);
			break;
		case 3:
			FileName = "src/sokoban/Level3.txt";
			File DataFile3 = new File(FileName);
			String Data3[] = ReadFile(DataFile3);
			LevelManager.ReadFileContents(Data3);
			break;
		case 4:
			FileName = "src/sokoban/Level4.txt";
			File DataFile4 = new File(FileName);
			String Data4[] = ReadFile(DataFile4);
			LevelManager.ReadFileContents(Data4);
			break;
		case 5:
			FileName = "src/sokoban/Level5.txt";
			File DataFile5 = new File(FileName);
			String Data5[] = ReadFile(DataFile5);
			LevelManager.ReadFileContents(Data5);
			break;
		}
	}
	
	/**Reads the text file and converts it to an array of Strings*/
	public static String[] ReadFile(File DataFile) throws FileNotFoundException, IOException{

		ArrayList<String> FileContents = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(DataFile))) {
	        String line = br.readLine();
	        while (line != null) {
	            FileContents.add(line);
	            line = br.readLine();
	        }
	    }
		String[] Data = FileContents.toArray(new String[0]);
		return Data;
	}
}
