package marshal.practice.com;

public class PrintMatrixDiagonally {

	public static void printMatrixDiagonally() {

		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };

		diagonalPrint(arr);

	}

	public static void diagonalPrint(int[][] arr) {

		int row = 0;
		int col = 0;
		for (int i = 0; i < arr[0].length; i++) {

			col = i;
			row = 0;
			while (row < arr.length && col >= 0) {
				System.out.print(arr[row++][col--] + " ");
			}
			System.out.println();

		}

		for (int j = 1; j < arr.length; j++) {

			col = arr[0].length - 1;
			row = j;
			while (row < arr.length && col >= 0) {
				System.out.print(arr[row++][col--] + " ");
			}
			System.out.println();

		}

	}

}
