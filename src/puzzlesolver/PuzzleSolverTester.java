
package puzzlesolver;

import puzzlesolver.utils.StringUtils;
import puzzlesolver.utils.SolverPrinter;


public class PuzzleSolverTester
{

	public static void main(String[] args)
	{
		PuzzleSolverTester.testSudoku();
	}


	private static void testSudoku()
	{
		int[][] board = {
			{3, 0, 0, 8, 0, 9, 0, 0, 7},
			{0, 0, 1, 4, 0, 3, 6, 0, 0},
			{0, 5, 0, 1, 2, 6, 0, 3, 0},
			{6, 9, 5, 0, 0, 0, 8, 2, 1},
			{0, 0, 7, 0, 0, 0, 9, 0, 0},
			{2, 1, 3, 0, 0, 0, 7, 5, 4},
			{0, 4, 0, 2, 3, 5, 0, 7, 0},
			{0, 0, 6, 7, 0, 4, 5, 0, 0},
			{5, 0, 0, 6, 0, 1, 0, 0, 9},
		};

		Solver solver = new SudokuSolver(board);
		PuzzleSolverTester.solve(solver);
	}


	private static void solve(Solver solver)
	{
		String solverName = solver.getClass().getSimpleName().replace("Solver", "").toUpperCase();
		System.out.println(solverName);
		System.out.println(StringUtils.repeat("=", solverName.length()));

		SolverPrinter.printBoard(solver);

		boolean solved = solver.solve();
		System.out.println("");

		if (solved) {
			SolverPrinter.printBoard(solver);

		} else {
			System.out.println("UNSOLVEABLE :(");
		}

		System.out.println("");
	}

}
