package PuzzleSolver.Solver;

public interface Solver {
	int getCellValue(int row, int col);

	int getBoardSize();

	int getMaxValue();

	boolean solve();
}
