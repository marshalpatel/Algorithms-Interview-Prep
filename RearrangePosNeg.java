package marshal.practice.com;

public class RearrangePosNeg {

	public static void rearrange(int[] arr) {

		int i = -1;
		int j = -1;

		for (int k = 0; k < arr.length; k++) {
			if (arr[k] > 0 && j == -1) {
				j = k;
			}

			if (arr[k] < 0 && i == -1) {
				i = k;
			}

			if (i >= 0 && j >= 0)
				break;

		}

		if (i > 0) {
			int t = 0;
			t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;
		}

		for (int k = 0; k < arr.length; k++) {
			
			int t = 0;
			
			if(arr[k]<0 && k-i>1){
				
				t = arr[k];
				arr[k] = arr[i+1];
				arr[i+1] = t;
				i++;
			}

		}

	}

}
