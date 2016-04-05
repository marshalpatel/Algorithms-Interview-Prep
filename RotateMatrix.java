package marshal.practice.com;

public class RotateMatrix {

	public static void rotateMatrix() {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		// int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

		int si = 0;
		int sj = 0;
		int n = matrix.length;

		/*
		 * while (si <= ((n - 1) / 2)) {
		 * 
		 * int x = si; while (si < n - (x + 1)) { int t1 = matrix[sj][n - 1 -
		 * si]; matrix[sj][n - 1 - si] = matrix[si][sj]; int t2 = matrix[n - 1 -
		 * si][n - 1 - sj]; matrix[n - 1 - si][n - 1 - sj] = t1; t1 = matrix[n -
		 * 1 - sj][si]; matrix[n - 1 - sj][si] = t2; matrix[si][sj] = t1;
		 * 
		 * si++;
		 * 
		 * }
		 * 
		 * si = x; si++; sj++;
		 * 
		 * }
		 */

		for (int layer = 0; layer < (matrix.length / 2); layer++) {

			int end = matrix.length - 1 - layer;
			int start = layer;
			for (int i = start; i < end; i++) {
				int offset = i - start;

				int temp = matrix[offset][end];

				matrix[offset][end] = matrix[start][i];

				int temp2 = matrix[end][end - offset];

				matrix[end][end - offset] = temp;

				temp = matrix[end - offset][start];

				matrix[end - offset][start] = temp2;

				matrix[start][i] = temp;

			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}

			System.out.println();
		}

	}

	public static void rotateMat()
	{
		int[][] matrix  = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		
		int layer = matrix.length/2;
        int start = 0;
        int end = matrix.length-1;
        
        while(layer >=1)
        {
            rotateLayer(matrix,start,end);
            
            layer--;
            start++;
            end--;
            
        }
        
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}

			System.out.println();
		}

	}

	public static void rotateLayer(int[][] matrix, int start, int end) {
		int l_r = start;
		int t_b = start;
		int r_l = end;
		int b_t = end;

		int i = start;

		while (i < end) {
			// start,l_r -> end,t_b
			// end, t_b -> end, r_l
			// end, r_l -> start, b_t
			// start, b_t -> start, l_r

			int temp = matrix[t_b][end];
			matrix[t_b][end] = matrix[start][l_r];

			int temp2 = matrix[end][r_l];
			matrix[end][r_l] = temp;

			temp = matrix[b_t][start];
			matrix[b_t][start] = temp2;

			matrix[start][l_r] = temp;

			l_r++;
			t_b++;
			r_l--;
			b_t--;
			i++;

		}
	}

	public static void rotateMatrixInSteps() {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		// int steps = 8;
		int layerCount = matrix.length < matrix[0].length ? matrix.length
				: matrix[0].length;
		layerCount = layerCount / 2;

		int l_r = matrix[0].length - 1;
		int t_b = matrix.length - 1;
		int r_l = 0;
		int b_t = 0;

		for (int steps = 0; steps < 3; steps++) {
			for (int layer = 0; layer < layerCount; layer++) {

				// int temp = matrix[layer][layer];
				int row = layer;
				int col = layer;
				while (col < l_r) {

					int temp = matrix[row][col + 1];
					matrix[row][col + 1] = matrix[row][col];
					matrix[row][col] = temp;
					col++;
				}

				while (row < t_b) {

					int temp = matrix[row + 1][col];
					matrix[row + 1][col] = matrix[row][col];
					matrix[row][col] = temp;
					row++;
				}

				while (col > r_l) {

					int temp = matrix[row][col - 1];
					matrix[row][col - 1] = matrix[row][col];
					matrix[row][col] = temp;
					col--;
				}

				while (row > b_t + 1) {

					int temp = matrix[row - 1][col];
					matrix[row - 1][col] = matrix[row][col];
					matrix[row][col] = temp;
					row--;
				}

				l_r--;
				t_b--;
				r_l++;
				b_t++;

			}

		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

	}

}
