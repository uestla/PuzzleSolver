package PuzzleSolver.Solver;

public abstract class UniqueRowsColsSolver extends BaseSolver {
	public UniqueRowsColsSolver(int[][] board, int maxValue) {
		super(board, maxValue);
	}

	@Override
	protected boolean canBePlaced(int row, int col, int value) {
		for (int i = 0, size = this.board.length; i < size; i++) {
			if (this.board[row][i] == value || this.board[i][col] == value) {
				return false;
			}
		}

		return true;
	}
}
