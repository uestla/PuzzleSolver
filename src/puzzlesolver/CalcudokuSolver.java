
package puzzlesolver;

import java.util.Arrays;


public final class CalcudokuSolver extends UniqueRowColSolver
{

	private final int[][][] regions;


	public CalcudokuSolver(int boardSize, int[][][] regions)
	{
		super(new int[boardSize][boardSize]);
		this.regions = regions;
	}


	@Override
	protected int[] getFirstEmptyField()
	{
		for (int[][] region : this.regions) {
			for (int i = 1; i < region.length; i++) {
				if (this.board[region[i][0]][region[i][1]] == 0) {
					return new int[] {region[i][0], region[i][1]};
				}
			}
		}

		return null;
	}


	@Override
	protected boolean canBePlaced(int row, int col, int value)
	{
		if (!super.canBePlaced(row, col, value)) {
			return false;
		}

		// find region with given field
		for (int i = 0; i < this.regions.length; i++) {
			for (int j = 1; j < this.regions[i].length; j++) {
				if (this.regions[i][j][0] == row && this.regions[i][j][1] == col) {
					return this.canBePlacedInRegion(i, value);
				}
			}
		}

		return true;
	}


	private boolean canBePlacedInRegion(int regionIndex, int value)
	{
		int[] regionValues = this.getSortedNonEmptyRegionValues(this.regions[regionIndex], value);
		int currentTotal = regionValues[regionValues.length - 1];
		int regionTotal = this.regions[regionIndex][0][0];

		for (int i = regionValues.length - 2; i >= 0; i--) {
			switch (this.regions[regionIndex][0][1]) {
				case 0: // addition
					currentTotal += regionValues[i];
					if (currentTotal > regionTotal) {
						return false;
					}
					break;

				case 1: // subtraction
					currentTotal -= regionValues[i];
					if (currentTotal < regionTotal) {
						return false;
					}
					break;

				case 2: // multiplication
					currentTotal *= regionValues[i];
					if (currentTotal > regionTotal) {
						return false;
					}
					break;

				case 3: // division
					if (currentTotal % regionValues[i] != 0) {
						return false;
					}

					currentTotal /= regionValues[i];
					if (currentTotal < regionTotal) {
						return false;
					}
					break;
			}
		}

		return currentTotal == regionTotal
				|| regionValues.length != this.regions[regionIndex].length - 1;
	}


	private int[] getSortedNonEmptyRegionValues(int[][] region, int newValue)
	{
		int valueCount = 1;
		for (int i = 1; i < region.length; i++) {
			if (this.board[region[i][0]][region[i][1]] != 0) {
				valueCount++;
			}
		}

		int index = 0;
		int[] regionValues = new int[valueCount];
		regionValues[index++] = newValue;

		for (int i = 1; i < region.length; i++) {
			if (this.board[region[i][0]][region[i][1]] != 0) {
				regionValues[index++] = this.board[region[i][0]][region[i][1]];
			}
		}

		Arrays.sort(regionValues);
		return regionValues;
	}

}
