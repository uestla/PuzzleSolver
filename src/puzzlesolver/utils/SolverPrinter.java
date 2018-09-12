
package puzzlesolver.utils;

import puzzlesolver.Solver;
import puzzlesolver.UniqueRowColRegionSolver;


public final class SolverPrinter
{

	public static void printBoard(Solver solver)
	{
		if (solver instanceof UniqueRowColRegionSolver) {
			SolverPrinter.printRegionBoard((UniqueRowColRegionSolver) solver);

		} else {
			SolverPrinter.printSimpleBoard(solver);
		}
	}


	private static void printRegionBoard(UniqueRowColRegionSolver solver)
	{
		String regBorderHor = "+" + StringUtils.repeat("-", 2 * solver.getRegionWidth() + 1);
		String rowBorder = StringUtils.repeat(regBorderHor, solver.getBoardSize() / solver.getRegionWidth()) + "+";

		for (int row = 0; row < solver.getBoardSize(); row++) {
			if (row % solver.getRegionHeight() == 0) {
				System.out.println(rowBorder);
			}

			for (int col = 0; col < solver.getBoardSize(); col++) {
				if (col % solver.getRegionWidth()== 0) {
					System.out.print("| ");
				}

				SolverPrinter.printValue(solver.getBoardValue(row, col));
				System.out.print(" ");
			}

			System.out.println("|");
		}

		System.out.println(rowBorder);
	}


	private static void printSimpleBoard(Solver solver)
	{
		for (int row = 0; row < solver.getBoardSize(); row++) {
			for (int col = 0; col < solver.getBoardSize(); col++) {
				if (col > 0) {
					System.out.print(" ");
				}

				SolverPrinter.printValue(solver.getBoardValue(row, col));
			}

			System.out.println("");
		}
	}


	private static void printValue(int value)
	{
		String stringValue = Integer.toHexString(value).toUpperCase();
		System.out.print("0".equals(stringValue) ? "-" : stringValue);
	}

}
