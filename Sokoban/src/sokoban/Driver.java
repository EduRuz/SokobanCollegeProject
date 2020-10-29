package sokoban;

import java.awt.EventQueue;

public class Driver {
	/*** Launch the application */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelManager window = new LevelManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
