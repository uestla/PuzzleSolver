
package puzzlesolver;


public abstract class UniqueRowColSolver implements Solver
{

	protected int[][] board;
	final protected int boardSize;


	public UniqueRowColSolver(int[][] board)
	{
		this.board = board;
		this.boardSize = board.length;
	}


	@Override
	final public int getBoardSize()
	{
		return this.boardSize;
	}


	@Override
	final public int getBoardValue(int row, int col)
	{
		return this.board[row][col];
	}


	@Override
	final public boolean solve()
	{
		int[] coords = this.getFirstEmptyField();

		if (coords == null) {
			return true;
		}

		for (int value = 1; value <= this.boardSize; value++) {
			if (this.canBePlaced(coords[0], coords[1], value)) {
				this.board[coords[0]][coords[1]] = value;

				if (this.solve()) {
					return true;
				}

				this.board[coords[0]][coords[1]] = 0;
			}
		}

		return false;
	}


	protected int[] getFirstEmptyField()
	{
		for (int row = 0; row < this.boardSize; row++) {
			for (int col = 0; col < this.boardSize; col++) {
				if (this.board[row][col] == 0) {
					return new int[] {row, col};
				}
			}
		}

		return null;
	}


	protected boolean canBePlaced(int row, int col, int value)
	{
		// already in row/column ?
		for (int i = 0; i < this.boardSize; i++) {
			if (this.board[row][i] == value || this.board[i][col] == value) {
				return false;
			}
		}

		return true;
	}

}
