package marshal.practice.com;

public class ValidPaths {

	static int count;
	static int u, p;

	public static void getPathCount() {

		int[][] matrix = { { 1, 1, 1,1}, { 1, 0, 1,0}, { 1, 1, 1,0} };
		int paths = 0;
		int[][] visited = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				visited[i][j] = 0;
			}
		}

		pathCountHelper(matrix, 0, 0);
		uniquePaths(matrix, visited, 0, 0);
		System.out.println(p+","+u);

	}

	public static void uniquePaths(int[][] matrix, int[][] visited,
			int rowIndex, int colIndex) {

		if (rowIndex == matrix.length - 1 && colIndex == matrix[0].length - 1) {
			// count++;
			visited[rowIndex][colIndex] = 1;
			return;
		}

		if (matrix[rowIndex][colIndex] == 1) {
			if (colIndex + 1 < matrix[0].length) {

				if (visited[rowIndex][colIndex + 1] == 0) {
					u++;
					uniquePaths(matrix, visited, rowIndex, colIndex + 1);
				}
				if(visited[rowIndex][colIndex+1]>-1)
				visited[rowIndex][colIndex] += visited[rowIndex][colIndex + 1];

			}

			if (rowIndex + 1 < matrix.length) {

				if (visited[rowIndex + 1][colIndex] == 0) {
					u++;
					uniquePaths(matrix, visited, rowIndex + 1, colIndex);
				}
				if(visited[rowIndex + 1][colIndex]>-1)
				visited[rowIndex][colIndex] += visited[rowIndex + 1][colIndex];

			}
		}
		else{
			visited[rowIndex][colIndex] = -1;
			return;
			
		}
			

	}

	public static void pathCountHelper(int[][] matrix, int rowIndex,
			int colIndex) {

		if (matrix[rowIndex][colIndex] != 1)
			return;

		if (rowIndex == matrix.length - 1 && colIndex == matrix[0].length - 1) {
			count++;
			return;
		}

		if (colIndex + 1 < matrix[0].length) {
			p++;
			pathCountHelper(matrix, rowIndex, colIndex + 1);
		}

		if (rowIndex + 1 < matrix.length) {
			p++;
			pathCountHelper(matrix, rowIndex + 1, colIndex);
		}

	}

}
