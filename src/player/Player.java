package player;

/**
 * @author {"12620001020 - Aniket Das", "12620001110 - Ronit Das", "12620001172 - Tabassum Haque"}
 *
 * ${AI Assignment}
 */

import game.Board;
import game.Move;
import utils.Constants;

public abstract class Player {

	protected char symbol;
	protected char opponentSymbol;
	public Player(char symbol, char opponentSymbol)
	{
		this.symbol = symbol;
		this.opponentSymbol = opponentSymbol;
	}
	public Player()
	{ 
		this(Constants.BLANK, Constants.BLANK);
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	public char getOpponentSymbol()
	{
		return opponentSymbol;
	}
	
	public abstract void generateNextMove(Board b);
	protected void performMove(Board b, Move m)
	{
		b.getBoard()[m.getRow()][m.getCol()] = this.symbol;
	}
	
}
