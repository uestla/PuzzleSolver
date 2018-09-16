
package puzzlesolver;

import puzzlesolver.utils.StringUtils;
import puzzlesolver.utils.SolverPrinter;


public class PuzzleSolverTester
{

	public static void main(String[] args)
	{
		PuzzleSolverTester.testSudoku();
		PuzzleSolverTester.testFrameSudoku3by2();
		PuzzleSolverTester.testFrameSudoku3by3();
		PuzzleSolverTester.testCalcudoku();
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


	private static void testFrameSudoku3by2()
	{
		int[][] sums = {
			{9, 5, 7, 8, 9, 4},
			{8, 5, 8, 4, 8, 9},
			{7, 14, 8, 13, 13, 8},
			{14, 7, 13, 8, 8, 13},
		};

		Solver solver = new FrameSudokuSolver(sums, 3, 2);
		PuzzleSolverTester.solve(solver);
	}


	private static void testFrameSudoku3by3()
	{
		int[][] sums = {
			{11, 23, 11, 8, 18, 19, 17, 21, 7},
			{16, 10, 19, 18, 12, 15, 16, 11, 18},
			{13, 21, 11, 22, 16, 7, 9, 22, 14},
			{16, 15, 14, 8, 20, 17, 12, 12, 21},
		};

		Solver solver = new FrameSudokuSolver(sums, 3, 3);
		PuzzleSolverTester.solve(solver);
	}


	private static void testCalcudoku()
	{
		int[][][] regions = {
			{{5, 0}, {0, 0}, {0, 1}},
			{{3, 2}, {0, 2}, {1, 2}},
			{{10, 0}, {0, 3}, {1, 3}, {1, 4}},
			{{30, 2}, {0, 4}, {0, 5}},
			{{10, 0}, {1, 0}, {1, 1}},
			{{2, 3}, {1, 5}, {2, 5}},
			{{1, 1}, {2, 0}, {2, 1}, {3, 1}},
			{{4, 1}, {2, 2}, {3, 2}},
			{{12, 2}, {2, 3}, {3, 3}},
			{{40, 2}, {2, 4}, {3, 4}, {3, 5}},
			{{3, 3}, {3, 0}, {4, 0}},
			{{100, 2}, {4, 1}, {4, 2}, {5, 2}},
			{{5, 1}, {4, 3}, {5, 3}},
			{{9, 0}, {4, 4}, {4, 5}},
			{{5, 0}, {5, 0}, {5, 1}},
			{{4, 2}, {5, 4}, {5, 5}},
		};

		Solver solver = new CalcudokuSolver(6, regions);
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
