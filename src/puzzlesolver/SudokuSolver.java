
package puzzlesolver;


public final class SudokuSolver extends UniqueRowColRegionSolver
{

	public SudokuSolver(int[][] board)
	{
		super(
				board,
				(int) Math.floor(Math.sqrt(board.length)),
				(int) Math.floor(Math.sqrt(board.length))
		);
	}

}
