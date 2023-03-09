package player;

/**
 * @author Aniket Das
 */

import ai.Minimax;
import game.Board;
import game.Move;
import utils.Constants;

public class PlayerAI extends Player {
	
//	private Random random;
	private Minimax ai;

	public PlayerAI()
	{
		super(Constants.AI, Constants.HUMAN);
//		random = new Random();
		ai = new Minimax(this);
	}

	@Override
	public void generateNextMove(Board b) {
		do
		{
			System.out.println("Thinking...");
//			Move m = new Move(random.nextInt(b.getDimension()), random.nextInt(b.getDimension()));
			Move m = ai.findBestMove(b.copy());
			System.out.println("Max Depth: " + ai.getMaxDepth());
			
			if(b.isValidMove(m)) {
				this.performMove(b, m);
				break;
			}
		} while(true);
	}
}
