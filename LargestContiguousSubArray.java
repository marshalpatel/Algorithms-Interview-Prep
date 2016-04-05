package marshal.practice.com;

public class LargestContiguousSubArray {

	public static void getLargestContiguousSubArray() {

		int[] arr = { 1, 2, 2, 2, 1, 3 };
		System.out.println(getMaxLength(arr));

	}

	public static int getMaxLength(int[] arr) {

		int maxLength = Integer.MIN_VALUE;
		int count = 0;
		int tempArr[] = new int[arr.length];
		int t;

		for (int i = 0; i < arr.length; i++) {
			tempArr[0] = 1;
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] - arr[i] < 0)
					t = -1 * (arr[j] - arr[i]);
				else
					t = arr[j] - arr[i];
				if (t < tempArr.length) {
					if (arr[j] - arr[i] > 0) {
						// if (tempArr[arr[j] - arr[i]] == 0)
						tempArr[arr[j] - arr[i]] += 1;
						// else
						// tempArr[arr[j] - arr[i] + 1] = 1;
					} else {

						// if (tempArr[arr[i] - arr[j]] == 0)
						tempArr[arr[i] - arr[j]] += 1;
						// else
						// tempArr[arr[i] - arr[j] + 1] = 1;
					}
					// tempArr[arr[i] - arr[j]] = 1;
				}
			}
			for (int k = 0; k < tempArr.length; k++) {

				if (tempArr[k] > 0) {
					count += tempArr[k];

				} else
					break;
			}

			if (count > maxLength)
				maxLength = count;

			for (int k = 0; k < tempArr.length; k++) {
				tempArr[k] = 0;
			}
			count = 0;

		}

		return maxLength;
	}

}
