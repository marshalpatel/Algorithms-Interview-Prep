package marshal.practice.com;

public class MaximumSumNonContiguous {

	public static void getMaxNonContiguousSum() {

		int[] arr = { 2, -3, 5, 7, -10, 100 };

		int[] sumArr = new int[arr.length];
		sumArr[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (i == 1) {
				if (sumArr[0] < arr[i])
					sumArr[1] = arr[1];
				else
					sumArr[1] = sumArr[0];
			}

			else {

				if (sumArr[i - 1] < (sumArr[i - 2] + arr[i])) {
					sumArr[i] = sumArr[i - 2] + arr[i];
				} else {
					sumArr[i] = sumArr[i - 1];
				}
			}

		}

		System.out.println(sumArr[sumArr.length - 1]);

	}

}
