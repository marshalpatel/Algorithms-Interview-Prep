package marshal.practice.com;

public class SearchInAlmostSortedArray {

	public static void search() {

		int arr[] = {4, 3, 40, 20, 50, 80, 70,100,90 };

		System.out.println(search(arr, 0, arr.length - 1, 18));
	}

	public static int search(int arr[], int start, int end, int k) {

		if (start == end) {
			if (arr[start] == k)
				return start;
			else
				return -1;

		}

		int mid = (end - start) / 2 + start;
		if (arr[mid] == k) {
			return mid;
		}

		if (start < mid && arr[mid - 1] == k)
			return mid - 1;
		if (end > mid && arr[mid + 1] == k)
			return mid + 1;

		if (arr[mid] > k)
			return search(arr, start, mid - 2, k);
		else
			return search(arr, mid + 2, end, k);

	}
}
