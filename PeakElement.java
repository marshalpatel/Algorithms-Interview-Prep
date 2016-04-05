package marshal.practice.com;

public class PeakElement {

	public static int getPeakElement(int[] arr, int s, int e) {

		if (s == e)
			return arr[s];

		int mid = (e - s) / 2 + s;

		if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
			return arr[mid];

		if (arr[mid] < arr[mid - 1]) {
			e = mid - 1;
			return getPeakElement(arr, s, e);
		} else {
			s = mid + 1;
			return getPeakElement(arr, s, e);
		}

	}

}
