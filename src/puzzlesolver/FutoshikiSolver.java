
package puzzlesolver;


public final class FutoshikiSolver extends UniqueRowColSolver
{

	private final int[][][] relations;


	public FutoshikiSolver(int[][] board, int[][][] relations)
	{
		super(board);
		this.relations = relations;
	}


	@Override
	protected boolean canBePlaced(int row, int col, int value)
	{
		if (!super.canBePlaced(row, col, value)) {
			return false;
		}

		// violates relation rules?
		for (int[][] relation : this.relations) {
			if ((relation[0][0] == row && relation[0][1] == col
					&& this.board[relation[1][0]][relation[1][1]] > 0
					&& value < this.board[relation[1][0]][relation[1][1]])

				|| (relation[1][0] == row && relation[1][1] == col
					&& this.board[relation[0][0]][relation[0][1]] > 0
					&& value > this.board[relation[0][0]][relation[0][1]])

			) {
				return false;
			}
		}

		return true;
	}

}
