package marshal.practice.com;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixSpirally {

	public static void spiralOrderHelper() {

		int[][] matrix = { { 1, 2, 3 },{ 7, 8, 9 },{ 13, 14, 15}};

		printSpiral(matrix);
		/*
		 * List<Integer> result = spiralOrder(matrix);
		 * 
		 * for (int i = 0; i < result.size(); i++) {
		 * System.out.println(result.get(i)); }
		 */
	}

	public static void printSpiral(int[][] matrix) {
		int l_r = matrix[0].length - 1;
		int t_b = matrix.length - 1;
		int r_l = 0;
		int b_t = 1;
		int count = 0;
		int size = matrix.length * matrix[0].length;
		

		int r = 0;
		int c = 0;

		while (count<size) {
			while (c <= l_r && count<size) {
				System.out.println(matrix[r][c]);
				count++;
				c++;
			}
			
			c--;
			r++;

			while (r <= t_b && count<size) {
				System.out.println(matrix[r][c]);
				count++;
				r++;
			}
			r--;
			c--;
			
			while (c >= r_l && count<size) {
				
				System.out.println(matrix[r][c]);
				count++;
				c--;
			}
			c++;
			r--;

			while (r >= b_t && count<size) {
				System.out.println(matrix[r][c]);
				count++;
				r--;
			}

			r++;
			c++;
			l_r -= 1;
			t_b -= 1;
			r_l++;
			b_t++;
		}

	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();

		int r = 0;
		int c = 0;

		if (matrix.length > 0) {
			int left_right = matrix[0].length - 1;
			int right_left = 0;
			int top_bottom = matrix.length - 1;
			int bottom_top = 1;
			while (result.size() < (matrix[0].length * matrix.length)) {

				while (c <= left_right) {
					if (result.size() == (matrix[0].length * matrix.length))
						return result;
					result.add(matrix[r][c]);
					c++;
				}

				r++;
				c--;
				while (r <= top_bottom) {
					if (result.size() == (matrix[0].length * matrix.length))
						return result;
					result.add(matrix[r][c]);

					r++;
				}

				r--;
				c--;

				while (c >= right_left) {

					if (result.size() == (matrix[0].length * matrix.length))
						return result;
					result.add(matrix[r][c]);

					c--;
				}

				r--;
				c++;
				while (r >= bottom_top) {

					if (result.size() == (matrix[0].length * matrix.length))
						return result;
					result.add(matrix[r][c]);

					r--;
				}

				c++;
				r++;
				left_right--;
				right_left++;
				top_bottom -= 1;
				bottom_top++;

			}
		}

		return result;

	}

}
