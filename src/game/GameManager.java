package game;

/**
 * @author Aniket Das
 */

import player.Player;
import player.PlayerAI;
import player.PlayerHuman;
import utils.Constants;

public class GameManager implements Runnable {

	private static GameManager instance = null;
	public static GameManager getInstance()
	{
		if(instance == null) instance = new GameManager();
		return instance;
	}
	
	private Board board;
	private Player human;
	private Player ai;
	
	public GameManager() {
		init();
	}
	
	public void init() {
		board = new Board();
		human = new PlayerHuman();
		ai = new PlayerAI();
	}
	
	@Override
	public void run()
	{
		while(board.areMovesLeft())
		{
			board.displayBoard();
			
			human.generateNextMove(board);
			if(board.isGameOver()) 
			{
				board.displayBoard();
				System.out.println("Winner: " + board.getWinner());
				break;
			}
			
			if(!board.areMovesLeft()) break;
			
			ai.generateNextMove(board);
			if(board.isGameOver()) 
			{
				board.displayBoard();
				System.out.println("Winner: " + board.getWinner());
				break;
			}
		}
		if(!board.areMovesLeft() && board.getWinner() == Constants.BLANK)
		{
			System.out.println("Draw");
		}
	}
}
