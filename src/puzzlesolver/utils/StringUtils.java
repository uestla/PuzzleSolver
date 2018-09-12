
package puzzlesolver.utils;


public final class StringUtils
{

	public static String repeat(String s, int n)
	{
		String result = "";
		for (int i = 0; i < n; i++) {
			result += s;
		}

		return result;
	}

}
