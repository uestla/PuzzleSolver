
package puzzlesolver;


public abstract class UniqueRowColRegionSolver extends UniqueRowColSolver
{

	final protected int regionWidth;
	final protected int regionHeight;


	public UniqueRowColRegionSolver(int[][] board, int regionWidth, int regionHeight)
	{
		super(board);
		this.regionWidth = regionWidth;
		this.regionHeight = regionHeight;
	}


	final public int getRegionWidth()
	{
		return this.regionWidth;
	}


	final public int getRegionHeight()
	{
		return this.regionHeight;
	}


	@Override
	protected boolean canBePlaced(int row, int col, int value)
	{
		if (!super.canBePlaced(row, col, value)) {
			return false;
		}

		// already in M×N region?
		int regionRowOffset = (row / this.regionHeight) * this.regionHeight;
		int regionColOffset = (col / this.regionWidth) * this.regionWidth;

		for (int i = 0; i < this.boardSize; i++) {
			int checkRow = regionRowOffset + (i / this.regionWidth);
			int checkCol = regionColOffset + (i % this.regionWidth);

			if (this.board[checkRow][checkCol] == value) {
				return false;
			}
		}

		return true;
	}

}
