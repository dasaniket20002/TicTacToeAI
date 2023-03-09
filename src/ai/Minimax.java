package ai;

/**
 * @author {"12620001020 - Aniket Das", "12620001110 - Ronit Das", "12620001172 - Tabassum Haque"}
 *
 * ${AI Assignment}
 */

import game.Board;
import game.Move;
import player.Player;
import utils.Constants;

public class Minimax {
	
	private Player player;
	private int maxDepth;
	
	public Minimax(Player player)
	{
		this.player = player;
		this.maxDepth = 0;
	}
	
	private int evaluate(Board b)
	{
		// Checking for Rows
	    for (int i = 0; i < b.getDimension(); i++)
	    {
	        boolean row_f = true;
	        for(int j = 0; j < b.getDimension(); j++)
	        {
	        	if(b.getBoard()[i][j] != b.getBoard()[i][0]) {
					row_f = false;
					break;
				}
	        }
	        if(row_f)
	        {
	        	if (b.getBoard()[i][0] == player.getSymbol())
	                return +10;
	            else if (b.getBoard()[i][0] == player.getOpponentSymbol())
	                return -10;
	        }
	    }
	 
	    // Checking for Columns for X or O victory.
	    for (int i = 0; i < b.getDimension(); i++)
	    {
	        boolean col_f = true;
	        for(int j = 0; j < b.getDimension(); j++)
	        {
	        	if(b.getBoard()[j][i] != b.getBoard()[0][i]) {
					col_f = false;
					break;
				}
	        }
	        if(col_f)
	        {
	        	if (b.getBoard()[0][i] == player.getSymbol())
	                return +10;
	            else if (b.getBoard()[0][i] == player.getOpponentSymbol())
	                return -10;
	        }
	    }
	 
	    // Checking for Diagonals for X or O victory.
	    boolean dia_f = true;
	    outer: for(int i = 0; i < b.getDimension(); i++)
		{
			for(int j = 0; j < b.getDimension(); j++)
			{
				if(i == j) {
					if(b.getBoard()[i][j] != b.getBoard()[0][0]) {
						dia_f = false;
						break outer;
					}
				}
			}
		}
	    if(dia_f)
	    {
	    	if (b.getBoard()[0][0] == player.getSymbol())
	            return +10;
	        else if (b.getBoard()[0][0] == player.getOpponentSymbol())
	            return -10;
	    }
	    
	    dia_f = true;
	    outer: for(int i = 0; i < b.getDimension(); i++)
		{
			for(int j = 0; j < b.getDimension(); j++)
			{
				if(i + j == b.getDimension() - 1) {
					if(b.getBoard()[i][j] != b.getBoard()[0][b.getDimension() - 1]) {
						dia_f = false;
						break outer;
					}
				}
			}
		}
	    if(dia_f)
	    {
	    	if (b.getBoard()[0][b.getDimension() - 1] == player.getSymbol())
	            return +10;
	        else if (b.getBoard()[0][b.getDimension() - 1] == player.getOpponentSymbol())
	            return -10;
	    }
	    
	    return 0;
	}
	 
	private int minimax(Board board, int depth, boolean isMax)
	{
	    int score = evaluate(board);
	 
	    // If Maximizer has won the game
	    // return his/her evaluated score
	    if (score == 10)
	        return score;
	 
	    // If Minimizer has won the game
	    // return his/her evaluated score
	    if (score == -10)
	        return score;
	 
	    // If there are no more moves and
	    // no winner then it is a tie
	    if (!board.areMovesLeft())
	        return 0;
	    else if(board.isGameOver())
	    	return 0;
	    
	    if(depth > maxDepth) maxDepth = depth;
	    
	    if (isMax)
	    {
	        int best = Integer.MIN_VALUE;
	        for (int i = 0; i < board.getDimension(); i++)
	        {
	            for (int j = 0; j < board.getDimension(); j++)
	            {
	                if (board.getBoard()[i][j] == Constants.BLANK)
	                {
	                    board.getBoard()[i][j] = player.getSymbol();
	                    
	                    best = Math.max(best, minimax(board, depth + 1, !isMax));
	                    board.getBoard()[i][j] = Constants.BLANK;
	                }
	            }
	        }
	        return best;
	    }
	    else
	    {
	        int best = Integer.MAX_VALUE;
	        for (int i = 0; i < board.getDimension(); i++)
	        {
	            for (int j = 0; j < board.getDimension(); j++)
	            {
	                if (board.getBoard()[i][j] == Constants.BLANK)
	                {
	                    board.getBoard()[i][j] = player.getOpponentSymbol();
	                    
	                    best = Math.min(best, minimax(board, depth + 1, !isMax));
	                    board.getBoard()[i][j] = Constants.BLANK;
	                }
	            }
	        }
	        return best;
	    }
	}
	public Move findBestMove(Board board)
	{
	    int bestVal = Integer.MIN_VALUE;
	    Move bestMove = null;
	    maxDepth = 0;
	    
	    for (int i = 0; i < board.getDimension(); i++)
	    {
	        for (int j = 0; j < board.getDimension(); j++)
	        {
	            if (board.getBoard()[i][j] == Constants.BLANK)
	            {
	                board.getBoard()[i][j] = player.getSymbol();
	                int moveVal = minimax(board, 0, false);

	                board.getBoard()[i][j] = Constants.BLANK;
	                
	                if (moveVal > bestVal)
	                {
	                    bestMove = new Move(i, j);
	                    bestVal = moveVal;
	                }
	            }
	        }
	    }
	    return bestMove;
	}
	
	public int getMaxDepth()
	{
		return maxDepth;
	}
}