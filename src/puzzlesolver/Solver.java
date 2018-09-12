
package puzzlesolver;


public interface Solver
{

	public boolean solve();
	public int getBoardSize();
	public int getBoardValue(int row, int col);

}
