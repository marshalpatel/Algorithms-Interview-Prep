package marshal.practice.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum() {

		int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length < 3)
			return result;

		Arrays.sort(nums);

		int i = 1;
		int j = nums.length - 1;
		int t = 0;
		int prev_i = -1;
		int prev_j = -1;

		while (t < nums.length) {

			
			  if(t > 0 && nums[t-1]==nums[t]){ while(t<nums.length &&
			  nums[t-1]==nums[t]){ t++; } }
			 

			i = t + 1;
			j = nums.length - 1;

			if (i < nums.length && -nums[t] >= nums[i]) {

				while (i < j) {

					if (nums[i] + nums[j] > -nums[t]) {

						j--;
					} else if (nums[i] + nums[j] < -nums[t]) {
						i++;
					} else {

						if ((prev_i == -1 && prev_j==-1) || nums[prev_i] != nums[i] || nums[prev_j] != nums[j]) {
							System.out.println(nums[t] + ", " + nums[i] + ", "
									+ nums[j]);
							prev_i = i;
							prev_j = j;
						}
						i++;
						j--;
					}
				}
			}

			t++;
		}

		return result;
	}
}
