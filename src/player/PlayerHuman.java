package player;

/**
 * @author {"12620001020 - Aniket Das", "12620001110 - Ronit Das", "12620001172 - Tabassum Haque"}
 *
 * ${AI Assignment}
 */

import java.util.Scanner;

import game.Board;
import game.Move;
import utils.Constants;

public class PlayerHuman extends Player {
	
	private Scanner sc;

	public PlayerHuman()
	{
		super(Constants.HUMAN, Constants.AI);
		sc = new Scanner(System.in);
	}
	
	@Override
	public void generateNextMove(Board b) {
		do
		{
			System.out.print("Enter the row and coloumn number to put move: ");
			Move m = new Move(sc.nextInt(), sc.nextInt());
			if(!m.validateMove()) continue;
			
			if(b.isValidMove(m)) {
				this.performMove(b, m);
				break;
			}
		} while(true);
	}
	
}
