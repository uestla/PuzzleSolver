package PuzzleSolver.Solver;

public class SudokuSolver extends UniqueRowsColsRegionSolver {
	public SudokuSolver(int[][] board) {
		super(board, 9, 3, 3);
	}
}
