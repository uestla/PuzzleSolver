package PuzzleSolver.Solver;

public abstract class UniqueRowsColsRegionSolver extends UniqueRowsColsSolver {
	final public int regionWidth;
	final public int regionHeight;

	public UniqueRowsColsRegionSolver(int[][] board, int maxValue, int regionWidth, int regionHeight) {
		super(board, maxValue);
		this.regionWidth = regionWidth;
		this.regionHeight = regionHeight;
	}

	@Override
	protected boolean canBePlaced(int row, int col, int value) {
		if (!super.canBePlaced(row, col, value)) {
			return false;
		}

		int regionRowOffset = (row / this.regionHeight) * this.regionHeight;
		int regionColOffset = (col / this.regionWidth) * this.regionWidth;

		for (int i = 0; i < this.board.length; i++) {
			int checkRow = regionRowOffset + (i / this.regionWidth);
			int checkCol = regionColOffset + (i % this.regionWidth);

			if (this.board[checkRow][checkCol] == value) {
				return false;
			}
		}

		return true;
	}
}
