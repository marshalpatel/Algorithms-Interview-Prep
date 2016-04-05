package marshal.practice.com;

import java.util.Arrays;

public class WiggleSort {

	public static void wiggleSort() {

		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3 };

		Arrays.sort(nums);
		int[] result = new int[nums.length];

		int i = (nums.length - 1) / 2;
		
		if(nums.length%2!=0){
			result[result.length-1]=nums[0];
		}

		int j = i + 1;
		int r = 0;
		int s = 0, e = 0;

		while (j < nums.length && i >= 0) {

			if (nums[i] < nums[j]) {

				result[r] = nums[i];
				result[r + 1] = nums[j];
				i--;
				j++;
				r += 2;
			} else if (nums[i] == nums[j]) {

				s = j;
				while (j < nums.length && nums[i] == nums[j]) {
					j++;
				}
				e = j;
			}
		}

		j = s;

		while (i >= 0 && j < e) {

			result[r] = nums[i];
			result[r + 1] = nums[j];
			i--;
			j++;
			r += 2;

		}

		for (int k = 0; k < result.length; k++) {
			nums[k] = result[k];
			System.out.print(nums[k] + ", ");
		}

//		System.out.println();
//		int[] num = { 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3 };
//		Arrays.sort(num);
//		int[] temp = new int[num.length];
//		int mid = num.length % 2 == 0 ? num.length / 2 - 1 : num.length / 2;
//		int index = 0;
//		for (int a = 0; a <= mid; a++) {
//			temp[index] = num[mid - a];
//			if (index + 1 < num.length)
//				temp[index + 1] = num[num.length - a - 1];
//			index = index + 2;
//		}
//		for (int a = 0; a < num.length; a++) {
//			num[a] = temp[a];
//			System.out.print(num[a] + ", ");
//		}

	}

}
