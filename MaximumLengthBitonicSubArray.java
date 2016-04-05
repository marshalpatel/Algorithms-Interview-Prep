package marshal.practice.com;

public class MaximumLengthBitonicSubArray {

	public static void getMaxLengthBitonicSubArray(int[] arr) {

		int start = 0;
		int end = 1;

		int maxLength = Integer.MIN_VALUE;

		// {10,20,30,40}

		for (int i = 2; i < arr.length; i++) {

			if (arr[end] > arr[i]) {
				end++;
			} else if (arr[end] < arr[i] && arr[end] < arr[end - 1]) {
				start = end;
				end = i;
			} else if (arr[end] < arr[i] && arr[end] > arr[end - 1]) {
				end++;
			}

			if (maxLength < end - start + 1) {
				maxLength = end - start + 1;
			}

		}

		System.out.println(maxLength);
	}
}
