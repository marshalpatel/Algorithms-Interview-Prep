package marshal.practice.com;

public class MaximumSumPathArray {

	public static void getMaximumPathSum() {

		int[] A = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] B = { 1, 5, 7, 8, 10, 15, 16, 19 };

		getMaxSum(A, B);
	}

	public static void getMaxSum(int[] A, int[] B) {

		int sum_a = 0;
		int sum_b = 0;
		int max_sum = Integer.MIN_VALUE;
		int a = A.length - 1;
		int b = B.length - 1;

		while (a >= 0 && b >= 0) {

			if (A[a] > B[b]) {
				sum_a += A[a];
				max_sum = max_sum < sum_a ? sum_a : max_sum;
				a--;

			}

			else if (A[a] < B[b]) {
				sum_b += B[b];
				max_sum = max_sum < sum_b ? sum_b : max_sum;
				b--;

			}

			else {

				max_sum += A[a];
				sum_a = max_sum;
				sum_b = max_sum;
				if (a < A.length)
					a--;

				if (b < B.length)
					b--;

			}
		}

		if (a == -1) {

			while (b >= 0) {
				sum_b += B[b];
				max_sum = max_sum < sum_b ? sum_b : max_sum;
				b--;

			}
		}

		else if (b == -1) {
			while (a < 0) {
				sum_a += A[a];
				max_sum = max_sum < sum_a ? sum_a : max_sum;
				a--;
			}
		}

		System.out.println(max_sum);

	}

}
