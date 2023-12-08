package PuzzleSolver.Tests;

import PuzzleSolver.Board.Printer;
import PuzzleSolver.Solver.Solver;
import PuzzleSolver.Solver.SudokuSolver;

public class PuzzleSolverTester {
	public static void main(String[] args) {
		testSudoku();
	}

	private static void testSudoku() {
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
		solve(solver);
	}

	private static void solve(Solver solver) {
		String solverName = solver.getClass().getSimpleName().replace("Solver", "").toUpperCase();
		System.out.println(solverName);
		System.out.println(new String(new char[solverName.length()]).replace("\0", "="));

		Printer.printBoard(solver);

		boolean solved = solver.solve();
		System.out.println("");

		if (solved) {
			Printer.printBoard(solver);

		} else {
			System.out.println("Puzzle not solvable.");
		}

		System.out.println("");
	}
}
