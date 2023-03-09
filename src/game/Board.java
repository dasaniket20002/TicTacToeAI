package game;

/**
 * @author Aniket Das
 */
import utils.Constants;

public class Board {

	private int dimension;
	private char[][] board;
	
	private char winner;
	
	public Board() { 
		dimension = Constants.BOARD_SIZE;
		board = new char[dimension][dimension];
		winner = Constants.BLANK;
		for(int i = 0; i < dimension; i++)
			for(int j = 0; j < dimension; j++)
				board[i][j] = Constants.BLANK;
	}
	public Board (Board b)
	{
		dimension = b.dimension;
		board = new char[dimension][dimension];
		winner = b.winner;
		for(int i = 0; i < dimension; i++)
			for(int j = 0; j < dimension; j++)
				this.board[i][j] = b.board[i][j];
	}
	
	public char[][] getBoard(){
		return board;
	}
	public int getDimension() {
		return dimension;
	}
	public char getWinner(){
		return winner;
	}
	public Board copy()
	{
		return new Board(this);
	}
	
	public boolean isValidMove(Move m)
	{
		return board[m.getRow()][m.getCol()] == Constants.BLANK;
	}
	public boolean areMovesLeft()
	{
		for(int i = 0; i < dimension; i++)
			for(int j = 0; j < dimension; j++)
				if(board[i][j] == Constants.BLANK) return true;
		return false;
	}
	private void tryFindWinner()
	{
		//Diagonal Check
		boolean dia_fl = true;
		outer: for(int i = 0; i < dimension; i++)
		{
			for(int j = 0; j < dimension; j++)
			{
				if(i == j) {
					if(board[i][j] != board[0][0]) {
						dia_fl = false;
						break outer;
					}
				}
			}
		}
		if(dia_fl) {
			winner = board[0][0];
			return;
		}
		
		boolean dia_fr = true;
		outer: for(int i = 0; i < dimension; i++)
		{
			for(int j = 0; j < dimension; j++)
			{
				if(i + j == dimension - 1) {
					if(board[i][j] != board[0][dimension - 1]) {
						dia_fr = false;
						break outer;
					}
				}
			}
		}
		if(dia_fr) {
			winner = board[0][dimension - 1];
			return;
		}
		
		//Row Check
		for(int i = 0; i < dimension; i++)
		{
			boolean row_f = true;
			for(int j = 0; j < dimension; j++)
			{
				if(board[i][j] != board[i][0]) {
					row_f = false;
					break;
				}
			}
			if(row_f)
			{
				winner = board[i][0];
				return;
			}
		}
		
		//Column Check
		for(int i = 0; i < dimension; i++)
		{
			boolean col_f = true;
			for(int j = 0; j < dimension; j++)
			{
				if(board[j][i] != board[0][i]) {
					col_f = false;
					break;
				}
			}
			if(col_f)
			{
				winner = board[0][i];
				return;
			}
		}
	}
	
	public boolean isGameOver()
	{
		tryFindWinner();
		return winner != Constants.BLANK;
	}
	
	public void displayBoard()
	{
		System.out.println();
		System.out.println("Board: ");
		for(int i = 0; i < dimension; i++)
		{
			for(int j = 0; j < dimension; j++)
			{
				System.out.print(" | " + board[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
}
