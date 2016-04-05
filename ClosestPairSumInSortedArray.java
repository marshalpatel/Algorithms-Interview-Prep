package marshal.practice.com;

public class ClosestPairSumInSortedArray {

	public static void getClosestPairSum() {

		int A[] = { 1, 4, 7, 10 };
		int B[] = { 5, 20, 30, 40 };
		int x = 10;

		getPair(A, B, x);

	}

	public static void getPair(int[] A, int[] B, int x) {

		int a = 0;
		int b = B.length - 1;
		int diff = 0;
		int minDiff = Integer.MAX_VALUE;
		int f = 0, s = 0;

		while (a < A.length && b >= 0) {

			if (A[a] + B[b] > x) {

				diff = A[a] + B[b] - x > 0 ? A[a] + B[b] - x : x - A[a] - B[b];
				if (diff < minDiff) {
					minDiff = diff;
					f = A[a];
					s = B[b];
				}

				b--;
			} else if (A[a] + B[b] < x) {

				diff = A[a] + B[b] - x > 0 ? A[a] + B[b] - x : x - A[a] - B[b];
				if (diff < minDiff) {
					minDiff = diff;
					f = A[a];
					s = B[b];
				}

				a++;

			}

			else {

				f = A[a];
				s = B[b];
				break;
			}
		}

		System.out.println(f + "," + s);

	}

}
