package main;

/**
 * @author Aniket Das
 */

import game.GameManager;

public class Main {
	public static void main(String args[])
	{	
		GameManager manager = GameManager.getInstance();
		Thread gameThread = new Thread(manager);
		gameThread.start();
		
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
