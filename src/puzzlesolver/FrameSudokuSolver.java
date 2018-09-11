
package puzzlesolver;


public final class FrameSudokuSolver extends UniqueRowColRegionSolver
{

	private final int[][] sums;


	public FrameSudokuSolver(int[][] sums, int regionWidth, int regionHeight)
	{
		super(new int[sums[0].length][sums[0].length], regionWidth, regionHeight);
		this.sums = sums;
	}


	@Override
	protected boolean canBePlaced(int row, int col, int value)
	{
		if (!super.canBePlaced(row, col, value)) {
			return false;
		}

		// exceeded row/column sum?
		if (row < this.regionHeight) {
			int topColSum = value;
			for (int i = 0; i < this.regionHeight; i++) {
				topColSum += this.board[i][col];
			}

			if ((row == (this.regionHeight - 1) && topColSum != this.sums[0][col])
					|| topColSum > this.sums[0][col]) {
				return false;
			}
		}

		if (row >= (this.boardSize - this.regionHeight)) {
			int bottomColSum = value;
			for (int i = 0; i < this.regionHeight; i++) {
				bottomColSum += this.board[this.boardSize - i - 1][col];
			}

			if ((row == this.boardSize - 1 && bottomColSum != this.sums[1][col])
					|| bottomColSum > this.sums[1][col]) {
				return false;
			}
		}

		if (col < this.regionWidth) {
			int leftRowSum = value;
			for (int i = 0; i < this.regionWidth; i++) {
				leftRowSum += this.board[row][i];
			}

			if ((col == this.regionWidth - 1 && leftRowSum != this.sums[2][row])
					|| leftRowSum > this.sums[2][row]) {
				return false;
			}
		}

		if (col >= (this.boardSize - this.regionWidth)) {
			int rightRowSum = value;
			for (int i = 0; i < this.regionWidth; i++) {
				rightRowSum += this.board[row][this.boardSize - i - 1];
			}

			if ((col == this.boardSize - 1 && rightRowSum != this.sums[3][row])
					|| rightRowSum > this.sums[3][row]) {
				return false;
			}
		}

		return true;
	}

}
