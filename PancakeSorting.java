package marshal.practice.com;

public class PancakeSorting {

	public static void flip(int[] arr, int index) {

		int k = 0;

		int temp = 0;
		while (k < index) {
			temp = arr[k];
			arr[k] = arr[index];
			arr[index] = temp;
			k++;
			index--;
		}

	}

}
