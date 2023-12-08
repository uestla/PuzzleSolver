package PuzzleSolver.Solver;

import PuzzleSolver.Board.Cell;

public abstract class BaseSolver implements Solver {
	protected int[][] board;
	final protected int maxValue;

	public BaseSolver(int[][] board, int maxValue) {
		this.board = board;
		this.maxValue = maxValue;
	}

	@Override
	public int getCellValue(int row, int col) {
		return this.board[row][col];
	}

	public int getBoardSize() {
		return this.board.length;
	}

	public int getMaxValue() {
		return this.maxValue;
	}

	@Override
	public boolean solve() {
		Cell emptyField = this.getFirstEmptyField();

		if (emptyField == null) {
			return true;
		}

		for (int value = 1; value <= this.maxValue; value++) {
			if (this.canBePlaced(emptyField.row(), emptyField.col(), value)) {
				this.board[emptyField.row()][emptyField.col()] = value;

				if (this.solve()) {
					return true;
				}

				this.board[emptyField.row()][emptyField.col()] = 0;
			}
		}

		return false;
	}

	protected Cell getFirstEmptyField() {
		for (int row = 0, rows = this.board.length; row < rows; row++) {
			for (int col = 0, cols = this.board[row].length; col < cols; col++) {
				if (this.board[row][col] == 0) {
					return new Cell(row, col);
				}
			}
		}

		return null;
	}

	abstract protected boolean canBePlaced(int row, int col, int value);
}
