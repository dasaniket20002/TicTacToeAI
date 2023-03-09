package game;

/**
 * @author {"12620001020 - Aniket Das", "12620001110 - Ronit Das", "12620001172 - Tabassum Haque"}
 *
 * ${AI Assignment}
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
