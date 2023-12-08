package PuzzleSolver.Board;

import PuzzleSolver.Solver.Solver;
import PuzzleSolver.Solver.UniqueRowsColsRegionSolver;

public class Printer {
	public static void printBoard(Solver solver) {
		if (solver instanceof UniqueRowsColsRegionSolver) {
			printRegionBoard((UniqueRowsColsRegionSolver) solver);

		} else {
			printSimpleBoard(solver);
		}
	}

	private static void printRegionBoard(UniqueRowsColsRegionSolver solver) {
		String regBorderHor = "+" + new String(new char[2 * solver.regionWidth + 1]).replace("\0", "-");
		String rowBorder = new String(new char[solver.getBoardSize() / solver.regionWidth]).replace("\0", regBorderHor) + "+";

		for (int row = 0; row < solver.getBoardSize(); row++) {
			if (row % solver.regionHeight == 0) {
				System.out.println(rowBorder);
			}

			for (int col = 0; col < solver.getBoardSize(); col++) {
				if (col % solver.regionWidth == 0) {
					System.out.print("| ");
				}

				printValue(solver, row, col);
				System.out.print(" ");
			}

			System.out.println("|");
		}

		System.out.println(rowBorder);
	}

	private static void printSimpleBoard(Solver solver) {
		for (int row = 0; row < solver.getBoardSize(); row++) {
			for (int col = 0; col < solver.getBoardSize(); col++) {
				if (col > 0) {
					System.out.print(" ");
				}

				printValue(solver, row, col);
			}

			System.out.println("");
		}
	}

	private static void printValue(Solver solver, int row, int col) {
		int width = Integer.toString(solver.getMaxValue()).length();
		String value = String.format("%1$-" + width + "s", solver.getCellValue(row, col));
		System.out.print("0".equals(value) ? "-" : value);
	}
}
