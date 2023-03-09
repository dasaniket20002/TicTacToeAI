package game;

/**
 * @author Aniket Das
 */

import utils.Constants;

public class Move
{
	private int row, col;
	
	public Move(int r, int c)
	{
		this.row = r;
		this.col = c;
	}

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	
	public boolean validateMove()
	{
		return row >= 0 && row < Constants.BOARD_SIZE && col >= 0 && col < Constants.BOARD_SIZE; 
	}
	
}
