package marshal.practice.com;

public class LIPathMatrix {

	public static void longestIncreasingPath() {

		int[][] matrix = {{3,4,5},
						  {3,2,6},
						  {2,2,1}
						 };
		
		int[][] visited = new int[matrix.length][matrix[0].length];
		int[][] processed = new int[matrix.length][matrix[0].length];
		int[][] lengths = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				lengths[i][j] = 1;
				visited[i][j] = 0;
				processed[i][j] = 0;
			}
		}

		int max = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (visited[i][j] == 0 && processed[i][j] == 0) {
					visited[i][j] = 1;
					lengths[i][j] = longestIncreasingPath(matrix, visited,
							processed, i, j, lengths);
					visited[i][j] = 0;

					if (lengths[i][j] > max)
						max = lengths[i][j];
				}
			}
		}
		
		
		//return max;
		System.out.println(max);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int longestIncreasingPath(int[][] matrix, int[][] visited,
			int[][] processed, int row, int col, int[][] lengths) {
		// int length = 1;
		if (row - 1 >= 0 && visited[row - 1][col] == 0
				&& processed[row - 1][col] == 0
				&& matrix[row][col] < matrix[row - 1][col]) {
			// length = 1 + longestIncreasingPath(matrix, visited, processed,
			// row+1, col);
			visited[row - 1][col] = 1;
			lengths[row][col] = max(
					1 + longestIncreasingPath(matrix, visited, processed,
							row - 1, col, lengths), lengths[row][col]);
			// visited[row+1][col] = 0;
		}
		else
		{
			if(row - 1 >= 0 && processed[row - 1][col] == 1 && matrix[row][col] < matrix[row - 1][col])
			{
				lengths[row][col] = max(lengths[row][col], lengths[row-1][col]+1);
			}
		}

		if (col - 1 >= 0 && visited[row][col - 1] == 0
				&& processed[row][col - 1] == 0
				&& matrix[row][col] < matrix[row][col - 1]) {
			// length = 1 + longestIncreasingPath(matrix, visited, processed,
			// row+1, col);
			visited[row][col - 1] = 1;
			lengths[row][col] = max(
					1 + longestIncreasingPath(matrix, visited, processed, row,
							col - 1, lengths), lengths[row][col]);
			// visited[row][col-1] = 0;
		}
		
		else
		{
			if(col - 1 >= 0
					&& processed[row][col - 1] == 1
					&& matrix[row][col] < matrix[row][col - 1])
			{
				lengths[row][col] = max(lengths[row][col], lengths[row][col-1]+1);
			}
		}

		if (col + 1 < matrix[0].length && visited[row][col + 1] == 0
				&& processed[row][col + 1] == 0
				&& matrix[row][col] < matrix[row][col + 1]) {
			// length = 1 + longestIncreasingPath(matrix, visited, processed,
			// row+1, col);
			visited[row][col + 1] = 1;
			lengths[row][col] = max(
					1 + longestIncreasingPath(matrix, visited, processed, row,
							col + 1, lengths), lengths[row][col]);
			// visited[row][col+1] = 0;
		}
		
		else
		{
			if(col + 1 < matrix[0].length
					&& processed[row][col + 1] == 1
					&& matrix[row][col] < matrix[row][col + 1])
			{
				lengths[row][col] = max(lengths[row][col], lengths[row][col+1]+1);
			}
		}

		if (row + 1 < matrix.length && visited[row + 1][col] == 0
				&& processed[row + 1][col] == 0
				&& matrix[row][col] < matrix[row + 1][col]) {
			// length = 1 + longestIncreasingPath(matrix, visited, processed,
			// row+1, col);
			visited[row + 1][col] = 1;
			lengths[row][col] = max(
					1 + longestIncreasingPath(matrix, visited, processed,
							row + 1, col, lengths), lengths[row][col]);
			// visited[row+1][col] = 0;
		}
		
		else
		{
			if(row + 1 < matrix.length
					&& processed[row + 1][col] == 1
					&& matrix[row][col] < matrix[row + 1][col])
			{
				lengths[row][col] = max(lengths[row][col], lengths[row+1][col]+1);
			}
		}

		processed[row][col] = 1;
		return lengths[row][col];
	}

}
