package marshal.practice.com;

public class FindKClosestElements {

	public static void getKClosestElements() {

		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53,53, 55, 56 };

		//System.out.println(getClosestElement(arr, 0, arr.length - 1, x));
		
		int x = 51;

		int index = getClosestElement(arr, 0, arr.length - 1, x);
		System.out.println(arr[index]);
		int diff = arr[index] - x > 0 ? arr[index] - x : -arr[index] + x;
		int k = 1;
		int K = 4;
		int forward = index + 1;
		int backward = index - 1;
		int diff_fwd = 0;
		int diff_bwd = 0;
		if (diff != 0) {

			while (k <= K - 1) {
				if (forward < arr.length && forward >= 0)
					diff_fwd = arr[forward] - x > 0 ? arr[forward] - x
							: -arr[forward] + x;
				else
					diff_fwd = 0;

				if (backward >= 0 && backward < forward)
					diff_bwd = arr[backward] - x > 0 ? arr[backward] - x
							: -arr[backward] + x;
				else
					diff_bwd = 0;
				if ((diff_fwd < diff_bwd || backward < 0) && forward<arr.length) {
					System.out.println(arr[forward]);
					forward++;
				} else {
					System.out.println(arr[backward]);
					backward--;
				}

				k++;
			}

		}

	}

	public static int getClosestElement(int[] arr, int s, int e, int x) {

		if (s == e)
			return e;

		int mid = (e - s) / 2 + s;

		int diff_mid = arr[mid] - x < 0 ? x - arr[mid] : arr[mid] - x;
		int diff_left = 0;
		int diff_right = 0;
		if(mid-1>=0)
		diff_left = arr[mid - 1] - x < 0 ? x - arr[mid - 1] : arr[mid - 1]
				- x;
		if(mid+1<arr.length)
		diff_right = arr[mid + 1] - x < 0 ? x - arr[mid + 1] : arr[mid + 1]
				- x;

		if (diff_mid <= diff_left && diff_mid <= diff_right)
			return mid;

		if (diff_mid > diff_right)
			return getClosestElement(arr, mid + 1, e, x);

		else
			return getClosestElement(arr, s, mid - 1>0?mid-1:0, x);
	}

}
