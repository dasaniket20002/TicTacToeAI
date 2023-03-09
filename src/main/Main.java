package main;

/**
 * @author {"12620001020 - Aniket Das", "12620001110 - Ronit Das", "12620001172 - Tabassum Haque"}
 *
 * ${AI Assignment}
 */

import game.GameManager;

public class Main {
	public static void main(String args[])
	{
		System.out.println("Authors: \n 12620001020 - Aniket Das \n 12620001110 - Ronit Das \n 12620001172 - Tabassum Haque");
		
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
