package marshal.practice.com;

public class Islands {

	static int count;

	public static void getIslandCount() {

		int[][] matrix = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		int[][] visited = new int[matrix.length][matrix[0].length];
		getIslandCountHelper(matrix, visited);
		System.out.println(count);

	}

	public static void getIslandCountHelper(int[][] matrix, int[][] visited) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 1 && visited[i][j] == 0) {
					count++;
					DFS(matrix, visited, i, j);
				}
			}
		}

	}

	public static void DFS(int[][] matrix, int[][] visited, int rowIndex,
			int colIndex) {

		if (matrix[rowIndex][colIndex] == 0)
			return;

		visited[rowIndex][colIndex] = 1;

		if (colIndex + 1 < matrix[0].length
				&& visited[rowIndex][colIndex + 1] == 0)
			DFS(matrix, visited, rowIndex, colIndex + 1);

		if (rowIndex + 1 < matrix.length
				&& visited[rowIndex + 1][colIndex] == 0)
			DFS(matrix, visited, rowIndex + 1, colIndex);

		if (colIndex + 1 < matrix[0].length && rowIndex + 1 < matrix.length
				&& visited[rowIndex + 1][colIndex + 1] == 0)
			DFS(matrix, visited, rowIndex + 1, colIndex + 1);

		if (colIndex - 1 >= 0 && colIndex - 1 < matrix[0].length
				&& rowIndex + 1 < matrix.length
				&& visited[rowIndex + 1][colIndex - 1] == 0)
			DFS(matrix, visited, rowIndex + 1, colIndex - 1);

		if (colIndex - 1 >= 0 && colIndex - 1 < matrix[0].length
				&& visited[rowIndex][colIndex - 1] == 0)
			DFS(matrix, visited, rowIndex, colIndex - 1);

		if (colIndex - 1 >= 0 && colIndex - 1 < matrix[0].length
				&& rowIndex - 1 >= 0 && rowIndex - 1 < matrix.length
				&& visited[rowIndex - 1][colIndex - 1] == 0)
			DFS(matrix, visited, rowIndex - 1, colIndex - 1);

		if (rowIndex - 1 >= 0 && visited[rowIndex - 1][colIndex] == 0)
			DFS(matrix, visited, rowIndex - 1, colIndex);

		if (colIndex + 1 < matrix[0].length  && rowIndex - 1 >= 0
				&& visited[rowIndex - 1][colIndex + 1] == 0)
			DFS(matrix, visited, rowIndex - 1, colIndex + 1);

	}

}
