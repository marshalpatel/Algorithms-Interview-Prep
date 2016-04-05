package marshal.practice.com;

public class ZigZagConversion {

	public static void zzConversion() {

		String str = "paypalishiring";

		int rows = 1;
		int index = 0;
		int row = 0;
		int col = 0;

		char[][] table = new char[rows][str.length() / 2];

		for (; col < table[0].length && index < str.length();) {

			for (;row < table.length && index < str.length();) {

				table[row][col] = str.charAt(index);
				index++;
				row++;
			}

			row -= 2;
			col++;
			while (index < str.length() && col < table[0].length && row >= 0) {

				table[row][col] = str.charAt(index);
				index++;
				row--;
				col++;

			}
			row += 2;
			col--;
		}

		printString(table);

	}

	private static void printString(char[][] t) {

		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[0].length; c++) {

				if (t[r][c] != '\0')
					System.out.print(t[r][c]);
			}
		}

	}

}
