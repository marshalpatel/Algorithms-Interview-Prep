package marshal.practice.com;

import java.util.LinkedList;

public class LargestAreaRectHist {

	/*
	 * Key idea: Find the number of elements greater than the current element to
	 * the right and left side. Similar to stock span problem.
	 */

	public static void getLargestRectInHist() {

		int[] arr = { 2, 10, 3, 8 };

		getLargestRectInHistHelper(arr);

	}

	public static void getLargestRectInHistHelper(int[] arr) {

		LinkedList<Integer> height = new LinkedList<Integer>();
		LinkedList<Integer> span = new LinkedList<Integer>();

		int[] res_right = new int[arr.length];
		int[] res_left = new int[arr.length];

		int count = 0;
		int max_area = Integer.MIN_VALUE;
		int temp_area = 0;

		height.push(arr[0]);
		span.push(1);
		res_left[0] = 1;
		res_right[arr.length - 1] = 1;

		for (int i = 1; i < arr.length; i++) {

			count = 0;
			while (!height.isEmpty() && !span.isEmpty()
					&& height.peek() >= arr[i]) {
				count += span.pop();
				height.pop();
			}
			res_left[i] = count + 1;
			height.push(arr[i]);
			span.push(res_left[i]);

		}

		height.clear();
		span.clear();

		height.push(arr[arr.length - 1]);
		span.push(1);

		for (int i = arr.length - 2; i >= 0; i--) {
			count = 0;
			while (!height.isEmpty() && !span.isEmpty()
					&& height.peek() >= arr[i]) {
				count += span.pop();
				height.pop();
			}
			res_right[i] = count + 1;
			height.push(arr[i]);
			span.push(res_right[i]);

		}

		for (int i = 0; i < arr.length; i++) {

			temp_area = arr[i] * (res_right[i] + res_left[i] - 1);
			if (temp_area > max_area)
				max_area = temp_area;

		}

		System.out.println(max_area);

	}

}
